package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	// costanti
	private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// attributi
	private String title;
	private LocalDate date;
	private int totalPlaces;
	private int reservedPlaces;

	// costruttore
	public Evento(String title, LocalDate date, int totalPlaces) throws Exception {
		this.title = title;
		this.reservedPlaces = 0;
		if (isValidDate(date)) {
			this.date = date;
		} else {
			throw new Exception("la data dell'evento è passata.");
		}
		if (isValidTotalPlaces(totalPlaces)) {
			this.totalPlaces = totalPlaces;
		} else {
			throw new Exception("i posti disponibili devono essere più di 0.");
		}

	}

	// getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTotalPlaces() {
		return totalPlaces;
	}

	public int getReservedPlaces() {
		return reservedPlaces;
	}

	// controlli validità
	private boolean isValidTotalPlaces(int totalPlaces) {
		return totalPlaces > 0;
	}

	private boolean isValidDate(LocalDate date) {
		return date.isAfter(LocalDate.now());
	}

	// metodi

	public void prenota() throws Exception {
		if (reservedPlaces > totalPlaces) {
			throw new Exception("l'evento è sold-out.");
		} else if (!isValidDate(date)) {
			throw new Exception("la data dell'evento è passata.");
		} else {
			reservedPlaces++;
		}
	}

	public void disdici() throws Exception {
		if (reservedPlaces == 0) {
			throw new Exception("non ci sono prenotazioni o prenotazioni sono meno delle richieste di disdetta.");
		} else if (!isValidDate(date)) {
			throw new Exception("la data dell'evento è passata.");
		} else {
			reservedPlaces--;
		}
	}

	@Override
	public String toString() {
		String formattedDate;
		formattedDate = this.date.format(FORMATTER);
		return formattedDate + " - " + title;
	}

}
