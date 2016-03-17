package address.data;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;

public class AddressEntryTest {

	@Test
	public void testAddressEntry() {
		AddressEntry A = new AddressEntry();
		AddressEntry B = new AddressEntry();
		assertEquals("", A.getEmail());
		assertEquals("", B.getAddress().getCity());
		assertEquals(A.getName().getFirstName(), B.getName().getFirstName());
	}

	
	@Test
	public void testAddressEntryStringStringStringStringStringStringStringString() {
		AddressEntry A = new AddressEntry("Eric", "Schreiner", "123 Lancaster Road", "Walnut Creek",
				"Ca", "94595", "925-818-6651", "ebschreiner@gmail.com");
		AddressEntry B = new AddressEntry("Tom", "Watson", "5 Lakeview Drive", "Hayward", "Ca",
				"93423", "273-837-9918", "tdubs@yahoo.com");
		assertEquals(A.getAddress().getState(), B.getAddress().getState());
		assertEquals("Eric", A.getName().getFirstName());
		assertEquals("tdubs@yahoo.com", B.getEmail());
	}
	
	@Test
	public void testAddressEntryintStringStringStringStringStringStringStringString() {
		AddressEntry A = new AddressEntry(1, "Eric", "Schreiner", "123 Lancaster Road", "Walnut Creek",
				"Ca", "94595", "925-818-6651", "ebschreiner@gmail.com");
		AddressEntry B = new AddressEntry(2, "Tom", "Watson", "5 Lakeview Drive", "Hayward", "Ca",
				"93423", "273-837-9918", "tdubs@yahoo.com");
		assertEquals(A.getAddress().getState(), B.getAddress().getState());
		assertEquals("Eric", A.getName().getFirstName());
		assertEquals("tdubs@yahoo.com", B.getEmail());
	}

	@Test
	public void testAddressEntryintNameAddressStringString() {
		Name nameA = new Name("Eric", "Schreiner");
		Name nameB = new Name("Tom", "Watson");
		Address addressA = new Address("123 Lancaster Road", "Walnut Creek", "Ca", "94595");
		Address addressB = new Address("5 Lakeview Drive", "Hayward", "Ca", "93423");
		AddressEntry A = new AddressEntry(nameA, addressA, "925-818-6651", "ebschreiner@gmail.com");
		AddressEntry B = new AddressEntry(nameB, addressB, "273-837-9918", "tdubs@yahoo.com");
		assertEquals(A.getAddress().getState(), B.getAddress().getState());
		assertEquals("Eric", A.getName().getFirstName());
		assertEquals("tdubs@yahoo.com", B.getEmail());
	}

	@Test
	public void testSetADDRESSENTRYID() {
		AddressEntry.setADDRESSENTRYID(5);
		AddressEntry A = new AddressEntry();
		AddressEntry B = new AddressEntry();
		assertEquals(6, A.getID());
		assertEquals(7, B.getID());
	}
	
	@Test
	public void testSetTelephone() {
		AddressEntry A = new AddressEntry("Eric", "Schreiner", "123 Lancaster Road", "Walnut Creek",
				"Ca", "94595", "925-818-6651", "ebschreiner@gmail.com");
		AddressEntry B = new AddressEntry("Tom", "Watson", "5 Lakeview Drive", "Hayward", "Ca",
				"93423", "273-837-9918", "tdubs@yahoo.com");
		A.setTelephone("888-990-1111");
		B.setTelephone("555-555-5555");
		assertEquals("888-990-1111", A.getTelephone());
		assertEquals("555-555-5555", B.getTelephone());
	}

