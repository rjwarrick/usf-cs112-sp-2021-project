package dataanalytics;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class KNNPredictor extends Predictor {
	private int k;
	private int survived = 0;
	private int died = 0;
	ArrayList<DataPoint> testPoints = new ArrayList<DataPoint>();
	ArrayList<DataPoint> trainPoints = new ArrayList<DataPoint>();

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
	public ArrayList<DataPoint> readData(String filename) {
		ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();

		Scanner scanner = null;
		File file = new File(filename);

		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		while (scanner.hasNextLine()) {
			String doubleSurvived = "";
			String stringAge = "";
			String stringFare = "";
			double newAge = 0.0;
			double newFare = 0.0;
			boolean isTest = false;

			List<String> records = getRecordFromLine(scanner.nextLine());
			if (records.size() != 7) {
				continue;
			}
			if (records.get(1) != null) {
				doubleSurvived = records.get(1);
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

			Random rand = new Random();

			for (int i = 0; i < dataPoints.size(); i++) {

				if (rand.nextDouble() <= 0.9) {
					isTest = false;
					DataPoint trainDataPoint = new DataPoint(newAge, newFare, doubleSurvived, isTest);
					trainPoints.add(trainDataPoint);

				} else {
					isTest = true;
					DataPoint testDataPoint = new DataPoint(newAge, newFare, doubleSurvived, isTest);
					testPoints.add(testDataPoint);
				}
			}
			for (int i = 0; i < dataPoints.size(); i++) {
				System.out.println(trainPoints.get(i));
			}

			for (int i = 0; i < dataPoints.size(); i++) {
				System.out.println(testPoints.get(i));
			}
		}

		return dataPoints;
	}

	private double getDistance(DataPoint p1, DataPoint p2) {

		double distance = Math.sqrt(Math.pow((p2.getF1() - p1.getF1()), 2) + Math.pow((p2.getF2() - p1.getF2()), 2));

		return distance;

	}

	@Override
	public int test(DataPoint datapoint) {
		if (datapoint.getIsTest()) {

			double[][] arr = new double[testPoints.size()][2];

			for (int i = 0; i < testPoints.size(); i++) {
				arr[i][0] = getDistance(datapoint, testPoints.get(i));

			}

			java.util.Arrays.sort(arr);
			
			double[] slice = new double[k];

			for (int i = 0; i < k; i++) {
				slice[i] = arr[i][1];
			}

			int hasSurvived = 0;
			int hasNotSurvived = 0;

			for (double label : slice) {

				if (label == 1.0) {

					hasSurvived++;

				} else if (label == 0.0) {

					hasNotSurvived++;
				}
			}

			if (hasSurvived > hasNotSurvived) {

				return 1;

			} else if (hasSurvived < hasNotSurvived) {

				return 0;
			}

			return 0;

		} else {
			System.out.println("This is not a test point!");
			return 0;
		}

	}

	@Override
	public Double getAccuracy(ArrayList<DataPoint> dataPoints) {

		int truePositive = 0;
		int falsePositive = 0;
		int falseNegative = 0;
		int trueNegative = 0;
		int testLabel = 0;
		int pointLabel = 0;
		int count = 0;

		for (int i = 0; i < dataPoints.size(); i++) {

			if (testLabel == 1 && pointLabel == 1) {
				truePositive++;
			}

			else if (testLabel == 1 && pointLabel == 0) {
				falsePositive++;
			}

			else if (testLabel == 0 && pointLabel == 1) {
				falseNegative++;
			}

			else if (testLabel == 0 && pointLabel == 0) {
				trueNegative++;
			}

			count++;
		}

		double accuracy = (truePositive + trueNegative) / (truePositive + falsePositive + falseNegative + trueNegative);
		return accuracy * 100;
	}

	@Override
	public Double getPrecision(ArrayList<DataPoint> data) {
		ArrayList<Integer> testLabels = new ArrayList<Integer>();

		int truePositive = 0;
		int falseNegative = 0;
		int testLabel = 0;
		int pointLabel = 0;
		int count = 0;

		for (int i = 0; i < data.size(); i++) {

			if (testLabel == 1 && pointLabel == 1) {
				truePositive++;

			} else if (testLabel == 0 && pointLabel == 1) {
				falseNegative++;
			}
			count++;
		}

		double precision = truePositive / (truePositive + falseNegative);
		return precision * 100;

	}

	public int getSurvived() {
		return survived;
	}

	public int getDied() {
		return died;
	}

	public ArrayList<DataPoint> getTests() {
		return this.testPoints;
	}

	public double getAccuracy(List<DataPoint> data) {
		// TODO Auto-generated method stub
		return 0;
	}

}
