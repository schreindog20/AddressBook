package address.data.note;
/**
 * 
 * @author Eric
 * @verison 1.0
 * 
 * Purpose: This class represents a note, holding a String variable for the note information and 
 * an integer variable to store the AddressEntryID of the AddressEntry the note is associated with
 */
public class Note {
	/** Note information */
	private String info;
	/** AddressEntryID Number */
	private int AddressEntryID;
	
	/**
	 * Paramaterized Constructor - Returns a Note object with variables initialized to parameters
	 * @return a Note object with variables initialized to parameters
	 * @param AddressEntryID is the AddressEntryID of the associated AddressEntry object
	 * @param info is the information the note contains
	 */
	public Note(int AddressEntryID, String info) {
		this.info = info;
		this.AddressEntryID = AddressEntryID;
	}
	
	/**
	 * Returns the note information
	 * @return the note information
	 */
	public String getInfo() {
		return info;
	}
}