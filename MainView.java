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

	private JPanel libraryPanel = new JPanel();
	private JButton mainMenuButton = new JButton("Main Menu");
	private JButton libraryButton3 = new JButton("Check Out");
	private JButton libraryButton4 = new JButton("Check Out Audio/Video Materials");
	private JButton libraryButton7 = new JButton("Reference Books");
	private JButton libraryButton8 = new JButton("Magazines");
	private JTable libraryTable = new JTable();
	private JScrollPane libraryTableScrollPane = new JScrollPane();
	
	//private JPanel mainPanel2 = new JPanel();
	private JButton libraryButton2 = new JButton("View Users");
	private JButton libraryButton5 = new JButton("Request a Book");
	private JButton libraryButton6 = new JButton("Renew a Book");


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
		
		libraryPanel.add(mainMenuButton);
		
		mainPanel.add(libraryButton2);

		libraryPanel.add(libraryButton3);

		libraryPanel.add(libraryButton4);

		mainPanel.add(libraryButton5);

		mainPanel.add(libraryButton6);

		libraryPanel.add(libraryButton7);

		libraryPanel.add(libraryButton8);
	//	libraryButton2.add(libraryButton);
		this.add(mainPanel);
	}
	
	
	// Action listeners
	void libraryButtonListener(ActionListener listenForLibraryButton) {
		libraryButton.addActionListener(listenForLibraryButton);
	}
	
	void mainMenuButtonListener(ActionListener listenForMainMenuButton) {
		mainMenuButton.addActionListener(listenForMainMenuButton);
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
	
	void showMainMenuPanel() {
		this.remove(libraryPanel);
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
