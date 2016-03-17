package address.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import address.data.AddressEntry;

/**
 * 
 * @author Eric
 * @version 1.0
 * 
 * Purpose: Represents the "edit" button (extends JButton) for the Main GUI interface
 * Action Performed: Opens dialog window where user edits the info of the selected
 * AddressEntry object. Then a confirm dialog will ask if the information entered 
 * is correct. If yes, then the selected AddressEntry object will be removed and a new
 * one will be added with the edited/entered data
 */
public class EditButton extends JButton{
	/** text field for first name in new dialog*/
	private JTextField firstName;
	/** text field for last name in new dialog*/
	private JTextField lastName;
	/** text field for street address in new dialog*/
	private JTextField street;
	/** text field for city in new dialog*/
	private JTextField city;
	/** text field for city in new dialog*/
	private JTextField state;
	/** text field for state in new dialog*/
	private JTextField zip;
	/** text field for phone number in new dialog*/
	private JTextField telephone;
	/** text field for email address in new dialog*/
	private JTextField email;
	/** Array of JComponent objects for storing dialog box components */
	private JComponent[] inputs;
	
	/** 
	 * Returns an EditButton object associated with the application's MainGuiFrame
	 * @return an EditButton object associated with the application's MainGuiFrame
	 * @param frame is the application's MainGUIFrame object
	 */
	public EditButton(MainGUIFrame frame) {
		setText("Edit Entry");
		setEnabled(false);
		firstName = new JTextField();
		lastName = new JTextField();
		street = new JTextField();
		city = new JTextField();
		state = new JTextField();
		zip = new JTextField();
		telephone = new JTextField();
		email = new JTextField();
		inputs = new JComponent[] {
				new JLabel("First Name"),
				firstName,
				new JLabel("Last Name"),
				lastName,
				new JLabel("Street Address"),
				street,
				new JLabel("City"),
				city,
				new JLabel("State"),
				state,
				new JLabel("Zip Code"),
				zip,
				new JLabel("Phone Number"),
				telephone,
				new JLabel("Email Address"),
				email
				};
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				whileloop: while (true)
				{
					int index = frame.list.getSelectedIndex();
					AddressEntry entry = frame.list.getModel().getElementAt(index);
					firstName.setText(entry.getName().getFirstName());
					lastName.setText(entry.getName().getLastName());
					street.setText(entry.getAddress().getStreet());
					city.setText(entry.getAddress().getCity());
					state.setText(entry.getAddress().getState());
					zip.setText(entry.getAddress().getZip());
					telephone.setText(entry.getTelephone());
					email.setText(entry.getEmail());
					JOptionPane.showMessageDialog(null,inputs,"Edit Entry Info",JOptionPane.PLAIN_MESSAGE);
					
					if (telephone.getText().charAt(3) == '-' && telephone.getText().charAt(7) == '-') {
						for (int i = 0; i < 12; i++) {
							if (i != 3 && i != 7 && i != 11) {
								if (Character.isDigit(telephone.getText().charAt(i))) {
									
								}
								else {
									JOptionPane.showMessageDialog(frame, "Incorrect Input: Phone # must be of the form 000-000-0000");
									break;
								}
							}
							else if (i == 11)
							{
								if (Character.isDigit(telephone.getText().charAt(i))) {
									AddressEntry newEntry = new AddressEntry(firstName.getText(), lastName.getText(), street.getText(),
											city.getText(), state.getText(), zip.getText(), telephone.getText(), email.getText());
									int yesNo = JOptionPane.showConfirmDialog(frame.getRootPane(), "Is this information correct?\n\n" + newEntry.toString());
									if (yesNo == JOptionPane.YES_OPTION)
									{
										frame.Book.remove(entry);
										frame.Book.add(newEntry);
										break whileloop;
									}
									else if (yesNo == JOptionPane.CANCEL_OPTION)
										break whileloop;
								}
								else 
									JOptionPane.showMessageDialog(frame, "Incorrect Input: Phone # must be of the form 000-000-0000");
							}
						}
					}
					else
						JOptionPane.showMessageDialog(frame, "Incorrect Input: Phone # must be of the form 000-000-0000");
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