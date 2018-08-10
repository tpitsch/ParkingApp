package controller;

import java.sql.SQLException;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import modelObjects.*;
import parkingDatabase.ParkingDB;

public class GUIController{
	
	//New database information components
	private ParkingDB db  = new ParkingDB();
	@FXML private VBox lotBox;
	@FXML private VBox spaceBox;
	@FXML private VBox staffBox;

	//"Update Staff" tab components:
    @FXML private TextField idEntry;
    @FXML private TextField extEntry;
    @FXML private TextField licenseEntry;
	@FXML private TableView<Staff> staffTable = new TableView<Staff>();
	@FXML private Label invalidLabel;

	//"Assign Spot" tab components:
	@FXML private TableView<Space> spaceTable = new TableView<Space>();
	@FXML private TextField assignStaffNo;
	@FXML private TextField assignSpaceNo;
	@FXML private Label spaceTaken;

	//"Reserve" tab components:
	@FXML private TableView<CoveredSpace> freeSpaceTable = new TableView<CoveredSpace>();
	@FXML private TextField bookingId;
	@FXML private DatePicker reserveDate;
	@FXML private TextField reserveSpace;
	@FXML private TextField reserveStaff;
	@FXML private TextField reserveLic;
	@FXML private Label reserveTaken;

    /**
     *
     * @throws Exception
     */
	public void initialize() throws Exception {
	    updateStaffList();
	    updateSpaceList();
	    updateFreeCoveredSpots();
	    //Added functionality of double clicking a tableview row to get that ID into the ID entry box in "Update Staff":
	    staffTable.setRowFactory(select ->		{
	    	TableRow<Staff> row = new TableRow<>();
	    	row.setOnMouseClicked(event ->	{
	    		if(event.getClickCount() == 2 && (!row.isEmpty()))	{
	    			idEntry.setText(row.getItem().getStaffNumber());
				}
			});
	    	return row;
		});
	    //Same functionality for the table in "Assign Spot" for the space number:
		spaceTable.setRowFactory(select ->		{
			TableRow<Space> row = new TableRow<>();
			row.setOnMouseClicked(event ->	{
				if(event.getClickCount() == 2 && (!row.isEmpty()))	{
					assignSpaceNo.setText(Integer.toString(row.getItem().getSpaceNumber()));
				}
			});
			return row;
		});
    }

    /**
     *
     * @throws Exception
     */
    @FXML
	public void updateStaffList() throws Exception {
        List<Staff> staff = db.getStaff();
        staffTable.getItems().clear();
        for(Staff s : staff)    {
            if(s != null) {
                staffTable.getItems().add(s);
            }
        }
    }

    @FXML
	public void updateSpaceList() throws SQLException {
    	List<Space> space = db.getAvailableSpaces();
    	spaceTable.getItems().clear();
    	for(Space s : space)	{
    		if(s != null)	{
    			spaceTable.getItems().add(s);
			}
		}
	}
	
    
	@FXML
	public void handleAddLot() {
		ObservableList<Node> ol = lotBox.getChildren();
		try {
			
			String name = ((TextField) ol.get(0)).getText();
			String location = ((TextField) ol.get(1)).getText();
			int cap = Integer.parseInt(((TextField) ol.get(2)).getText());
			int floors = Integer.parseInt(((TextField) ol.get(3)).getText());
			
			Lot l = new Lot(name, location,cap, floors);
			
			db.addLot(l);
			
			clearFields(ol);
			
			alertBox("lot",true,false);
		} catch (SQLException e) {
			clearFields(ol);
			alertBox("lot",false,true);
		} catch (Exception e) {
			clearFields(ol);
			alertBox("lot",false,true);
		}
	}
	
	@FXML
	public void handleAddSpace() {
		ObservableList<Node> ol = spaceBox.getChildren();
		
		int spaceNumber = Integer.parseInt(((TextField) ol.get(0)).getText());
		String spaceType = ((TextField) ol.get(1)).getText();
		String lotName = ((TextField) ol.get(2)).getText();
		
		Space s = new Space(spaceNumber, spaceType, lotName);
		
		try {
			db.addSpace(s);
			
			clearFields(ol);
			alertBox("space",true,false);
		}  catch (SQLException e) {
			clearFields(ol);
			alertBox("space",false,true);
		} catch (Exception e) {
			clearFields(ol);
			alertBox("space",false,false);
		}
		
	}
	
