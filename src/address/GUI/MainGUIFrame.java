package address.GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import address.data.AddressBook;
import address.data.AddressEntry;
import address.GUI.*;

/**
 * 
 * @author Eric
 * @version 1.0
 * @since JDK 1.8
 *
 * purpose: the main GUI class for exercise 9.  Contains display, new, and remove buttons as well as a 
 * scrollable frame listing the entries in the AddressBook
 */
public class MainGUIFrame extends JFrame  {
	/**
	 * Address Book object
	 */
	protected AddressBook Book;
	/**
	 * display button
	 */
	protected DisplayButton displayB;
	/**
	 * new button
	 */
	protected NewButton newB;
	/**
	 * remove button
	 */
	protected RemoveButton removeB;
	/**
	 * load button
	 */
	protected LoadButton loadB;
	/**
	 * save button
	 */
	protected SaveButton saveB;
	/** view notes button */
	protected ViewNotesButton viewNotesB;
	/** add note button */
	protected AddNoteButton addNoteB;
	/** edit entry button */
	protected EditButton editB;
	/** search by last name button */
	protected SearchByNameButton searchNameB;
	/** search by keyword button */
	protected SearchByKeywordButton searchKeywordB;
	/**
	 * JList for displaying list of entries in scroll pane
	 */
	protected JList<AddressEntry> list;
	/**
	 * Scroll pane for displaying list of entries
	 */
	protected JScrollPane sPane;
	
	/**
	 * Returns a MyJFrame object associated with an AddressBook "Book"
	 * @param Book is the AddressBook associated with the MyJFrame object
	 */
	public MainGUIFrame(AddressBook Book)
	{
		this.Book = Book;
		setLayout(new BorderLayout());
		setSize(800,400);
		
		/**
		 * Grid panel for buttons
		 */
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(10,1));		

		list = Book.getBookList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if(list.isSelectionEmpty()) {
					removeB.setEnabled(false);
					addNoteB.setEnabled(false);
					viewNotesB.setEnabled(false);
					editB.setEnabled(false);
				}
				else {
					removeB.setEnabled(true);
					int[] indices = list.getSelectedIndices();
					if (indices.length == 1){
						addNoteB.setEnabled(true);
						viewNotesB.setEnabled(true);
						editB.setEnabled(true);
					}
					else {
						addNoteB.setEnabled(false);
						viewNotesB.setEnabled(false);
						editB.setEnabled(false);
					}
				}
			}
		});
		sPane = new JScrollPane(list);
		sPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		displayB = new DisplayButton(this);
		newB = new NewButton(this);
		removeB = new RemoveButton(this);
		saveB = new SaveButton(this);
		loadB = new LoadButton(this);
		viewNotesB = new ViewNotesButton(this);
		addNoteB = new AddNoteButton(this);
		editB = new EditButton(this);
		searchNameB = new SearchByNameButton(this);
		searchKeywordB = new SearchByKeywordButton(this);
		
		buttons.add(displayB);
		buttons.add(searchNameB);
		buttons.add(searchKeywordB);
		buttons.add(newB);
		buttons.add(editB);
		buttons.add(removeB);
		buttons.add(loadB);
		buttons.add(saveB);
		buttons.add(viewNotesB);
		buttons.add(addNoteB);
		
		add(buttons, "West");
		add(sPane, "Center");
		this.setLocation(500,325);
		setVisible(true);
	}
}