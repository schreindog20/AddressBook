package address.data;

import java.util.TreeSet;
import java.util.Vector;
import javax.swing.JList;
import java.util.Iterator;
import java.sql.*;
import address.data.*;

/**
 * 
 * @author Eric
 * @version 1.0
 *
 * Purpose: This class represents an address book, containing multiple address book entries
 */
public class AddressBook {
	/**
	 * A TreeSet collection for storing and sorting AddressBookEntry objects
	*/
	protected TreeSet <AddressEntry> Book;
	/** Vector of collection (for JList display in GUI) */
	private Vector <AddressEntry> BookVector;
	/** JList of collection for display in GUI */
	private JList <AddressEntry> BookList;
	
	/**
	 * Returns a new AddressBook object with an empty TreeSet Book
	 * @return A new AddressBook object with an empty TreeSet Book
	 */
	public AddressBook()
	{
		Book = new TreeSet<AddressEntry>(new MyComparator());
	}
	
	public JList<AddressEntry> getBookList()
	{
		BookVector = new Vector(Book);
		BookList = new JList(BookVector);
		return BookList;
	}
	/**
	 * Adds an AddressEntry object to the AddressBook's TreeSet. If the entry is already in the Book
	 * (has the same ID as an entry already in the list), it does nothing
	 * @param e is an AddressEntry object
	 */
	public void add(AddressEntry e)
	{
		boolean match = false;
		Iterator<AddressEntry> iter = Book.iterator();
		while (iter.hasNext())
		{
			if (e.getID() == iter.next().getID())
			{
				match = true;
				break;
			}
		}
		if (match == false)
			Book.add(e);
	}
	
	/**
	 * Removes an AddressEntry object from the AddressBook's TreeSet
	 * @param e is an AddressEntry object
	 */
	public void remove(AddressEntry e)
	{
		Iterator<AddressEntry> i = Book.iterator();
		while (i.hasNext())
			if (i.next() == e)
				i.remove();

	}
	
	/**
	 * Reads AddressEntry data from the database, and adds the new AddressEntry objects to 
	 * the AddressBook's TreeSet.
	 * @throws SQLException 
	 */
	public void init() throws SQLException
	{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","anonymous","password");
		Statement stmnt = conn.createStatement();
		ResultSet rset = stmnt.executeQuery("select * from ADDRESSENTRYTABLE");
		int max = 1;
		while(rset.next())
		{
			add(new AddressEntry(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), 
					rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9)));
			if (rset.getInt(1) > max)
			{
				max = rset.getInt(1);
			}
		}	
		AddressEntry.setADDRESSENTRYID(max);
	}
	
	/**
	 * Clears the database of all AddressEntries and then saves to the database all entries stored in
	 * program memory.
	 * @throws SQLException
	 */
	public void saveToDB() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","anonymous","password");
		Statement stmnt = conn.createStatement();
		stmnt.executeUpdate("truncate table ADDRESSENTRYTABLE");
		stmnt.close();
		PreparedStatement addEntry = conn.prepareStatement("insert into ADDRESSENTRYTABLE values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
		Iterator<AddressEntry> iter = Book.iterator();
		AddressEntry entry;
		while (iter.hasNext())
		{
			entry = iter.next();
			addEntry.setInt(1, entry.getID());
			addEntry.setString(2, entry.getName().getFirstName());
			addEntry.setString(3, entry.getName().getLastName());
			addEntry.setString(4, entry.getAddress().getStreet());
			addEntry.setString(5, entry.getAddress().getCity());
			addEntry.setString(6, entry.getAddress().getState());
			addEntry.setString(7, entry.getAddress().getZip());
			addEntry.setString(8, entry.getTelephone());
			addEntry.setString(9, entry.getEmail());
			addEntry.executeQuery();
		}
		addEntry.close();
		conn.close();
	}
	
	/**
	 * Finds returns a JList all of the Address Entries that have prefixes matching the given String
	 * for display
	 * @param name is the name (or beginning of a name) to be searched for
	 * @return searchList is a JList of AddressEntry objects with lastName matching the parameter
	 */
	public JList<AddressEntry> findForListing(String name)
	{
		Iterator<AddressEntry> i = Book.iterator();
		AddressEntry a;
		Vector<AddressEntry> searchVector = new Vector<AddressEntry>();
		while (i.hasNext())
		{
			a = i.next();
			if (a.getName().getLastName().startsWith(name))
			{
				searchVector.addElement(a);
			}
		}
		JList<AddressEntry> searchList = new JList(searchVector);
		return searchList;
	}
	
	/**
	 * Finds returns a JList all of the Address Entries that have notes with info
	 * matching the given String for display
	 * @param name is the name (or beginning of a name) to be searched for
	 * @return searchList is a JList of AddressEntry objects with lastName matching the parameter
	 * @throws SQLException 
	 */
	public JList<AddressEntry> findForListingKeyword(String keyword) throws SQLException
	{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","anonymous","password");
		PreparedStatement keywordSearch = conn.prepareStatement("select * from NOTESTABLE where INFO like ?");
		keywordSearch.setString(1, "%" + keyword + "%");
		ResultSet rset = keywordSearch.executeQuery();
		AddressEntry entry;
		Vector<AddressEntry> searchVector = new Vector<AddressEntry>();
		while (rset.next())
		{
			Iterator<AddressEntry> i = Book.iterator();
			while (i.hasNext()) {
				entry = i.next();
				if (rset.getInt(1) == entry.getID())
					searchVector.add(entry);
			}
		}
		JList<AddressEntry> searchList = new JList(searchVector);
		return searchList;
	}
}