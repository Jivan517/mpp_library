package presentation;

import java.net.URL;
import java.util.ResourceBundle;

import business.Author;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Cont implements Initializable
{

	@FXML
	 TableView<Author> t;

	@FXML
	 TableView<Author> tt;

	@FXML
	 TableColumn<Author, String> nn;

	@FXML
	 TableColumn<Author, String> an;

	@FXML
	 TableColumn<Author, String> sn;

	@FXML
	 TableColumn<Author, String> dd;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ObservableList<Author> oe = FXCollections.observableArrayList(new Author("z","15","M","jkasd"),new Author("z","15","M","jkasd")
				,new Author("zk","15","M","jkasd"),new Author("z","15","M","jkasd"),new Author("z","15","M","jkasd"));

		nn.setCellValueFactory(new PropertyValueFactory<>("su"));
		sn.setCellValueFactory(new PropertyValueFactory<>("s"));
		an.setCellValueFactory(new PropertyValueFactory<>("a"));
		dd.setCellValueFactory(new PropertyValueFactory<>("cuu"));

//		ii.setCellValueFactory(new PropertyValueFactory<>("n"));
//		tl.setCellValueFactory(new PropertyValueFactory<>("shortBio"));

//		t.setItems(cc);
//		t.setItems(oe);


	}



}
