package parkingDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelObjects.CoveredSpace;
import modelObjects.Lot;
import modelObjects.Space;
import modelObjects.SpaceBooking;
import modelObjects.Staff;
import modelObjects.StaffSpace;

/**
 * A class for our application to access a database.
 */
public class ParkingDB {
	
	/** The username to login to your database. */
	private static String userName = "*";
	
	/** The password to login to your database. */
	private static String password = "*";

	/** The server name to login to your database. */
	private static String serverName = "cssgate.insttech.washington.edu";

	/** The connection to the database. Used to perform actions on the connected database. */
	private static Connection sConnection;
	
	/**
	 * Creates a sql connection to MySQL using the properties for
	 * userid, password and server information. (Copied from example by Menaka Abraham).
	 * @throws SQLException connection to DB fails
	 */
	public static void createConnection() throws SQLException {
		sConnection =  DriverManager
				.getConnection("jdbc:mysql://" + serverName + "/" + userName + "?user="
						+ userName + "&password=" + password);
	}
	
	
	/**
	 * Adds a lot to the database with the given user input.
	 * @param lot the lot that needs to be added.
	 * @throws Exception lot already exists/database error
	 */
	public void addLot(Lot lot) throws SQLException {
		if (sConnection == null) {
			createConnection();
		}
		String sql = "insert into Lot values " + "(?, ?, ?, ?); ";
		PreparedStatement ps = null;
		ps = sConnection.prepareStatement(sql);
		ps.setString(1, lot.getName());
		ps.setString(2, lot.getLocation());
		ps.setInt(3,lot.getCapacity());
		ps.setInt(4, lot.getFloors());
		ps.executeUpdate();
	}
	
	/**
	 * Add a space to the database with user input.
	 * @param space the space to be added
	 * @throws SQLException space already exists/database error
	 */
	public void addSpace(Space space) throws Exception {
		if (sConnection == null) {
			createConnection();
		}
		String sql = "insert into Space values " + "(?, ?, ?); ";
		PreparedStatement ps = null;
		ps = sConnection.prepareStatement(sql);
		ps.setInt(1, space.getSpaceNumber());
		ps.setString(2, space.getSpaceType());
		ps.setString(3, space.getLotName());
		ps.executeUpdate();
	}
	
	/**
	 * Adds a new staff member to the database
	 * @param staff new staff member to add
	 * @throws SQLException staff already exists/database error
	 */
	public void addStaff(Staff staff) throws SQLException {
		if (sConnection == null) {
			createConnection();
		}
		String sql = "insert into Staff values " + "(?, ?, ?, ?); ";
		PreparedStatement ps = null;
		ps = sConnection.prepareStatement(sql);
		ps.setString(1, staff.getStaffName());
		ps.setString(2, staff.getStaffNumber());
		ps.setString(3, staff.getExt());
		ps.setString(4, staff.getLicense());
		ps.executeUpdate();
	}

	/**
	 * Updates a staff members license & phone number. If one parameter is blank, it will be unchanged.
	 * @param id ID of the staff member to edit.
	 * @param phone new phone number
	 * @param license new license place number
	 * @throws SQLException ID does not exist/database error
	 */
	public void updateStaff(String id, String phone, String license) throws SQLException {
		if (sConnection == null)	{
			createConnection();
		}
		//Default sql statement case, both phone and license being updated
		String sql = "UPDATE Staff SET telephoneExt = " + phone + ", vehicleLicenseNumber = '" + license
				+ "' WHERE staffNumber = " + id;
		if(phone.equals("") && license.equals("")) {
			//phone and license blank, update nothing.
			return;
		} else if (phone.equals(""))	{
			//Phone is blank, update license
			sql = "UPDATE Staff SET vehicleLicenseNumber = '" + license + "' WHERE staffNumber = " + id;
		} else if (license.equals("")) {
			//License is blank, update phone
			sql = "UPDATE Staff SET telephoneExt = " + phone + " WHERE staffNumber = " + id;
		}
		PreparedStatement ps = null;
		ps = sConnection.prepareStatement(sql);
		ps.executeUpdate();
	}

	/**
	 * Assigns a space to a staff member.
	 * @param staffSpace the StaffSpace that needs to be added to the database
	 * @return boolean for if the StaffSpace was successfully added to the DB
	 * @throws SQLException failed to add to the database/database error
	 */
	public boolean assignSpace(StaffSpace staffSpace) throws Exception {
		if (sConnection == null) {
			createConnection();
		}
		List<Space> available = getAvailableSpaces();
		boolean freeSpot = false;
		for(Space s : available)	{
			if(s.getSpaceNumber() == staffSpace.getSpaceNumber())	{
				freeSpot = true;
				break;
			}
		}
		if(freeSpot) {
			String sql = "insert into StaffSpace values " + "(?, ?); ";
			PreparedStatement ps = null;

			ps = sConnection.prepareStatement(sql);
			ps.setString(1, staffSpace.getStaffNumber());
			ps.setInt(2, staffSpace.getSpaceNumber());
			ps.executeUpdate();
			return true;
		}
		return false;
	}

