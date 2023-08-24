package BankingSystem;

public class accounts {

	private String name;
	private String pass;
	private int balance;
	private int id;
	private static int accountCount=0;
	
	public accounts(String name, String pass, int balance, int id){
		this.name = name;
		this.balance = balance;
		this.id = id;
		this.pass = pass;
		accountCount++; //Increments The Total Amount of Accounts
	}
	
	public String accountInfo() {
		return("User ID: "+ id +" | "+"Name: "+ name +" | "+ "Balance: "+ balance); //Show the Account Info
	}
	public int accountID() {
		return id;
	}
	public String accountName() {
		return name;
	}
	public String accountPass() {
		return pass;
	}
	public int accountBal() {
		return balance;
	}
}
