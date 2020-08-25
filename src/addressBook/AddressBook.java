package addressBook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AddressBook {
	public static void main(String[] args) {
		boolean usingApp = true;
		Menu addressMenu = new Menu();
		Contacts contactList = new Contacts();
		// TODO Auto-generated method stub
		while(usingApp) {
			int choice = addressMenu.runMainMenu();
			switch(choice) {
				case 0:
					usingApp = false;
					break;
				// Add
				case 1:
					try {
						System.out.print("\n\nEnter contact's first name: ");
						BufferedReader usrConIn = new BufferedReader(new InputStreamReader(System.in));
						String firstName = usrConIn.readLine();
						System.out.print("\nEnter contact's last name: ");
						String lastName = usrConIn.readLine();
						System.out.print("\nEnter contact's street: ");
						String street = usrConIn.readLine();
						System.out.print("\nEnter contact's city: ");
						String city = usrConIn.readLine();
						System.out.print("\nEnter contact's state: ");
						String state = usrConIn.readLine();
						System.out.print("\nEnter contact's zip code: ");
						String tempZip = usrConIn.readLine();
						int zipcode = Integer.parseInt(tempZip);
						System.out.print("\nEnter contact's phone number: ");
						String tempPhone = usrConIn.readLine();
						int phoneNum = Integer.parseInt(tempPhone);
		
						usrConIn.close();
						contactList.addContact(firstName, lastName, street, city, state, zipcode, phoneNum);
					}
					catch (Exception e) {
						System.out.println(e);
					}
					break;
				// Delete
				case 2:
					try {
						System.out.print("\n\nEnter contact's first name: ");
						Scanner usrConIn = new Scanner(System.in);
						String firstName = usrConIn.nextLine();
						System.out.print("\nEnter contact's last name: ");
						String lastName = usrConIn.nextLine();
						usrConIn.close();
						
						contactList.deleteContact(firstName, lastName);
					}
					catch (Exception e) {
						System.out.println(e);
					}
					break;
				// Update
				case 3:
					try {
						System.out.print("\n\nEnter contact's first name: ");
						Scanner usrConIn = new Scanner(System.in);
						String firstName = usrConIn.nextLine();
						System.out.print("\nEnter contact's last name: ");
						String lastName = usrConIn.nextLine();
						usrConIn.close();
						
						Person person = contactList.findContact(firstName, lastName);
						contactList.updateContact(person);
					}
					catch (Exception e) {
						System.out.println(e);
					}
				// Display all
				case 4:
					contactList.listContactes();
					break;
				default:
					break;
			}
		}
	}

}
