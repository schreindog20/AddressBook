package address.data;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyComparatorTest {

	@Test
	public void testCompare() {
		MyComparator m = new MyComparator();
		AddressEntry E = new AddressEntry("First", "Last", "Address", "City", "State", "Zip", "Phone", "Email");
		AddressEntry E2 = new AddressEntry("First2", "Last2", "Address2", "City2", "State2", "Zip2", "Phone2", "Email2");
		AssertEquals(1, m.compare(E, E2));
	}

	private void AssertEquals(int i, int compare) {
		// TODO Auto-generated method stub
		
	}

}