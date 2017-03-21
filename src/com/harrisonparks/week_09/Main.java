package com.harrisonparks.week_09;

abstract class Contact {
    protected String name;

    Contact(String name) {
        this.name = name;
    }

    abstract public void contact();
}

class EmailContact extends Contact{
    protected String email;

    EmailContact(String name, String email) {
        super(name);
        this.email = email;
    }

    @Override
    public void contact() {
        System.out.println("Emailing " + email);
    }
}

class PhoneContact extends Contact {
    protected String phoneNumber;

    PhoneContact(String name, String phoneNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void contact() {
        System.out.println("Calling " + phoneNumber);
    }
}


public class Main {
    public static void main(String[] args) {
        EmailContact emailContact = new EmailContact("Arthur", "aneuman1@cscc.edu");
        emailContact.contact();

        PhoneContact phoneContact = new PhoneContact("Bob", "123-456-7890");
        phoneContact.contact();
    }
}