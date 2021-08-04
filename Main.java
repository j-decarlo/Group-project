package library_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] a) {

        // Initialize the library
	    Library library = new Main().initializeLibrary();

        //asking for name
        JFrame frame = new JFrame();
        Object result = JOptionPane.showInputDialog(frame, "Enter name:");

        //checking to see if user inputed a number
        Pattern n = Pattern.compile("[0-9]");
        Matcher m = n.matcher((CharSequence) result);

        while (m.find()){
            JOptionPane.showMessageDialog(null, "Please enter only string");
            result = JOptionPane.showInputDialog(frame, "Enter name:");
            m = n.matcher((CharSequence) result);
        }


        //asking for users age
        String result2 = JOptionPane.showInputDialog(frame, "Enter age:");

        //checking to see if user inputed
        Pattern age1 = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
        Matcher match2 = age1.matcher((CharSequence) result2);
        while (match2.find()) {
            JOptionPane.showMessageDialog(null, "Please enter only numbers");
            result2 = JOptionPane.showInputDialog(frame, "Enter age:");
            match2 = age1.matcher((CharSequence) result2);
        }


        //asking for users address
        //since address has numbers and characters no need for validation
        Object result3 = JOptionPane.showInputDialog(frame, "Enter address:");


        //asking for users phone number
        Object result4 = JOptionPane.showInputDialog(frame, "Enter phone number:");

        //checking to see if only it is a number
        Pattern num3 = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
        Matcher match3 = num3.matcher((CharSequence) result4);
        while (match3.find()) {
            JOptionPane.showMessageDialog(null, "Please enter only numbers");
            result4 = JOptionPane.showInputDialog(frame, "Enter phone number:");
            match3 = num3.matcher((CharSequence) result4);
        }


        //asking for the users library number
        Object result5 = JOptionPane.showInputDialog(frame, "Enter library card number:");

        //checking to see if it is only a number
        Pattern num4 = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
        Matcher match4 = num4.matcher((CharSequence) result5);
        while (match4.find()) {
            JOptionPane.showMessageDialog(null, "Please enter only numbers");
            result5 = JOptionPane.showInputDialog(frame, "Enter library card number:");
            match4 = num4.matcher((CharSequence) result5);
        }



        //Printing results out
        System.out.println("Name: " + result);
        System.out.println("Age: " + result2);

        //checking to see if user is an adult or child
        int i = Integer.parseInt(result2);
        if(i <= 12) {
            System.out.println("Note: Children can only check out 5 items at a time.");
        }
        else {
            System.out.println("Note: Adults may check out more than 5 items at a time.");
        }

        System.out.println("Address: " + result3);
        System.out.println("Phone Number: " + result4);
        System.out.println("Library Card: " + result5);

        System.out.println("\n");

        System.out.println("Would you like to check out a book?");


        //checks to see if user would like to check a book out or not
        //we should implement the class here
        int dialogButton = 0;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to check out a book?", "Book Checkout Area", dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION) {
            System.out.println();
            // Saving code here
        }

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
