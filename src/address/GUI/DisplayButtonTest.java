package address.GUI;

import static org.junit.Assert.*;
import org.junit.Test;

import address.data.AddressBook;

public class DisplayButtonTest {

	@Test
	public void testDisplayButton() {
		AddressBook book = new AddressBook();
		MainGUIFrame frame = new MainGUIFrame(book);
		DisplayButton A = new DisplayButton(frame);
		DisplayButton B = new DisplayButton(frame);
		assertEquals (A.getActionCommand(), B.getActionCommand());
	}

}