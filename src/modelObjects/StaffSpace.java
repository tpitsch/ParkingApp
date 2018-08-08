package modelObjects;

/**
 * A class of parking spaces meant for staff members
 */
public class StaffSpace {

	/** The unique ID of the staff assigned to this spot */
	private String staffNumber;

	/** The parking space number */
	private int spaceNumber;

	/**
	 * Creates a new parking space for staff members.
	 * @param staffNumber Unique staff ID for this parking space
	 * @param spaceNumber number of the parking space
	 */
	public StaffSpace(String staffNumber, int spaceNumber) {
		super();
		this.staffNumber = staffNumber;
		this.spaceNumber = spaceNumber;
	}

	/**
	 * Gets the staff ID of this parking spot
	 * @return staff ID assigned to this spot
	 */
	public String getStaffNumber() {
		return staffNumber;
	}

	/**
	 * Gets the parking space number of this spot
	 * @return parking space number of this spot
	 */
	public int getSpaceNumber() {
		return spaceNumber;
	}

	/**
	 * updates the staff ID number of this spot
	 * @param staffNumber new ID number
	 */
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	/**
	 * updates space number of this parking spot
	 * @param spaceNumber new spot number
	 */
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
}
