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
	
	public String checkOutItem(Object objId, Object objLibraryNumber) {
		String response = "";
		int id = Integer.valueOf((String) objId);
		int libraryNumber = Integer.valueOf((String) objLibraryNumber);
		
		if(libraryNumber > 6)
		{
			return response = "Library number does not exist";
		}
		
		if(id > 0 && id < 11)	// Book
		{
			if(!library.isBookAvailable(library.getBookFromID(id)))
			{
				return response = "Book is already checked out.\nTry requesting the item instead.";
			}
			
			Boolean valid = library.checkOutBook(library.getBookFromID(id), library.getUserFromLibraryNumber(libraryNumber));
			if(valid)
			{
				response = "Checked out book ID: " + id + " (" + library.getBookFromID(id).getTitle() + ") " + "by library number: " + libraryNumber + " (" + library.getUserFromLibraryNumber(libraryNumber).getName() + ")";
			}
			else
			{
				response = "Book cannot be checked out.\nYou have met the total limit of items you can check out.";
			}
		}
		else if(id > 10 && id < 21)	// Audio/Video
		{
			if(!library.isAudioVideoAvailable(library.getAVFromID(id)))
			{
				return response = "Audio/video item is already checked out.\nTry requesting the item instead.";
			}
			
			Boolean valid = library.checkOutAudioVideo(library.getAVFromID(id), library.getUserFromLibraryNumber(libraryNumber));
			if(valid)
			{
				response = "Checked out audio/video item ID: " + id + " (" + library.getAVFromID(id).getTitle() + ") " + "by library number: " + libraryNumber + " (" + library.getUserFromLibraryNumber(libraryNumber).getName() + ")";
			}
			else
			{
				response = "Audio/video item cannot be checked out.\nYou have met the total limit of items you can check out.";
			}
		}
		else if(id > 20 && id < 26)	// Reference Book
		{
			response = "Reference books cannot be checked out";
		}
		else if(id > 25 && id < 31)	// Magazine
		{
			response = "Magazines cannot be checked out";
		}
		else
		{
			response = "Item ID does not exist";
		}
		
		return response;
	}
	
	public String requestItem(Object objId, Object objLibraryNumber) {
		String response = "";
		int id = Integer.valueOf((String) objId);
		int libraryNumber = Integer.valueOf((String) objLibraryNumber);
		
		if(libraryNumber > 6)
		{
			return response = "Library number does not exist";
		}
		
		if(id > 0 && id < 11)	// Book
		{
			library.requestBook(library.getBookFromID(id), library.getUserFromLibraryNumber(libraryNumber));
			response = "Requested book ID: " + id + " (" + library.getBookFromID(id).getTitle() + ") " + "by library number: " + libraryNumber + " (" + library.getUserFromLibraryNumber(libraryNumber).getName() + ")";
		}
		else if(id > 10 && id < 21)	// Audio/Video
		{
			library.requestAudioVideo(library.getAVFromID(id), library.getUserFromLibraryNumber(libraryNumber));
			response = "Requested audio/video item ID: " + id + " (" + library.getAVFromID(id).getTitle() + ") " + "by library number: " + libraryNumber + " (" + library.getUserFromLibraryNumber(libraryNumber).getName() + ")";
		}
		else if(id > 20 && id < 26)	// Reference Book
		{
			response = "Reference books cannot be checked out";
		}
		else if(id > 25 && id < 31)	// Magazine
		{
			response = "Magazines cannot be checked out";
		}
		else
		{
			response = "Item ID does not exist";
		}
		
		return response;
	}
	
	public String renewItem(Object objId, Object objLibraryNumber) {
		String response = "";
		int id = Integer.valueOf((String) objId);
		int libraryNumber = Integer.valueOf((String) objLibraryNumber);
		
		if(libraryNumber > 6)
		{
			return response = "Library number does not exist";
		}
		
		if(id > 0 && id < 11)	// Book
		{
			Boolean checkedOutByUser = false;
			List<UserCheckOut> usersCheckOut = library.getUsersCheckOut();
			for(UserCheckOut uco : usersCheckOut)
			{
				if(uco.getUser() == library.getUserFromLibraryNumber(libraryNumber))
				{
					List<CheckedOutBook> checkedOutBooks = uco.getCheckedOutBooks();
					for(CheckedOutBook cBook : checkedOutBooks)
					{
						if(cBook.getBook() == library.getBookFromID(id))
						{
							checkedOutByUser = true;
						}
					}
				}
			}
			if(!checkedOutByUser)
			{
				return response = "Book was not checked out by user";
			}
			
			if(library.isBookRequested(library.getBookFromID(id)))
			{
				return response = "Book has been requested.\nYou must return this item.";
			}
			if(library.isBookRenewed(library.getBookFromID(id)))
			{
				return response = "Book has been renewed already.\nYou must return this item.";
			}
			else
			{
				response = "Renewed book ID: " + id + " (" + library.getBookFromID(id).getTitle() + ") " + "by library number: " + libraryNumber + " (" + library.getUserFromLibraryNumber(libraryNumber).getName() + ")";
				library.setBookRenewed(library.getBookFromID(id));;
			}
		}
		else if(id > 10 && id < 21)	// Audio/Video
		{
			Boolean checkedOutByUser = false;
			List<UserCheckOut> usersCheckOut = library.getUsersCheckOut();
			for(UserCheckOut uco : usersCheckOut)
			{
				if(uco.getUser() == library.getUserFromLibraryNumber(libraryNumber))
				{
					List<CheckedOutAV> checkedOutAudioVideo = uco.getCheckedOutAudioVideo();
					for(CheckedOutAV cAV : checkedOutAudioVideo)
					{
						if(cAV.getAudioVideo() == library.getAVFromID(id))
						{
							checkedOutByUser = true;
						}
					}
				}
			}
			if(!checkedOutByUser)
			{
				return response = "Audio/video item was not checked out by user";
			}
			
			if(library.isAudioVideoRequested(library.getAVFromID(id)))
			{
				return response = "Audio/video item has been requested.\nYou must return this item.";
			}
			if(library.isAudioVideoRenewed(library.getAVFromID(id)))
			{
				return response = "Audio/video item has been renewed already.\nYou must return this item.";
			}
			else
			{
				response = "Renewed audio/video item ID: " + id + " (" + library.getAVFromID(id).getTitle() + ") " + "by library number: " + libraryNumber + " (" + library.getUserFromLibraryNumber(libraryNumber).getName() + ")";
				library.setAVRenewed(library.getAVFromID(id));
			}
		}
		else if(id > 20 && id < 26)	// Reference Book
		{
			response = "Reference books cannot be checked out";
		}
		else if(id > 25 && id < 31)	// Magazine
		{
			response = "Magazines cannot be checked out";
		}
		else
		{
			response = "Item ID does not exist";
		}
		
		return response;
	}
	
	public String returnItem(Object objId, Object objLibraryNumber) {
		String response = "";
		int id = Integer.valueOf((String) objId);
		int libraryNumber = Integer.valueOf((String) objLibraryNumber);
		
		if(libraryNumber > 6)
		{
			return response = "Library number does not exist";
		}
		
		if(id > 0 && id < 11)	// Book
		{
			Boolean checkedOutByUser = false;
			List<UserCheckOut> usersCheckOut = library.getUsersCheckOut();
			for(UserCheckOut uco : usersCheckOut)
			{
				if(uco.getUser() == library.getUserFromLibraryNumber(libraryNumber))
				{
					List<CheckedOutBook> checkedOutBooks = uco.getCheckedOutBooks();
					for(CheckedOutBook cBook : checkedOutBooks)
					{
						if(cBook.getBook() == library.getBookFromID(id))
						{
							checkedOutByUser = true;
						}
					}
				}
			}
			if(!checkedOutByUser)
			{
				return response = "Book was not checked out by user";
			}
			
			library.returnBook(library.getBookFromID(id), library.getUserFromLibraryNumber(libraryNumber));
		//	library.returnBookUserCheckOut(library.getBookFromID(id), library.getUserFromLibraryNumber(libraryNumber));
			response = "Returned book ID: " + id + " (" + library.getBookFromID(id).getTitle() + ") " + "by library number: " + libraryNumber + " (" + library.getUserFromLibraryNumber(libraryNumber).getName() + ")\nFines: $" + library.printFineString(library.getUserFromLibraryNumber(libraryNumber));
		}
		else if(id > 10 && id < 21)	// Audio/Video
		{
			Boolean checkedOutByUser = false;
			List<UserCheckOut> usersCheckOut = library.getUsersCheckOut();
			for(UserCheckOut uco : usersCheckOut)
			{
				if(uco.getUser() == library.getUserFromLibraryNumber(libraryNumber))
				{
					List<CheckedOutAV> checkedOutAudioVideo = uco.getCheckedOutAudioVideo();
					for(CheckedOutAV cAV : checkedOutAudioVideo)
					{
						if(cAV.getAudioVideo() == library.getAVFromID(id))
						{
							checkedOutByUser = true;
						}
					}
				}
			}
			if(!checkedOutByUser)
			{
				return response = "Audio/video item was not checked out by user";
			}
			
			library.returnAudioVideo(library.getAVFromID(id), library.getUserFromLibraryNumber(libraryNumber));
		//	library.returnAudioVideoUserCheckOut(library.getAVFromID(id), library.getUserFromLibraryNumber(libraryNumber));
			response = "Returned audio/video item ID: " + id + " (" + library.getAVFromID(id).getTitle() + ") " + "by library number: " + libraryNumber + " (" + library.getUserFromLibraryNumber(libraryNumber).getName() + ")\nFines: $" + library.printFineString(library.getUserFromLibraryNumber(libraryNumber));
		}
		else if(id > 20 && id < 26)	// Reference Book
		{
			response = "Reference books cannot be checked out";
		}
		else if(id > 25 && id < 31)	// Magazine
		{
			response = "Magazines cannot be checked out";
		}
		else
		{
			response = "Item ID does not exist";
		}
		
		return response;
	}
	
	public String saveChangesExport() {
		String response = "Disabled for demo purposes";

		// TODO
		
		return response;
	}
}

