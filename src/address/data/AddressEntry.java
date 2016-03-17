package address.data;

import java.sql.*;

/**
 * 
 * @author Eric
 * @version 1.1
 * 
 * Purpose: This class represents an AddressEntry, holding String variables for name, address,
 * telephone number, and email address.  Also has a static AddressEntryIDNumber variable that will
 * increment upon every contructor call, assigning the newest AddressEntry object the next value 
 * for its AddressEntryID variable.
 */
public class AddressEntry {
	/** static ADDRESSENTRYID */
	private static int ADDRESSENTRYID;
	/** AddressEntryID */
	private int ID;
	/** Name */
	private Name name;
	/** Address */
	private Address address;
	/** Phone # */
	private String telephone;
	/** Email Address */
	private String email;


	/**
	 * Default Constructor - Returns an AddressEntry object with String variables initialized to ""
	 * @return an AddressEntry object with String variables initialized to ""
	 */
	public AddressEntry() {
		name = new Name();
		address = new Address();
		telephone = email = "";
		ID = ++ADDRESSENTRYID;
	}
	
	/**
	 * Primary Constructor - Returns an AddressEntry object with String variables initialized to
	 * parameters
	 * @return an AddressEntry object with String variables initialized to parameters
	 * @param firstName is the first name
	 * @param lastName is the last name
	 * @param street is the street address
	 * @param city is the city
	 * @param state is the state
	 * @param zip is the zip code
	 * @param telephone is a telephone number
	 * @param email is an email address
	 */
	public AddressEntry(String firstName, String lastName, String street, String city,
			String state, String zip, String telephone, String email){
		name = new Name(firstName, lastName);
		address = new Address(street, city, state, zip);
		this.telephone = telephone;
		this.email = email;
		ID = ++ADDRESSENTRYID;
	}
	
	/**
	 * Secondary Constructor - Returns an AddressEntry object with String variables initialized to 
	 * values of String variables of Name and Address parameters and telephone and email variables
	 * initialized to String parameters
	 * @param address is an Address object
	 * @param name is a Name object
	 * @param telephone is a telephone number
	 * @param email is an email address
	 */
	public AddressEntry(Name name, Address address, String telephone, String email) {
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		ID = ++ADDRESSENTRYID;
	}
	
	/**
	 * Primary Constructor - Returns an AddressEntry object with String variables initialized to
	 * parameters and ID variable initialized to parameter (for use by AddressBook.init()
	 * @return an AddressEntry object with String variables initialized to
	 * parameters and ID variable initialized to parameter
	 * @param ID is the ID number 
	 * @param firstName is the first name
	 * @param lastName is the last name
	 * @param street is the street address
	 * @param city is the city
	 * @param state is the state
	 * @param zip is the zip code
	 * @param telephone is a telephone number
	 * @param email is an email address
	 */
	public AddressEntry(int ID, String firstName, String lastName, String street, String city,
			String state, String zip, String telephone, String email){
		name = new Name(firstName, lastName);
		address = new Address(street, city, state, zip);
		this.telephone = telephone;
		this.email = email;
		this.ID = ID;
	}
	
	/** 
	 * Sets the static ADDRESSENTRYID variable to the parameter (for use by AddressBook.init())
	 * @param id is the the largest ID variable of the AddressEntries loaded from the database
	 * using the AddressBook.init() method
	 */
	public static void setADDRESSENTRYID(int id) {
		ADDRESSENTRYID = id;
	}
	
	/**
	 * Sets the telephone variable to the parameter
	 * @param zip is the telephone number
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * Sets the email variable to the parameter
	 * @param zip is the email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Returns the Name object of the AddressEntry object
	 * @return the Name object of the AddressEntry object
	 */
	public Name getName() {
		return name;
	}
	
	/**
	 * Returns the Address object of the AddressEntry object
	 * @return the Address object of the AddressEntry object
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Returns the telephone String variable of the AddressEntry object
	 * @return the telephone variable of the AddressEntry object
	 */
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * Returns the email String variable of the AddressEntry object
	 * @return the email variable of the AddressEntry object
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Returns the AddressEntryID integer variable of the AddressEntry object
	 * @return the AddressEntryID variable of the AddressEntry object
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * Converts the data of an AddressEntry object to a String object for printing and returns that String
	 * @return s is a String of the AddressEntry object's data
	 */
	public String toString() {
		String s = name.getLastName();
		s += ", ";
		s += name.getFirstName();
		s += "    ";
		s += address.getStreet();
		s += " ";
		s += address.getCity();
		s += ", ";
		s += address.getState();
		s += " ";
		s += address.getZip();
		s += "    ";
		s += telephone;
		s += " ";
		s += email;
		s += "\n";
		return s;
	}
	
	/**
	 * Adds a new note to the NOTESTABLE in database associated with the AddressEntry object
	 * @param info is the note information
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void addNote(String info) throws ClassNotFoundException, SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","anonymous","password");
		PreparedStatement storeNote = conn.prepareStatement("insert into NOTESTABLE values(?, ?)");
		storeNote.setInt(1, this.ID);
		storeNote.setString(2, info);
		storeNote.executeQuery();
		storeNote.close();
		conn.close();

	}
	
	/** 
	 * Converts the data from NOTESTABLE in the database w/ the AdressEntryID of this AddressEntry
	 * object into a String for displaying in GUI
	 * @return a String representation of the Note objects associated with this AddressEntry object
	 * @throws SQLException
	 */
	public String notesToString() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","anonymous","password");
		PreparedStatement retrieveNotes = conn.prepareStatement("select * from NOTESTABLE where ADDRESSENTRYID = ?");
		retrieveNotes.setInt(1,  this.ID);
		String s = "";
		ResultSet rset = retrieveNotes.executeQuery();
		int count = 1;
		while (rset.next())
		{
			s += count++ + ") ";
			s += rset.getString(2);
			s += "\n\r";
		}
		retrieveNotes.close();
		conn.close();
		return s;
	}
}