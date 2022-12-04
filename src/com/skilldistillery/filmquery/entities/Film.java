package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private int relYear;
	private int lanId;
	private double renDur;
	private double renRat;
	private int length;
	private double repCost;
	private String rating;
	private String specFeat;
	private String language;
	private List<Actor> actors;

	public Film(int id, String title, String description, int relYear, int lanId, double renDur, double renRat,
			int length, double repCost, String rating, String specFeat, String language, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.relYear = relYear;
		this.lanId = lanId;
		this.renDur = renDur;
		this.renRat = renRat;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.specFeat = specFeat;
		this.language = language;
		this.actors = actors;
	}
	public Film() {
		super();
	}

	public Film(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRelYear() {
		return relYear;
	}

	public void setRelYear(int relYear) {
		this.relYear = relYear;
	}

	public int getLanId() {
		return lanId;
	}

	public void setLanId(int lanId) {
		this.lanId = lanId;
	}

	public double getRenDur() {
		return renDur;
	}

	public void setRenDur(double renDur) {
		this.renDur = renDur;
	}

	public double getRenRat() {
		return renRat;
	}

	public void setRenRat(double renRat) {
		this.renRat = renRat;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getRepCost() {
		return repCost;
	}

	public void setRepCost(double repCost) {
		this.repCost = repCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecFeat() {
		return specFeat;
	}

	public void setSpecFeat(String specFeat) {
		this.specFeat = specFeat;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Title of Film = " + title + "\nDescription of Film = " + description + "\nYear Released = " + relYear
				+  "\nRating = " + rating + "\nLanguage = " + language + "\nActors = "	+ actors;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, lanId, length, rating, relYear, renDur, renRat, repCost, specFeat, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && id == other.id && lanId == other.lanId
				&& length == other.length && rating == other.rating && relYear == other.relYear
				&& renDur == other.renDur && renRat == other.renRat && repCost == other.repCost
				&& specFeat == other.specFeat && Objects.equals(title, other.title);
	}

}