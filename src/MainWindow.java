import java.io.IOException;

import controller.GUIController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelObjects.Lot;
import parkingDatabase.ParkingDB;

public class MainWindow extends Application{
	
	private Stage primaryStage;
	private ParkingDB db;
	
	@Override
    public void start(Stage primaryStage) throws Exception {
      this.primaryStage = primaryStage;
      mainWindow();
    }
	public void mainWindow() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/appWindow.fxml"));
    		AnchorPane pane = loader.load();
    	 
    		GUIController cont = loader.getController();
    		db = new ParkingDB();
    		cont.makeComp(db);
    		
    		Scene scene = new Scene(pane);
    		
    		
    		primaryStage.setScene(scene);
    		primaryStage.show();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    
    }
    
 public static void main(String[] args) {
        launch(args);
    }
}


