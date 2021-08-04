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
	private List<UserCheckOut> usersCheckOut;
	
	
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
	
	public Object[][] getUserDataItemsData() {
		
		//Object[] columnNames = {"Name", "ID", "Type", "Title", "Requested", "Checked Out", "Checkout Date"};
		
		usersCheckOut = library.getUsersCheckOut();

		int size = 0;
		for(UserCheckOut uco : usersCheckOut)
		{
			size += uco.getCheckedOutTotal();
			size += uco.getBookRequests().size();
			size += uco.getAudioVideoRequests().size();
		}
		
		Object[][] data = new Object[size][7];
		int idx = 0;
		
		for(UserCheckOut uco : usersCheckOut)
		{
			if(uco.getCheckedOutBooks().size() > 0)
			{
				try
				{
					List<CheckedOutBook> checkedOutBooks = uco.getCheckedOutBooks();
					for(CheckedOutBook cBook : checkedOutBooks)
					{
						Object[] dataRow = {uco.getUser().getName(), cBook.getBook().getID(), "Book", cBook.getBook().getTitle(), "N/A", "Yes", cBook.getCheckedOutDateString()};
						data[idx] = dataRow;
						++idx;
					}
				}
				catch(Exception ex)
				{
					//System.out.println(ex);
				}
			}
		}
		
		for(UserCheckOut uco : usersCheckOut)
		{
			if(uco.getCheckedOutAudioVideo().size() > 0)
			{
				try
				{
					List<CheckedOutAV> checkedOutAudioVideo = uco.getCheckedOutAudioVideo();
					for(CheckedOutAV cAV : checkedOutAudioVideo)
					{
						Object[] dataRow = {uco.getUser().getName(), cAV.getAudioVideo().getID(), "Audio/Video", cAV.getAudioVideo().getTitle(), "N/A", "Yes", cAV.getCheckedOutDateString()};
						data[idx] = dataRow;
						++idx;
					}
				}
				catch(Exception ex)
				{
					//System.out.println(ex);
				}
			}
		}
		
		for(UserCheckOut uco : usersCheckOut)
		{
			if(uco.getBookRequests().size() > 0)
			{
				try
				{
					List<Book> bookRequests = uco.getBookRequests();
					for(Book book : bookRequests)
					{
						Object[] dataRow = {uco.getUser().getName(), book.getID(), "Book", book.getTitle(), "Yes", "N/A", "N/A"};
						data[idx] = dataRow;
						++idx;
					}
				}
				catch(Exception ex)
				{
					//System.out.println(ex);
				}
			}
		}
		
		for(UserCheckOut uco : usersCheckOut)
		{
			if(uco.getAudioVideoRequests().size() > 0)
			{
				try
				{
					List<AudioVideo> audioVideoRequests = uco.getAudioVideoRequests();
					for(AudioVideo av : audioVideoRequests)
					{
						Object[] dataRow = {uco.getUser().getName(), av.getID(), "Book", av.getTitle(), "Yes", "N/A", "N/A"};
						data[idx] = dataRow;
						++idx;
					}
				}
				catch(Exception ex)
				{
					//System.out.println(ex);
				}
			}
		}
		
		return data;
	}
}
