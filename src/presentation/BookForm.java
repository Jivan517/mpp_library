package presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookForm extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("BookForm.fxml"));
		Scene scene = new Scene(root, 300, 175);
		primaryStage.setTitle("Add/Edit Book");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
}
