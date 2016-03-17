package address.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * @author Eric
 * 
 * Purpose: Represents the "new" button (extends JButton) for the Main GUI interface
 * Action Performed: Calls the static AddressBook object's init() method, loading all of the
 * Address Entries from the database into the AddressBook 
 */
public class LoadButton extends JButton{
	/** 
	 * Returns a LoadButton object associated with the application's MainGuiFrame
	 * @return a LoadButton object associated with the application's MainGuiFrame
	 * @param frame is the application's MainGUIFrame object
	 */
	public LoadButton(MainGUIFrame frame) {
		setText("Load from DB");
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				try {
					frame.Book.init();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.removeB.setEnabled(false);
				frame.viewNotesB.setEnabled(false);
				frame.addNoteB.setEnabled(false);
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