	@Test
	public void testSetEmail() {
		AddressEntry A = new AddressEntry("Eric", "Schreiner", "123 Lancaster Road", "Walnut Creek",
				"Ca", "94595", "925-818-6651", "ebschreiner@gmail.com");
		AddressEntry B = new AddressEntry("Tom", "Watson", "5 Lakeview Drive", "Hayward", "Ca",
				"93423", "273-837-9918", "tdubs@yahoo.com");
		A.setEmail("hi@yahoo.com");
		B.setEmail("bye@yahoo.com");
		assertEquals("hi@yahoo.com", A.getEmail());
		assertEquals("bye@yahoo.com", B.getEmail());
	}

	@Test
	public void testGetName() {
		AddressEntry A = new AddressEntry("Eric", "Schreiner", "123 Lancaster Road", "Walnut Creek",
				"Ca", "94595", "925-818-6651", "ebschreiner@gmail.com");
		AddressEntry B = new AddressEntry("Tom", "Watson", "5 Lakeview Drive", "Hayward", "Ca",
				"93423", "273-837-9918", "tdubs@yahoo.com");
		assertEquals("Schreiner", A.getName().getLastName());
		assertEquals("Tom", B.getName().getFirstName());
	}

	@Test
	public void testGetAddress() {
		AddressEntry A = new AddressEntry("Eric", "Schreiner", "123 Lancaster Road", "Walnut Creek",
				"Ca", "94595", "925-818-6651", "ebschreiner@gmail.com");
		AddressEntry B = new AddressEntry("Tom", "Watson", "5 Lakeview Drive", "Hayward", "Ca",
				"93423", "273-837-9918", "tdubs@yahoo.com");
		assertEquals("123 Lancaster Road", A.getAddress().getStreet());
		assertEquals("93423", B.getAddress().getZip());
	}

	@Test
	public void testGetTelephone() {
		AddressEntry A = new AddressEntry("Eric", "Schreiner", "123 Lancaster Road", "Walnut Creek",
				"Ca", "94595", "925-818-6651", "ebschreiner@gmail.com");
		AddressEntry B = new AddressEntry("Tom", "Watson", "5 Lakeview Drive", "Hayward", "Ca",
				"93423", "273-837-9918", "tdubs@yahoo.com");
		assertEquals("925-818-6651", A.getTelephone());
		assertEquals("273-837-9918", B.getTelephone());
	}

	@Test
	public void testGetEmail() {
		AddressEntry A = new AddressEntry("Eric", "Schreiner", "123 Lancaster Road", "Walnut Creek",
				"Ca", "94595", "925-818-6651", "ebschreiner@gmail.com");
		AddressEntry B = new AddressEntry("Tom", "Watson", "5 Lakeview Drive", "Hayward", "Ca",
				"93423", "273-837-9918", "tdubs@yahoo.com");
		assertEquals("ebschreiner@gmail.com", A.getEmail());
		assertEquals("tdubs@yahoo.com", B.getEmail());
	}

	@Test
	public void testToString() {
		AddressEntry A = new AddressEntry("Eric", "Schreiner", "123 Lancaster Road", "Walnut Creek",
				"Ca", "94595", "925-818-6651", "ebschreiner@gmail.com");
		AddressEntry B = new AddressEntry("Tom", "Watson", "5 Lakeview Drive", "Hayward", "Ca",
				"93423", "273-837-9918", "tdubs@yahoo.com");
		System.out.println("toString Output\n\n" + A.toString() + "\n" + B.toString());
	}

	@Test
	public void testAddNoteString() throws ClassNotFoundException, SQLException {
		AddressEntry A = new AddressEntry();
		AddressEntry B = new AddressEntry();
		A.addNote("empty address");
		B.addNote("Hi im a note");
		System.out.println("testAddNote output\n" + A.notesToString() + "\n" + B.notesToString());
	}
	
	@Test
	public void testNotesToString() throws ClassNotFoundException, SQLException {
		AddressEntry A = new AddressEntry();
		AddressEntry B = new AddressEntry();
		A.addNote("empty address");
		B.addNote("Hi im a note");
		System.out.println("notesToString() output\n" + A.notesToString() + "\n" + B.notesToString());
	}
}