package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String title;
		int totalPlaces;
		LocalDate date;

		boolean follow = false;
		boolean validity = false;

		do {
			System.out.print("Inserire nome dell'evento: ");
			title = scan.nextLine();
			if (title == null || title.length() == 0) {
				System.out.println("L'evento deve avere un titolo");
			} else {
				validity = true;
			}
		} while (validity == false);
		validity = false;
		do {
			System.out.print("Inserire posti disponibili: ");
			totalPlaces = scan.nextInt();
			if (totalPlaces <= 0) {
				System.out.println("Ci deve essere almeno una prenotazione.");
			} else {
				validity = true;
			}
		} while (validity == false);
		validity = false;
		int day;
		do {
			System.out.print("Inserire giorno evento (DD): ");
			day = scan.nextInt();
			if (day > 31 || day <= 0) {
				System.out.println("Giorno deve essere compreso tra 1 e 31.");
			} else {
				validity = true;
			}
		} while (validity == false);
		validity = false;
		int month;
		do {
			System.out.print("Inserire mese evento (MM): ");
			month = scan.nextInt();
			if (month > 12 || month <= 0) {
				System.out.println("Mese deve essere compreso tra 1 e 12.");
			} else {
				validity = true;
			}
		} while (validity == false);
		validity = false;
		int year;
		do {
			System.out.print("Inserire anno evento (AAAA): ");
			year = scan.nextInt();
			if (year < 2021) {
				System.out.println("Anno non può essere precedente all'anno corrente.");
			} else {
				validity = true;
			}
		} while (validity == false);
		validity = false;
		date = LocalDate.of(year, month, day);

		try {

			Evento event = new Evento(title, date, totalPlaces);
			System.out.print("\nScrivere s per prenotare o n per proseguire senza prenotare: ");
			scan.nextLine();
			String choice = scan.nextLine().toLowerCase();

			do {
				if (choice.equals("s")) {
					follow = true;
					int resNum;
					do {
						System.out.print("Inserire numero prenotazioni da effettuare: ");
						resNum = scan.nextInt();
						if (resNum <= 0 || resNum > totalPlaces) {
							System.out.println("Inserire un valore compreso tra 1 e " + totalPlaces + ".");
						} else {
							validity = true;
						}

					} while (validity == false);
					validity = false;
					for (int i = 1; i <= resNum; i++) {
						event.prenota();
					}

				} else if (choice.equals("n")) {
					follow = true;
				} else {
					System.out.println("Inserire un valore valido (s/n): ");
				}

			} while (follow == false);
			follow = false;
			System.out.println("I biglietti prenotati sono: " + event.getReservedPlaces());
			System.out.println("I biglietti rimasti sono: " + (event.getTotalPlaces() - event.getReservedPlaces()));

			System.out.print("\nScrivere s per disdire o n per continuare senza disdire: ");
			scan.nextLine();
			choice = scan.nextLine();
			do {
				if (choice.equals("s")) {
					follow = true;
					int resNum;
					do {
						System.out.print("\nInserire numero prenotazioni da disdire: ");
						resNum = scan.nextInt();
						if (resNum > totalPlaces) {
							System.out.print("Le disdette non possono essere di più delle prenotazioni.");
						} else {
							validity = true;
						}
					} while (validity == false);
					for (int i = 1; i <= resNum; i++) {
						event.disdici();
					}

				} else if (choice.equals("n")) {
					follow = true;
				} else {
					System.out.println("Inserire un valore valido (s/n): ");
				}

			} while (follow == false);

			System.out.println("I biglietti prenotati sono: " + event.getReservedPlaces());
			System.out.println("I biglietti rimasti sono: " + (event.getTotalPlaces() - event.getReservedPlaces()));

		} catch (Exception e) {
			System.out.println("Il programma è terminato perché " + e.getMessage());
		}

		System.out.println("Grazie per aver prenotato!");

		scan.close();
	}

}
