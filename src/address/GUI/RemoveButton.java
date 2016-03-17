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
 * Purpose: Represents the "remove" button (extends JButton) for the Main GUI interface
 * Action Performed: Opens a confirm dialog to confirm if the user wants to remove the 
 * selected AddressEntry objects from the AddressBook. If yes, entries are removed.
 */
public class RemoveButton extends JButton{
	/** 
	 * Returns a RemoveButton object associated with the application's MainGuiFrame
	 * @return a RemoveButton object associated with the application's MainGuiFrame
	 * @param frame is the application's MainGUIFrame object
	 */
	public RemoveButton(MainGUIFrame frame) {
		setEnabled(false);
		setText("Remove Selected");
		addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				int[] indexArray = frame.list.getSelectedIndices();
				int i;
				
				String s = "Are you sure you wish to delete these entries?\n\n\n";
				for (i = 0; i < indexArray.length; i++)
				{
					
					s += frame.list.getModel().getElementAt(indexArray[i]).toString();
				}
				int yesNo = JOptionPane.showConfirmDialog(frame.getRootPane(), s);
				if (yesNo == JOptionPane.YES_OPTION)
				{
					for (i = 0; i < indexArray.length; i++)
					{
						frame.Book.remove(frame.list.getModel().getElementAt(indexArray[i]));
					}
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