package experiments;

import javax.swing.*;
import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tester{

  public static void main(String[] a) {
	  
	  //asking for name
    JFrame frame = new JFrame();
    Object result = JOptionPane.showInputDialog(frame, "Enter name:");
    
    //checking to see if user inputed a number
	Pattern n = Pattern.compile("[0-9]");
	Matcher m = n.matcher((CharSequence) result);

	if (m.find()){
   JOptionPane.showMessageDialog(null, "Please enter only string");
   result = JOptionPane.showInputDialog(frame, "Enter name:");
	}
	
	
	//asking for users age
    String result2 = JOptionPane.showInputDialog(frame, "Enter age:");
    
    //checking to see if user inputed 
    Pattern age1 = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
	Matcher match2 = age1.matcher((CharSequence) result2);
	if (match2.find()) {
     JOptionPane.showMessageDialog(null, "Please enter only numbers");
     result2 = JOptionPane.showInputDialog(frame, "Enter age:");
	}
	
	
	//asking for users address
	//since address has numbers and characters no need for validation
    Object result3 = JOptionPane.showInputDialog(frame, "Enter address:");
    
    //asking for users phone number
    Object result4 = JOptionPane.showInputDialog(frame, "Enter phone number:");
    
    //checking to see if only it is a number
    Pattern num3 = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
	Matcher match3 = num3.matcher((CharSequence) result4);
	if (match3.find()) {
     JOptionPane.showMessageDialog(null, "Please enter only numbers");
     result4 = JOptionPane.showInputDialog(frame, "Enter phone number:");
	}
	
	//asking for the users library number
    Object result5 = JOptionPane.showInputDialog(frame, "Enter library number:");
    
    //checking to see if it is only a number
    Pattern num4 = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
	Matcher match4 = num4.matcher((CharSequence) result5);
	if (match4.find()) {
     JOptionPane.showMessageDialog(null, "Please enter only numbers");
     result5 = JOptionPane.showInputDialog(frame, "Enter library number:");
	}
	
	
	
	//Printing results out
    System.out.println("Your name is: " + result);
    System.out.println("Your age is: " +result2);
    
    //checking to see if user is an adult or child
    int i = Integer.parseInt(result2);
    if(i <= 12)
    {
    	System.out.println("You are considered a child to the library.");
    	System.out.println("Note: You can only check out 5 items at a time.");
    }
    else {
    	System.out.println("You are considered an adult to the library.");
    }
    
    System.out.println("Your address is: " +result3);
    System.out.println("Your phone number is: " +result4);
    System.out.println("Your library number is: " +result5);
    
    System.out.println("\n");
    
    System.out.println("Would you like to check out a book?");
    
    
  //checks to see if user would like to check a book out or not
  	//we should implement the class here
  	int dialogButton = 0;
  	int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to check out a book?","Book Checkout Area" ,dialogButton);
  	if(dialogResult == JOptionPane.YES_OPTION){
  		System.out.println();
  	  // Saving code here
  	}

    
  }


