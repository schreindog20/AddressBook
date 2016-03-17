package address.data;

/**
 * 
 * @author Eric
 * @version 1.0
 * 
 * Purpose: This class represents a person's name, holding String variables for first and last names
 */
public class Name {
	/** First Name */
	private String firstName;
	/** Last Name */
	private String lastName;
	
	/**
	 * Default Constructor - returns a Name object with variables initialized to ""
	 * @return a Name object with variables initialized to ""
	 */
	public Name() {
		firstName = lastName = "";
	}
	
	/**
	 * Fully-Parameterized Constructor - returns a Name object with variables initialized to parameters
	 * @ a Name object with variables initialized to parameters
	 * @param firstName is the first name
	 * @param lastName is the last name
	 */
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Sets the firstName String variable to the parameter
	 * @param firstName is the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Sets the lastName String variable to the parameter
	 * @param lastName is the first name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns the first name of the Name object
	 * @return the first name of the Name object
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Returns the last name of the Name object
	 * @return the last name of the Name object
	 */
	public String getLastName() {
		return lastName;
	}
}