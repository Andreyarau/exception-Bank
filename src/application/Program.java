package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomianException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = scan.nextInt();
		System.out.print("Holder: ");
		scan.nextLine();
		String holder = scan.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = scan.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = scan.nextDouble();
		
		Account account = new Account(number, holder, initialBalance, withdrawLimit);
		
		try {
			System.out.print("\nEnter amount for withdraw: ");
			account.withdraw(scan.nextDouble());
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		catch (DomianException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		scan.close();

	}

}
