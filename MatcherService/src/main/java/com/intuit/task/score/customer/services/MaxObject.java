package com.intuit.task.score.customer.services;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaxObject {
	private double sum;
	private List<String> indexes = new LinkedList<String>();
	
	
	

}