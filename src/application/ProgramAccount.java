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
			System.out.println("Enter account data");

			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();

			System.out.print("Holder: ");
			String holder = sc.nextLine();

			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();

			System.out.print("Withdraw limit: ");
			double whitDraw = sc.nextDouble();

			Account account = new Account(number, holder, balance, whitDraw);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();

			account.withDraw(amount);

			boolean running = true;
			while (running) {
				System.out.println("\nChoose an operation: ");
				System.out.println("1 - Deposit");
				System.out.println("2 - Withdraw");
				System.out.println("3 - Check Balance");
				System.out.println("0 - Exit");
				int option = sc.nextInt();

				switch (option) {
				case 1:
					System.out.print("Enter amount to deposit: ");
					double depositAmount = sc.nextDouble();
					try {
						account.deposit(depositAmount);
						System.out.println(
								"Deposit Successful! New balance: " + String.format("%.2f", account.getBalance()));
					} catch (DomainException e) {
						System.out.println("Error: " + e.getMessage());
					}
					break;

				case 2:
					System.out.print("Enter amount to withdraw: ");
					double withdrawAmount = sc.nextDouble();
					try {
						account.withDraw(withdrawAmount);
						System.out.println(
								"Withdraw successful! New balance: " + String.format("%.2f", account.getBalance()));
					} catch (DomainException e) {
						System.out.println("Erro: " + e.getMessage());
					}
					break;

				case 3:
					System.out.println("Current balance: " + String.format("%.2f", account.getBalance()));
					break;

				case 0:
					running = false;
					System.out.println("Exiting. Thank you!");
					break;

				default:
					System.out.println("Invalid option! Try again.");
				}
			}

		}

		catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}
