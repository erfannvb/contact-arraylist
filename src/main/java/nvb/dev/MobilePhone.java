package nvb.dev;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private final List<Contact> contactList = new ArrayList<>();

    public void printContact() {
        System.out.println("Contact List");
        for (int i = 0; i < contactList.size(); i++) {
            int order = i + 1;
            System.out.println(order + ". " + contactList.get(i).name()
                    + " -> " + contactList.get(i).phoneNumber());
        }
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact.name()) >= 0) {
            System.out.println(contact.name() + " already exists.");
            return false;
        }
        contactList.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println(oldContact.name() + " was not found.");
            return false;
        } else if (findContact(newContact.name()) >= 0) {
            System.out.println(newContact.name() + " already exists.");
            return false;
        }
        contactList.set(position, newContact);
        System.out.println(oldContact.name() + " was replaced with " + newContact.name());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println(contact.name() + " was not found.");
            return false;
        }
        contactList.remove(position);
        return true;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) return contact.name();
        return null;
    }

    public Contact queryContact(String contactName) {
        int position = findContact(contactName);
        if (position >= 0) return contactList.get(position);
        return null;
    }

    private int findContact(Contact contact) {
        return contactList.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            if (contact.name().equals(contactName)) return i;
        }
        return -1;
    }

}
