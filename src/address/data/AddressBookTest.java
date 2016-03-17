package address.data;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;

public class AddressBookTest {

	@Test
	public void testAddressBook() {
		AddressBook A = new AddressBook();
		AddressBook B = new AddressBook();
		assertEquals(0, A.Book.size());
		B.add(new AddressEntry());
		assertEquals(1, B.Book.size());
	}

	@Test
	public void testGetBookList() {
		AddressBook A = new AddressBook();
		AddressEntry E = new AddressEntry("First", "Last", "Address", "City", "State", "Zip", "Phone", "Email");
		AddressEntry E2 = new AddressEntry("First2", "Last2", "Address2", "City2", "State2", "Zip2", "Phone2", "Email2");
		A.add(E);
		A.add(E2);
		AddressBook B = new AddressBook();
		AddressEntry E3 = new AddressEntry("First3", "Last3", "Address3", "City3", "State3", "Zip3", "Phone3", "Email3");
		AddressEntry E4 = new AddressEntry("First4", "Last4", "Address4", "City4", "State4", "Zip4", "Phone4", "Email4");	
		B.add(E3);
		B.add(E4);
}
	@Test
	public void testAdd() {
		AddressBook A = new AddressBook();
		AddressBook B = new AddressBook();
		A.add(new AddressEntry());
		B.add(new AddressEntry());
		B.add(new AddressEntry());
		assertEquals(1, A.Book.size());
		assertEquals(2, B.Book.size());
	}

	@Test
	public void testRemove() {
		AddressBook A = new AddressBook();
		AddressBook B = new AddressBook();
		AddressEntry E = new AddressEntry();
		A.add(E);
		A.add(new AddressEntry());
		AddressEntry E1 = new AddressEntry();
		B.add(E1);
		B.add(new AddressEntry());
		assertEquals(2, A.Book.size());
		assertEquals(2, B.Book.size());
		A.remove(E);
		B.remove(E1);
		assertEquals(1, A.Book.size());
		assertEquals(1, B.Book.size());
	}

	@Test
	public void testInit() throws SQLException {
		AddressBook A = new AddressBook();
		AddressBook B = new AddressBook();
		A.init();
		B.init();
		assertEquals(5, A.Book.size());
		assertEquals(5, B.Book.size());
	}

	@Test
	public void testSaveToDB() throws SQLException {
		AddressBook A = new AddressBook();
		AddressBook B = new AddressBook();
		A.init();
		AddressEntry E = new AddressEntry();
		A.saveToDB();
		B.init();
		assertEquals(A.Book.size(), B.Book.size());
		B.remove(E);
		B.saveToDB();
	}

	@Test
	public void testFindForListing() throws SQLException {
		AddressBook A = new AddressBook();
		AddressBook B = new AddressBook();
		A.init();
		B.init();
		assertEquals(A.findForListing("Schreiner").getModel().getSize(), B.findForListing("Schreiner").getModel().getSize());
	}
	
	@Test
	public void testFindForListingKeyword() throws SQLException {
		AddressBook A = new AddressBook();
		AddressBook B = new AddressBook();
		A.init();
		B.init();
		assertEquals(1, A.findForListingKeyword("ark").getModel().getSize());
		assertEquals(0, B.findForListingKeyword("hellokitty").getModel().getSize());
	}

}