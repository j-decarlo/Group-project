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

public class MainView extends JFrame {
	
	// Properties //////////////////////////////////////////////////
	private Library library;
	
	private JPanel mainPanel = new JPanel();
	private JButton libraryButton = new JButton("View Library Items");

	private JPanel libraryPanel = new JPanel();
	private JButton mainMenuButton = new JButton("Main Menu");
	
	
	// Constructor //////////////////////////////////////////////////
	MainView(Library _library) {
		library = _library;
		
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
		
		this.add(mainPanel);
	}
	
	
	// Action listeners
	void libraryButtonListener(ActionListener listenForLibraryButton){
		libraryButton.addActionListener(listenForLibraryButton);
	}
	
	void mainMenuButtonListener(ActionListener listenForMainMenuButton){
		mainMenuButton.addActionListener(listenForMainMenuButton);
	}
	
	
	// Change the view
	void showLibraryPanel(){
		this.remove(mainPanel);
		this.add(libraryPanel);
		this.revalidate();
		this.repaint();
	}
	
	void showMainMenuPanel(){
		this.remove(libraryPanel);
		this.add(mainPanel);
		this.revalidate();
		this.repaint();
	}
	
	
	// Open a pop-up that contains the message passed
	void displayMessage(String message){
		JOptionPane.showMessageDialog(this, message);
	}
	
	// Open a pop-up that contains the error message passed
	void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
