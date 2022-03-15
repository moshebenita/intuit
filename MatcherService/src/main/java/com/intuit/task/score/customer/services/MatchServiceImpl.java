package com.intuit.task.score.customer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.intuit.task.score.customer.services.data.ConverterScoreObject;
import com.intuit.task.score.customer.services.data.MatchData;
import com.intuit.task.score.customer.services.data.MatchObjectDataList;
import com.intuit.task.score.customer.services.data.PartialMatchData;
import com.intuit.task.score.rest.controller.object.BuyerSupplierFileData;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MaxScoreCalculator maxScoreCalculator;
	
	@Autowired
	private RestTemplate scoreRestTemplate;
	
	@Autowired
	private ConverterScoreObject converterScoreObject;
	
	

	@Override
	public MatchData fullMatchBuyersupplier(List<BuyerSupplierFileData> buyer, List<BuyerSupplierFileData> supplier)
			throws Exception {
		List<BuyerSupplierFileData> listFullMatch = buyer.stream()
		.filter(c -> supplier.contains(c))
		  .collect(Collectors.toList());
		buyer.removeAll(listFullMatch);
		supplier.removeAll(listFullMatch);
		MatchData matchData = new MatchData(listFullMatch, buyer, supplier);
		return matchData;
	}

	
//	get list of seller and supplier for partial match and return match by score -> activate score service in localhost:8801
	@Override
	public List<PartialMatchData> matchBuyerSellerGeneric(List<BuyerSupplierFileData> buyer,
			List<BuyerSupplierFileData> seller) throws Exception {
		double [][] arr = new double[buyer.size()][seller.size()];
		for(int i = 0; i < buyer.size(); i++ ) {
			for(int j = 0; j < seller.size(); j++ ) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				
				MatchObjectDataList matchObjectDataList = converterScoreObject.convertBuyerSupplierFileData(buyer.get(i), seller.get(j));
				HttpEntity<MatchObjectDataList> entity = new HttpEntity<MatchObjectDataList>(matchObjectDataList ,headers);
				 int score = scoreRestTemplate.postForObject("/api/score/calcGenericDataScore", entity, Integer.class);
				 arr[i][j] = score;
			}
		}
		
//		find by recursive the best score of partial match
		MaxObject maxObject = maxScoreCalculator.findMax(arr, buyer.size(), seller.size());
		List<PartialMatchData> listResult = new ArrayList<PartialMatchData>();
		for(int i = 0; i < maxObject.getIndexes().size(); i++ ) {
			String indexes = maxObject.getIndexes().get(i).trim();
			if(!indexes.isEmpty()) {
				int buyerIdex = Integer.parseInt(indexes.split(",")[0]);
				int selllerIdex = Integer.parseInt(indexes.split(",")[1]);
				listResult.add(new PartialMatchData(buyer.get(buyerIdex), seller.get(selllerIdex)));
			}
		}
		return listResult;
	}

}
