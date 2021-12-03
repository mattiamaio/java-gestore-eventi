package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean follow = false;
		boolean error = false;
		String choice;
		

		System.out.print("Inserire nome dell'evento: ");
		String title = scan.nextLine();
		System.out.print("Inserire posti disponibili: ");
		int totalPlaces = scan.nextInt();
		System.out.print("Inserire giorno evento (DD): ");
		int day = scan.nextInt();
		System.out.print("Inserire mese evento (MM): ");
		int month = scan.nextInt();
		System.out.print("Inserire anno evento (AAAA): ");
		int year = scan.nextInt();
		LocalDate date = LocalDate.of(year, month, day);

		try {
			do {
				Evento event = new Evento(title, date, totalPlaces);
				//System.out.println(event.toString());
				System.out.print("\nScrivere s per prenotare o n per proseguire senza prenotare: ");
				choice = scan.nextLine().toLowerCase();
				if(choice.equals("s")) {
					follow = true;
					System.out.println("inserire numero prenotazioni da effettuare: ");
					int resNum = scan.nextInt();
					for(int i = 1; i <= resNum; i++) {
						event.prenota();
					}
					System.out.println(event.getReservedPlaces());
					System.out.println(event.getTotalPlaces());
					
				} else if(choice.equals("n")) {
					System.out.println("Grazie ed arrivederci.");
				} else {
					System.out.println("Inserire un valore valido (s/n): ");
				}
				
				
				

				


			} while (follow == false);

		} catch (Exception e) {
			System.out.println("Il programma è terminato perché: " + e.getMessage());
		}

		scan.close();
	}

}
