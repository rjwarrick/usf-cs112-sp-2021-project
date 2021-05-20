package dataanalytics;

import java.util.ArrayList;

public abstract class Predictor {
	
	public abstract ArrayList<DataPoint> readData(String filename);
	
	public abstract int test(DataPoint data);
	
	public abstract Double getAccuracy(ArrayList<DataPoint> data);
	
	public abstract Double getPrecision(ArrayList<DataPoint> data); // changed from String

}
