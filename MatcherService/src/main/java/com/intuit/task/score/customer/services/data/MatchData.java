package com.intuit.task.score.customer.services.data;

import java.util.List;

import com.intuit.task.score.rest.controller.object.BuyerSupplierFileData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchData {
	private List<BuyerSupplierFileData> matchList;
	List<BuyerSupplierFileData> buyerNotMatchList;
	List<BuyerSupplierFileData> supplierNotMatchList;

}
