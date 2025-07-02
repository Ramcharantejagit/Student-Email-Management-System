package emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Email {
    private String fname;
    private String lname;
    private String rollNo;
    private String dept;
    private String email;
    private String domain;
    private String password;
    private String domainPassword;
    private int mailCapacity = 500; // Default mailbox capacity
    private String alternateEmail;
    private Scanner s = new Scanner(System.in);

    // Constructor to receive first name, last name, and roll number
    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("Enter Roll No:");
        this.rollNo = s.next();
        this.dept = setDept(); // Set department
        this.password = generatePassword(8); // Generate personal email password
        this.domainPassword = generatePassword(8); // Generate domain email password
        this.email = generateEmail(); // Generate personal email
        this.domain = generateDomain(); // Generate domain email

        System.out.println("New Student:");
        System.out.println("Name: " + fname + " " + lname);
        System.out.println("Personal Email: " + email);
        System.out.println("Domain Email: " + domain);
        System.out.println("Personal Email Password: " + password);
        System.out.println("Domain Email Password: " + domainPassword);
    }

    // Generate domain email
    private String generateDomain() {
        return rollNo + "@cmrec.ac.in";
    }

    // Generate personal email
    private String generateEmail() {
        return fname.toLowerCase() + "." + lname.toLowerCase() + "@" + dept.toLowerCase() + ".department.com";
    }

    // Set department
    private String setDept() {
        System.out.println("Department Codes:\n1 for Information Technology\n2 for Computer Science\n3 for Data Science\n0 for None");
        boolean flag = false;
        do {
            System.out.println("Enter Department Code: ");
            int choice = s.nextInt();
            switch (choice) {
                case 1 -> {
                    return "IT";
                }
                case 2 -> {
                    return "CSE";
                }
                case 3 -> {
                    return "DS";
                }
                case 0 -> {
                    return "None";
                }
                default -> System.out.println("Invalid choice, please choose again.");
            }
        } while (!flag);
        return null;
    }

    // Generate random password
    private String generatePassword(int length) {
        Random r = new Random();
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = capitalChars + smallChars + numbers + symbols;
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(values.charAt(r.nextInt(values.length())));
        }
        return password.toString();
    }

    // Change personal email password
    public void setPassword() {
        System.out.println("Enter current personal email password: ");
        String temp = s.next();
        if (temp.equals(this.password)) {
            System.out.println("Enter new password: ");
            this.password = s.next();
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Incorrect password.");
        }
    }

    // Change domain email password
    public void setDomainPassword() {
        System.out.println("Enter current domain email password: ");
        String temp = s.next();
        if (temp.equals(this.domainPassword)) {
            System.out.println("Enter new domain password: ");
            this.domainPassword = s.next();
            System.out.println("Domain password changed successfully.");
        } else {
            System.out.println("Incorrect domain password.");
        }
    }

    // Set mailbox capacity
    public void setMailCapacity() {
        System.out.println("Current mailbox capacity: " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity updated successfully.");
    }

    // Set alternate email
    public void alternateEmail() {
        System.out.println("Enter new alternate email: ");
        this.alternateEmail = s.next();
        System.out.println("Alternate email set successfully.");
    }

    // Display user information
    public void getInfo() {
        System.out.println("Name: " + fname + " " + lname);
        System.out.println("Department: " + dept);
        System.out.println("Domain Mail: " + domain);
        System.out.println("Domain Password: " + domainPassword);
        System.out.println("Personal Email: " + email);
        System.out.println("Personal Email Password: " + password);
        System.out.println("Mailbox Capacity: " + mailCapacity + "mb");
        System.out.println("Alternate Email: " + (alternateEmail != null ? alternateEmail : "null"));
    }

    // Store information in file
    public void storeFile() {
        try (FileWriter fw = new FileWriter("info.txt")) {
            fw.write("First Name: " + fname + "\nLast Name: " + lname + "\nRoll No: " + rollNo);
            fw.write("\nDepartment: " + dept + "\nPersonal Email: " + email + "\nDomain Email: " + domain);
            fw.write("\nPersonal Email Password: " + password + "\nDomain Password: " + domainPassword);
            fw.write("\nMailbox Capacity: " + mailCapacity + "mb" + "\nAlternate Email: " + (alternateEmail != null ? alternateEmail : "null"));
            System.out.println("Data stored successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while storing data: " + e.getMessage());
        }
    }

    // Read information from file
    public void readFile() {
        try (FileReader fr = new FileReader("info.txt")) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading data: " + e.getMessage());
        }
    }
}
