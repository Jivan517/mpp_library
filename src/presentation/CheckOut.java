package presentation;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import business.Author;
import business.Book;
import business.LibraryMember;
import business.UILib;
import dataaccess.DataAccessFacade;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CheckOut extends Application
{
	private Book book;
	@FXML
	private TextField mem_id;
	@FXML
	private TextField isbn_num;
	@FXML
	private TableView<Author> checkout_records;

	@FXML private TableColumn<Author, String> due_date;
	@FXML private TableColumn<Author, String> return_date;

	@FXML private TableColumn<Author, String> checkout_date;

	@FXML private TableColumn<Author, String> title;


	@FXML private Label isbn, btitle,  copynum, author, popular, availablenum;
	@FXML private Label bid;

	public void setBookInfo(){
		isbn.setText(book.getISBN());
		btitle.setText(book.getTitle());
		bid.setText(Long.toString(book.getId()));
		copynum.setText(Integer.toString(book.numberOfCopies()));
		author.setText(book.getAuthor());
		availablenum.setText(Integer.toString(book.getAvailableNumber()));

	}
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

		DataAccessFacade accessFacade = new DataAccessFacade();
		LibraryMember lm = (LibraryMember) accessFacade.readLibraryMember(memberId);

		System.out.println(lm.getName());

	}

	@FXML protected void handleSearchBookCopy(ActionEvent event) throws Exception {

		String isbn_number = isbn_num.getText();

		book = Book.bookWithISBN(isbn_number);
		if(book == null){
			UILib.toast("No such book");
			return;
		}

		this.setBookInfo();

	}

	@FXML protected void handleResetButtonAction(ActionEvent event) throws Exception {

		mem_id.setText("");
		isbn_num.setText("");
	}

	@FXML protected void handleDoneButtonAction(ActionEvent event) throws Exception {
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	@FXML protected void handleCheckOutButton(ActionEvent event) throws Exception {
//		LibraryMember member = new LibraryMember(memberId, memberId + " " + isbn_number);
		System.out.println("CO");
	}
	@FXML
	public void printToConsole(ActionEvent event) throws Exception{
		System.out.println("BOOK");
	}

	@FXML
	public void initialize() {

		List<Author> as = new ArrayList<>();
		as.add(new Author("Auth", "Auth", "cred", "Bio"));

		ObservableList<Author> b = FXCollections.observableArrayList();

		b.add(new Author("Auth", "Auth", "cred", "Bio"));
		b.add(new Author("Auth", "Auth", "cred", "Bio"));
		b.add(new Author("Auth", "Auth", "cred", "Bio"));
		b.add(new Author("Auth", "Auth", "cred", "Bio"));
		b.add(new Author("Auth", "Auth", "cred", "Bio"));
		b.add(new Author("Auth", "Auth", "cred", "Bio"));
		b.add(new Author("Auth", "Auth", "cred", "Bio"));
		b.add(new Author("Auth", "Auth", "cred", "Bio"));
		b.add(new Author("Auth", "Auth", "cred", "Bio"));

//				b.add(new Book("1", "tit1", as));
//				b.add(new Book("1", "tit1", as));
//				b.add(new Book("1", "tit1", as));

			title.setCellValueFactory(new PropertyValueFactory<Author,String>("credential"));
			due_date.setCellValueFactory(new PropertyValueFactory<Author,String>("credential"));
			return_date.setCellValueFactory(new PropertyValueFactory<Author,String>("credential"));
			checkout_date.setCellValueFactory(new PropertyValueFactory<Author,String>("shortBio"));

			checkout_records.setItems(b);

	}
}