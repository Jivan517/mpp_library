package presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CheckOut extends Application
{
	@FXML
	private TextField mem_id;
	@FXML
	private TextField isbn_num;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("CheckOut.fxml"));
		Scene scene = new Scene(root, 650, 720);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Book Check out");
		primaryStage.setScene(scene);
		primaryStage.show();
		}

	@FXML protected void handleSearchMem(ActionEvent event) throws Exception {

		String memberId = mem_id.getText();
		System.out.println(memberId);
	}

	@FXML protected void handleSearchBookCopy(ActionEvent event) throws Exception {

		String isbn_number = isbn_num.getText();

		System.out.println(isbn_number);

	}

	@FXML protected void handleResetButtonAction(ActionEvent event) throws Exception {

		mem_id.setText("");
		isbn_num.setText("");
	}

	@FXML protected void handleDoneButtonAction(ActionEvent event) throws Exception {
		this.stop();
	}

	@FXML protected void handleCheckOutButton(ActionEvent event) throws Exception {
//		LibraryMember member = new LibraryMember(memberId, memberId + " " + isbn_number);
		System.out.println("CO");
	}
	@FXML
	public void printToConsole(ActionEvent event) throws Exception{
		System.out.println("BOOK");
	}
}