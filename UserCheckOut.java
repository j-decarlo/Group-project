package library_system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserCheckOut {
	
	// Properties //////////////////////////////////////////////////
	private User user;
	
	private List<CheckedOutBook> checkedOutBooks;
	private List<CheckedOutAV> checkedOutAudioVideo;
	
	private List<Book> bookRequests;
	private List<AudioVideo> audioVideoRequests;
	
	private int checkedOutTotal;
	
	
	// Constructor //////////////////////////////////////////////////
	public UserCheckOut(User _user) {
		user = _user;
		
		checkedOutBooks = new ArrayList<CheckedOutBook>();
		checkedOutAudioVideo = new ArrayList<CheckedOutAV>();
		
		bookRequests = new ArrayList<Book>();
		audioVideoRequests = new ArrayList<AudioVideo>();
		
		checkedOutTotal = 0;
	}

	
	// Getters //////////////////////////////////////////////////
	public User getUser() {
		return user;
	}
	
	public List<CheckedOutBook> getCheckedOutBooks() {
		return checkedOutBooks;
	}
	
	public List<CheckedOutAV> getCheckedOutAudioVideo() {
		return checkedOutAudioVideo;
	}
	
	public List<Book> getBookRequests() {
		return bookRequests;
	}
	
	public List<AudioVideo> getAudioVideoRequests() {
		return audioVideoRequests;
	}
	
	public int getCheckedOutTotal() {
		return checkedOutTotal;
	}
	
	
	// Functions //////////////////////////////////////////////////
	
	// Add item functions
	public void checkOutBook(Book book) {
		if(bookRequests.contains(book))
		{
			bookRequests.remove(book);
		}
		
		CheckedOutBook cBook = new CheckedOutBook(book);
		
		checkedOutBooks.add(cBook);
		++checkedOutTotal;
	}

	public void checkOutBook(Book book, Date date) {
		if(bookRequests.contains(book))
		{
			bookRequests.remove(book);
		}
		
		CheckedOutBook cBook = new CheckedOutBook(book, date);
		
		checkedOutBooks.add(cBook);
		++checkedOutTotal;
	}

	public void checkOutAudioVideo(AudioVideo av) {
		if(audioVideoRequests.contains(av))
		{
			audioVideoRequests.remove(av);
		}
		
		CheckedOutAV cAV = new CheckedOutAV(av);
		
		checkedOutAudioVideo.add(cAV);
		++checkedOutTotal;
	}

	public void checkOutAudioVideo(AudioVideo av, Date date) {
		if(audioVideoRequests.contains(av))
		{
			audioVideoRequests.remove(av);
		}
		
		CheckedOutAV cAV = new CheckedOutAV(av, date);
		
		checkedOutAudioVideo.add(cAV);
		++checkedOutTotal;
	}
	
	// Return items
	public void returnBook(Book book) {
		//if(checkedOutBooks.contains(book))
		//{
		//	checkedOutBooks.remove(book);
		//	book.setIsCheckedOut(false);
		//}
		
		for(CheckedOutBook cBook : checkedOutBooks)
		{
			if(book == cBook.getBook())
			{
				checkedOutBooks.remove(cBook);
				book.setIsCheckedOut(false);
			}
		}
		
		--checkedOutTotal;
	}

	public void returnAudioVideo(AudioVideo av) {
		//if(checkedOutAudioVideo.contains(av))
		//{
		//	checkedOutAudioVideo.remove(av);
		//}
		
		for(CheckedOutAV cAV : checkedOutAudioVideo)
		{
			if(av == cAV.getAudioVideo())
			{
				checkedOutAudioVideo.remove(cAV);
				av.setIsCheckedOut(false);
			}
		}
		
		--checkedOutTotal;
	}

	// Request items
	public void requestBook(Book book) {
		bookRequests.add(book);	// what if duplicate?
	}

	public void requestAudioVideo(AudioVideo av) {
		audioVideoRequests.add(av);	// what if duplicate?
	}
}


// Class for checked out book items
class CheckedOutBook {
	Book checkedOutBook;
	Date checkedOutDate;
	Date returnDate;
	
	CheckedOutBook(Book book) {
		checkedOutBook = book;
		checkedOutDate = new Date();
		returnDate = setReturnDate(book.getCheckoutLength());
	}
	
	CheckedOutBook(Book book, Date date) {
		checkedOutBook = book;
		checkedOutDate = date;
		returnDate = setReturnDate(book.getCheckoutLength());
	}
	
	Book getBook() {
		return checkedOutBook;
	}
	
	Date getCheckedOutDate() {
		return checkedOutDate;
	}
	
	String getCheckedOutDateString() {
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		String stringDate = df.format(checkedOutDate);
		return stringDate;
	}
	
	Date getReturnDate() {
		return returnDate;
	}
	
	String getReturnDateString() {
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		String stringDate = df.format(returnDate);
		return stringDate;
	}
	
	Date setReturnDate(int checkoutLength) {
		Date returnDate = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, checkoutLength);
		
		returnDate = cal.getTime();
		
		return returnDate;
	}
}


// Class for checked out audio/video items
class CheckedOutAV {
	AudioVideo checkedOutAV;
	Date checkedOutDate;
	Date returnDate;
	
	CheckedOutAV(AudioVideo av) {
		checkedOutAV = av;
		checkedOutDate = new Date();
		returnDate = setReturnDate(av.getCheckoutLength());
	}
	
	CheckedOutAV(AudioVideo av, Date date) {
		checkedOutAV = av;
		checkedOutDate = date;
		returnDate = setReturnDate(av.getCheckoutLength());
	}
	
	AudioVideo getAudioVideo() {
		return checkedOutAV;
	}
	
	Date getCheckedOutDate() {
		return checkedOutDate;
	}
	
	String getCheckedOutDateString() {
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		String stringDate = df.format(checkedOutDate);
		return stringDate;
	}
	
	Date getReturnDate() {
		return returnDate;
	}
	
	String getReturnDateString() {
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		String stringDate = df.format(returnDate);
		return stringDate;
	}
	
	Date setReturnDate(int checkoutLength) {
		Date returnDate = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, checkoutLength);
		
		returnDate = cal.getTime();
		
		return returnDate;
	}
}
