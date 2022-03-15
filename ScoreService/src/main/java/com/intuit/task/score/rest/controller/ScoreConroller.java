package com.intuit.task.score.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.task.score.logic.ScoreService;
import com.intuit.task.score.rest.controller.object.MatchObjectDataList;
import com.intuit.task.score.rest.controller.object.TransactionDataCompare;

@RestController
@RequestMapping("/api/score/")
public class ScoreConroller {
	
	
	@Autowired
	private ScoreService scoreService;
	
	@PostMapping(value = "calcTransactionDataScore")
	public double calcTransactionDataScore(@RequestBody TransactionDataCompare transactionDataCompare) {
		double score = scoreService.calcScore(transactionDataCompare.getTranA(),transactionDataCompare.getTranB());
		return score;
	}
	
	@PostMapping(value = "calcGenericDataScore")
	public double calcGenericDataScore(@RequestBody MatchObjectDataList matchObjectDataList) {
		double score = scoreService.calcGenericScore(matchObjectDataList);
		return score;
	}
	


}
