package com.intuit.task.score.rest.controller.serialize;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DoubleDeserialize extends JsonDeserializer<Double> {

	private static final String DATE_PATTERN = "dd/MM/yyyy";
	private static final String DATE_PATTERN_WITH_COMMAS = "yyyy-MM-dd";


	@Override
	public Double deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String doubleAsString ;
		try {
			doubleAsString = p.getText().replace("\"", "").replace(",", "").trim();
			if(doubleAsString.isEmpty())
				return null;
			Double doubleValue = Double.parseDouble(doubleAsString);
			return doubleValue;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		System.err.println(Double.parseDouble("2099.00"));
	}

}
