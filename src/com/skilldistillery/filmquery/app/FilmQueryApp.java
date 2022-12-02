package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	/*
	 * private void test() throws SQLException { Film film = db.findFilmById(1);
	 * System.out.println(film); }
	 */

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean runMenu = true;
		while (runMenu) {
			mainMenu();
			int userInput = input.nextInt();
			switch (userInput) {
			case 1:
				filmId(input);
				break;
			case 2:
				actorId(input);
				break;
			case 3:
				actorByFilm(input);

			}
		}

	}

	private void actorByFilm(Scanner input) {
		System.out.println("Enter film ID for desired actor:");
		try {
			int id = input.nextInt();
			List<Actor> actor = db.findActorsByFilmId(id);
			if (actor != null) {
				System.out.println(actor);
			} else {
				System.out.println("There is an error with the ID");
			}
		} catch (Exception e) {
			System.err.println("Invalid input");
			input.next();
			startUserInterface(input);
		}

	}

	private void actorId(Scanner input) {
		System.out.println("Enter actor ID:");
		try {
			int actorID = input.nextInt();
			Actor actor = db.findActorById(actorID);
			if (actor != null) {
				System.out.println(actor);
			} else {
				System.out.println("Actor ID does not exist.");
			}
		} catch (Exception e) {
			System.err.println("Invalid input");
			input.next();
			startUserInterface(input);
		}

	}

	private void filmId(Scanner input) {
		System.out.println("Enter film ID:");
		try {
			int filmID = input.nextInt();
			Film film = db.findFilmById(filmID);
			if (film != null) {
				System.out.println(film);
			} else {
				System.out.println("Film ID does not exist.");
			}
		} catch (Exception e) {
			System.err.println("Invalid input");
			input.next();
			startUserInterface(input);
		}

	}

	private void mainMenu() {
		System.out.println("Welcome to the Film Query");
		System.out.println("Choose from the following list of options!");
		System.out.println("1) Look up film by FILM ID");
		System.out.println("2) Look up actor by ACTOR ID");
		System.out.println("3) Look up actor by FILM ID");
	}
}
