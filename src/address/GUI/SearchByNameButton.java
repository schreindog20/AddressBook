package address.GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import address.data.AddressEntry;

/**
 * 
 * @author Eric
 * @version 1.0
 * 
 * Purpose: Represents the "search by last name" button (extends JButton) for the Main GUI interface
 * Action Performed: Opens dialog window where user enters the last name to search for.
 * Then the sPane of the application's MainGUIFrame instance is updated to display a JList
 * of entries matching the search
 */
public class SearchByNameButton extends JButton{
	/** text field for last name in new dialog*/
	private JTextField lastName;
	/** Array of JComponent objects for storing dialog box components */
	private JComponent[] inputs;
	
	/** 
	 * Returns a SearchByNameButton object associated with the application's MainGuiFrame
	 * @return a SearchByNameButton object associated with the application's MainGuiFrame
	 * @param frame is the application's MainGUIFrame object
	 */
	public SearchByNameButton(MainGUIFrame frame) {
		setText("Search by Last Name");
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				lastName = new JTextField();
				inputs = new JComponent[] {
						new JLabel("Last Name"),
						lastName};
				JOptionPane.showMessageDialog(null, inputs, "Enter Last Name to be Searched For", JOptionPane.PLAIN_MESSAGE);
				frame.removeB.setEnabled(false);
				frame.editB.setEnabled(false);
				frame.addNoteB.setEnabled(false);
				frame.viewNotesB.setEnabled(false);
				frame.list = frame.Book.findForListing(lastName.getText());
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
