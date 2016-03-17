package address.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

/**
 * 
 * @author Eric
 * @version 1.0
 * 
 * Purpose: Represents the "add note" button (extends JButton) for the Main GUI interface
 * Action Performed: Opens a dialog for the user to enter information for a Note object 
 * associated with the selected AddressEntry object
 */
public class AddNoteButton extends JButton{
	/** text field for note info in new dialog*/
	private JTextField noteInfo;
	/** Array of JComponent objects for storing dialog box components */
	private JComponent[] inputs;
	
	/** 
	 * Returns an AddNoteButton object associated with the application's MainGuiFrame
	 * @return an AddNoteButton object associated with the application's MainGuiFrame
	 * @param frame is the application's MainGUIFrame object
	 */
	public AddNoteButton(MainGUIFrame frame) {
		setEnabled(false);
		setText("Add New Note");
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				int index = frame.list.getSelectedIndex();
				noteInfo = new JTextField();
				inputs = new JComponent[] {
						new JLabel("Note Information"),
						noteInfo};
				while (true)
				{
					JOptionPane.showMessageDialog(null, inputs, frame.list.getModel().getElementAt(index).toString(), JOptionPane.PLAIN_MESSAGE);
					int yesNo = JOptionPane.showConfirmDialog(frame.getRootPane(), "Is this information correct?\n\n" + noteInfo.getText());
					if (yesNo == JOptionPane.YES_OPTION)
					{
						try {
							frame.list.getModel().getElementAt(index).addNote(noteInfo.getText());
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					else if (yesNo == JOptionPane.CANCEL_OPTION)
						break;
				}
			}
		});
	}
}