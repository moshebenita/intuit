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
	private static final String DATE_PATTERN_WITH_COMMAS = "yyyy-MM-dd";


	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		try {
			String dateAsString = p.getText().trim();
			if (dateAsString.length() == DATE_PATTERN_WITH_COMMAS.length() && dateAsString.contains("-")) {
				return LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern(DATE_PATTERN_WITH_COMMAS));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
