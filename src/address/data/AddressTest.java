package address.data;

import static org.junit.Assert.*;
import org.junit.Test;

public class AddressTest {

	@Test
	public void testAddress() {
		Address A = new Address();
		Address B = new Address();
		assertEquals("", A.getCity()); 
		assertEquals("", B.getState());
	}

	@Test
	public void testAddressStringStringStringString() {
		Address A = new Address("3 Boron Drive", "Periodic", "Ta", "26303");
		Address B = new Address("543 Myspace Way", "Periodic", "Pa", "26283");
		assertEquals(A.getCity(), B.getCity());
		assertEquals("3 Boron Drive", A.getStreet());
	}

	@Test
	public void testSetStreet() {
		Address A = new Address("3 Boron Drive", "Periodic", "Ta", "26303");
		Address B = new Address("543 Myspace Way", "Periodic", "Pa", "26283");
		B.setStreet("6 Hallow Street");
		A.setStreet("89 Tubular Way");
		assertEquals("6 Hallow Street", B.getStreet());
		assertEquals("89 Tubular Way", A.getStreet());
	}

	@Test
	public void testSetCity() {
		Address A = new Address("3 Boron Drive", "Periodic", "Ta", "26303");
		Address B = new Address("543 Myspace Way", "Periodic", "Pa", "26283");
		A.setCity("Pittsburgh");
		B.setCity("Hayward");
		assertEquals("Pittsburgh", A.getCity());
		assertEquals("Hayward", B.getCity());
	}

	@Test
	public void testSetState() {
		Address A = new Address("3 Boron Drive", "Periodic", "Ta", "26303");
		Address B = new Address("543 Myspace Way", "Periodic", "Pa", "26283");
		A.setState("Ca");
		B.setState("Ma");
		assertEquals("Ca", A.getState());
		assertEquals("Ma", B.getState());
	}

	@Test
	public void testSetZip() {
		Address A = new Address("3 Boron Drive", "Periodic", "Ta", "26303");
		Address B = new Address("543 Myspace Way", "Periodic", "Pa", "26283");
		A.setZip("82233");
		B.setZip("82723");
		assertEquals("82233", A.getZip());
		assertEquals("82723", B.getZip());
	}

	@Test
	public void testGetStreet() {
		Address A = new Address("3 Boron Drive", "Periodic", "Ta", "26303");
		Address B = new Address("543 Myspace Way", "Periodic", "Pa", "26283");
		assertEquals("3 Boron Drive", A.getStreet());
		assertEquals("543 Myspace Way", B.getStreet());
	}

	@Test
	public void testGetCity() {
		Address A = new Address("3 Boron Drive", "Periodic", "Ta", "26303");
		Address B = new Address("543 Myspace Way", "Periodic", "Pa", "26283");
		assertEquals("Periodic", A.getCity());
		assertEquals("Periodic", B.getCity());
		assertEquals(A.getCity(), B.getCity());
	}

	@Test
	public void testGetState() {
		Address A = new Address("3 Boron Drive", "Periodic", "Ta", "26303");
		Address B = new Address("543 Myspace Way", "Periodic", "Pa", "26283");
		assertEquals("Ta", A.getState());
		assertEquals("Pa", B.getState());
	}

	@Test
	public void testGetZip() {
		Address A = new Address("3 Boron Drive", "Periodic", "Ta", "26303");
		Address B = new Address("543 Myspace Way", "Periodic", "Pa", "26283");
		assertEquals("26303", A.getZip());
		assertEquals("26283", B.getZip());
	}

}