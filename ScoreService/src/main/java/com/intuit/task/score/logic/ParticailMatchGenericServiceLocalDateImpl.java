package com.intuit.task.score.logic;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;

import com.intuit.task.score.rest.controller.object.MatchObjectData;

public class ParticailMatchGenericServiceLocalDateImpl implements ParticailMatchGenericService{
	
	@Value("${score.date.days.threshold : 370}")
    private int dateThreshold;
	
	private static final String DATE_PATTERN_WITH_COMMAS = "yyyy-MM-dd";

	@Override
	public boolean isParticialMatch(MatchObjectData matchObjectData) {
		if(null == matchObjectData.getObjectA() || null == matchObjectData.getObjectB()) {
			return MatchUtil.checkNullObject(matchObjectData.getObjectA(), matchObjectData.getObjectB());
		}
		LocalDate obj1 = LocalDate.parse(matchObjectData.getObjectA(), DateTimeFormatter.ofPattern(DATE_PATTERN_WITH_COMMAS));
		LocalDate obj2 = LocalDate.parse(matchObjectData.getObjectB(), DateTimeFormatter.ofPattern(DATE_PATTERN_WITH_COMMAS));
		long daysdiffernce = Duration.between(obj1.atStartOfDay(), obj2.atStartOfDay()).toDays();
		return Math.abs(daysdiffernce) <= dateThreshold;
	}

}
