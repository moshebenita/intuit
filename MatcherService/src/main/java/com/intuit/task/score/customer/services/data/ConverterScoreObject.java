package com.intuit.task.score.customer.services.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.intuit.task.score.rest.controller.object.BuyerSupplierFileData;
import com.intuit.task.score.rest.controller.object.TransactionData;

@Service
public class ConverterScoreObject {
	private DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public MatchObjectDataList convertBuyerSupplierFileData(BuyerSupplierFileData buyerTran,BuyerSupplierFileData supplierTran ) {
		MatchObjectDataList matchObjectDataList =  new MatchObjectDataList();
		List<MatchObjectData> listObject = new ArrayList<>();
		
		listObject.add(new MatchObjectData(localDateSetter(buyerTran.getDate()), localDateSetter(supplierTran.getDate()), LocalDate.class));
		listObject.add(new MatchObjectData(buyerTran.getBillNo(), supplierTran.getBillNo(), String.class));
		
		listObject.add(new MatchObjectData(doubleSetter(buyerTran.getGstRate()), doubleSetter(supplierTran.getGstRate()), Double.class));
		listObject.add(new MatchObjectData(doubleSetter(buyerTran.getTaxValue()), doubleSetter(supplierTran.getTaxValue()), Double.class));
		listObject.add(new MatchObjectData(doubleSetter(buyerTran.getCgst()), doubleSetter(supplierTran.getCgst()), Double.class));
		listObject.add(new MatchObjectData(doubleSetter(buyerTran.getSgst()), doubleSetter(supplierTran.getSgst()), Double.class));
		listObject.add(new MatchObjectData(doubleSetter(buyerTran.getTotal()), doubleSetter(supplierTran.getTotal()), Double.class));
		matchObjectDataList.setListObject(listObject);
		return matchObjectDataList;
		
	}

	private String localDateSetter(LocalDate localDateValue) {
		if(null != localDateValue)
			return localDateValue.format(pattern);
		return null;
	}
	
	private String doubleSetter(Double doubleValue) {
		if(null != doubleValue)
			return Double.toString(doubleValue);
		return null;
	}

}
