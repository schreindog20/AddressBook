package address.GUI;

import static org.junit.Assert.*;

import org.junit.Test;
import address.data.AddressBook;

public class SaveButtonTest {

	@Test
	public void testSaveButton() {
		AddressBook book = new AddressBook();
		MainGUIFrame frame = new MainGUIFrame(book);
		SaveButton A = new SaveButton(frame);
		SaveButton B = new SaveButton(frame);
		assertEquals (A.getActionCommand(), B.getActionCommand());
	}

}