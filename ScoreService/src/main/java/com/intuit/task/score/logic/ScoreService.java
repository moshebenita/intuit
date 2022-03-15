package com.intuit.task.score.logic;

import com.intuit.task.score.rest.controller.object.MatchObjectDataList;
import com.intuit.task.score.rest.controller.object.TransactionData;

public interface ScoreService {
	
	public double calcScore(TransactionData tranA,TransactionData tranB);
	public double calcGenericScore(MatchObjectDataList trans);

}
