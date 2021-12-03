package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Boolean follow = null;

		String title;
		int totalPlaces;
		LocalDate date;

		System.out.print("Inserire nome dell'evento: ");
		title = scan.nextLine();
		System.out.print("Inserire posti disponibili: ");
		totalPlaces = scan.nextInt();
		System.out.print("Inserire giorno evento (DD): ");
		int day = scan.nextInt();
		System.out.print("Inserire mese evento (MM): ");
		int month = scan.nextInt();
		System.out.print("Inserire anno evento (AAAA): ");
		int year = scan.nextInt();
		date = LocalDate.of(year, month, day);

		try {

			Evento event = new Evento(title, date, totalPlaces);
			// System.out.println(event.toString());
			System.out.print("\nScrivere s per prenotare o n per proseguire senza prenotare: ");
			scan.nextLine();
			String choice = scan.nextLine().toLowerCase();

			do {
				if (choice.equals("s")) {
					follow = true;
					System.out.print("inserire numero prenotazioni da effettuare: ");
					int resNum = scan.nextInt();
					for (int i = 1; i <= resNum; i++) {
						event.prenota();
					}

				} else if (choice.equals("n")) {
					System.out.println("Grazie ed arrivederci.");
				} else {
					System.out.println("Inserire un valore valido (s/n): ");
				}

			} while (follow == false);

			System.out.println(event.getReservedPlaces());
			System.out.println(event.getTotalPlaces() - event.getReservedPlaces());
			
			System.out.print("\nScrivere s per disdire o continuare senza disdire: ");
			scan.nextLine();
			String choice2 = scan.nextLine();
			do {
				if (choice2.equals("s")) {
					follow = true;
					System.out.print("inserire numero prenotazioni da disdire: ");
					int resNum = scan.nextInt();
					for (int i = 1; i <= resNum; i++) {
						event.disdici();
					}

				} else if (choice2.equals("n")) {
					System.out.println("Grazie ed arrivederci.");
				} else {
					System.out.println("Inserire un valore valido (s/n): ");
				}

			} while (follow == false);
			
			System.out.println(event.getReservedPlaces());
			System.out.println(event.getTotalPlaces() - event.getReservedPlaces());

		} catch (Exception e) {
			System.out.println("Il programma è terminato perché: " + e.getMessage());
		}

		scan.close();
	}

}
