package experiments;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	// Properties //////////////////////////////////////////////////
	List<Book> libraryBooks;
	List<AudioVideo> libraryAudioVideo;
	List<ReferenceBook> libraryReferenceBooks;
	List<Magazine> libraryMagazines;
	
	
	// Constructor //////////////////////////////////////////////////
	public Library() {
		libraryBooks = new ArrayList<>();
		libraryAudioVideo = new ArrayList<>();
		libraryReferenceBooks = new ArrayList<>();
		libraryMagazines = new ArrayList<>();
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

	// Add functions
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
}
