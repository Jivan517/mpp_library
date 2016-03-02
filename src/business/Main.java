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
//		LibraryMember member = new LibraryMember("John");
//		
//		ArrayList<Author> authors = new ArrayList();
//		authors.add(new Author("Zalelam", "Ghee", "credentials", "he is bad guy!"));
//		
//		Publication p = new Book("ISBN", "1234", authors);
//		
//		LendableCopy c = new LendableCopy(343, p);
//		c.setPublication(p);
//		c.setCopyId(1);
//		member.checkout(c, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS));
//		
//		
		LoginForm lf = new LoginForm();
		lf.start(primaryStage);
	}
	
}
