package modelObjects;

/**
 * A staff class. Contains information about staff of a company.
 */
public class Staff {

	/** The name of the staff member */
	private String staffName;

	/** The unique number of the staff member */
	private String staffNumber;

	/** The telephone extension of the staff member */
	private String ext;

	/** The license plate number of the staff member */
	private String license;

	/**
	 * Creates a new staff member
	 * @param staffName name of staff
	 * @param staffNumber unique ID of staff
	 * @param ext telephone extension of staff
	 * @param license license plate number of staff
	 */
	public Staff(String staffName, String staffNumber, String ext, String license) {
		this.staffName = staffName;
		this.staffNumber = staffNumber;
		this.ext = ext;
		this.license = license;
	}

	/**
	 * Gets the staff members name
	 * @return name of staff member
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 * gets staff members unique ID number
	 * @return staff unique ID
	 */
	public String getStaffNumber() {
		return staffNumber;
	}

	/**
	 * gets staff members telephone extension
	 * @return staff telephone extension
	 */
	public String getExt() {
		return ext;
	}

	/**
	 * gets staff members license plate
	 * @return staff membesr license plate
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * updates staff members name
	 * @param staffName new name
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 * updates staff members unique ID number (which should never happen)
	 * @param staffNumber new ID number
	 */
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	/**
	 * Updates the extension number of a staff member
	 * @param ext new telephone extension
	 */
	public void setExtension(String ext) {
		this.ext = ext;
	}

	/**
	 * updates staff members license plate
	 * @param license new license plate
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	
}

