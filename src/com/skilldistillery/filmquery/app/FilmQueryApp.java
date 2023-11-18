package com.skilldistillery.filmquery.app;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.skilldistillery.filmquery.database.*;
import com.skilldistillery.filmquery.entities.*;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		try {
//			app.test();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		app.launch();
	}

//	private void test() throws SQLException {
//		List<Film> film = db.findFilmsByKeyword("worst");
//		System.out.println(film);
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int userInput;
		boolean stop = true;
		while (stop) {
			try {
				menu();
				userInput = input.nextInt();
				input.nextLine();
				switch (userInput) {
				case 1:
					System.out.print("Please enter the ID you want to look up: ");
					userInput = input.nextInt();
					try {
						Film film = db.findFilmById(userInput);
						if (film == null) {
							System.out.println("\nThere is nothing with that ID please try again.\n");
						} else {
							System.out.println(film);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					String userKeyword;
					System.out.print("Please enter the KEYWORD you want to look up: ");
					userKeyword = input.nextLine();
					List<Film> film = db.findFilmsByKeyword(userKeyword);
					if (film.isEmpty()) {
						System.out.println(
								"\nThere is nothing with the keyword: " + userKeyword + " please try again.\n");
					} else {
						System.out.println(film);
					}
					break;
				case 3:
					System.out.println("Goodbye!");
					stop = false;
					input.close();
					System.exit(0);
				default:
					System.out.println("Invalid Input\n");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input\n");
				launch();
			}
		}

	}

	private void menu() {
		System.out.println("Please select from the following");
		System.out.println("////////////////////////////////");
		System.out.println("////////////////////////////////");
		System.out.println("/// 1. Search by Film ID     ///");
		System.out.println("/// 2. Search by Keyword     ///");
		System.out.println("/// 3. Exit Program          ///");
		System.out.println("////////////////////////////////");
		System.out.println("////////////////////////////////");
	}

}
