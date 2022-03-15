package com.intuit.task.score.customer.services.process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.intuit.task.score.customer.services.CsvFileService;
import com.intuit.task.score.customer.services.MatchException;
import com.intuit.task.score.customer.services.MatchService;
import com.intuit.task.score.customer.services.data.MatchData;
import com.intuit.task.score.customer.services.data.MatchDataResult;
import com.intuit.task.score.customer.services.data.PartialMatchData;
import com.intuit.task.score.rest.controller.object.BuyerSupplierFileData;

@Service
public class MatchProcessorServiceImpl implements MatchProcessorService {

	@Autowired
	private CsvFileService csvFileService;
	
	@Autowired
	private MatchService matchService;
	
//	get 2 files and return the result
	@Override
	public MatchDataResult processFileMatch(MultipartFile buyerFile, MultipartFile supplierFile) {
		
		try {
			List<BuyerSupplierFileData> buyerList = csvFileService.loadObjectFromByte(BuyerSupplierFileData.class, buyerFile.getBytes());
			List<BuyerSupplierFileData> supplierList = csvFileService.loadObjectFromByte(BuyerSupplierFileData.class, supplierFile.getBytes());
//			split the list to 2 parts in MatchData
//			1 -> the full match
//			2 -> the potential partial result 
			MatchData matchData = matchService.fullMatchBuyersupplier(buyerList, supplierList);
//			
//			
			List<PartialMatchData> listPartialResult = matchService.matchBuyerSellerGeneric(buyerList, supplierList);
			MatchDataResult matchDataResult = new MatchDataResult();
			matchDataResult.setFullMatchList(matchData.getMatchList());
			matchDataResult.setPartialDataList(listPartialResult);
			return matchDataResult;
		} catch (Exception e) {
			throw new MatchException("failed in processFileMatch",e);
		}

	}

}
