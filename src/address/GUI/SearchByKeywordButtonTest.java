package address.GUI;

import static org.junit.Assert.*;
import org.junit.Test;

import address.data.AddressBook;

public class SearchByKeywordButtonTest {

	@Test
	public void testSearchByKeywordButton() {
		AddressBook book = new AddressBook();
		MainGUIFrame frame = new MainGUIFrame(book);
		SearchByKeywordButton A = new SearchByKeywordButton(frame);
		SearchByKeywordButton B = new SearchByKeywordButton(frame);
		assertEquals (A.getActionCommand(), B.getActionCommand());
	}

}