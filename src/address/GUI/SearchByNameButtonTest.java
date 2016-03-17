package address.GUI;

import static org.junit.Assert.*;
import org.junit.Test;
import address.data.AddressBook;

public class SearchByNameButtonTest {

	@Test
	public void testSearchByNameButton() {
		AddressBook book = new AddressBook();
		MainGUIFrame frame = new MainGUIFrame(book);
		SearchByNameButton A = new SearchByNameButton(frame);
		SearchByNameButton B = new SearchByNameButton(frame);
		assertEquals (A.getActionCommand(), B.getActionCommand());
	}

}
