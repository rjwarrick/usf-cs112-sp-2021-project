package dataanalytics;

public class DataPoint {
	public double f1;
	public double f2;
	public String label;
	public boolean isTest;

	public DataPoint(double f1Param, double f2Param, String labelParam, boolean isTestParam) {
		this.f1 = f1Param;
		this.f2 = f2Param;
		this.label = labelParam;
		this.isTest = isTestParam;
	}

	public DataPoint() {
		this.f1 = 0.0;
		this.f2 = 0.0;
		this.label = "";
		this.isTest = false;
	}

	public double getF1() {
		return f1;
	}

	public double getF2() {
		return f2;
	}

	public String getLabel() {
		return label;
	}

	public boolean getIsTest() {
		return isTest;
	}

	public void setF1(double f1Param) {
		f1 = f1Param;
	}

	public void setF2(double f2Param) {
		f2 = f2Param;
	}

	public void setLabel(String labelParam) {
		label = labelParam;
	}

	public void setIsTest(boolean isTestParam) {
		isTest = isTestParam;
	}
	
	@Override
	public String toString() {
		return this.f1 + " " + this.f2 + " " + this.label + " " + this.isTest;
	}

}
