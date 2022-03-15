package com.intuit.task.score.rest.controller.serialize;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateDeserialize extends JsonDeserializer<LocalDate> {

	private static final String DATE_PATTERN = "dd/MM/yyyy";
	private static final String SHORT_DATE_PATTERN = "dd/MM/yyyy";
	private static final String DATE_PATTERN_WITH_COMMAS = "dd-MM-yyyy";
	private static final String SHORT_PATTERN_WITH_COMMAS = "dd-MM-yy";
	private static final String COMMAS = "-";
	private static final String DASH = "/";


	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		try {
			String dateAsString = p.getText().trim();
			String day = "";
			String month = "";
			String year = "";
			String[] arr;
			LocalDate date;
			if (dateAsString.contains(DASH)) {
				arr = dateAsString.split("/");
			}
			else {
				arr = dateAsString.split(COMMAS);
			}
			day = (arr[0]);
			month = arr[1];
			year = arr[2];
			if(day.length() < 2 )
				day = "0" +  day;
			if(month.length() < 2 )
				month = "0" +  month;
			if(year.length() < 4 )
				date = LocalDate.parse(day + "-" + month + "-" + year, DateTimeFormatter.ofPattern(SHORT_PATTERN_WITH_COMMAS));
			else
				date = LocalDate.parse(day + "-" + month + "-" + year, DateTimeFormatter.ofPattern(DATE_PATTERN_WITH_COMMAS));
			return date;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	

}
