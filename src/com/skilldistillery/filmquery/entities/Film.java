package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private int relYear;
	private int lanId;
	private int renDur;
	private int renRat;
	private int length;
	private int repCost;
	private int rating;
	private int specFeat;
	private List<Actor> actors;

	public Film() {
	}

	public Film(int id, String title, String description, int relYear, int lanId, int renDur, int renRat, int length,
			int repCost, int rating, int specFeat) {
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
	}

	public Film(int id, String title, String description, int relYear, int lanId, int renDur, int renRat, int length,
			int repCost, int rating, int specFeat, List<Actor> actors) {
		this(id, title, description, relYear, lanId, renDur, renRat, length, repCost, rating, specFeat);
		this.actors = actors;
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

	public int getRenDur() {
		return renDur;
	}

	public void setRenDur(int renDur) {
		this.renDur = renDur;
	}

	public int getRenRat() {
		return renRat;
	}

	public void setRenRat(int renRat) {
		this.renRat = renRat;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getRepCost() {
		return repCost;
	}

	public void setRepCost(int repCost) {
		this.repCost = repCost;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getSpecFeat() {
		return specFeat;
	}

	public void setSpecFeat(int specFeat) {
		this.specFeat = specFeat;
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