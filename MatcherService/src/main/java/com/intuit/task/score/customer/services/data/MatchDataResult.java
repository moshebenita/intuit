package com.intuit.task.score.customer.services.data;

import java.util.ArrayList;
import java.util.List;

import com.intuit.task.score.rest.controller.object.BuyerSupplierFileData;

import lombok.Data;

@Data
public class MatchDataResult {

	private List<BuyerSupplierFileData> fullMatchList = new ArrayList<BuyerSupplierFileData>();
	private List<PartialMatchData> partialDataList = new ArrayList<PartialMatchData>();
	
	public void addPartialData(BuyerSupplierFileData buyerSupplierFileData) {
		fullMatchList.add(buyerSupplierFileData);
	}
	
	public void addPartialMatchData(PartialMatchData partialMatchData) {
		partialDataList.add(partialMatchData);
	}
	
}
