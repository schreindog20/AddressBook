package address.GUI;

import static org.junit.Assert.*;
import org.junit.Test;

import address.data.AddressBook;

public class EditButtonTest {

	@Test
	public void testEditButton() {
		AddressBook book = new AddressBook();
		MainGUIFrame frame = new MainGUIFrame(book);
		EditButton A = new EditButton(frame);
		EditButton B = new EditButton(frame);
		assertEquals (A.getActionCommand(), B.getActionCommand());
	}

}