	@FXML
	public void handleAddStaff() {
		ObservableList<Node> ol = staffBox.getChildren();
		
		String name = ((TextField) ol.get(0)).getText();
		String number = ((TextField) ol.get(1)).getText();
		String ext = ((TextField) ol.get(2)).getText();
		String license = ((TextField) ol.get(3)).getText();
		
		Staff s = new Staff(name, number, ext, license);
		
		try {
			db.addStaff(s);
			
			clearFields(ol);
			alertBox("staff",true,false);
		}  catch (SQLException e) {
			clearFields(ol);
			alertBox("lot",false,true);
		} catch (Exception e) {
			clearFields(ol);
			alertBox("lot",false,false);
		}
		
	}
	
	@FXML
	public void handleAssignSpace() throws SQLException {
		String empNum = assignStaffNo.getText();
		int spaceNum = Integer.parseInt(assignSpaceNo.getText());
		StaffSpace ss = new StaffSpace(empNum, spaceNum);
		try {
			spaceTaken.setVisible(!db.assignSpace(ss));
		} catch (Exception e) {
			alertBox("space",false,true);
		}
		assignStaffNo.clear();
		assignSpaceNo.clear();
		updateSpaceList();
	}

	@FXML
    public void handleUpdateStaff() throws Exception {
        String id = idEntry.getText();
        String ext = extEntry.getText();
        String lic = licenseEntry.getText();
        boolean idExists = false;
        //CHECK IF THE ID EXISTS
        for(Staff s : staffTable.getItems())    {
            if(s.getStaffNumber().equals(id))    {
                idExists = true;
                break;
            }
        }
        if(idExists) {
            invalidLabel.setVisible(false);
            db.updateStaff(id, ext, lic);
            updateStaffList();
            idEntry.clear();
            extEntry.clear();
            licenseEntry.clear();
        } else {
            invalidLabel.setVisible(true);
        }
    }

    public void updateFreeCoveredSpots() throws SQLException {
    	List<CoveredSpace> free = db.getAvailableCoveredSpaces();
    	freeSpaceTable.getItems().clear();
    	for(CoveredSpace cs : free)	{
    		if(cs != null)	{
    			freeSpaceTable.getItems().add(cs);
			}
		}
		bookingId.setText(Integer.toString(db.getNextBookingID()));
	}
	
	/**
	 * 
	 * @throws SQLException
	 */
	@FXML
	public void handleReserve() throws SQLException {
		//make a new booking
		String date = reserveDate.getValue().toString();
		date.replace("/","-");
		int space = Integer.parseInt(reserveSpace.getText());
		boolean taken = true;
		for(CoveredSpace cs : freeSpaceTable.getItems())	{
			if(space == cs.getSpaceNumber())	{
				taken = false;
				break;
			}
		}
		if(!taken)	{
			SpaceBooking sb = new SpaceBooking(Integer.parseInt(bookingId.getText()), space,
					Integer.parseInt(reserveStaff.getText()), reserveLic.getText(), date);
			db.reserveSpace(sb);
		}
		reserveTaken.setVisible(taken);
		updateFreeCoveredSpots();
	}


	/**
	 * Clears the list of text fields of their input.
	 * @param l the list of text fields that were used for input.
	 */
	private void clearFields(ObservableList<Node> l) {
		for(int i = 0; i<l.size();i++) {
			((TextField) l.get(i)).clear();
		}
	}
	
	/**
	 * Displays an alert box as to the success or failure of the operation
	 * @param s string of the type of operation
	 * @param b it was a success or failure
	 */
	private void alertBox(String s,boolean works, boolean sql) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		if(works && !sql) {
			alert.setTitle("It worked!");
			alert.setHeaderText("The " + s + " has been added to the database");
		}else if(!works && !sql){
			alert.setAlertType(AlertType.WARNING);
			alert.setTitle("It failed!");
			alert.setHeaderText("The " + s + " was not added to the database");
		}else if(sql) {
			alert.setAlertType(AlertType.WARNING);
			alert.setTitle("It failed!");
			alert.setHeaderText("The " + s + " was not added to the database because it"
					+ " already exists");
		}
		alert.showAndWait();
	}
}

	 
