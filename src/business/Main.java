package business;
import dataaccess.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import presentation.*;
import javafx.application.Application;

import javafx.stage.Stage;
public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		LibraryMember member = new LibraryMember("John4");

		ArrayList<Author> authors = new ArrayList();
		authors.add(new Author("Misss", "Guuu", "crreeee", "TOTOTOTTO"));

		Book b = new Book("COBY", "0913", authors);
		Publication p = b;

		LendableCopy c = new LendableCopy(343, p);
		c.setPublication(p);
		c.setCopyId(1);
		//member.checkout(c, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS));

		DataAccessFacade accessFacade = new DataAccessFacade();
//		accessFacade.saveBook("bukk", b);

		//accessFacade.saveLendableCopy(4455, c);
		System.out.println(accessFacade.readLendableCopy(4455));

		//LibraryMember m = accessFacade.readLibraryMember("john.ser");
		//System.out.println(m.toString());


//		LoginForm lf = new LoginForm();
//		lf.start(primaryStage);
	}


}
