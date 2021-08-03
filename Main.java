package library_system;

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
        
        Book book1 = new Book("Don Quixote", true, 15.00);
        library.addBook(book1);
        Book book2 = new Book("The Great Gatsby", true, 10.25);
        library.addBook(book2);
        Book book3 = new Book("Hamlet", true, 7.50);
        library.addBook(book3);
        Book book4 = new Book("The Odyssey", true, 12.00);
        library.addBook(book4);
        Book book5 = new Book("1984", true, 20.15);
        library.addBook(book5);
        Book book6 = new Book("Brave New World", false, 5.50);
        library.addBook(book6);
        Book book7 = new Book("On the Road", false, 3.00);
        library.addBook(book7);
        Book book8 = new Book("Lord of the Flies", false, 9.99);
        library.addBook(book8);
        Book book9 = new Book("Animal Farm", false, 14.75);
        library.addBook(book9);
        Book book10 = new Book("The Chronicles of Narnia", false, 18.00);
        library.addBook(book10);
        
        AudioVideo av1 = new AudioVideo("Michael Jackson - Thriller", 6.66);
        library.addAudioVideo(av1);
        AudioVideo av2 = new AudioVideo("AC/DC - Back in Black", 5.00);
        library.addAudioVideo(av2);
        AudioVideo av3 = new AudioVideo("Pink Floyd - The Dark Side of the Moon", 11.11);
        library.addAudioVideo(av3);
        AudioVideo av4 = new AudioVideo("Eagles - Hotel California", 7.20);
        library.addAudioVideo(av4);
        AudioVideo av5 = new AudioVideo("The Beatles - Abbey Road", 12.00);
        library.addAudioVideo(av5);
        AudioVideo av6 = new AudioVideo("Avatar", 23.00);
        library.addAudioVideo(av6);
        AudioVideo av7 = new AudioVideo("Titanic", 13.25);
        library.addAudioVideo(av7);
        AudioVideo av8 = new AudioVideo("The Lion King", 8.08);
        library.addAudioVideo(av8);
        AudioVideo av9 = new AudioVideo("The Dark Knight", 13.00);
        library.addAudioVideo(av9);
        AudioVideo av10 = new AudioVideo("Shrek", 11.65);
        library.addAudioVideo(av10);
        
        ReferenceBook ref1 = new ReferenceBook("World Book Encyclopedia");
        library.addReferenceBook(ref1);
        ReferenceBook ref2 = new ReferenceBook("Merriam-Webster's Mini Pocket Thesaurus");
        library.addReferenceBook(ref2);
        ReferenceBook ref3 = new ReferenceBook("Oxford English Dictionary");
        library.addReferenceBook(ref3);
        ReferenceBook ref4 = new ReferenceBook("MLA Handbook");
        library.addReferenceBook(ref4);
        ReferenceBook ref5 = new ReferenceBook("The Elements of Style");
        library.addReferenceBook(ref5);
        
        Magazine mag1 = new Magazine("PEOPLE Magazine");
        library.addMagazine(mag1);
        Magazine mag2 = new Magazine("TV Guide Magazine");
        library.addMagazine(mag2);
        Magazine mag3 = new Magazine("Parents Magazine");
        library.addMagazine(mag3);
        Magazine mag4 = new Magazine("EatingWell Magazine");
        library.addMagazine(mag4);
        Magazine mag5 = new Magazine("Better Homes & Gardens Magazine");
        library.addMagazine(mag5);
        
        return library;
    }
}