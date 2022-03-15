package com.intuit.task.score.customer.services.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchObjectData {
	
	private String objectA;
	private String objectB;
	private Class<?> clazz;
	

}
