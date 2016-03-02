package presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainForm extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
		Scene scene = new Scene(root, 500, 175);
		primaryStage.setTitle("Librarian");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	@FXML protected void handleAddMemberButtonAction(ActionEvent event) throws Exception {
	       AddMember am = new AddMember();
	       Stage stage = new Stage();
			am.start(stage);
    }
	@FXML protected void handleListMemberButtonAction(ActionEvent event) {
	       
    }
	@FXML protected void handleSearchMemberButtonAction(ActionEvent event) {
	       
    }
	@FXML protected void handleAddBookButtonAction(ActionEvent event) {
	       
    }
	@FXML protected void handleAddCopyButtonAction(ActionEvent event) throws Exception {
	       AddCopyForm ac = new AddCopyForm();
	       Stage stage = new Stage();
	       ac.start(stage);
    }

}
