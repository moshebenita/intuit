package com.intuit.task.score.customer.services;

import java.util.List;

import com.intuit.task.score.customer.services.data.MatchData;
import com.intuit.task.score.customer.services.data.PartialMatchData;
import com.intuit.task.score.rest.controller.object.BuyerSupplierFileData;

public interface MatchService {
	
//	public List<PartialMatchData> matchBuyerSeller(List<BuyerSupplierFileData> buyer, List<BuyerSupplierFileData> seller)throws Exception;
	public List<PartialMatchData> matchBuyerSellerGeneric(List<BuyerSupplierFileData> buyer, List<BuyerSupplierFileData> seller)throws Exception;
	public MatchData fullMatchBuyersupplier(List<BuyerSupplierFileData> buyer, List<BuyerSupplierFileData> seller)throws Exception;

}
