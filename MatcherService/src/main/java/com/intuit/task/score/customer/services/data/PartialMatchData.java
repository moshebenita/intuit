package com.intuit.task.score.customer.services.data;

import com.intuit.task.score.rest.controller.object.BuyerSupplierFileData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartialMatchData {
	
	private BuyerSupplierFileData buyerTXNData;
	private BuyerSupplierFileData supplierTXNData;

}
