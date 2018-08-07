package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelObjects.Lot;
import modelObjects.Space;
import modelObjects.Staff;
import modelObjects.StaffSpace;
import parkingDatabase.ParkingDB;

public class GUIController{
	
	private ParkingDB db  = new ParkingDB();
	@FXML private VBox lotBox;
	@FXML private VBox spaceBox;
	@FXML private VBox staffBox;


    @FXML private TextField idEntry;
    @FXML private TextField extEntry;
    @FXML private TextField licenseEntry;
	@FXML private TableView<Staff> staffTable = new TableView<Staff>();
	@FXML private Label invalidLabel;

    /**
     *
     * @throws Exception
     */
	public void initialize() throws Exception {
	    updateStaffList();
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
		} catch (Exception e) {
			clearFields(ol);
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
		} catch (Exception e) {
			clearFields(ol);
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
		} catch (Exception e) {
			clearFields(ol);
		}
		
	}
	
	@FXML
	public void handleAssignSpace() {
		
		ObservableList<Node> ol = staffBox.getChildren();
		
		String empNum = ((TextField) ol.get(0)).getText();
		int spaceNum = Integer.parseInt(((TextField) ol.get(1)).getText());
		
		StaffSpace ss = new StaffSpace(empNum, spaceNum);
		
		try {
			db.assignSpace(ss);
			
			clearFields(ol);
		} catch (Exception e) {
			clearFields(ol);
		}
		
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
	
	@FXML
	public void handleUpdateInfo() {
		System.out.println("update info");
	}
	
	@FXML
	public void handleReserve() {
		System.out.println("reserving space");
	}

	public void makeComp(ParkingDB db) {
		this.db = db;
	}

	private void clearFields(ObservableList<Node> l) {
		for(int i = 0; i<l.size();i++) {
			((TextField) l.get(i)).clear();
		}
	}
}

	 
