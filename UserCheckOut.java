package experiments;

import java.util.ArrayList;
import java.util.List;

public class UserCheckOut {
	
	// Properties //////////////////////////////////////////////////
	private User user;
	
	private List<Book> checkedOutBooks;
	private List<AudioVideo> checkedOutAudioVideo;
	
	private List<Book> bookRequests;
	private List<AudioVideo> audioVideoRequests;
	
	private int checkedOutTotal;
	
	
	// Constructor //////////////////////////////////////////////////
	public UserCheckOut(User _user) {
		user = _user;
		
		checkedOutBooks = new ArrayList<Book>();
		checkedOutAudioVideo = new ArrayList<AudioVideo>();
		
		bookRequests = new ArrayList<Book>();
		audioVideoRequests = new ArrayList<AudioVideo>();
		
		checkedOutTotal = 0;
	}

	
	// Getters //////////////////////////////////////////////////
	public User getUser() {
		return user;
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
		
		checkedOutBooks.add(book);
		++checkedOutTotal;
	}

	public void checkOutAudioVideo(AudioVideo av) {
		if(audioVideoRequests.contains(av))
		{
			audioVideoRequests.remove(av);
		}
		
		checkedOutAudioVideo.add(av);
		++checkedOutTotal;
	}
	
	// Return items
	public void returnBook(Book book) {
		if(checkedOutBooks.contains(book))
		{
			checkedOutBooks.remove(book);
			book.setCanCheckout(true);
		}
		--checkedOutTotal;
	}

	public void returnAudioVideo(AudioVideo av) {
		if(checkedOutAudioVideo.contains(av))
		{
			checkedOutAudioVideo.remove(av);
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
