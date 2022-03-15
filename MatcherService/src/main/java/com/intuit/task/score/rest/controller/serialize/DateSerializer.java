package com.intuit.task.score.rest.controller.serialize;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateSerializer extends StdSerializer<LocalDate>{
	
	private static final long serialVersionUID = 1L;
	
	public DateSerializer() {
		this(LocalDate.class,true);
	}

	protected DateSerializer(Class<?> t, boolean dummy) {
		super(t, dummy);
	}

	@Override
	public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeString( value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
	}

}
