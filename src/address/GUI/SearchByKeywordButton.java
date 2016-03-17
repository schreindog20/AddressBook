package address.GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import address.data.AddressEntry;

/**
 * 
 * @author Eric
 * @version 1.0
 * 
 * Purpose: Represents the "search by keyword" button (extends JButton) for the Main GUI interface
 * Action Performed: Opens dialog window where user enters the last name to search for.
 * Then the sPane of the application's MainGUIFrame instance is updated to display a JList
 * of entries matching the search
 */
public class SearchByKeywordButton extends JButton{
	/** text field for keyword in new dialog*/
	private JTextField keyword;
	/** Array of JComponent objects for storing dialog box components */
	private JComponent[] inputs;
	/** 
	 * Returns a SearchByKeywordButton object associated with the application's MainGuiFrame
	 * @return a SearchByKeywordButton object associated with the application's MainGuiFrame
	 * @param frame is the application's MainGUIFrame object
	 */
	public SearchByKeywordButton(MainGUIFrame frame) {
		setText("Search by Keyword");
		addActionListener(new ActionListener(){
			JList<AddressEntry> searchList = new JList();
			public void actionPerformed(ActionEvent event) {
				keyword = new JTextField();
				inputs = new JComponent[] {
						new JLabel("Keyword"),
						keyword};
				JOptionPane.showMessageDialog(null, inputs, "Enter Keyword to be Searched For", JOptionPane.PLAIN_MESSAGE);
				try {
					frame.list = frame.Book.findForListingKeyword(keyword.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.removeB.setEnabled(false);
				frame.editB.setEnabled(false);
				frame.addNoteB.setEnabled(false);
				frame.viewNotesB.setEnabled(false);
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