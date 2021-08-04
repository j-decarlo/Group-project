package library_system;

import java.util.List;

public class MainModel {
	
	// Properties //////////////////////////////////////////////////
	private Library library;
	private List<Book> libraryBooks;
	private List<AudioVideo> libraryAudioVideo;
	private List<ReferenceBook> libraryReferenceBooks;
	private List<Magazine> libraryMagazines;
	private List<User> libraryUsers;
	
	
	public void setLibrary(Library _library) {
		this.library = _library;
	}
	
	
	public Object[][] getLibraryItemsData() {
		libraryBooks = library.getBooks();
		libraryAudioVideo = library.getAudioVideo();
		libraryReferenceBooks = library.getReferenceBooks();
		libraryMagazines = library.getMagazines();
		
		int size = libraryBooks.size() + libraryAudioVideo.size() + libraryReferenceBooks.size() + libraryMagazines.size();
		Object[][] data = new Object[size][5];
		int idx = 0;
		
		for(Book book : libraryBooks)
		{
			String bestSeller = "No";
			if(book.isBestSeller())
			{
				bestSeller = "Yes";
			}
			Object[] dataRow = {"Book", book.getID(), book.getTitle(), bestSeller, book.getItemValueString()};
			data[idx] = dataRow;
			++idx;
		}
		
		for(AudioVideo av : libraryAudioVideo)
		{
			Object[] dataRow = {"Audio/Video", av.getID(), av.getTitle(), "N/A", av.getItemValueString()};
			data[idx] = dataRow;
			++idx;
		}
		
		for(ReferenceBook ref : libraryReferenceBooks)
		{
			Object[] dataRow = {"Reference Book", ref.getID(), ref.getTitle(), "N/A", "N/A"};
			data[idx] = dataRow;
			++idx;
		}
		
		for(Magazine mag : libraryMagazines)
		{
			Object[] dataRow = {"Magazine", mag.getID(), mag.getTitle(), "N/A", "N/A"};
			data[idx] = dataRow;
			++idx;
		}
		
		return data;
	}
	
	public Object[][] getUsersItemsData() {
		libraryUsers = library.getUsers();
		
		int size = libraryUsers.size();
		Object[][] data = new Object[size][5];
		int idx = 0;
		
		for(User user : libraryUsers)
		{
			Object[] dataRow = {user.getName(), user.getAddress(), user.getPhoneNumber(), user.getLibraryNumber(), user.getAge()};
			data[idx] = dataRow;
			++idx;
		}
		
		return data;
	}
}
