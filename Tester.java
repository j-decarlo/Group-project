package experiments;

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
    Object result2 = JOptionPane.showInputDialog(frame, "Enter age:");
    
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

    System.out.println("Your name is: " + result);
    System.out.println("Your age is: " +result2);
    System.out.println("Your address is: " +result3);
    System.out.println("Your phone number is: " +result4);
    System.out.println("Your library number is: " +result5);
    
    
  }

}
