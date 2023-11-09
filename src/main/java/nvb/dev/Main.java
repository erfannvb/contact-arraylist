package nvb.dev;

import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static final MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();

        while (!quit) {

            System.out.print("Choose your action : ");
            int action = input.nextInt();

            switch (action) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContact();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    System.out.println("Invalid Action!");
                    break;
            }

        }
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable Actions : ");
        System.out.println("0 - to shutdown");
        System.out.println("1 - to print the contact list");
        System.out.println("2 - to add a new contact");
        System.out.println("3 - to update an existing contact");
        System.out.println("4 - to remove an existing contact");
        System.out.println("5 - to query if a contact exists");
        System.out.println("6 - to print the available actions");
    }

    private static void addContact() {
        System.out.println("Enter new contact name : ");
        String name = input.next();

        System.out.println("Enter new contact phone number : ");
        String phoneNumber = input.next();

        Contact newContact = Contact.createContact(name, phoneNumber);
        if (mobilePhone.addContact(newContact)) {
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Error adding contact.");
        }
    }

    private static void updateContact() {
        System.out.println("Enter contact name : ");
        String existingName = input.next();

        Contact exisitngContact = mobilePhone.queryContact(existingName);
        if (exisitngContact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Enter new contact name : ");
        String newName = input.next();

        System.out.println("Enter new phone number : ");
        String newPhoneNumber = input.next();

        Contact newContact = Contact.createContact(newName, newPhoneNumber);
        if (mobilePhone.updateContact(exisitngContact, newContact)) {
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Error updating contact.");
        }
    }

    private static void removeContact() {
        System.out.println("Enter contact name : ");
        String existingName = input.next();

        Contact exisitngContact = mobilePhone.queryContact(existingName);
        if (exisitngContact == null) {
            System.out.println("Contact not found!");
            return;
        }

        if (mobilePhone.removeContact(exisitngContact)) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Error deleting contact.");
        }
    }

    private static void queryContact() {
        System.out.println("Enter contact name : ");
        String existingName = input.next();

        Contact contact = mobilePhone.queryContact(existingName);
        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Name : " + contact.name() + "\n"
                + "PhoneNumber : " + contact.phoneNumber());
    }


}
