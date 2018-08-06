package parkingDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelObjects.Lot;
import modelObjects.Space;
import modelObjects.Staff;
import modelObjects.StaffSpace;

public class ParkingDB {
	

	private static String userName = "***";
	private static String password = "***"; 
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
			ps.setString(3, staff.getExtension());
			ps.setString(4, staff.getLicense());
			ps.executeUpdate();
		}catch(SQLException e) {
			//throw new Exception("Unable to add new Space: " + e.getMessage());
		}
	}
	
	//TODO add statements to update a staff member(only phone and license can be updated)
	public void updateStaff(String phone, String licence) {
		
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
	
}
