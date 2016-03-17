package address.data.note;

import static org.junit.Assert.*;
import org.junit.Test;

public class NoteTest {

	@Test
	public void testNote() {
		Note A = new Note(1, "Note A");
		Note B = new Note(2, "Note B");
		assertEquals("Note A", A.getInfo());
		assertEquals("Note B", B.getInfo());
	}

	@Test
	public void testGetInfo() {
		Note A = new Note(1, "Note A");
		Note B = new Note(2, "Note B");
		assertEquals("Note A", A.getInfo());
		assertEquals("Note B", B.getInfo());
	}

}