package dataanalytics;

import java.util.ArrayList;

public abstract class Predictor {
	
	abstract ArrayList<DataPoint> readData(String filename);
	
	abstract String test(DataPoint data);
	
	abstract Double getAccuracy(ArrayList<DataPoint>data);
	
	abstract String getPrecision(ArrayList<DataPoint>data);

}
