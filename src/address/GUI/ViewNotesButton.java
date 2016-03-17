package address.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import address.GUI.MainGUIFrame;
import address.data.AddressBook;

import javax.swing.*;

/**
 * 
 * @author Eric
 * @version 1.0
 * 
 * Purpose: Represents the "view notes" button (extends JButton) for the Main GUI interface
 * Action Performed: Alters the 
 */
public class ViewNotesButton extends JButton {
	/** text area for note info in new dialog*/
	private JTextArea noteInfo;
	
	/** 
	 * Returns a ViewNotesButton object associated with the application's MainGuiFrame
	 * @return a ViewNotesButton object associated with the application's MainGuiFrame
	 * @param frame is the application's MainGUIFrame object
	 */
	public ViewNotesButton(MainGUIFrame frame) {
		setText("Display Notes");
		setEnabled(false);
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				int index = frame.list.getSelectedIndex();
				try {
					noteInfo = new JTextArea(frame.list.getModel().getElementAt(index).notesToString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.sPane.setViewportView(noteInfo);
			}
		});
	}
}
