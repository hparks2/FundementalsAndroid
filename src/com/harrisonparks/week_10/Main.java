package com.harrisonparks.week_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Contact implements Comparable<Contact> {
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

    public void display() {
        System.out.println("Name: " + name + ", Email: " + email);
    }

    @Override
    public int compareTo(Contact otherContact) {
        if (!this.name.equals(otherContact.name)) {
            return this.name.compareTo(otherContact.name);
        }
        else {
            return this.email.compareTo(otherContact.email);
        }
    }
}

class ContactCollection implements Iterable<Contact>{
    private List<Contact> contactList = new ArrayList<>();

    public void add(Contact newContact) {
        contactList.add(newContact);
    }

    @Override
    public Iterator<Contact> iterator() {
        return contactList.iterator();
    }
}


public class Main {
    public static void main(String[] args) {
        Contact bob = new Contact("Bob", "bob@bob.com");
        Contact arthur = new Contact("Arthur", "aneuman1@cscc.edu");
        Contact arthur2 = new Contact("Arthur", "aaaaa@aaaa.com" );


        //List<Contact> contactsList = new ArrayList(){};
        ContactCollection contacts = new ContactCollection();
        contacts.add(bob);
        contacts.add(arthur);
        contacts.add(arthur2);


        for (Contact entry: contacts) {
            entry.display();
        }

    }
}
