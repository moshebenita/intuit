package com.intuit.task.score.logic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.intuit.task.score.rest.controller.object.MatchObjectDataList;
import com.intuit.task.score.rest.controller.object.TransactionData;

public class ScoreServiceImpl implements ScoreService{

	@Autowired
	private PartitialMatchService partitialMatchService;
	
	private double transactionDataFieldMatchValue = 14.2;
	
	Map<Class,ParticailMatchGenericService> mapTypeService = new HashMap<>();
	
	
	
	public ScoreServiceImpl(Map<Class, ParticailMatchGenericService> mapTypeService) {
		this.mapTypeService = mapTypeService;
	}

//	compare 2 TXN
	@Override
	public double calcScore(TransactionData tranA, TransactionData tranB) {
		double currentScoure = 0;
		if(partitialMatchService.isParticalMatchStringObject(tranA.getGstin(), tranB.getGstin()))
			currentScoure = transactionDataFieldMatchValue;
		if(partitialMatchService.isParticalMatchIntegerLocalDate(tranA.getDate(), tranB.getDate()))
				currentScoure += transactionDataFieldMatchValue;
		if(partitialMatchService.isParticalMatchStringObject(tranA.getBillNo(), tranB.getBillNo()))
			currentScoure += transactionDataFieldMatchValue;
		if(partitialMatchService.isParticalMatchDoubleObject(tranA.getGstRate(), tranB.getGstRate()))
			currentScoure += transactionDataFieldMatchValue;
		if(partitialMatchService.isParticalMatchDoubleObject(tranA.getTaxValue(), tranB.getTaxValue()))
			currentScoure += transactionDataFieldMatchValue;
		if(partitialMatchService.isParticalMatchDoubleObject(tranA.getCgst(), tranB.getCgst()))
			currentScoure += transactionDataFieldMatchValue;
		if(partitialMatchService.isParticalMatchDoubleObject(tranA.getSgst(), tranB.getSgst()))
			currentScoure += transactionDataFieldMatchValue;
		return currentScoure;
	}

//	get generic object and calc score for match
	@Override
	public double calcGenericScore(MatchObjectDataList trans) {
		double currentScoure = 0;
//		decide field match value
		double transactionDataFieldMatchValue = 100 / trans.getListObject().size();
		for(int i = 0; i < trans.getListObject().size(); i ++) {
//			get match decide by class type
			ParticailMatchGenericService matchService = mapTypeService.get(trans.getListObject().get(i).getClazz());
			if(null == matchService)
				throw new RuntimeException("type:" + trans.getListObject().get(i).getClazz() +" not implemented yet!!!!");
			if(matchService.isParticialMatch(trans.getListObject().get(i)))
				currentScoure+=transactionDataFieldMatchValue;
		}
		return currentScoure;
	}
	

}
