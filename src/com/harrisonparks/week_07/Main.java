package com.harrisonparks.week_07;

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

    public boolean equals(Object obj){
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact otherContact = (Contact) obj;
        return this.name.equals(otherContact.getName())
                && this.email.equals(otherContact.getEmail());
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

class BusinessContact extends Contact{
    private String phoneNumber;

    public BusinessContact(String name, String email, String phoneNumber) {
        super(name, email);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Phone: " + phoneNumber);
    }

}

public class Main {
    public static void main(String[] args) {
        Contact bob = new Contact("Bob", "bob@bob.com");
        bob.display();

        BusinessContact sue = new BusinessContact("Sue", "sue@sue.com", "123-456-7890");
        sue.display();

        System.out.println(sue.getName());
    }
}