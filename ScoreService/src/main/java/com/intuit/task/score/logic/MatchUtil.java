package com.intuit.task.score.logic;

public final class MatchUtil {
	
	public static boolean checkNullObject(Object obj1,Object obj2) {
		if(null == obj1 && null == obj2) {
			return true;
		}
		return false;
	}

}
