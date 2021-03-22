package dataanalytics;

public class DataPoint {
	private Double f1;
	private Double f2;
	private String label;
	Boolean isTest;
	
	public DataPoint(Double f1, Double f2, String label, Boolean isTest) {
		this.f1 = f1;
		this.f2 = f2;
		setLabel(label);
		setIsTest(isTest);
	}
	
	public DataPoint(Double f1, String label) {
		this.setF1(f1);
		this.setLabel(label);;
	}
	
	public DataPoint(Double f1) {
		this.f1 = f1;
		this.label = null;
	}
	
	public Double getF1() {
		return this.f1;
	}
	
	public Double getF2() {
		return this.f2;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public Boolean getIsTest() {
		return this.isTest;
	}

	public void setF1(Double f1) {
		// Feel free to add some restrictions
		if (f1 < 0) {
			return;
		}
		this.f1 = f1;
	}
	
	public void setF2(Double f2) {
		if (f2 < 0) {
			return;
		}
		this.f2 = f2;
	}
	
	public void setLabel(String label) {
		if (! (label.equals("Green") || label.equals("Blue"))) {
			return;
		}
		this.label = label;
	}
	
	public void setIsTest(Boolean isTest) {
		if (! (isTest.equals(true) || isTest.equals(false))) {
			return;
		}
		this.isTest = isTest;
		
	}
	
}
