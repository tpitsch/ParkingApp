package parkingDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelObjects.Lot;
import modelObjects.Space;
import modelObjects.Staff;
import modelObjects.StaffSpace;

public class ParkingDB {
	

	private static String userName = "tpitsch";
	private static String password = "omRaic";
	private static String serverName = "cssgate.insttech.washington.edu"; 
	private static Connection sConnection;

	
	
	/**
	 * Creates a sql connection to MySQL using the properties for
	 * userid, password and server information. (Copied from example by Menaka Abraham).
	 * @throws SQLException
	 */
	public static void createConnection() throws SQLException {
		sConnection =  DriverManager
				.getConnection("jdbc:mysql://" + serverName + "/" + userName + "?user=" + userName + "&password=" + password);
	}
	
	
	/**
	 * Adds a lot to the database with the given user input.
	 * @param lot the lot that needs to be added.
	 * @throws Exception when SQL error occurs.
	 */
	public void addLot(Lot lot) throws Exception {
		if (sConnection == null) {
			createConnection();
		}
		String sql = "insert into Lot values " + "(?, ?, ?, ?); ";
		PreparedStatement ps = null;
		
		try {
			ps = sConnection.prepareStatement(sql);
			ps.setString(1, lot.getName());
			ps.setString(2, lot.getLocation());
			ps.setInt(3,lot.getCapacity());
			ps.setInt(4, lot.getFloors());
			ps.executeUpdate();
		}catch(SQLException e) {
			//throw new Exception("Unable to add new Lot: " + e.getMessage());
		}
	}
	
	/**
	 * Add a space to the database with user input.
	 * @param space the space to be added
	 * @throws SQLException
	 */
	public void addSpace(Space space) throws Exception {
		if (sConnection == null) {
			createConnection();
		}
		
		String sql = "insert into Space values " + "(?, ?, ?); ";
		PreparedStatement ps = null;
		
		try {
			ps = sConnection.prepareStatement(sql);
			ps.setInt(1, space.getSpaceNumber());
			ps.setString(2, space.getSpaceType());
			ps.setString(3, space.getLotName());
			ps.executeUpdate();
		}catch(SQLException e) {
			//throw new Exception("Unable to add new Space: " + e.getMessage());
		}
	}
	
	/**
	 * Adds a new staff member to the database
	 * @param staff new staff member to add
	 * @throws Exception
	 */
	public void addStaff(Staff staff) throws Exception {
		if (sConnection == null) {
			createConnection();
		}
		
		String sql = "insert into Staff values " + "(?, ?, ?, ?); ";
		PreparedStatement ps = null;
		
		try {
			ps = sConnection.prepareStatement(sql);
			ps.setString(1, staff.getStaffName());
			ps.setString(2, staff.getStaffNumber());
			ps.setString(3, staff.getExt());
			ps.setString(4, staff.getLicense());
			ps.executeUpdate();
		}catch(SQLException e) {
			//throw new Exception("Unable to add new Space: " + e.getMessage());
		}
	}

	/**
	 * Updates a staff members license & phone number. If one parameter is blank, it will be unchanged.
	 * @param id ID of the staff member to edit.
	 * @param phone new phone number
	 * @param license new license place number
	 * @throws SQLException
	 */
	public void updateStaff(String id, String phone, String license) throws SQLException {
		if (sConnection == null)	{
			createConnection();
		}
		//Default sql statement case, both phone and license being updated
		String sql = "UPDATE Staff SET telephoneExt = " + phone + ", vehicleLicenseNumber = " + license
				+ " WHERE staffNumber = " + id;
		if(phone.equals("") && license.equals("")) {
			//phone and license blank, update nothing.
			return;
		} else if (phone.equals(""))	{
			//Phone is blank, update license
			sql = "UPDATE Staff SET vehicleLicenseNumber = " + license + "WHERE staffNumber = " + id;
		} else if (license.equals("")) {
			//License is blank, update phone
			sql = "UPDATE Staff SET telephoneExt = " + phone + " WHERE staffNumber = " + id;
		}
		PreparedStatement ps = null;
		try {
			ps = sConnection.prepareStatement(sql);
			//ps.setString(1, phone);
			//ps.setString(2, license);
			ps.executeUpdate();
		}	catch(SQLException e)	{

		}
	}
	
	//TODO test if that space is already assigned first
	public void assignSpace(StaffSpace staffSpace) throws Exception {
		if (sConnection == null) {
			createConnection();
		}
		
		String sql = "insert into StaffSpace values " + "(?, ?); ";
		PreparedStatement ps = null;
		
		ps = sConnection.prepareStatement(sql);
		ps.setString(1, staffSpace.getStaffNumber());
		ps.setInt(2, staffSpace.getSpaceNumber());
		ps.executeUpdate();
		
	}
	
	//TODO add statements to allow staff to reserve a space for a visitor
	public void reserveSpace() {
		
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
	
}
