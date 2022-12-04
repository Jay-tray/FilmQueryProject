package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String user = "student";
	private static final String pass = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load database driver:");
		}
	}

	@Override
	public Film findFilmByFilmId(int filmId) {
		if (filmId <= 0) {
			return null;
		}
		Film film = null;
		String sql = "SELECT film.* FROM film WHERE film.id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();

			if (filmResult.next()) {
				film = new Film();

				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setRelYear(filmResult.getInt("release_year"));
				film.setLanId(filmResult.getInt("language_id"));
				film.setRenDur(filmResult.getDouble("rental_duration"));
				film.setRenRat(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setRepCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecFeat(filmResult.getString("special_features"));
				film.setActors(findActorsByFilmId(filmId));
				film.setLanguage(getLanguageOfFilm(filmId));
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		if (actorId <= 0) {
			return null;
		}
		Actor actor = null;
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();

			if (actorResult.next()) {
				actor = new Actor(); // Create the object
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));

			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		if (filmId <= 0) {
			return null;
		}
		List<Actor> listActor = new ArrayList<>();
		String sql = "SELECT actor.id,actor.first_name,actor.last_name FROM film JOIN film_actor ON film.id=film_actor.film_id JOIN actor ON film_actor.actor_id = actor.id WHERE film.id=?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet idResult = stmt.executeQuery();

			while (idResult.next()) {
				int id = idResult.getInt("id");
				String firstName = idResult.getString("first_name");
				String lastName = idResult.getString("last_name");

				Actor actor = new Actor(id, firstName, lastName);
				listActor.add(actor);
			}

			idResult.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listActor;
	}

	@Override
	public List<Film> findFilmByActorId(int actorId) {
		if (actorId <= 0) {
			return null;
		}
		List<Film> listOfFilms = new ArrayList<>();
		String sql = "SELECT film.title FROM actor JOIN film_actor ON actor.id=film_actor.actor_id JOIN film ON film_actor.film_id=film.id WHERE actor.id= ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String title = rs.getString("film.title");
				Film film = new Film(title);
				listOfFilms.add(film);
			}
		
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfFilms;
	}

	@Override
	public List<Film> findFilmByKeywords(String keyword) {

		List<Film> listOfFilms = new ArrayList<>();
		String sql = "SELECT * FROM film WHERE film.title LIKE ? OR film.description LIKE ? ";
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet filmResult = stmt.executeQuery();

			while (filmResult.next()) {
				film = new Film();
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setRelYear(filmResult.getInt("release_year"));
				film.setLanId(filmResult.getInt("language_id"));
				film.setRenDur(filmResult.getDouble("rental_duration"));
				film.setRenRat(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setRepCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecFeat(filmResult.getString("special_features"));
				film.setActors(findActorsByFilmId(film.getId()));
				film.setLanguage(getLanguageOfFilm(film.getId()));

				listOfFilms.add(film);
			}

			filmResult.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfFilms;
	}

	public String getLanguageOfFilm(int filmId) {
		if (filmId <= 0) {
			return null;
		}
		String sql = "SELECT language.name FROM film JOIN language ON film.language_id=language.id WHERE film.id = ?";
		String language = "";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				language = rs.getString("language.name");
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return language;
	}
}
