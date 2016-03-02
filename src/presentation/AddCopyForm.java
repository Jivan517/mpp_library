package presentation;

import business.Book;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddCopyForm extends Application {
	private Book book = null;
	@FXML private TextField isbnText;
	@FXML private TextField tcid;
	@FXML private Label isbn, title,  copynum, author, popular;
	@FXML private Label bid;
	@FXML protected void handleAddButtonAction(ActionEvent event) {
		if(book == null){
			System.out.println("No book selected");
			return;
		}
		int cid = Integer.parseInt(tcid.getText());
		if(tcid.getText().length() <= 0 || cid <= 0){
			System.out.println("You should enter the correct copy id");
		}
		book.addCopy(cid);
		book.save();
	}
	@FXML protected void handleSearchButtonAction(ActionEvent event) {

		book = Book.bookWithISBN(this.isbnText.getText());
		if(book == null){
			System.out.println("No such book");
			return;
		}
		System.out.println("read one book");
		isbn.setText(book.getISBN());
		title.setText(book.getTitle());
		bid.setText(Integer.toString(book.getId()));
		copynum.setText(Integer.toString(book.numberOfCopies()));
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("AddCopyForm.fxml"));
		Scene scene = new Scene(root, 500, 400);
		primaryStage.setTitle("Add Library Member");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	
}
