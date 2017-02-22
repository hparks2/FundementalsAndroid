package com.harrisonparks.week_05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

class Contact {
    private String name;
    private String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void add(Contact contact) {
        contacts.add(contact);
    }

    public String findEmail(String name) {
        for (Contact contact: contacts) {
            if (contact.getName().equals(name)) {
                return contact.getEmail();
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Contact bob = new Contact("bob","bob@bob.com");
        AddressBook addressBook = new AddressBook();
        addressBook.add(bob);

        Contact sue = new Contact("sue", "sue@sue.com");
        addressBook.add(sue);

        System.out.println(addressBook.findEmail("bob"));
        System.out.println(addressBook.findEmail("sue"));
    }
}