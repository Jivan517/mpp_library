package dataaccess;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import business.*;

public class BookDataAccessFacade implements DataAccess {
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "/src/dataaccess/storage/book/";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	
	@Override
	public void write(String name, Object obj) {
		ObjectOutputStream out = null;
		try {
			
			Book book = (Book) obj;
			
			FileOutputStream fileOut = new FileOutputStream(OUTPUT_DIR + name);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(book);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in " + OUTPUT_DIR + name );
						
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
		
	}

	@Override
	public Object read(String name) {
		ObjectInputStream in = null;
		Book book = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
			in = new ObjectInputStream(Files.newInputStream(path));
			book = (Book)in.readObject();
		} catch(Exception e) {
			
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return book;
	}
}
