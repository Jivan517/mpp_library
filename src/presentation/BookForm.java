package presentation;

import business.Author;
import business.Book;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.*;

public class BookForm extends Application {

	@FXML private TextField title, isbn, author, maxCheckoutLength, copyid;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("BookForm.fxml"));
		Scene scene = new Scene(root, 600, 475);
		primaryStage.setTitle("Add/Edit Book");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@FXML protected void submitAction(ActionEvent event) throws Exception {
	       Book book = new Book();
	       book.setTitle(title.getText());
	       book.setISBN(isbn.getText());
	       book.setId(System.nanoTime()/1000);
	       Author at = new Author(author.getText(), null, null, null);
	       book.addAuthor(at);
	       book.setMaxCheckoutLength(Integer.parseInt(maxCheckoutLength.getText()));
	       book.addCopy(Integer.parseInt(copyid.getText()));
	       book.save();
	}
		
	@FXML protected void handleResetButtonAction(ActionEvent event) {
	        title.setText("");
	        isbn.setText("");
	        author.setText("");
	        maxCheckoutLength.setText("");
	        copyid.setText("");
	}
	
}
