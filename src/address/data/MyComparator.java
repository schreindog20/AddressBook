package address.data;

import java.util.Comparator;
/**
 * 
 * @author Eric
 * @version 1.0
 *
 * purpose: provides a comparator for AddressEntry objects that compares the last names of entries for sorting
 */
public class MyComparator implements Comparator<AddressEntry>{
	/**
	 * Compares the last names of 2 AddressBookEntry objects. 
	 * Returns a negative int if e1.lastName < e2.lastName, 
	 * 0 if e1.LastName == e2.LastName, and a positive int if e1.LastName > e2.LastName.
	 * 
	 * @return An int denoting whether e1 is <, ==, or > e2.
	 * @param e1 is an AddressBookEntry object
	 * @param e2 is an AddressBookEntry object
	 */
	public int compare(AddressEntry e1, AddressEntry e2)
	{
		if (e1.getName().getLastName().compareTo(e2.getName().getLastName()) < 0)
			return -1;
		else return 1;
	}
}