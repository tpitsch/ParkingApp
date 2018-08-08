package modelObjects;

/**
 * A class of parking spaces that do not have cover and are free to park in.
 */
public class UncoveredSpace {

	/** number of parking space */
	private int spaceNumber;

	/**
	 * Creates an uncovered parking spot
	 * @param spaceNumber the space number of the uncovered spot
	 */
	public UncoveredSpace(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}

	/**
	 * gets the space number of this uncovered space
	 * @return space number of this uncovered space
	 */
	public int getSpaceNumber() {
		return spaceNumber;
	}

	/**
	 * updates space number of the uncovered space
	 * @param spaceNumber new space number
	 */
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
}
