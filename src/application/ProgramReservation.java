package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class ProgramReservation {

	public static void main(String[] args)  {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
	
			System.out.print("checkin date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("checkout date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
		
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
		
			System.out.println();
			System.out.println("Enter date to update the reservation:");
			System.out.print("checkin date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("checkout date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
		
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format: ");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}
}