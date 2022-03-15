package com.intuit.task.score.rest.controller.object;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intuit.task.score.rest.controller.serialize.DateDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionData {
	
	private String gstin;
	
	@JsonDeserialize(using = DateDeserialize.class)
	private LocalDate date;
	private String billNo;
	private double gstRate;
	private double taxValue;
	private double cgst;
	private double sgst;
	private double total;

}
