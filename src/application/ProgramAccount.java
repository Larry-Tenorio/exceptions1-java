package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class ProgramAccount {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Enter account number: ");
			int number = sc.nextInt();
			
			System.out.print("Enter account holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			
			System.out.print("Enter initial balance: ");
			double balance = sc.nextDouble();
			
			System.out.print("Enter withDrawnLimit: ");
			double withDrawnLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withDrawnLimit);
			
			System.out.print("\nEnter amount for withDrawn: ");
			double amount = sc.nextDouble();
			
			account.withDraw(amount);
			
			System.out.print(String.format("New balance: %.2f ", account.getBalance()));
			
		} catch (DomainException e) {
			System.out.println("Withdrawn error: " + e.getMessage());
		}
	}

}
