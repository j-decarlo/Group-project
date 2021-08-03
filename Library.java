package experiments;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	// Properties //////////////////////////////////////////////////
	List<Book> libraryBooks;
	List<AudioVideo> libraryAudioVideo;
	List<ReferenceBook> libraryReferenceBooks;
	List<Magazine> libraryMagazines;
	
	List<Book> checkedOutBooks;
	List<AudioVideo> checkedOutAudioVideo;
	
	List<Book> bookRequests;
	List<AudioVideo> audioVideoRequests;
	
	
	// Constructor //////////////////////////////////////////////////
	public Library() {
		libraryBooks = new ArrayList<Book>();
		libraryAudioVideo = new ArrayList<AudioVideo>();
		libraryReferenceBooks = new ArrayList<ReferenceBook>();
		libraryMagazines = new ArrayList<Magazine>();
		
		checkedOutBooks = new ArrayList<Book>();
		checkedOutAudioVideo = new ArrayList<AudioVideo>();
		
		bookRequests = new ArrayList<Book>();
		audioVideoRequests = new ArrayList<AudioVideo>();
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
			System.out.println(book);
		}
	}

	public void printAudioVideo() {
		for(AudioVideo av : libraryAudioVideo)
		{
			System.out.println(av);
		}
	}

	public void printReferenceBooks() {
		for(ReferenceBook refBook : libraryReferenceBooks)
		{
			System.out.println(refBook);
		}
	}

	public void printMagazines() {
		for(Magazine magazine : libraryMagazines)
		{
			System.out.println(magazine);
		}
	}

	// Add item functions
	public void addLibraryBook(Book book) {
		libraryBooks.add(book);
	}

	public void addAudioVideo(AudioVideo av) {
		libraryAudioVideo.add(av);
	}

	public void addReferenceBook(ReferenceBook refBook) {
		libraryReferenceBooks.add(refBook);
	}

	public void addMagazine(Magazine magazine) {
		libraryMagazines.add(magazine);
	}
	
	// Library functions /////////////////////////
	
	// Check out items
	public void checkOutBook(Book book) {
		checkedOutBooks.add(book);
	}

	public void checkOutAudioVideo(AudioVideo av) {
		checkedOutAudioVideo.add(av);
	}

	// Check if items are available
	public Boolean isBookAvailable(Book book) {
		return !(checkedOutBooks.contains(book));
	}

	public Boolean isAudioVideoAvailable(AudioVideo av) {
		return !(checkedOutAudioVideo.contains(av));
	}

	// Request items
	public void requestBook(Book book) {
		bookRequests.add(book);	// what if duplicate?
	}

	public void requestAudioVideo(AudioVideo av) {
		audioVideoRequests.add(av);	// what if duplicate?
	}
}
