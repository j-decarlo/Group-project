package library_system;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		
		mainPanel.add(libraryButton);
		mainPanel.add(usersButton);
		
		libraryPanel.add(mainMenuButton);
		libraryPanel.add(checkOutButton);
		libraryPanel.add(requestButton);
		libraryPanel.add(renewButton);
		libraryPanel.add(refBooksButton);
		libraryPanel.add(magsButton);
		
		usersPanel.add(mainMenuButton2);
		usersPanel.add(userDataButton);

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
	
	
	// Change the view
	void showLibraryPanel(Object[][] tableData) {
		try
		{
			libraryPanel.remove(libraryTableScrollPane);
			libraryPanel.remove(libraryTable);
			
			Object[] columnNames = {"Type", "ID", "Title", "Best Seller", "Value"};
			libraryTable = new JTable(tableData, columnNames);
			
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
	
	
	// Open a pop-up that contains the message passed
	void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	// Open a pop-up that contains the error message passed
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
