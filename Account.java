package ATMSystem.copy;
//This is a blueprint for a bank ATM system
//this fill will contains all of the variables and methods needed for this systems
//this file will be used by another class
import java.util.Scanner;
public class Account {// start class
	//fields are Private/secured, The are not accessible
	//encapsulation required to access fields > Use Gets and Sets
	private String memberName;
	private String memberPin;
	private int memberBalance;
	
	
	static Scanner input= new Scanner(System.in);
	//============================Constructors==============================
	public Account(String memberName, String memberPin, int memberBalance) {
		//Constructor with 3 parameters to pass through the values
		this.memberName = memberName;
		this.memberPin = memberPin;
		this.memberBalance = memberBalance;
	}// end constructor

	public Account() {}// empty constructor

	//===============================Gets/Sets==============================
	// Encapsulation( a method to access private fields)
	public String getMemberName() {
		return memberName;
	}//end get

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}//end set

	public String getMemberPin() {
		return memberPin;
	}//end get

	public void setMemberPin(String memberPin) {
		this.memberPin = memberPin;
	}//end set

	public int getMemberBalance() {
		return memberBalance;
	}//end get

	public void setMemberBalance(int memberBalance) {
		this.memberBalance = memberBalance;
	}//end set
	//========================== Other Methods ====================================
	// method to over write the default toString method
	@Override
	public String toString() {
		return "Account Information [ Name:" + memberName + ", Pin:" + memberPin + ", Balance:" + memberBalance
				+ "]";
	}// end method
	
	// method to withdraw from the members account
	//if statement for withdraw is no more than is in account
	public void withdraw(int debit) {	

		if(debit>memberBalance) {
			System.out.println("Insufficient funds, please try again");
			withdraw(input.nextInt());
		}// end if
		System.out.println("Withdrawing: " + debit);
		memberBalance = memberBalance - debit;
		menuReturn();
		}// end method

	// method to deposit money into the members account
	public void deposit(int credit) {
		System.out.println("Depositing: " + credit);
		memberBalance = memberBalance + credit;
		menuReturn();

	}// end method
	
	//Method for current user to set new pin
	public void newPin(String pin) {
		//for loop to see if the new password matches any current passwords set by other user accounts.
		for(int i=0;i<StartApplication.customer.length;i++) {
			
			if ((StartApplication.customer[i].getMemberPin().matches (pin))) {
				System.out.println("Pin in use");
				System.out.println("Please try again");
				newPin(input.next());
			
			} // end if
			
		}//end for
		memberPin=pin;
		System.out.println("Pin changed");
		menuReturn();
	}// end method
	
	public void login(String pin) {
		if(pin.matches(memberPin)) {
			System.out.println("Correct pin Welcome "+memberName);
			menuOptions();
		}//end if

		
	}// end method
		
		public void menuOptions() {
			System.out.println("Please choose one of the following options "+memberName );
			System.out.println("1.Account Information");
			System.out.println("2.Deposit");
			System.out.println("3.Withdraw");
			System.out.println("4.New pin");
			System.out.println("5.Exit");
			String option = input.next();
			
			//switch statement to choose options
			switch (option) {
			case "1":
				System.out.println(toString());
				menuReturn();
				break;
			case "2":
				System.out.println("How much would you like to deposit?");
				deposit(validate(input.next()));
				break;
			case "3":
				System.out.println("Please insert/ select withdrawal amount.");
				withdraw(validate(input.next()));
				break;
			case "4":
				System.out.println("Please enter your new pin.");
				newPin(input.next());
				break;
			case "5":
				System.out.println("Goodbye "+ memberName + ", Thank you for using Craig's ATM.");
				System.exit(0);
				break;
			default:
				System.out.println("Incorrect option, please try again.");
				System.out.println("           ");
				menuOptions();
				break;
				
			}// end switch
			
		}//end method
	
	
		//error check or validation  method for taking in integers
		public int validate(String userInput) {
			//while loop to check that the input is an integer
			while(!userInput.matches("\\d+")) {
				System.out.println("Error, digits only");
	    		System.out.println("Please enter again");
	    		userInput = input.next();
			}//end while
			return Integer.parseInt(userInput);
		}//end method
		
		// A method so the user can access the main page after withdrawing, depositing and checking their information
		public void menuReturn(){
			System.out.println("Would you like to return to the Main Menu?");
			System.out.println("1. Yes");
			System.out.println("2. No, Exit from ATM");
			//Switch statement to bring customer to main menu or exit
			String option = input.next();
			switch (option) {
				case "1":
					menuOptions();
					break;
				case "2":
					System.out.println("Goodbye "+ memberName + ", Thank you for using Craig's ATM.");
					System.exit(0);
					break;
				default :
					System.out.println("Incorrect option chosen");
					menuReturn();
				}// end switch
		
		}// end method
		
		
	
	

}//end class
