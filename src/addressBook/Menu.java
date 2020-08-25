package addressBook;

import java.util.Scanner;

public class Menu {
	
	public String mainMenu = "Address Book Main Menu\n\n";
	public String addOption = "1) Add contact to address book\n";
	public String deleteOption = "2) Delete contact from address book\n";
	public String updateOption = "3) Update contact in address book\n";
	public String displayAllOption = "4) Display all contacts from address book\n";
	
	public String updateMenu = "Address Book Update Menu\n\n";
	public String updateStreet = "1) Update street\n";
	public String updateCity = "2) Update city\n";
	public String updateState = "3) Update state\n";
	public String updateZip = "4) Update zipcode\n";
	public String updatePhoneNum = "5) Update phone number\n";

	public String quitOption = "0) Quit";
	
	public int choice = 0;
	
	public int runMainMenu() {
		while(true) {
			System.out.println(mainMenu + addOption + deleteOption + updateOption + displayAllOption + quitOption);
			try {
				this.choice = Integer.parseInt(getUsrInput());
				if(this.choice < 0 || this.choice > 4) {
					System.out.println("\nInvalid option entered\n\n");
				}
				else {
					return this.choice;
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public int runUpdateMenu() {
		while(true) {
			System.out.println(updateMenu + updateStreet + updateCity + updateState + updateZip + updatePhoneNum + quitOption);
			try {
				this.choice = Integer.parseInt(getUsrInput());
				if(this.choice < 0 || this.choice > 5) {
					System.out.println("\nInvalid option entered\n\n");
				}
				else {
					return this.choice;
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public String getUsrInput() {
		String usrInput = null;
		Scanner usrConIn = new Scanner(System.in);
		System.out.print("\nEnter menu choice: ");
		usrInput = usrConIn.nextLine();
		usrConIn.close();
		
		return usrInput;
	}
	
}
