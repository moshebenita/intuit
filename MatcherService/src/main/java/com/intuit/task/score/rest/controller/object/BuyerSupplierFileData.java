package com.intuit.task.score.rest.controller.object;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.intuit.task.score.rest.controller.serialize.DateDeserialize;
import com.intuit.task.score.rest.controller.serialize.DoubleDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BuyerSupplierFileData {
	
	@JsonProperty("GSTIN")
	private String gstin;
	
	@JsonDeserialize(using = DateDeserialize.class)
	@JsonProperty("Date")
	private LocalDate date;
	
	@JsonProperty("Bill no")
	private String billNo;
	
	@JsonDeserialize(using = DoubleDeserialize.class)
	@JsonProperty("GST rate(%)")
	private Double gstRate;
	
	@JsonDeserialize(using = DoubleDeserialize.class)
	@JsonProperty("Taxable value")
	private Double taxValue;
	
	@JsonDeserialize(using = DoubleDeserialize.class)
	@JsonProperty("IGST")
	private Double igst;
	
	@JsonDeserialize(using = DoubleDeserialize.class)
	@JsonProperty("CGST")
	private Double cgst;
	
	@JsonDeserialize(using = DoubleDeserialize.class)
	@JsonProperty("SGST")
	private Double sgst;
	
	@JsonDeserialize(using = DoubleDeserialize.class)
	@JsonProperty("Total")
	private Double total;
	
	

}
