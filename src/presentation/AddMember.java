package presentation;

import java.awt.TextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddMember extends Application {

	private TextField txtmember_id;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("AddMember.fxml"));
		Scene scene = new Scene(root, 500, 400);
		primaryStage.setTitle("Add Library Member");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML protected void handleSubmitButtonAction(ActionEvent event) throws Exception {

		System.out.println(this.txtmember_id.getText());
	   
	}
	@FXML protected void handleResetButtonAction(ActionEvent event) throws Exception {
	       
		   
	}
}
