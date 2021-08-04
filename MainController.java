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
		this.mView.checkOutButtonListener(new CheckOutButtonListener());
		this.mView.requestButtonListener(new RequestButtonListener());
		this.mView.renewButtonListener(new RenewButtonListener());
		this.mView.refBooksButtonListener(new RefBooksButtonListener());
		this.mView.magsButtonListener(new MagsButtonListener());
		
		this.mView.usersButtonListener(new UsersButtonListener());
		this.mView.mainMenuButton2Listener(new MainMenuButton2Listener());
		this.mView.userDataButtonListener(new UserDataButtonListener());
		
		this.mView.usersButton2Listener(new UsersButton2Listener());
		this.mView.mainMenuButton3Listener(new MainMenuButton3Listener());
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
				mView.showMainMenuPanelFromLibrary();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}

	class CheckOutButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.displayMessage("TODO");
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}

	class RequestButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.displayMessage("TODO");
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}

	class RenewButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.displayMessage("TODO");
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}

	class RefBooksButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.displayReferenceBookMessage();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}

	class MagsButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.displayMagazineMessage();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}
	
	
	class UsersButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.showUsersPanel(mModel.getUsersItemsData());
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}

	class MainMenuButton2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.showMainMenuPanelFromUsers();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}

	class UserDataButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.showUserDataPanel(mModel.getUserDataItemsData());
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}


	class MainMenuButton3Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.showMainMenuPanelFromUserData();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}
	
	class UsersButton2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try
			{
				mView.showUsersPanelFromUserData(mModel.getUsersItemsData());
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				mView.displayErrorMessage("Error:\n" + ex);
			}
		}
	}
}
