package dataanalytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class DummyPredictor extends Predictor {
	
	public Double goodAvg;
	public Double badAvg;

	@Override
	public ArrayList<DataPoint>readData(String filename) {
		// TODO Auto-generated method stub
		ArrayList<DataPoint> brandNewData = new ArrayList<DataPoint>(2);
		
		File testData = new File(filename);
		
		try {
			Scanner scanner = new Scanner(testData);
			
			while (scanner.hasNextLine()) {
				Double f1 = scanner.nextDouble();
				Double f2 = scanner.nextDouble();
				String label = scanner.next();
				Boolean isTest = scanner.nextBoolean();
//				System.out.println(scanner.nextLine());
				
				DataPoint dataPoint = new DataPoint(f1, f2, label, isTest);
		
				brandNewData.add(dataPoint);
				
				System.out.println(dataPoint);
			}
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		System.out.println("Hello");
		System.out.println(brandNewData);
		return brandNewData;
	}

	@Override
	public String test(DataPoint data) {
		return null;
	}

	@Override
	public Double getAccuracy(ArrayList<DataPoint> data) {
		
		Double goodSum = 0.0;
		Double badSum = 0.0;
		
		int numGood = 0;
		int numBad = 0;

		for (int i = 0; i < data.size(); i++) {
			DataPoint d = data.get(i);
			Double f = d.getF1();
			String label = d.getLabel();
			
			// Compute avg here.
			if (label.equals("Good")) {
				goodSum += f;
				numGood += 1;
			}
			
			else if (label.equals("Bad")) {
				badSum += f;
				numBad += 1;
			}

		this.goodAvg = goodSum / numGood;
		this.badAvg = badSum / numBad;

		}
		System.out.println(goodAvg);
		System.out.println(badAvg);
		return 0.0;
	}

	@Override
	public String getPrecision(ArrayList<DataPoint> data) {
		return null;
//		double goodDist = Math.abs(data.getF1() - this.goodAvg);
//		double badDist = Math.abs(data.getF2() - this.badAvg);
//		
//		if (goodDist < badDist) {
//			return "Good";
//			
//		} else {
//			
//			return "Bad"; 
//		}
	}
}


