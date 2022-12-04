package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
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
				chooseByKeyword(input);
				break;
			case 3:
				System.out.println("Goodbye");
				runMenu = false;
				break;

			}
		}

	}


	private void mainMenu() {
		System.out.println("Welcome to the Film Query");
		System.out.println("Choose from the following list of options!");
		System.out.println("1) Look up film by FILM ID");
		System.out.println("2) Look up film by KEYWORD");
		System.out.println("3) Quit");
	}

	private void filmId(Scanner input) {
		System.out.println("Enter film ID:");
		try {
			int filmID = input.nextInt();
			Film film = db.findFilmByFilmId(filmID);
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

	private void chooseByKeyword(Scanner input) {
		System.out.println("Enter keyword:");
		try {
			String keyword = input.next();
			List<Film> filmList = db.findFilmByKeywords(keyword);
			if (filmList.size() > 0) {
				for (Film film : filmList) {
					System.out.println(film);
				}
			} else {
				System.out.println("Matching film does not exist.");
			}
		} catch (Exception e) {
			System.err.println("Invalid input");
			input.next();
			startUserInterface(input);
		}

	}
}
