package com.intuit.task.score.customer.services;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

@Service
public class MaxScoreCalculator {
	
	public MaxObject findMax(double[][] arr, int rowNum, int collumnNum) {
		MaxObject maxObject = new MaxObject();
		for(int i = 0 ; i < rowNum; i++) {
			MaxObject caurrentMaxObject = getMaxObjectNumber(arr, 0, i, rowNum, collumnNum, i, "");
			if(caurrentMaxObject.getSum() > maxObject.getSum())
				maxObject = caurrentMaxObject;
		}
		return maxObject;
	}

	public MaxObject getMaxObjectNumber(double[][] arr, int currrentRow, int currrentCollumn , int rowNum, int collumnNum, double countMaxSum, String olderChoose) {

		MaxObject maxObject = new MaxObject();
		olderChoose += "," + currrentCollumn;
		double currentMax = 0;
		List<String> list = Arrays.asList(olderChoose.split(","));

		for(int i = 0; i < collumnNum; i++) {
			if(list.contains(Integer.toString(i)))
				continue;
			MaxObject currentMaxObject = getMaxObjectNumber(arr, currrentRow + 1, i, rowNum, collumnNum, countMaxSum, olderChoose);
			double currentCount = currentMaxObject.getSum();
			if(currentCount > currentMax) {
				currentMax = currentCount;
				maxObject = currentMaxObject;
			}


		}
		maxObject.getIndexes().add((currrentRow) + "," + currrentCollumn + "  ");

		double max = arr[currrentRow][currrentCollumn] + currentMax + countMaxSum;
		maxObject.setSum(max);
		return maxObject;

	}
	
	public static void main(String[] args) {
		MaxScoreCalculator calc = new MaxScoreCalculator();
		double[][] arr = {{40, 10, 10}, {45, 90, 10}, {10, 20, 10}} ;
		MaxObject maxObject = calc.findMax(arr, 3, 3);
		System.err.println(maxObject);
	}

}
