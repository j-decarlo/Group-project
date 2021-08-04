package library_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
	
	// Properties //////////////////////////////////////////////////
	private MainView mView;
	private MainModel mModel;
	
	
	// Constructor //////////////////////////////////////////////////
	public MainController(MainView _mView, MainModel _mModel) {
		this.mView = _mView;
		this.mModel = _mModel;
		
		this.mView.libraryButtonListener(new LibraryButtonListener());
		this.mView.mainMenuButtonListener(new MainMenuButtonListener());
	}
	
	
	// Action listeners
	class LibraryButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.showLibraryPanel(mModel.getLibraryItemsData());
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}

	class MainMenuButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.showMainMenuPanel();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}
}
