package view;

import java.io.IOException;

import controller.GUIController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUI extends Application {
	
	private Stage primaryStage;
	
	
    @Override
    public void start(Stage primaryStage) {
      this.primaryStage = primaryStage;
      mainWindow();
    }
    
    
    public void mainWindow() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/appWindow.fxml"));
    		AnchorPane pane = loader.load();
    	 
    		Scene scene = new Scene(pane);
    		
    		GUIController control = loader.getController();
    		//control.makeWindow(primaryStage,scene);
    		
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


