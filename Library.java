package library_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library {
	
	// Properties //////////////////////////////////////////////////
	private List<Book> libraryBooks;
	private List<AudioVideo> libraryAudioVideo;
	private List<ReferenceBook> libraryReferenceBooks;
	private List<Magazine> libraryMagazines;
	
	private int itemCount;
	
	private List<User> libraryUsers;
	
	private List<Book> checkedOutBooks;
	private List<AudioVideo> checkedOutAudioVideo;
	
	private List<Book> bookRequests;
	private List<AudioVideo> audioVideoRequests;

	private List<UserCheckOut> usersCheckOut;
	
	
	// Constructor //////////////////////////////////////////////////
	public Library() {
		libraryBooks = new ArrayList<Book>();
		libraryAudioVideo = new ArrayList<AudioVideo>();
		libraryReferenceBooks = new ArrayList<ReferenceBook>();
		libraryMagazines = new ArrayList<Magazine>();
		
		itemCount = 0;
		
		libraryUsers = new ArrayList<User>();
		
		checkedOutBooks = new ArrayList<Book>();
		checkedOutAudioVideo = new ArrayList<AudioVideo>();
		
		bookRequests = new ArrayList<Book>();
		audioVideoRequests = new ArrayList<AudioVideo>();

		usersCheckOut = new ArrayList<UserCheckOut>();
	}

	
	// Getters //////////////////////////////////////////////////
	public List<Book> getBooks() {
		return libraryBooks;
	}

	public List<AudioVideo> getAudioVideo() {
		return libraryAudioVideo;
	}

	public List<ReferenceBook> getReferenceBooks() {
		return libraryReferenceBooks;
	}

	public List<Magazine> getMagazines() {
		return libraryMagazines;
	}

	public int getItemCount() {
		return itemCount;
	}

	public List<User> getUsers() {
		return libraryUsers;
	}

	public User getUser(String name) {
		User user = new User();
		for(User libUser : libraryUsers)
		{
			if(libUser.getName().equals(name))
			{
				user = libUser;
				break;
			}
		}
		return user;
	}

	public Book getBookFromID(int id) {
		Book book = null;
		for(Book libBook : libraryBooks)
		{
			if(libBook.getID() == id)
			{
				book = libBook;
				break;
			}
		}
		return book;
	}

	public AudioVideo getAVFromID(int id) {
		AudioVideo av = null;
		for(AudioVideo libAV : libraryAudioVideo)
		{
			if(libAV.getID() == id)
			{
				av = libAV;
				break;
			}
		}
		return av;
	}

	
	// Setters //////////////////////////////////////////////////
	public void setBooks(List<Book> _libraryBooks) {
		this.libraryBooks = _libraryBooks;
	}

	public void setAudioVideo(List<AudioVideo> _libraryAudioVideo) {
		this.libraryAudioVideo = _libraryAudioVideo;
	}

	public void setReferenceBooks(List<ReferenceBook> _libraryReferenceBooks) {
		this.libraryReferenceBooks = _libraryReferenceBooks;
	}

	public void setMagazines(List<Magazine> _libraryMagazines) {
		this.libraryMagazines = _libraryMagazines;
	}
	
	
	// Functions //////////////////////////////////////////////////
	
	// Print functions
	public void printBooks() {
		for(Book book : libraryBooks)
		{
			book.printTitle();
		}
	}

	public void printAudioVideo() {
		for(AudioVideo av : libraryAudioVideo)
		{
			av.printTitle();
		}
	}

	public void printReferenceBooks() {
		for(ReferenceBook refBook : libraryReferenceBooks)
		{
			refBook.printTitle();
		}
	}

	public void printMagazines() {
		for(Magazine magazine : libraryMagazines)
		{
			magazine.printTitle();
		}
	}

	public void printUsers() {
		for(User user : libraryUsers)
		{
			user.printName();
		}
	}

	public void printUserCheckedOutItems() {
		for(UserCheckOut uco : usersCheckOut)
		{
			// Print checked out books
			for(CheckedOutBook cBook : uco.getCheckedOutBooks())
			{
				System.out.println("Checked out book: " + cBook.getBook().getTitle());
				System.out.println("Checked out on: " + cBook.getCheckedOutDateString());
			}
			
			// Print checked out audio/video items
			for(CheckedOutAV cAV : uco.getCheckedOutAudioVideo())
			{
				System.out.println("Checked out audio/video: " + cAV.getAudioVideo().getTitle());
				System.out.println("Checked out on: " + cAV.getCheckedOutDateString());
			}
		}
	}

	// Add item functions
	public void addBook(Book book) {
		libraryBooks.add(book);
		++itemCount;
	}

	public void addAudioVideo(AudioVideo av) {
		libraryAudioVideo.add(av);
		++itemCount;
	}

	public void addReferenceBook(ReferenceBook refBook) {
		libraryReferenceBooks.add(refBook);
		++itemCount;
	}

	public void addMagazine(Magazine magazine) {
		libraryMagazines.add(magazine);
		++itemCount;
	}

	public void addUser(User user) {
		libraryUsers.add(user);
	}
	
	// Library functions /////////////////////////
	
	// Check out items
	public Boolean checkOutBook(Book book, User user) {
		if(bookRequests.contains(book))
		{
			bookRequests.remove(book);
		}
		
		checkedOutBooks.add(book);
		book.setCanCheckout(false);
		
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				if(user.getAge() <= 12 && uco.getCheckedOutTotal() == 5)
				{
					// deny the child
					// beginning logic will be messed up - FIX
					System.out.println("You have met the total limit of books you can check out.");
					return false;
				}
				else
				{
					uco.checkOutBook(book);
				}
			}
		}
		if(!userFound)
		{
			UserCheckOut newUserCheckOut = new UserCheckOut(user);
			newUserCheckOut.checkOutBook(book);
			usersCheckOut.add(newUserCheckOut);
		}
		
		return true;
	}
	
	public Boolean checkOutBook(Book book, User user, Date date) {
		if(bookRequests.contains(book))
		{
			bookRequests.remove(book);
		}
		
		checkedOutBooks.add(book);
		book.setCanCheckout(false);
		
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				if(user.getAge() <= 12 && uco.getCheckedOutTotal() == 5)
				{
					// deny the child
					// beginning logic will be messed up - FIX
					System.out.println("You have met the total limit of books you can check out.");
					return false;
				}
				else
				{
					uco.checkOutBook(book, date);
				}
			}
		}
		if(!userFound)
		{
			UserCheckOut newUserCheckOut = new UserCheckOut(user);
			newUserCheckOut.checkOutBook(book, date);
			usersCheckOut.add(newUserCheckOut);
		}
		
		return true;
	}

	public Boolean checkOutAudioVideo(AudioVideo av, User user) {
		if(audioVideoRequests.contains(av))
		{
			audioVideoRequests.remove(av);
		}
		
		checkedOutAudioVideo.add(av);
		av.setCanCheckout(false);
		
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				if(user.getAge() <= 12 && uco.getCheckedOutTotal() == 5)
				{
					// deny the child
					// beginning logic will be messed up - FIX
					System.out.println("You have met the total limit of audio videos you can check out.");
					return false;
				}
				else
				{
					uco.checkOutAudioVideo(av);
				}
			}
		}
		if(!userFound)
		{
			UserCheckOut newUserCheckOut = new UserCheckOut(user);
			newUserCheckOut.checkOutAudioVideo(av);
			usersCheckOut.add(newUserCheckOut);
		}
		
		return true;
	}

	public Boolean checkOutAudioVideo(AudioVideo av, User user, Date date) {
		if(audioVideoRequests.contains(av))
		{
			audioVideoRequests.remove(av);
		}
		
		checkedOutAudioVideo.add(av);
		av.setCanCheckout(false);
		
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				if(user.getAge() <= 12 && uco.getCheckedOutTotal() == 5)
				{
					// deny the child
					// beginning logic will be messed up - FIX
					System.out.println("You have met the total limit of audio videos you can check out.");
					return false;
				}
				else
				{
					uco.checkOutAudioVideo(av, date);
				}
			}
		}
		if(!userFound)
		{
			UserCheckOut newUserCheckOut = new UserCheckOut(user);
			newUserCheckOut.checkOutAudioVideo(av, date);
			usersCheckOut.add(newUserCheckOut);
		}
		
		return true;
	}
	
	// Return items
	public void returnBook(Book book, User user) {
		if(checkedOutBooks.contains(book))
		{
			checkedOutBooks.remove(book);
			book.setCanCheckout(true);
		}
		
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				uco.returnBook(book);
			}
		}
		if(!userFound)
		{
			// nothing to do
		}
	}

	public void returnAudioVideo(AudioVideo av, User user) {
		if(checkedOutAudioVideo.contains(av))
		{
			checkedOutAudioVideo.remove(av);
			av.setCanCheckout(true);
		}
		
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				uco.returnAudioVideo(av);
			}
		}
		if(!userFound)
		{
			// nothing to do
		}
	}

	// Check if items are available
	public Boolean isBookAvailable(Book book) {
		return !(checkedOutBooks.contains(book));
	}

	public Boolean isAudioVideoAvailable(AudioVideo av) {
		return !(checkedOutAudioVideo.contains(av));
	}

	// Request items
	public void requestBook(Book book, User user) {
		bookRequests.add(book);	// what if duplicate?
		
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				uco.requestBook(book);
			}
		}
		if(!userFound)
		{
			UserCheckOut newUserCheckOut = new UserCheckOut(user);
			newUserCheckOut.requestBook(book);
			usersCheckOut.add(newUserCheckOut);
		}
	}

	public void requestAudioVideo(AudioVideo av, User user) {
		audioVideoRequests.add(av);	// what if duplicate?
		
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				uco.requestAudioVideo(av);
			}
		}
		if(!userFound)
		{
			UserCheckOut newUserCheckOut = new UserCheckOut(user);
			newUserCheckOut.requestAudioVideo(av);
			usersCheckOut.add(newUserCheckOut);
		}
	}
}
