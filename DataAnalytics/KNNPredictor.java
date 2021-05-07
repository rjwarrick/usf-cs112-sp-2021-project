package dataanalytics;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class KNNPredictor extends Predictor {
	private int k;
	private int survived = 0;
	private int died = 0;

	public KNNPredictor(int k) {
		this.k = k;
	}

	private List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(",");
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}

	@Override
	public ArrayList<DataPoint> readData(String filename) { // bug...
		ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();

		Scanner scanner = null;
		File file = new File(filename);

		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		while (scanner.hasNextLine()) {
			String stringSurvived = "";
			String stringAge = "";
			String stringFare = "";
			Double newAge = 0.0;
			Double newFare = 0.0;
			
			List<String> records = getRecordFromLine(scanner.nextLine());
			if (records.size() != 7) {
				continue;
			}
			if (records.get(1) != null) {
				stringSurvived = records.get(1);
			}
			if (records.get(5) != null) {
				stringAge = records.get(5);
			}
			if (records.get(6) != null) {
				stringFare = records.get(6);
			}

			try {
				newAge = Double.parseDouble(stringAge);
			} catch (NumberFormatException e) {
				continue;
			}

			try {
				newFare = Double.parseDouble(stringFare);
			} catch (NumberFormatException e) {
				continue;
			}
			
			boolean isTest;

			Random rand = new Random();
			double randNum = rand.nextDouble();
			    // 90% of the data is reserved for training
			if (randNum <= 0.9) {
				isTest = false;
				// Set the type of DataPoint as “train” and put into the Collection
			} else {
				isTest = true;
				// Set the type of DataPoint as “test” and put into the Collection
			}

			if (stringSurvived == "1") {
//				survivedbool = true;
				survived += 1;

			} else {
//				survivedbool = false;
				died += 1;
			}

			DataPoint ageAndFare = new DataPoint(newAge, newFare, stringSurvived, isTest);

			dataPoints.add(ageAndFare);

		}
		for (int i = 0; i < dataPoints.size(); i++ ) {
			System.out.println(dataPoints.get(i));
		}
		for (int i = 0; i < dataPoints.size(); i++ ) {
			
		}
		System.out.println("Survived: " + survived);
		return dataPoints;
	}


	private double getDistance(DataPoint p1, DataPoint p2) {

		double distance = Math.sqrt(Math.pow((p2.getF1() - p1.getF1()), 2) + Math.pow((p2.getF2() - p1.getF2()), 2));
		
		System.out.println(distance);
		return distance;

	}
		
	@Override
	String test(DataPoint dataPoints) {

		return null;
	}

	@Override
	Double getAccuracy(ArrayList<DataPoint> dataPoints) {
		int truePositive = 0;
		int falsePositive = 0;
		int falseNegative = 0;
		int trueNegative = 0;

//
//		if (test.isEqual(1) && label.isEqual(1)) {
//			truePositive += 1;
//		}
//
//		if (test.isEqual(1) && label.isEqual(0)) {
//			falsePositive += 1;
//		}
//
//		if (test.isEqual(0) && label.isEqual(0)) {
//			falseNegative += 1;
//		}
//
//		if (test.isEqual(0) && label.isEqual(1)) {
//			trueNegative += 1;
//		}
//
//		accuracy = (truePositive + trueNegative) / (truePositive + trueNegative + falsePositive + falseNegative);

		return null;
	}

	@Override
	Double getPrecision(ArrayList<DataPoint> data) { // changed from String
//		Double truePositive = 0.0;
//		Double falsePositive = 0.0;
//		Double falseNegative = 0.0;
//		Double trueNegative = 0.0;
//		Double precision = 0.0;
//
//		if (test.isEqual(1) && label.isEqual(1)) {
//			truePositive += 1;
//		}
//
//		if (test.isEqual(1) && label.isEqual(0)) {
//			falsePositive += 1;
//		}
//
//		if (test.isEqual(0) && label.isEqual(0)) {
//			falseNegative += 1;
//		}
//
//		if (test.isEqual(0) && label.isEqual(1)) {
//			trueNegative += 1;
//		}
//
//		precision = truePositive / (truePositive + falseNegative);

		return null;
	}
}
