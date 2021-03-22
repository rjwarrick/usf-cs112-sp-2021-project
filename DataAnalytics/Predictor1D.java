package dataanalytics;

import java.lang.Math;
import java.util.ArrayList;

public class Predictor1D {
	
	public Double greenAvg;
	public Double blueAvg;
	
	public void readData(ArrayList<DataPoint> data) {
		// TODO:
		Double greenSum = 0.0;
		Double blueSum = 0.0;
		
		int numGreen = 0;
		int numBlue = 0;

		for (int i = 0; i < data.size(); i++) {
			DataPoint d = data.get(i);
			Double f = d.getF1();
			String label = d.getLabel();
			
			// Compute avg here.
			if (label.equals("Green")) {
				greenSum += f;
				numGreen += 1;
			}
			
			else if (label.equals("Blue")) {
				blueSum += f;
				numBlue += 1;
			}

		this.greenAvg = greenSum / numGreen;
		this.blueAvg = blueSum / numBlue;

		}
		System.out.println(greenAvg);
		System.out.println(blueAvg);
	}
	

	
	public String test(DataPoint data) {
		// TODO: Return Blue or green based on how close it is to computed average
		double greenDist = Math.abs(data.getF1() - this.greenAvg);
		double blueDist = Math.abs(data.getF1() - this.blueAvg);
		
		if (greenDist < blueDist) {
			return "Green";
			
		} else {
			
			return "Blue"; 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predictor1D predictor = new Predictor1D();
		ArrayList<DataPoint> data = new ArrayList<DataPoint>(4);
		data.add(new DataPoint(2.0, "Green"));
		data.add(new DataPoint(4.0, "Green"));
		data.add(new DataPoint(9.0, "Blue"));
		data.add(new DataPoint(11.0, "Blue"));
		data.add(new DataPoint(13.0, "Blue"));
		//
		DataPoint testData1 = new DataPoint(9.0);
		DataPoint testData2 = new DataPoint(1.0);
		
		predictor.readData(data);
		System.out.println(predictor.test(testData1));
		System.out.println(predictor.test(testData2));
		
		int [][] my2dArr;
		my2dArr = new int[10][20]; // (null, null, null, null, ...,)
		for (int i = 0; i < my2dArr.length; i++) {
			my2dArr[i] = new int[i * 20];
		}
		System.out.println(my2dArr[9].length);


	}

}
