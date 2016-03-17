package address.data;

import static org.junit.Assert.*;
import org.junit.Test;

public class NameTest {

	@Test
	public void testName() {
		Name A = new Name();
		Name B = new Name();
		assertEquals("", A.getFirstName());
		assertEquals("", B.getLastName());
	}

	@Test
	public void testNameStringString() {
		Name A = new Name("Tim", "Biglow");
		Name B = new Name("Sarah", "Harper");
		assertEquals("Tim", A.getFirstName());
		assertEquals("Harper", B.getLastName());
	}

	@Test
	public void testSetFirstName() {
		Name A = new Name("Tim", "Biglow");
		Name B = new Name("Sarah", "Harper");
		A.setFirstName("Mark");
		B.setFirstName("Jerry");
		assertEquals("Mark", A.getFirstName());
		assertEquals("Jerry", B.getFirstName());
	}

	@Test
	public void testSetLastName() {
		Name A = new Name("Tim", "Biglow");
		Name B = new Name("Sarah", "Harper");
		A.setLastName("Hughes");
		B.setLastName("Raptor");
		assertEquals("Hughes", A.getLastName());
		assertEquals("Raptor", B.getLastName());
	}

	@Test
	public void testGetFirstName() {
		Name A = new Name("Tim", "Biglow");
		Name B = new Name("Sarah", "Harper");
		assertEquals("Tim", A.getFirstName());
		assertEquals("Sarah", B.getFirstName());
	}

	@Test
	public void testGetLastName() {
		Name A = new Name("Tim", "Biglow");
		Name B = new Name("Sarah", "Harper");
		assertEquals("Biglow", A.getLastName());
		assertEquals("Harper", B.getLastName());
	}

}