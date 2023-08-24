package BankingSystem;

import java.util.Random;
import java.util.Scanner;


class bankAccount {
	static Random rand= new Random();
	static Scanner scanner = new Scanner(System.in);  
	
	private String name;
	private String pass;
	private int accNum;
	private int bal;
	
	private static accounts[] accountsBank; // All Account in the bank
	private static int accountCount; // Counts how many account are currently in the bank
	
	public bankAccount() {
		accountsBank = new accounts[100];
		accountCount = 0;
		
	}
	
	public void createAccount(String name, String pass, int balance) {
		
		int accNum = (int)Math.floor(Math.random() * (5000 - 1000 + 1) + 1000);
		
		accounts accounts = new accounts(name,pass,balance,accNum);
		accountsBank[accountCount] = accounts; //Saves Account details to an array
		accountCount++; //Increments account Count for every new account created
		
		System.out.println("       Your ID is: " + accNum); //Prints the users ID after account Creation
	}
	
	public void printInfo(int accountNum) {
		if (accountCount == 0) {
			System.out.println("The Database is Empty!"); //If there are currently no accounts created this will print
		}
		else {
			for (int i = 0; i<accountCount; i++) {
				if(accountNum == accountsBank[i].accountID()) { //Checks if the user has an account
					
					System.out.print("Enter Password: ");
					String pass = scanner.next();
					System.out.println(" ");
					
					if(pass.equals(accountsBank[i].accountPass())) //Validates user password before showing User Information
					{
						System.out.println("Account ID: " + accountsBank[i].accountID());
						System.out.println("Account Name: " + accountsBank[i].accountName());
						System.out.println("Account Password: " + accountsBank[i].accountPass());
						System.out.println("Account Balance: " + accountsBank[i].accountBal());
					}
					else {
						System.out.println("Invalid Password!");
					}
				}
				else {
					System.out.println("User Not Found!");
				}
			}
		}
	}
	
	public void printInfoList() { 
		if (accountCount == 0) { //If there are currently no accounts created this will print
			System.out.println("The Database is Empty!");
		}
		for (int i = 0; i<accountCount; i++)  //Print all Users
		{
			System.out.println(accountsBank[i].accountInfo());
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public int getAccNum() {
		return accNum;	
	}
	
	public void setBal(int bal) {
		this.bal = bal;
	}
	public int getBal() {
		return bal;
	}
	
	public void depositMoney(int accountNum, String pass){
		int userMoney = 0;
		
		if (accountCount == 0) {
			System.out.println("The Database is Empty!"); //If there are currently no accounts created this will print
		}
		else {
			for(int i = 0; i<accountCount; i++) {
				if(accountNum == accountsBank[i].accountID()) { //Checks if the user has an account
					if(pass.equals(accountsBank[i].accountPass()))
					{
						System.out.println("Deposit Money into Account");
						System.out.print("Enter Amount: ");
						userMoney = scanner.nextInt();
						
						int oldBal = accountsBank[i].accountBal();
						int newBal = oldBal + userMoney;
						String name = accountsBank[i].accountName();
						String password = accountsBank[i].accountPass();
						int accNum = accountsBank[i].accountID();
						
						accounts accounts = new accounts(name,password,newBal,accNum);
						accountsBank[i] = accounts;
						
						System.out.println(accountsBank[i].accountInfo());
					}
					else {
						System.out.println("Incorrect Password. Try again!");
						break;
					}
				}
				else{
					System.out.println("Account does not exist.");
					break;
				}
			}
		}
	}
	
	public void withdrawMoney(int accountNum, String pass){
		int userMoney = 0;
		
		if (accountCount == 0) {
			System.out.println("The Database is Empty!"); //If there are currently no accounts created this will print
		}
		else {
			for(int i = 0; i < accountCount; i++) {
				if(accountNum == accountsBank[i].accountID()) { //Checks if the user has an account
					if(pass.equals(accountsBank[i].accountPass())){
						System.out.println("Withdraw Money from Account");
						System.out.print("Enter Amount: ");
						userMoney = scanner.nextInt();
						
						int oldBal = accountsBank[i].accountBal();
						int newBal = oldBal - userMoney;
						String name = accountsBank[i].accountName();
						String password = accountsBank[i].accountPass();
						int accNum = accountsBank[i].accountID();
						
						accounts accounts = new accounts(name,password,newBal,accNum);
						accountsBank[i] = accounts;
						
						System.out.println(accountsBank[i].accountInfo());
					}
					else {
						System.out.println("Incorrect Password. Try again!");
						break;
					}
				}
				else{
					System.out.println("Account does not exist.");
					break;
				}
			}
		}
	}
	
	public int getOwnerAcc(int accountNum, String pass){
		int ownerAcc;
		
		if (accountCount == 0) {
			System.out.println("The Database is Empty!"); //If there are currently no accounts created this will print
		}
		else {
			for(int i = 0; i < accountCount; i++) {
				if(accountNum == accountsBank[i].accountID()) { //Checks if the user has an account
					if(pass.equals(accountsBank[i].accountPass())){
						
						ownerAcc = accountsBank[i].accountID();
						
						return ownerAcc;
						
					}
					else {
						System.out.println("Incorrect Password. Try again!");
						break;
					}
				}
				else{
					System.out.println("Account does not exist.");
					break;
				}
			}
		}
		
		return 0;
	}
	
	public int getTransfereeAcc(int accountNum){
		int transferAcc;
		
		if (accountCount == 0) {
			System.out.println("The Database is Empty!"); //If there are currently no accounts created this will print
		}
		else {
			for(int i = 0; i < accountCount; i++) {
				if(accountNum == accountsBank[i].accountID()) { //Checks if the user has an account
					transferAcc = accountsBank[i].accountID();
					
					return transferAcc;
				}
				else{
					System.out.println("Account does not exist.");
					break;
				}
			}
		}
		
		return 0;
	}
	
	public void transferMoney(int ownerAcc, int transferAcc){
		int userMoney = 0;
		
		for(int i = 0; i < accountCount; i++) {
			if(ownerAcc == accountsBank[i].accountID()){
				System.out.print("Enter Amount: ");
				userMoney = scanner.nextInt();
				
				int oldOwnerBal = accountsBank[i].accountBal();
				int newOwnerBal = oldOwnerBal - userMoney;
				String ownerName = accountsBank[i].accountName();
				String ownerpass = accountsBank[i].accountPass();
				int ownerAccNum = accountsBank[i].accountID();
				
				accounts accounts = new accounts(ownerName,ownerpass,newOwnerBal,ownerAccNum);
				accountsBank[i] = accounts;
				
				if(transferAcc == accountsBank[i].accountID()){
					int oldTransferBal = accountsBank[i].accountBal();
					int newTransferBal = oldTransferBal + userMoney;
					String transferName = accountsBank[i].accountName();
					String transferPass = accountsBank[i].accountPass();
					int transferAccNum = accountsBank[i].accountID();
					
					accounts transferAccounts = new accounts(transferName,transferPass,newTransferBal,transferAccNum);
					accountsBank[i] = transferAccounts;
				}
			}
		}
		System.out.println("Money transfer to Account");
	}
}
