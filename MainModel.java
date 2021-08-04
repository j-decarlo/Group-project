package library_system;

import java.util.List;

public class MainModel {
	
	// Properties //////////////////////////////////////////////////
	private Library library;
	private List<Book> libraryBooks;
	private List<AudioVideo> libraryAudioVideo;
	private List<ReferenceBook> libraryReferenceBooks;
	private List<Magazine> libraryMagazines;
	
	
	public void setLibrary(Library _library) {
		this.library = _library;
	}
	
	
	public Object[][] getLibraryItemsData() {
		libraryBooks = library.getBooks();
		libraryAudioVideo = library.getAudioVideo();
		libraryReferenceBooks = library.getReferenceBooks();
		libraryMagazines = library.getMagazines();
		
		Object[][] data = {
				{"Book", "1", "Harry Potter", "Yes", "$9.99"},
				{"Audio/Video", "12", "Metallica", "N/A", "$15.00"},
				{"Magazine", "26", "Time", "N/A", "$3.50"}
			};
		
		return data;
	}
}
