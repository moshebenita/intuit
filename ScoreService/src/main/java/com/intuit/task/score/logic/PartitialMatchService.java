package com.intuit.task.score.logic;

import java.time.LocalDate;

public interface PartitialMatchService  {
	
	public boolean isParticalMatchStringObject(String val1, String val2);
	public boolean isParticalMatchIntegerObject(Integer obj1, Integer obj2);
	public boolean isParticalMatchDoubleObject(Double obj1, Double obj2);
	public boolean isParticalMatchIntegerLocalDate(LocalDate obj1, LocalDate obj2);

}