	/**
	 * Puts a SpaceBooking entry into the database.
	 * @param sb The spacebooking entry to add to the database.
	 * @throws SQLException invalid booking entry/failed to add to database
	 */
	public void reserveSpace(SpaceBooking sb) throws SQLException {
		if(sConnection == null)	{
			createConnection();
		}
		Statement stmt = null;
		String query = "SELECT COUNT(*) as res FROM SpaceBooking";
		stmt = sConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		//NEED TO CHECK RESERVATIONS PER DATE!
		if(rs.getInt("res") < 20) {
			//make space booking sql
			rs.close();
			query = "INSERT INTO SpaceBooking VALUES (?, ?, ?, ?, ?) ";
			PreparedStatement ps = sConnection.prepareStatement(query);
			ps.setInt(1, sb.getBookingID());
			ps.setInt(2, sb.getSpaceNumber());
			ps.setInt(3, sb.getStaffNumber());
			ps.setString(4, sb.getVisitorLicense());
			ps.setString(5, sb.getDateOfVisit());
			ps.executeUpdate();
		}
		if(stmt != null)	{
			stmt.close();
		}
	}

	/**
	 * Gets covered spaces from the database that are not assigned to anyone. Used to populate tableview
	 * @return A list of covered spaces currently not in use
	 * @throws SQLException database error
	 */
	public List<CoveredSpace> getAvailableCoveredSpaces() throws SQLException{
		if(sConnection == null)	{
			createConnection();
		}
		List<CoveredSpace> space = new ArrayList<CoveredSpace>();
		Statement stmt = null;
		String query = "SELECT spaceNumber FROM Space WHERE spaceType = \"CoveredSpace\" AND " +
								"spaceNumber NOT IN (SELECT spaceNumber FROM SpaceBooking)";
		stmt = sConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())	{
			int spaceNo = rs.getInt("spaceNumber");
			space.add(new CoveredSpace(spaceNo, 0));
		}
		if(stmt != null)	{
			stmt.close();
		}
		return space;
	}

	/**
	 * Gets a list of ALL available spaces. Used to populate tableview
	 * @return a list of all available spaces
	 * @throws SQLException Database error
	 */
	public List<Space> getAvailableSpaces() throws SQLException {
		if(sConnection == null)	{
			createConnection();
		}
		List<Space> space = new ArrayList<Space>();
		Statement stmt = null;
		String query = "SELECT spaceNumber, lotName FROM Space WHERE spaceNumber NOT IN (SELECT spaceNumber FROM StaffSpace)";
		try {
			stmt = sConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())	{
				int spaceNo = rs.getInt("spaceNumber");
				String lot = rs.getString("lotName");
				Space s = new Space(spaceNo, "staffSpace", lot);
				space.add(s);
			}
		} catch (Exception e)	{

		} finally {
			if(stmt != null)	{
				stmt.close();
			}
		}
		return space;
	}

	/**
	 * Gets a list of all staff in the database. Used to populate the tableview.
	 * (Copied and edited from Menaka Abraham's movie example)
	 * @return list of staff in database
	 * @throws Exception
	 */
	public List<Staff> getStaff() throws Exception {
		if(sConnection == null)	{
			createConnection();
		}
		Statement stmt = null;
		String query = "SELECT staffName, staffNumber, telephoneExt, vehicleLicenseNumber FROM Staff";
		List<Staff> staff = new ArrayList<Staff>();
		try {
			stmt = sConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String name = rs.getString("staffName");
				int number = rs.getInt("staffNumber");
				int tele = rs.getInt("telephoneExt");
				String license = rs.getString("vehicleLicenseNumber");
				Staff s = new Staff(name, Integer.toString(number), Integer.toString(tele), license);		//I don't like that I have to cast the numbers to strings
				staff.add(s);
			}
		}	catch (SQLException e)	{
			e.printStackTrace();
			throw new Exception("Unable to retrieve staff list: " + e.getMessage());
		}	finally {
			if (stmt != null)	{
				stmt.close();
			}
		}
		return staff;
	}

	/**
	 * Gets the next available booking ID. This allows the ID to be automatically generated for the user
	 * @return the next booking ID that should be used
	 * @throws SQLException database error.
	 */
	public int getNextBookingID() throws SQLException {
		if(sConnection == null)	{
			createConnection();
		}
		Statement stmt = null;
		String query = "SELECT COUNT(*) FROM SpaceBooking";
		int count = 0;
		try {
			stmt = sConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e)	{

		} finally {
			if (stmt != null)	{
				stmt.close();
			}
		}
		return count + 1;
	}
	
}
