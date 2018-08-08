package modelObjects;

/**
 * Parking space class
 */
public class Space {

	/** The number of the parking space. */
	private int spaceNumber;

	/** The type of parking space (Staff spot, covered, uncovered) */
	private String spaceType;

	/** The name of the lot the parking space is in. */
	private String lotName;

	/**
	 * Constructor for a parking space.
	 * @param spaceNumber number of the parking space
	 * @param spaceType type of parking space (staff spot, covered, uncovered)
	 * @param lotName name of the lot the parking space is in
	 */
	public Space(int spaceNumber, String spaceType, String lotName) {
		this.spaceNumber = spaceNumber;
		this.spaceType = spaceType;
		this.lotName = lotName;
	}

	/**
	 * gets space number
	 * @return space number
	 */
	public int getSpaceNumber() {
		return spaceNumber;
	}

	/**
	 * gets space type
	 * @return space type
	 */
	public String getSpaceType() {
		return spaceType;
	}

	/**
	 * gets lot name
	 * @return lot name
	 */
	public String getLotName() {
		return lotName;
	}

	/**
	 * updates space number
	 * @param spaceNumber new space number
	 */
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}

	/**
	 * updates space type
	 * @param spaceType new space type
	 */
	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	/**
	 * updates lot name
	 * @param lotName new lot name
	 */
	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

}
