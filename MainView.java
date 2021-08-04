package library_system;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame {
	
	// Properties //////////////////////////////////////////////////
	private JPanel mainPanel = new JPanel();
	private JButton libraryButton = new JButton("View Library Items");
	private JButton usersButton = new JButton("View Users");

	private JPanel libraryPanel = new JPanel();
	private JButton mainMenuButton = new JButton("Main Menu");
	private JButton checkOutButton = new JButton("Check Out");
	private JButton requestButton = new JButton("Request");
	private JButton renewButton = new JButton("Renew");	
	private JButton refBooksButton = new JButton("Reference Books");
	private JButton magsButton = new JButton("Magazines");
	
	private JTable libraryTable = new JTable();
	private JScrollPane libraryTableScrollPane = new JScrollPane();
	
	private JPanel usersPanel = new JPanel();
	private JButton mainMenuButton2 = new JButton("Main Menu");
	private JButton userDataButton = new JButton("View User Data");
	
	private JTable usersTable = new JTable();
	private JScrollPane usersTableScrollPane = new JScrollPane();
	
	private JPanel userDataPanel = new JPanel();
	private JButton mainMenuButton3 = new JButton("Main Menu");
	private JButton usersButton2 = new JButton("View Users");
	
	private JTable userDataTable = new JTable();
	private JScrollPane userDataTableScrollPane = new JScrollPane();


	// Constructor //////////////////////////////////////////////////
	MainView() {
		// Set up the view and add the components
		
		this.setTitle("Library System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750, 500);
		
		// Set the icon
		String filePath = new File("").getAbsolutePath();
        filePath += System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "library_system" + System.getProperty("file.separator") + "icon.png";
		ImageIcon img = new ImageIcon(filePath);
		this.setIconImage(img.getImage());
		
		// Display in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		libraryButton.setAlignmentX(CENTER_ALIGNMENT);
		usersButton.setAlignmentX(CENTER_ALIGNMENT);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		mainPanel.add(Box.createVerticalGlue());
		mainPanel.add(libraryButton);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		mainPanel.add(usersButton);
		mainPanel.add(Box.createVerticalGlue());
		
		libraryPanel.add(mainMenuButton);
		libraryPanel.add(checkOutButton);
		libraryPanel.add(requestButton);
		libraryPanel.add(renewButton);
		libraryPanel.add(refBooksButton);
		libraryPanel.add(magsButton);
		
		usersPanel.add(mainMenuButton2);
		usersPanel.add(userDataButton);
		
		userDataPanel.add(mainMenuButton3);
		userDataPanel.add(usersButton2);

		this.add(mainPanel);
	}
	
	
	// Action listeners
	void libraryButtonListener(ActionListener listener) {
		libraryButton.addActionListener(listener);
	}
	
	void mainMenuButtonListener(ActionListener listener) {
		mainMenuButton.addActionListener(listener);
	}
	
	void checkOutButtonListener(ActionListener listener) {
		checkOutButton.addActionListener(listener);
	}
	
	void requestButtonListener(ActionListener listener) {
		requestButton.addActionListener(listener);
	}
	
	void renewButtonListener(ActionListener listener) {
		renewButton.addActionListener(listener);
	}
	
	void refBooksButtonListener(ActionListener listener) {
		refBooksButton.addActionListener(listener);
	}
	
	void magsButtonListener(ActionListener listener) {
		magsButton.addActionListener(listener);
	}
	
	
	void usersButtonListener(ActionListener listener) {
		usersButton.addActionListener(listener);
	}
	
	void mainMenuButton2Listener(ActionListener listener) {
		mainMenuButton2.addActionListener(listener);
	}
	
	void userDataButtonListener(ActionListener listener) {
		userDataButton.addActionListener(listener);
	}

	
	void mainMenuButton3Listener(ActionListener listener) {
		mainMenuButton3.addActionListener(listener);
	}
	
	void usersButton2Listener(ActionListener listener) {
		usersButton2.addActionListener(listener);
	}
	
	
	// Change the view
	void showLibraryPanel(Object[][] tableData) {
		try
		{
			libraryPanel.remove(libraryTableScrollPane);
			libraryPanel.remove(libraryTable);
			
			Object[] columnNames = {"Type", "ID", "Title", "Best Seller", "Value"};
			libraryTable = new JTable(tableData, columnNames);
			libraryTable.setDefaultEditor(Object.class, null);
			
			libraryTableScrollPane = new JScrollPane(libraryTable);
			libraryTable.setFillsViewportHeight(true);
			libraryPanel.add(libraryTableScrollPane);
			libraryPanel.revalidate();
			libraryPanel.repaint();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			displayErrorMessage("Error:\n" + ex);
		}
		
		this.remove(mainPanel);
		this.add(libraryPanel);
		this.revalidate();
		this.repaint();
	}
	
	void showUsersPanel(Object[][] tableData) {
		try
		{
			usersPanel.remove(usersTableScrollPane);
			usersPanel.remove(usersTable);
			
			Object[] columnNames = {"Name", "Address", "Phone Number", "Library Number", "Age"};
			usersTable = new JTable(tableData, columnNames);
			usersTable.setDefaultEditor(Object.class, null);
			
			usersTableScrollPane = new JScrollPane(usersTable);
			usersTable.setFillsViewportHeight(true);
			usersPanel.add(usersTableScrollPane);
			usersPanel.revalidate();
			usersPanel.repaint();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			displayErrorMessage("Error:\n" + ex);
		}
		
		this.remove(mainPanel);
		this.add(usersPanel);
		this.revalidate();
		this.repaint();
	}
	
	void showUsersPanelFromUserData(Object[][] tableData) {
		try
		{
			usersPanel.remove(usersTableScrollPane);
			usersPanel.remove(usersTable);
			
			Object[] columnNames = {"Name", "Address", "Phone Number", "Library Number", "Age"};
			usersTable = new JTable(tableData, columnNames);
			usersTable.setDefaultEditor(Object.class, null);
			
			usersTableScrollPane = new JScrollPane(usersTable);
			usersTable.setFillsViewportHeight(true);
			usersPanel.add(usersTableScrollPane);
			usersPanel.revalidate();
			usersPanel.repaint();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			displayErrorMessage("Error:\n" + ex);
		}
		
		this.remove(userDataPanel);
		this.add(usersPanel);
		this.revalidate();
		this.repaint();
	}
	
	void showUserDataPanel(Object[][] tableData) {
		try
		{
			userDataPanel.remove(userDataTableScrollPane);
			userDataPanel.remove(userDataTable);
			
			Object[] columnNames = {"Name", "ID", "Type", "Title", "Requested", "Checked Out", "Checkout Date"};
			userDataTable = new JTable(tableData, columnNames);
			userDataTable.setDefaultEditor(Object.class, null);
			
			userDataTableScrollPane = new JScrollPane(userDataTable);
			userDataTable.setFillsViewportHeight(true);
			userDataPanel.add(userDataTableScrollPane);
			userDataPanel.revalidate();
			userDataPanel.repaint();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			displayErrorMessage("Error:\n" + ex);
		}
		
		this.remove(usersPanel);
		this.add(userDataPanel);
		this.revalidate();
		this.repaint();
	}
	
	void showMainMenuPanelFromLibrary() {
		this.remove(libraryPanel);
		this.add(mainPanel);
		this.revalidate();
		this.repaint();
	}
	
	void showMainMenuPanelFromUsers() {
		this.remove(usersPanel);
		this.add(mainPanel);
		this.revalidate();
		this.repaint();
	}
	
	void showMainMenuPanelFromUserData() {
		this.remove(userDataPanel);
		this.add(mainPanel);
		this.revalidate();
		this.repaint();
	}
	
	
	// Open a pop-up that contains the message passed
	void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	// Open a pop-up that contains the error message passed
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	void displayReferenceBookMessage() {
		JOptionPane.showMessageDialog(this, "Reference books cannot be checked out");
	}
	
	void displayMagazineMessage() {
		JOptionPane.showMessageDialog(this, "Magazines cannot be checked out");
	}
	
	
	// Input dialogs
	Object idInputDialog() {
		Object result = JOptionPane.showInputDialog(this, "Enter the item ID:");
		
		if ((result == null) || (((String) result).length() == 0))
		{
			return null;
		}
		
		//checking to see if user inputed a number
		Pattern n = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
		Matcher m = n.matcher((CharSequence) result);

		while (m.find()) {
			JOptionPane.showMessageDialog(null, "Please enter only numbers");
			result = JOptionPane.showInputDialog(this, "Enter the item ID:");
			m = n.matcher((CharSequence) result);
		}
		
		return result;
	}
	
	Object libraryNumberInputDialog() {
		Object result = JOptionPane.showInputDialog(this, "Enter the library number:");
		
		if ((result == null) || (((String) result).length() == 0))
		{
			return null;
		}
		
		//checking to see if user inputed a number
		Pattern n = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
		Matcher m = n.matcher((CharSequence) result);

		while (m.find()) {
			JOptionPane.showMessageDialog(null, "Please enter only numbers");
			result = JOptionPane.showInputDialog(this, "Enter the library number:");
			m = n.matcher((CharSequence) result);
		}
		
		return result;
	}
}

