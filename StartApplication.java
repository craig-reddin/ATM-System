package ATMSystem.copy;
//This is the start of the application
//This is the entry point
//This class contains the Main method
import java.util.Scanner;
public class StartApplication {// Start class
	//Create an object of class Account and assign it a value
	//Make connection between the two classes
	//Make array here to create the database of users
	static Account[]customer=new Account[5];
	static Scanner input= new Scanner(System.in);
	// field for incorrect pin
	static int pinCount;

	public static void main(String[] args) {//Start main
		customer[0]=new Account ("Treza","1111",100);
		customer[1]=new Account ("Daniel","2222",200);
		customer[2]=new Account ("Jason","3333",300);
		customer[3]=new Account ("Josh","4444",400);
		customer[4]=new Account ("Jessica","5555",500);
		//print out database (Screenshot 3 for documentation)
		// use a for loop to print out all accounts
		//Print out to welcome user.
		System.out.println("\tFinal screenshot for documentation");
		System.out.println("            ");
		System.out.println("\tWelcome to Craig's ATM.");
		System.out.println("            ");
		System.out.println("Please enter your pin:");
		pinCount=0;
		//while loop to ensure pin cant be entered more than 3 time before being locked out
		while(pinCount<3) {
		String membersPin= input.next();
		for(int i=0;i<customer.length;i++) {
			if(customer[i].getMemberPin().matches(membersPin)) {
			customer[i].login(membersPin);
			}//end if
		}// end for loop
		System.out.println("Incorrect Password entered, try again");
 		pinCount++;
		}// end while
		//print out for customer direction
		System.out.println("Sorry, you have entered the incorrect pin too many times");
		System.out.println("Please drop in to your local branch or call 01 87878989");
		
		System.exit(0);
	
		
		
	}//end main

}//end class
