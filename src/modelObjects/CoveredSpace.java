package modelObjects;

public class CoveredSpace {
	
	private int spaceNumber;
	private double rate;
	
	public CoveredSpace(int spaceNumber, double rate) {
		this.spaceNumber = spaceNumber;
		this.rate = rate;
	}

	
	public int getSpaceNumber() {
		return spaceNumber;
	}
	public double getRate() {
		return rate;
	}
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
}
