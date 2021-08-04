package library_system;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

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
	
	public User getUserFromLibraryNumber(int libraryNumberInt) {
		String libraryNumber = String.valueOf(libraryNumberInt);
		User user = new User();
		for(User libUser : libraryUsers)
		{
			if(libUser.getLibraryNumber().equals(libraryNumber))
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

	public List<UserCheckOut> getUsersCheckOut() {
		return usersCheckOut;
	}
	
	public List<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}

	public List<AudioVideo> getCheckedOutAudioVideo() {
		return checkedOutAudioVideo;
	}
	
	public List<Book> getRequestedBooks() {
		return bookRequests;
	}

	public List<AudioVideo> getRequestedAudioVideo() {
		return audioVideoRequests;
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

	public float printFineString(User user) {
		String fine = "$";
		double fineDouble = 0.00;
		
		for(UserCheckOut uco : usersCheckOut)
		{
			// Get fines from books
			for(CheckedOutBook cBook : uco.getCheckedOutBooks())
			{
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, cBook.getBook().getCheckoutLength());
				Date overdueDate = cal.getTime();
				Date checkedOutDate = cal.getTime();
				
				if(overdueDate.before(new Date()))
				{
					
					LocalDate overdueLocalDate = LocalDate.parse(new SimpleDateFormat("MM-dd-yyyy").format(overdueDate));
					LocalDate checkedOutLocalDate = LocalDate.parse(new SimpleDateFormat("MM-dd-yyyy").format(checkedOutDate));
					int daysOverdue = (int) ChronoUnit.DAYS.between(overdueLocalDate, checkedOutLocalDate);
					int item = (int) Book.getItemValue(); 
					fineDouble += 0.10 * item; 
					System.out.println(overdueLocalDate);
					System.out.println(checkedOutLocalDate);
					System.out.println(daysOverdue);
					
					System.out.println("Your book is not due. You owe: $" + fineDouble);
				}
				/*
				else
				{
					   int N;
				        float f;
				        Scanner sc=new Scanner(System.in);
				        System.out.println("Enter the no. of days the book is returned late:");
				        N=sc.nextInt();
				        if (N<=5)
				            f=0.40f*N;
				        else if (N<=10)
				            f=0.40f*5+(N-5)*0.65f;
				        else
				            f=0.40f*5+0.65f*5+(N-10)*0.80f;
				        System.out.println("Fine= $"+f);

					//System.out.println("Your book is over due. You owe:" + fine);
				}
				
				else if(overdueDate.after(new Date()))
				{

					System.out.println("Your book is over due. You owe:" + fineDouble);
					
				}
				else {
					System.out.println("You owe nothing");
				}
				
				 int N;
			        float f;
			        Scanner sc=new Scanner(System.in);
			        System.out.println("Enter the no. of days the book is returned late:");
			        N=sc.nextInt();
			        if (N<=5)
			            f=0.10f*N;
			        else if (N<=10)
			            f=0.10f*5+(N-5)*0.10f;
			        else
			            f=0.10f*5+0.10f*5+(N-10)*0.10f;
			        System.out.println("Fine= $"+f);
			        //return f;
			     */
			
			}
			
			// Get fines from audio/video items
			for(CheckedOutAV cAV : uco.getCheckedOutAudioVideo())
			{
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, cAV.getAudioVideo().getCheckoutLength());
				Date overdueDate = cal.getTime();
				
				if(overdueDate.before(new Date()))
				{
					LocalDate overdueLocalDate = LocalDate.parse(new SimpleDateFormat("MM-dd-yyyy").format(overdueDate));
					LocalDate checkedOutLocalDate = LocalDate.parse(new SimpleDateFormat("MM-dd-yyyy").format(new Date()));
					int daysOverdue = (int) ChronoUnit.DAYS.between(overdueLocalDate, checkedOutLocalDate);
					fineDouble += daysOverdue * 0.10;
				}
			}
		}
		 int N;
	        float f;
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Enter the no. of days the book is returned late:");
	        N=sc.nextInt();
	        if (N<=5)
	            f=0.10f*N;
	        else if (N<=10)
	            f=0.10f*5+(N-5)*0.10f;
	        else
	            f=0.10f*5+0.10f*5+(N-10)*0.10f;
	        System.out.println("Fine= $"+f);
	        return f;
		//return f + String.format("%.2f", fineDouble);
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
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				if(user.getAge() <= 12 && uco.getCheckedOutTotal() == 5)
				{
					// deny the child
					System.out.println("You have met the total limit of books you can check out.");
					return false;
				}
				else
				{
					if(bookRequests.contains(book))
					{
						bookRequests.remove(book);
					}
					
					checkedOutBooks.add(book);
					book.setCanCheckout(false);
					
					uco.checkOutBook(book);
				}
			}
		}
		if(!userFound)
		{
			if(bookRequests.contains(book))
			{
				bookRequests.remove(book);
			}
			
			checkedOutBooks.add(book);
			book.setCanCheckout(false);
			
			UserCheckOut newUserCheckOut = new UserCheckOut(user);
			newUserCheckOut.checkOutBook(book);
			usersCheckOut.add(newUserCheckOut);
		}
		
		return true;
	}
	
	public Boolean checkOutBook(Book book, User user, Date date) {
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				if(user.getAge() <= 12 && uco.getCheckedOutTotal() == 5)
				{
					// deny the child
					System.out.println("You have met the total limit of books you can check out.");
					return false;
				}
				else
				{
					if(bookRequests.contains(book))
					{
						bookRequests.remove(book);
					}
					
					checkedOutBooks.add(book);
					book.setCanCheckout(false);
					
					uco.checkOutBook(book, date);
				}
			}
		}
		if(!userFound)
		{
			if(bookRequests.contains(book))
			{
				bookRequests.remove(book);
			}
			
			checkedOutBooks.add(book);
			book.setCanCheckout(false);
			
			UserCheckOut newUserCheckOut = new UserCheckOut(user);
			newUserCheckOut.checkOutBook(book, date);
			usersCheckOut.add(newUserCheckOut);
		}
		
		return true;
	}

	public Boolean checkOutAudioVideo(AudioVideo av, User user) {
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				if(user.getAge() <= 12 && uco.getCheckedOutTotal() == 5)
				{
					// deny the child
					System.out.println("You have met the total limit of audio videos you can check out.");
					return false;
				}
				else
				{
					if(audioVideoRequests.contains(av))
					{
						audioVideoRequests.remove(av);
					}
					
					checkedOutAudioVideo.add(av);
					av.setCanCheckout(false);
					
					uco.checkOutAudioVideo(av);
				}
			}
		}
		if(!userFound)
		{
			if(audioVideoRequests.contains(av))
			{
				audioVideoRequests.remove(av);
			}
			
			checkedOutAudioVideo.add(av);
			av.setCanCheckout(false);
			
			UserCheckOut newUserCheckOut = new UserCheckOut(user);
			newUserCheckOut.checkOutAudioVideo(av);
			usersCheckOut.add(newUserCheckOut);
		}
		
		return true;
	}

	public Boolean checkOutAudioVideo(AudioVideo av, User user, Date date) {
		Boolean userFound = false;
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				userFound = true;
				if(user.getAge() <= 12 && uco.getCheckedOutTotal() == 5)
				{
					// deny the child
					System.out.println("You have met the total limit of audio videos you can check out.");
					return false;
				}
				else
				{
					if(audioVideoRequests.contains(av))
					{
						audioVideoRequests.remove(av);
					}
					
					checkedOutAudioVideo.add(av);
					av.setCanCheckout(false);
					
					uco.checkOutAudioVideo(av, date);
				}
			}
		}
		if(!userFound)
		{
			if(audioVideoRequests.contains(av))
			{
				audioVideoRequests.remove(av);
			}
			
			checkedOutAudioVideo.add(av);
			av.setCanCheckout(false);
			
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
	}
	
	public void returnBookUserCheckOut(Book book, User user) {
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				uco.returnBook(book);
			}
		}
	}

	public void returnAudioVideo(AudioVideo av, User user) {
		if(checkedOutAudioVideo.contains(av))
		{
			checkedOutAudioVideo.remove(av);
			av.setCanCheckout(true);
		}
	}

	public void returnAudioVideoUserCheckOut(AudioVideo av, User user) {
		for(UserCheckOut uco : usersCheckOut)
		{
			if(user == uco.getUser())
			{
				uco.returnAudioVideo(av);
			}
		}
	}

	// Check if items are available
	public Boolean isBookAvailable(Book book) {
		return !(checkedOutBooks.contains(book));
	}

	public Boolean isAudioVideoAvailable(AudioVideo av) {
		return !(checkedOutAudioVideo.contains(av));
	}

	// Check if items are requested
	public Boolean isBookRequested(Book book) {
		return (bookRequests.contains(book));
	}

	public Boolean isAudioVideoRequested(AudioVideo av) {
		return (audioVideoRequests.contains(av));
	}

	// Check if items have been renewed
	public Boolean isBookRenewed(Book book) {
		for(UserCheckOut uco : usersCheckOut)
		{
			List<CheckedOutBook> checkedOutBooks = uco.getCheckedOutBooks();
			for(CheckedOutBook cBook : checkedOutBooks)
			{
				if(cBook.getBook() == book)
				{
					return cBook.getRenewed();
				}
			}
		}
		return false;
	}
	
	public Boolean isAVRenewed(AudioVideo av) {
		for(UserCheckOut uco : usersCheckOut)
		{
			List<CheckedOutAV> checkedOutAudioVideo = uco.getCheckedOutAudioVideo();
			for(CheckedOutAV cAV : checkedOutAudioVideo)
			{
				if(cAV.getAudioVideo() == av)
				{
					return cAV.getRenewed();
				}
			}
		}
		return false;
	}

	// Set if item has been renewed
	public void setBookRenewed(Book book) {
		for(UserCheckOut uco : usersCheckOut)
		{
			List<CheckedOutBook> checkedOutBooks = uco.getCheckedOutBooks();
			for(CheckedOutBook cBook : checkedOutBooks)
			{
				if(cBook.getBook() == book)
				{
					cBook.setRenewed(true);
				}
			}
		}
	}
	
	public void setAVRenewed(AudioVideo av) {
		for(UserCheckOut uco : usersCheckOut)
		{
			List<CheckedOutAV> checkedOutAudioVideo = uco.getCheckedOutAudioVideo();
			for(CheckedOutAV cAV : checkedOutAudioVideo)
			{
				if(cAV.getAudioVideo() == av)
				{
					cAV.setRenewed(true);
				}
			}
		}
	}

	public Boolean isAudioVideoRenewed(AudioVideo av) {
		return !(audioVideoRequests.contains(av));
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
