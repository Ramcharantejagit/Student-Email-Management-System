package emailapp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // User info
        System.out.println("Enter first name: ");
        String f_name = s.next();
        System.out.println("Enter last name: ");
        String l_name = s.next();
        
        // Creating object for Email class
        Email em1 = new Email(f_name, l_name);
        int choice = -1;
        
        do {
            System.out.println("\n-----------------");
            System.out.println("Enter your choice");
            System.out.println("-----------------");
            System.out.println("1. Show Info");
            System.out.println("2. Change Domain Password");
            System.out.println("3. Change Email Password");
            System.out.println("4. Change Mailbox Capacity");
            System.out.println("5. Set Alternate Mail");
            System.out.println("6. Store data in file");
            System.out.println("7. Display data from file");
            System.out.println("8. Exit");
            
            choice = s.nextInt();
            
            switch (choice) {
                case 1 -> em1.getInfo();
                case 2 -> em1.setDomainPassword();
                case 3 -> em1.setPassword();
                case 4 -> em1.setMailCapacity();
                case 5 -> em1.alternateEmail();
                case 6 -> em1.storeFile();
                case 7 -> em1.readFile();
                case 8 -> System.out.println("Thank you for using the application");
                default -> System.out.println("Invalid choice! Enter proper choice again.");
            }
        } while (choice != 8);
        
        s.close();
    }
}

// Placeholder for the Email class
class Email {
    private String firstName;
    private String lastName;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void getInfo() {
        // Implement the method to show user info
        System.out.println("Name: " + firstName + " " + lastName);
    }

    public void setDomainPassword() {
        // Implement the method to change domain password
    }

    public void setPassword() {
        // Implement the method to change email password
    }

    public void setMailCapacity() {
        // Implement the method to change mailbox capacity
    }

    public void alternateEmail() {
        // Implement the method to set alternate email
    }

    public void storeFile() {
        // Implement the method to store data in a file
    }

    public void readFile() {
        // Implement the method to read data from a file
    }
}
