package BankingSystem;

import java.util.Scanner; 

public class bank {
	public static void main(String[] args) {
		
		bankAccount account = new bankAccount();
		
		int userchoice=0;
		String name;
		String pass;
		int bal = 0;
		int id = 0;
		int accountNum;
		
		do {
			Scanner scanner = new Scanner(System.in);  //Create a Scanner object to be used by the whole bank class
			System.out.println("================================");
			System.out.println("     Welcome to AdonisBank");
			System.out.println("================================");
			System.out.println(" ");
			System.out.println("    Please Select A Number");
			System.out.println(" ");
			System.out.println("================================");
			System.out.println("(1) User List");
			System.out.println("(2) Print User Information");
			System.out.println("(3) Create New Account");
			System.out.println("(4) Deposit Money into Account");
			System.out.println("(5) Withdraw Money from Account");
			System.out.println("(6) Transfer Money to another Account");
			System.out.println("(7) Exit");
			System.out.println("================================");
			System.out.print("Enter Choice: ");
			userchoice = scanner.nextInt(); 
			scanner.nextLine();
			System.out.println("================================");
			
			switch (userchoice) {
				
				case 1:
					account.printInfoList(); //Shows all the users created
					break;
					
				case 2:
					System.out.print("Enter ID: "); 
					id = scanner.nextInt(); //Prints a certain Users Information based on the ID
					account.printInfo(id);  //Checks if ID is valid and requires authentication by password
					break;
		
				case 3:
					System.out.print("Enter Name: ");
					name = scanner.nextLine();
					
					if (name.matches("^[0-9]")) //Checks if name has any number
					{
						do{
						    System.out.print("Please enter a valid name: ");
						    name = scanner.nextLine();
						}while(name.matches("^[0-9]"));  //Loops until user enters a valid name without numbers
					}
					
					System.out.println(" ");
					System.out.println("Password Must be at least 3 Characters");
					System.out.print("Create Password: ");
					pass = scanner.nextLine();
					
					if (pass.length() < 3) //Checks if password entered is at least 3 Characters
					{
						while(pass.length() < 3) { //Loops until user has at least 3 Characters
							System.out.println(" ");
							System.out.println("Password Must be at least 3 Characters");
							System.out.print("Enter a Valid Password: ");
							pass = scanner.nextLine();
						}
						
					}
					System.out.println(" ");
					try {
						System.out.println("Please Enter An Amount More than $1000");
						System.out.print("Enter Balance: ");
						bal = scanner.nextInt(); //User Input must be 1000 or more
						
						while(bal < 1000){ //Loops if User Input is less than 1000
							System.out.println(" ");
							System.out.println("Balance Should be $1000 Minimum");
						    System.out.print("Enter Balance: ");
						    bal = scanner.nextInt();
						}
						
						System.out.println("================================");
						System.out.println("   Account has Been Created!");
						account.createAccount(name, pass, bal); //Creates an Account
						System.out.println("================================");
						
					}catch(Exception e) {			
						System.out.println("Invalid Input");
					}
					break;
					
				case 4:
					System.out.print("Enter Account Number: ");
					accountNum = scanner.nextInt();
					System.out.print("Enter Password: ");
					pass = scanner.next();
					account.depositMoney(accountNum,pass);
					break;
					
				case 5:
					System.out.print("Enter Account Number: ");
					accountNum = scanner.nextInt();
					System.out.print("Enter Password: ");
					pass = scanner.next();
					account.withdrawMoney(accountNum,pass);
					break;
					
				case 6:			
					System.out.print("Enter User Account Number: ");
					int ownerAcc = scanner.nextInt();
					System.out.print("Enter Password: ");
					pass = scanner.next();
					account.getOwnerAcc(ownerAcc,pass);
					
					System.out.print("Enter Account Number: ");
					int transferAcc = scanner.nextInt();
					account.getTransfereeAcc(transferAcc);
					
					account.transferMoney(ownerAcc, transferAcc);
					
					break;
			}
		}while (userchoice < 6); 	
	}
}
