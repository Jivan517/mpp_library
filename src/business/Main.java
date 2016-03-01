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

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import presentation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
//		LibraryMember member = new LibraryMember("John");
//		Publication p = new Book(1, "1234","Gone with the Wind");
//		LendableCopy c = new LendableCopy();
//		c.setPublication(p);
//		c.setCopyId(1);
//		member.checkout(c, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS));
//		System.out.println("Location of 'user.dir':\n  "+DataAccessFacade.OUTPUT_DIR);
//		DataAccess da = new DataAccessFacade();
//		da.saveLibraryMember("John", member);
//		System.out.println("Reading record for John:\n"+"  "+da.readLibraryMember("John"));
		LoginForm lf = new LoginForm();
		lf.start(primaryStage);
	}
	

}
