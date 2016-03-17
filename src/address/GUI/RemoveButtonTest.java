package address.GUI;

import static org.junit.Assert.*;
import org.junit.Test;

import address.data.AddressBook;

public class RemoveButtonTest {

	@Test
	public void testRemoveButton() {
		AddressBook book = new AddressBook();
		MainGUIFrame frame = new MainGUIFrame(book);
		RemoveButton A = new RemoveButton(frame);
		RemoveButton B = new RemoveButton(frame);
		assertEquals (A.getActionCommand(), B.getActionCommand());
	}

}