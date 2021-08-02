package experiments;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tester {

    public static void main(final String[] args) {
        final JFrame parent = new JFrame();
        JButton button = new JButton();

        button.setText("Click me to show dialog!");
        parent.add(button);
        parent.pack();
        parent.setVisible(true);
        
        // Create user object
        User user1 = new User();

        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(parent,
                        "What is your name?", null);
                user1.setName(name);
                user1.printName();
                
                String address = JOptionPane.showInputDialog(parent,
                        "What is your address?", null);
                user1.setAddress(address);
                user1.printAddress();
                
                String phoneNumber = JOptionPane.showInputDialog(parent,
                        "What is your phone number?", null);
                user1.setPhoneNumber(phoneNumber);
                user1.printPhoneNumber();
                
                String libraryNumber = JOptionPane.showInputDialog(parent,
                        "What is your library number?", null);
                user1.setLibraryNumber(libraryNumber);
                user1.printLibraryNumber();
            }
        });
    }
}
