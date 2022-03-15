package com.intuit.task.score.logic;

import com.intuit.task.score.rest.controller.object.MatchObjectData;

public class ParticailMatchGenericServiceStringImpl implements ParticailMatchGenericService{

	@Override
	public boolean isParticialMatch(MatchObjectData matchObjectData) {
		if(null == matchObjectData.getObjectA() || null == matchObjectData.getObjectB()) {
			return MatchUtil.checkNullObject(matchObjectData.getObjectA(), matchObjectData.getObjectB());
		}
		if(matchObjectData.getObjectA().length() < matchObjectData.getObjectB().length())
			return substr(matchObjectData.getObjectA(), matchObjectData.getObjectB()) != -1;
		return substr(matchObjectData.getObjectB(), matchObjectData.getObjectA()) != -1;
	}
	
	private static int substr(String s2, String s1){
        int counter = 0; //pointing s2
        int i = 0;
        for(;i<s1.length();i++){
            if(counter==s2.length())
                break;
            if(s2.charAt(counter)==s1.charAt(i)){
                counter++;
            }else{
                //Special case where character preceding the i'th character is duplicate
                if(counter>0){
                    i -= counter;
                }
                counter = 0;
            }
        }
        return counter < s2.length()?-1:i-counter;
    }

}
