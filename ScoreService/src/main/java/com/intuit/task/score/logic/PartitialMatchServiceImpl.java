package com.intuit.task.score.logic;

import java.time.Duration;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PartitialMatchServiceImpl  implements PartitialMatchService{

	@Value("${score.int.threshold : 1}")
    private int intThreshold;
	
	@Value("${score.double.threshold : 1}")
    private double doubleThreshold;
	
	@Value("${score.date.days.threshold : 370}")
    private int dateThreshold;
	
	@Override
	public boolean isParticalMatchStringObject(String val1, String val2) {
		if(null == val1 || null == val2) {
			return checkNullObject(val1, val2);
		}
		
		return val1.contains(val2);
	}

	@Override
	public boolean isParticalMatchIntegerObject(Integer obj1, Integer obj2) {
		if(null == obj1 || null == obj2) {
			return checkNullObject(obj1, obj2);
		}
		int currentThreshhold = Math.abs((Math.abs(obj1) - Math.abs(obj2))) ;
		return currentThreshhold < intThreshold;
	}

	@Override
	public boolean isParticalMatchDoubleObject(Double obj1, Double obj2) {
		if(null == obj1 || null == obj2) {
			return checkNullObject(obj1, obj2);
		}
		return Math.abs((Math.abs(obj1) - Math.abs(obj2))) < doubleThreshold;
	}

	@Override
	public boolean isParticalMatchIntegerLocalDate(LocalDate obj1, LocalDate obj2) {
		if(null == obj1 || null == obj2) {
			return checkNullObject(obj1, obj2);
		}
		long daysdiffernce = Duration.between(obj1.atStartOfDay(), obj2.atStartOfDay()).toDays();
		return Math.abs(daysdiffernce) < dateThreshold;
	}



	private boolean checkNullObject(Object obj1,Object obj2) {
		if(null == obj1 && null == obj2) {
			return true;
		}
		return false;
	}


}
