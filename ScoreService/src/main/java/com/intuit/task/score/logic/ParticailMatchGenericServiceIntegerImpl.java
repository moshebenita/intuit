package com.intuit.task.score.logic;

import org.springframework.beans.factory.annotation.Value;

import com.intuit.task.score.rest.controller.object.MatchObjectData;

public class ParticailMatchGenericServiceIntegerImpl implements ParticailMatchGenericService{
	
	@Value("${score.int.threshold : 1}")
    private int intThreshold;

	@Override
	public boolean isParticialMatch(MatchObjectData matchObjectData) {
		if(null == matchObjectData.getObjectA() || null == matchObjectData.getObjectB()) {
			return MatchUtil.checkNullObject(matchObjectData.getObjectA(), matchObjectData.getObjectB());
		}
		Integer obj1 = Integer.parseInt(matchObjectData.getObjectA());
		Integer obj2 = Integer.parseInt(matchObjectData.getObjectB());
		int currentThreshhold = Math.abs((Math.abs(obj1) - Math.abs(obj2))) ;
		return currentThreshhold <= intThreshold;
	}

}
