package address.GUI;

import static org.junit.Assert.*;
import org.junit.Test;
import address.data.AddressBook;

public class AddNoteButtonTest {

	@Test
	public void testAddNoteButton() {
		AddressBook book = new AddressBook();
		MainGUIFrame frame = new MainGUIFrame(book);
		AddNoteButton A = new AddNoteButton(frame);
		AddNoteButton B = new AddNoteButton(frame);
		assertEquals (A.getActionCommand(), B.getActionCommand());
	}

}