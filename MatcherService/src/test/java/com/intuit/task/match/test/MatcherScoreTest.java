package com.intuit.task.match.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuit.task.score.customer.services.MaxObject;
import com.intuit.task.score.customer.services.MaxScoreCalculator;

@RunWith(SpringRunner.class)
public class MatcherScoreTest {

	MaxScoreCalculator calculator = new MaxScoreCalculator();



	@Test
	public void calcMaxScore() {
		double[][] arr = {{40, 10, 10}, {45, 90, 10}, {10, 20, 10}} ;
		MaxObject maxObject = calculator.findMax(arr, 3, 3);
		Assert.assertEquals(maxObject.getSum(), 149.0, 0.0);
	}

}
