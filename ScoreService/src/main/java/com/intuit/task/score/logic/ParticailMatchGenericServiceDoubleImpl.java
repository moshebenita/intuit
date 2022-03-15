package com.intuit.task.score.logic;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;

import com.intuit.task.score.rest.controller.object.MatchObjectData;


public class ParticailMatchGenericServiceDoubleImpl implements ParticailMatchGenericService{
	
	
	@Value("${score.double.threshold : 1}")
    private double doubleThreshold;

	@Override
	public boolean isParticialMatch(MatchObjectData matchObjectData) {
		if(null == matchObjectData.getObjectA() || null == matchObjectData.getObjectB()) {
			return MatchUtil.checkNullObject(matchObjectData.getObjectA(), matchObjectData.getObjectB());
		}
		Double obj1 = Double.parseDouble(matchObjectData.getObjectA());
		Double obj2 = Double.parseDouble(matchObjectData.getObjectB());
		return Math.abs((Math.abs(obj1) - Math.abs(obj2))) <= doubleThreshold;
	}

}
