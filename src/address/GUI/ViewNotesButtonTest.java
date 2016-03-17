package address.GUI;

import static org.junit.Assert.*;
import org.junit.Test;
import address.data.AddressBook;

public class ViewNotesButtonTest {

	@Test
	public void testViewNotesButton() {
		AddressBook book = new AddressBook();
		MainGUIFrame frame = new MainGUIFrame(book);
		ViewNotesButton A = new ViewNotesButton(frame);
		ViewNotesButton B = new ViewNotesButton(frame);
		assertEquals (A.getActionCommand(), B.getActionCommand());
	}

}