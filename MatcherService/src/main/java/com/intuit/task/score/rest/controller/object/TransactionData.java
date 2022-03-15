package com.intuit.task.score.rest.controller.object;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
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
	@JsonSerialize(using = com.intuit.task.score.rest.controller.serialize.DateSerializer.class)
	private LocalDate date;
	
	private String billNo;
	private Double gstRate;
	private Double taxValue;
	private Double cgst;
	private Double sgst;
	private Double total;

}
