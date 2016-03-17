package address;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import address.data.AddressBook;
import address.GUI.MainGUIFrame;

public class AddressBookApplicationTest {

	@Test
	public void testMain() throws SQLException {
		AddressBook A = new AddressBook();
		AddressBook B = new AddressBook();
		A.init();
		B.init();
		MainGUIFrame frame1 = new MainGUIFrame(A);
		MainGUIFrame frame2 = new MainGUIFrame(B);
		assertEquals((int)frame1.getAlignmentX(), (int)frame2.getAlignmentX());
	}

}