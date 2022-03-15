package com.intuit.task.score.test.unit;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuit.task.score.logic.ParticailMatchGenericServiceDoubleImpl;
import com.intuit.task.score.logic.ParticailMatchGenericServiceIntegerImpl;
import com.intuit.task.score.logic.ParticailMatchGenericServiceLocalDateImpl;
import com.intuit.task.score.logic.ParticailMatchGenericServiceStringImpl;
import com.intuit.task.score.rest.controller.object.MatchObjectData;

@RunWith(SpringRunner.class)
public class MatcherTest {
	
	@Test
	public void matchDoubleTrue() {
		ParticailMatchGenericServiceDoubleImpl matcher = new ParticailMatchGenericServiceDoubleImpl();
		Assert.assertTrue(matcher.isParticialMatch(new  MatchObjectData("5.5","5.5",Double.class)));
	}
	
	@Test
	public void matchDoubleFalse() {
		ParticailMatchGenericServiceDoubleImpl matcher = new ParticailMatchGenericServiceDoubleImpl();
		Assert.assertFalse(matcher.isParticialMatch(new  MatchObjectData("5.5","6.5",Double.class)));
	}
	
	@Test
	public void matchIntegerTrue() {
		ParticailMatchGenericServiceIntegerImpl matcher = new ParticailMatchGenericServiceIntegerImpl();
		Assert.assertTrue(matcher.isParticialMatch(new  MatchObjectData("5","5",Integer.class)));
	}
	
	@Test
	public void matchIntegerFalse() {
		ParticailMatchGenericServiceIntegerImpl matcher = new ParticailMatchGenericServiceIntegerImpl();
		Assert.assertFalse(matcher.isParticialMatch(new  MatchObjectData("6","5",Integer.class)));
	}
	
	@Test
	public void matchLocalDateTrue() {
		ParticailMatchGenericServiceLocalDateImpl matcher = new ParticailMatchGenericServiceLocalDateImpl();
		Assert.assertTrue(matcher.isParticialMatch(new  MatchObjectData("2017-09-03","2017-09-03",LocalDate.class)));
	}
	
	@Test
	public void matchLocalDateFalse() {
		ParticailMatchGenericServiceLocalDateImpl matcher = new ParticailMatchGenericServiceLocalDateImpl();
		Assert.assertFalse(matcher.isParticialMatch(new  MatchObjectData("2017-09-03","2015-09-03",LocalDate.class)));
	}
	
	@Test
	public void matchStringTrue() {
		ParticailMatchGenericServiceStringImpl matcher = new ParticailMatchGenericServiceStringImpl();
		Assert.assertTrue(matcher.isParticialMatch(new  MatchObjectData("abcde","bcd",String.class)));
	}
	
	@Test
	public void matchStringFalse() {
		ParticailMatchGenericServiceStringImpl matcher = new ParticailMatchGenericServiceStringImpl();
		Assert.assertFalse(matcher.isParticialMatch(new  MatchObjectData("yyyy","abcd",String.class)));
	}

}
