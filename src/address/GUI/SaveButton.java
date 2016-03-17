package address.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

/**
 * 
 * @author Eric
 * 
 * Purpose: Represents the "new" button (extends JButton) for the Main GUI interface
 * Action Performed: Calls the static AddressBook object's init() method, loading all of the
 * Address Entries from the database into the AddressBook 
 */
public class SaveButton extends JButton{
	/** 
	 * Returns a LoadButton object associated with the application's MainGuiFrame
	 * @return a LoadButton object associated with the application's MainGuiFrame
	 * @param frame is the application's MainGUIFrame object
	 */
	public SaveButton(MainGUIFrame frame) {
		setText("Save to DB");
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				try {
					frame.Book.saveToDB();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}