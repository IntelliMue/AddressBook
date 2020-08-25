package addressBook;

import java.util.Iterator;
import java.util.Vector;


public class Contacts {
    public Vector <Person> contacts = null;
    public static int counter = 0;
    public String phoneFmt = "(\\d{3})(\\d{3})(\\d{4})";
    
    public Contacts() {
        this.contacts = new Vector<Person>();
    }
    
    public Person findContact(String firstName, String lastName) {
    	Iterator <Person> i = this.contacts.iterator();
        
        while(i.hasNext()) {
            Person currPerson = i.next();
            if(currPerson.firstName.equals(firstName) && currPerson.lastName.equals(lastName)) {
            	return currPerson;
            }
        }
        return null;
    }
    
    public void addContact(String firstName, String lastName, String street, String city, 
    					  String state, int zipcode, int phoneNum) {
    	Person person = new Person(firstName, lastName, street, city, 
    							   state, zipcode, phoneNum);
    	this.contacts.addElement(person);

    }
    
    public void deleteContact(String firstName, String lastName) {
        Iterator <Person> i = this.contacts.iterator();
    
        while(i.hasNext()) {
            Person currPerson = i.next();
            if(currPerson.firstName.equals(firstName) && currPerson.lastName.equals(lastName)) {
                this.contacts.remove(currPerson);
            }
        }
    }
    
    public void updateContact(Person person) {
    	Menu addressMenu = new Menu();
    	final int choice = addressMenu.runUpdateMenu();
		switch(choice) {
		// Update street
		case 1:
			break;
		// Update city
		case 2:
			break;
		// Update state
		case 3:
			break;
		// Update zipcode
		case 4:
			break;
		// Update phone number
		case 5:
			break;
		}
    }
    
    public Integer getTotalContactNum() {
        return this.contacts.size();
    }
    
    public void  listContactes() {
        Iterator <Person> i = this.contacts.iterator();
    
        System.out.println("Animal List (CSV Format):");
        while(i.hasNext()) {
            Person currPerson = i.next();
            System.out.println(currPerson.convertToString());
        }
    }
}
