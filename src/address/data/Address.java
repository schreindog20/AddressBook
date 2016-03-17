package address.data;
/**
 * 
 * @author Eric
 * @version 1.0
 * 
 * Purpose: This class represents an Address, holding String variables for street, city,
 * state, and zip code.
 */
public class Address {
	/** Street Address */
	private String street;
	/** City */
	private String city;
	/** State */
	private String state;
	/** Zip Code */
	private String zip;
	
	/**
	 * Default Constructor - returns an Address object with String variables initialized to ""
	 * @return an Address object with String variables initialized to ""
	 */
	public Address() {
		street = city = state = zip = "";
	}
	
	/**
	 * Fully-Paramaterized Constructor - returns an Address object with variables initalized to
	 * parameters
	 * @return an Address object with variables initalized to parameters
	 * @param street is the street name and address
	 * @param city is the city name
	 * @param state is the state (abbreviation)
	 * @param zip is the zip code
	 */
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	/**
	 * Sets the street variable to the parameter
	 * @param street is the street name and address
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Sets the city variable to the parameter
	 * @param city is the city name
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Sets the state variable to the parameter
	 * @param state is the state (abbreviation)
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Sets the zip variable to the parameter
	 * @param zip is the zip code
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/**
	 * Returns the street String variable
	 * @return the street variable of the Address object
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Returns the city String variable
	 * @return the city variable of the Address object
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Returns the state String variable
	 * @return the state variable of the Address object
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Returns the zip String variable
	 * @return the zip variable of the Address object
	 */
	public String getZip() {
		return zip;
	}
}