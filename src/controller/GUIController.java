package controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelObjects.Lot;
import modelObjects.Space;
import parkingDatabase.ParkingDB;

public class GUIController{
	
	private ParkingDB db;
	@FXML private VBox lotBox;
	@FXML private VBox spaceBox;
	
	@FXML
	public void handleAddLot() {
		try {
			ObservableList<Node> ol = lotBox.getChildren();
			
			String name = ((TextField) ol.get(0)).getText();
			String location = ((TextField) ol.get(1)).getText();
			int cap = Integer.parseInt(((TextField) ol.get(2)).getText());
			int floors = Integer.parseInt(((TextField) ol.get(3)).getText());
			
			Lot l = new Lot(name, location,cap, floors);
			
			db.addLot(l);
			
			clearFields(ol);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleAddSpace() {
		ObservableList<Node> ol = spaceBox.getChildren();
		
		int spaceNumber = Integer.parseInt(((TextField) ol.get(3)).getText());
		String spaceType = ((TextField) ol.get(1)).getText();
		String lotName = ((TextField) ol.get(2)).getText();
		
		Space s = new Space(spaceNumber, spaceType, lotName);
		
		try {
			db.addSpace(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void handleAddStaff() {
		
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

	 
