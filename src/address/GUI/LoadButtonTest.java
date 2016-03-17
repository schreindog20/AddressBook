package address.GUI;

import static org.junit.Assert.*;
import org.junit.Test;

import address.data.AddressBook;

public class LoadButtonTest {

	@Test
	public void testLoadButton() {
		AddressBook book = new AddressBook();
		MainGUIFrame frame = new MainGUIFrame(book);
		LoadButton A = new LoadButton(frame);
		LoadButton B = new LoadButton(frame);
		assertEquals (A.getActionCommand(), B.getActionCommand());
	}

}