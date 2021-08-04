package library_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] a) {

        // Initialize the library
	    Library library = new Main().initializeLibrary();
	    
	    // Setup the MVC application
	    MainView mView = new MainView();
	    MainModel mModel = new MainModel();
	    mModel.setLibrary(library);
	    MainController mController = new MainController(mView, mModel);
	    mView.setVisible(true);
    }

    
    // Initializes the library
    public Library initializeLibrary() {
    	
        Library library = new Library();
        
        String filePath = new File("").getAbsolutePath();
        filePath += System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "library_system" + System.getProperty("file.separator") + "library.csv";

        // Read the csv file
        // item_type,title,best_seller,value
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String row;
            while ((row = br.readLine()) != null)
            {
                String[] values = row.split(",");
                
                // Create and add items to the library
                if(values[0].equals("book"))
                {
            		Book book = new Book(values[1], Boolean.parseBoolean(values[2]), Double.parseDouble(values[3]));
            		book.setID(library.getItemCount() + 1);
            		library.addBook(book);
            	}
            	else if(values[0].equals("av"))
            	{
            		AudioVideo av = new AudioVideo(values[1], Double.parseDouble(values[3]));
            		av.setID(library.getItemCount() + 1);
            		library.addAudioVideo(av);
            	}
            	else if(values[0].equals("reference"))
            	{
            		ReferenceBook ref = new ReferenceBook(values[1]);
            		ref.setID(library.getItemCount() + 1);
            		library.addReferenceBook(ref);
            	}
            	else if(values[0].equals("magazine"))
            	{
            		Magazine mag = new Magazine(values[1]);
            		mag.setID(library.getItemCount() + 1);
            		library.addMagazine(mag);
            	}
            }
        }
        catch (IOException e)
        {
			e.printStackTrace();
		}
	    
	    // Initialize the users
	    library = initializeUsers(library);
	    
	    // Initialize the user data
	    library = initializeUserData(library);
        
        return library;
    }

    
    // Initializes the users
    public Library initializeUsers(Library library) {
    	
        String filePath = new File("").getAbsolutePath();
        filePath += System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "library_system" + System.getProperty("file.separator") + "users.csv";

        // Read the csv file
        // name,address,phone_number,library_number,age
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String row;
            while ((row = br.readLine()) != null)
            {
                String[] values = row.split(",");
                
                // Create and add users to the library
                User user = new User();
                user.setName(values[0]);
                user.setAddress(values[1]);
                user.setPhoneNumber(values[2]);
                user.setLibraryNumber(values[3]);
                user.setAge(Integer.parseInt(values[4]));
                
                library.addUser(user);
            }
        }
        catch (IOException e)
        {
			e.printStackTrace();
		}
        
		return library;
    }

    
    // Initializes the user data
    public Library initializeUserData(Library library) {
    	
        String filePath = new File("").getAbsolutePath();
        filePath += System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "library_system" + System.getProperty("file.separator") + "userdata.csv";

        // Read the csv file
        // user_name,item_ID,item_type,requested,checked_out,checkout_date
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String row;
            while ((row = br.readLine()) != null)
            {
                String[] values = row.split(",");
                
                // Create and add the user data to the library
                User user = library.getUser(values[0]);
                int itemID = Integer.parseInt(values[1]);
                
                if(values != null && 4 >= 0 && 4 < values.length && values[4] != null && Boolean.parseBoolean(values[4]))	// Checkout book
                {
                	if(values[2].equals("book"))
                	{
                		String dateString = values[5];
                		DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
                		Date date = new Date();
                		try
                		{
                			date = df.parse(dateString);
                		}
                		catch (ParseException e)
                		{
                		    e.printStackTrace();
                		}
                		
                		library.checkOutBook(library.getBookFromID(itemID), user, date);
                	}
                	else if(values[2].equals("av"))
                	{
                		String dateString = values[5];
                		DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
                		Date date = new Date();
                		try
                		{
                			date = df.parse(dateString);
                		}
                		catch (ParseException e)
                		{
                		    e.printStackTrace();
                		}
                		
                		library.checkOutAudioVideo(library.getAVFromID(itemID), user, date);
                	}
                }
                else if(values != null && 3 >= 0 && 3 < values.length && values[3] != null && Boolean.parseBoolean(values[3]))	// Request book
                {
                	if(values[2].equals("book"))
                	{
                		library.requestBook(library.getBookFromID(itemID), user);
                	}
                	else if(values[2].equals("av"))
                	{
                		library.requestAudioVideo(library.getAVFromID(itemID), user);
                	}
                }
            }
        }
        catch (IOException e)
        {
			e.printStackTrace();
		}
        
		return library;
    }
}
