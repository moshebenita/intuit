package com.intuit.task.score.rest.controller.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDataCompare {
	
	private TransactionData tranA;
	private TransactionData tranB;

}
