package modelObjects;

/**
 * A class of parking spaces that have cover that have a monthly rate.
 */
public class CoveredSpace {

	/** The space number of the covered space */
	private int spaceNumber;

	/** The monthly rate (cost) of this covered space */
	private double rate;

	/**
	 * Creates a new covered parking space
	 * @param spaceNumber the space number
	 * @param rate the monthly cost
	 */
	public CoveredSpace(int spaceNumber, double rate) {
		this.spaceNumber = spaceNumber;
		this.rate = rate;
	}

	/**
	 * gets the space number of this covered space
	 * @return space number
	 */
	public int getSpaceNumber() {
		return spaceNumber;
	}

	/**
	 * gets the monthly rate of this covered space
	 * @return monthly rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * updates the space number of this covered space
	 * @param spaceNumber new space number
	 */
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}

	/**
	 * updates the monthly rate of this covered space
	 * @param rate new monthly rate
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
}
