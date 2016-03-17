package address.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * @author Eric
 * @version 1.0
 * 
 * Purpose: Represents the "new" button (extends JButton) for the Main GUI interface
 * Action Performed: Displays all of the AddressEntry objects in the AddressBook as a
 * JList in the MainGUIFrame object's scroll frame
 */
public class DisplayButton extends JButton{
	
	/** 
	 * Returns a DisplayButton object associated with the application's MainGuiFrame
	 * @return a DisplayButton object associated with the application's MainGuiFrame
	 * @param frame is the application's MainGUIFrame object
	 */
	public DisplayButton(MainGUIFrame frame) {
		setText("Display Entries");
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				frame.removeB.setEnabled(false);
				frame.viewNotesB.setEnabled(false);
				frame.addNoteB.setEnabled(false);
				frame.editB.setEnabled(false);
				frame.list = frame.Book.getBookList();
				frame.list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						if(frame.list.isSelectionEmpty()) {
							frame.removeB.setEnabled(false);
							frame.addNoteB.setEnabled(false);
							frame.viewNotesB.setEnabled(false);
							frame.editB.setEnabled(false);
						}
						else {
							frame.removeB.setEnabled(true);
							int[] indices = frame.list.getSelectedIndices();
							if (indices.length == 1){
								frame.editB.setEnabled(true);
								frame.addNoteB.setEnabled(true);
								frame.viewNotesB.setEnabled(true);
							}
							else {
								frame.addNoteB.setEnabled(false);
								frame.viewNotesB.setEnabled(false);
								frame.editB.setEnabled(false);
							}
						}
					}
				});
				frame.sPane.setViewportView(frame.list);
			}
		});
	}
}