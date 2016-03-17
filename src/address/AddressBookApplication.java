package address;

import java.sql.*;
import address.data.AddressBook;
import address.GUI.MainGUIFrame;
/**
 * 
 * @author Eric
 * @version 1.1
 *
 * Purpose: This class contains the main method and runs the program, creating a static
 * AddressBook ojbect and then a MainGUIFrame object associated with that object
 */
public class AddressBookApplication {
	/**
	 * Static AddressBook object for the application
	 */
	private static AddressBook A;
	/**
	 * 
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		A = new AddressBook();
		MainGUIFrame myFrame = new MainGUIFrame(A);
	}
}