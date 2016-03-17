package address.GUI;

import static org.junit.Assert.*;
import org.junit.Test;

import address.data.AddressBook;

public class NewButtonTest {

	@Test
	public void testNewButton() {
		AddressBook book = new AddressBook();
		MainGUIFrame frame = new MainGUIFrame(book);
		NewButton A = new NewButton(frame);
		NewButton B = new NewButton(frame);
		assertEquals (A.getActionCommand(), B.getActionCommand());
	}

}