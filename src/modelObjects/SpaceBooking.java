package modelObjects;

/**
 * A class meant to be used to book parking spaces by staff of a company.
 */
public class SpaceBooking {

	/** The ID of this booking */
	private int bookingID;

	/** The space number to be booked */
	private int spaceNumber;

	/** The staff number of the staff who is booking */
	private int staffNumber;

	/** The license plate of the visitor the spot is booked for */
	private String visitorLicense;

	/** The date the spot is booked for */
	private String dateOfVisit;

	/**
	 * Creates a new booking for a parking space
	 * @param bookingID ID of booking
	 * @param spaceNumber parking space to be booked
	 * @param staffNumber staff member who is booking
	 * @param visitorLicense license plate of visitor
	 * @param dateOfVisit date visitor will be visiting
	 */
	public SpaceBooking(int bookingID,int spaceNumber, int staffNumber, 
						String visitorLicense,String dateOfVisit) {
		this.bookingID = bookingID;
		this.spaceNumber = spaceNumber;
		this.staffNumber = staffNumber;
		this.visitorLicense = visitorLicense;
		this.dateOfVisit = dateOfVisit;
	}

	/**
	 * Gets booking ID of this booking
	 * @return booking ID
	 */
	public int getBookingID() {
		return bookingID;
	}

	/**
	 * gets the space number of this booking
	 * @return space number
	 */
	public int getSpaceNumber() {
		return spaceNumber;
	}

	/**
	 * gets the staff number of the staff member who made the booking
	 * @return staff number of who made the booking
	 */
	public int getStaffNumber() {
		return staffNumber;
	}

	/**
	 * gets the license plate of who the booking is for
	 * @return license plate of visitor
	 */
	public String getVisitorLicense() {
		return visitorLicense;
	}

	/**
	 * gets the date the visitor will be visiting
	 * @return date visitor will be visiting
	 */
	public String getDateOfVisit() {
		return dateOfVisit;
	}

	/**
	 * updates the booking ID
	 * @param bookingID new booking ID
	 */
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	/**
	 * updates the space number
	 * @param spaceNumber new space number
	 */
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}

	/**
	 * updates the staff number
	 * @param staffNumber new staff number
	 */
	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}

	/**
	 * updates the visitors license plate
	 * @param license new license plate
	 */
	public void setVisitorLicense(String license) {
		this.visitorLicense = license;
	}

	/**
	 * updates the date of the booking visit
	 * @param date new date of visit
	 */
	public void setDateOfVisit(String date) {
		this.dateOfVisit = date;
	}
}
