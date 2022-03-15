package com.intuit.task.score.customer.services.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
public class MatchObjectDataList {

	private List<MatchObjectData> listObject;
	
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		List<MatchObjectData> listObject = new ArrayList<>();
		listObject.add(new MatchObjectData("2018-03-31","2018-03-31",LocalDate.class));
		listObject.add(new MatchObjectData("moshe","benita",String.class));
		MatchObjectDataList list = new MatchObjectDataList();
		list.setListObject(listObject);
		System.err.println(om.writeValueAsString(list));
		
	}
}
