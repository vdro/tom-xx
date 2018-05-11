
package domain.service;

import java.util.ArrayList;
import java.util.List;

import domain.Actor;
import domain.Film;

public class FilmService {
	
	
	private static ArrayList<Film> db = new ArrayList<Film>();
	
	private static int currentFilmId = 1;

	private static int currentActorId = 1;
	

	public List<Film> getAll() {
		return this.db;
	}
	

	public Film getFilm(int id) {
		for(Film f : db) {
			if(f.getId()==id) return f;
		}
		return null;
	}
	

	public void addFilm(Film film) {
		film.setId(currentFilmId);
		db.add(film);
		++currentFilmId;
	}
	
	
	public void updateFilm(Film film) {
		for(Film f : db) {
			if(f.getId()==film.getId()) {
				if( ! film.getTitle().equals("")) f.setTitle(film.getTitle());
				if(film.getYear() != 0) f.setYear(film.getYear());
				
				if( ! film.getActor().isEmpty()) {
					for(Actor a : film.getActor()) {
						f.addActor(a);
					}
				}
				
				if( ! film.getComment().isEmpty()) {
				for(String s : film.getComment()) {
					f.addComment(s);
				}
				}
				
				if( ! film.getRating().isEmpty()) {
				for (int r : film.getRating()) {
					f.addRating(r);
				}
				}
			}
		}
	}
	

	public List<String> getComment(int id) {
		return db.get(id).getComment();
	}
	
	
	public void addComment(String title, String comment) {
		for (Film film : db) {
			if(film.getTitle().equalsIgnoreCase(title))   film.addComment(comment);
		}
	}
	

	public void deleteComment(String title, String comment) {
		for (Film film : db) {
			if(film.getTitle().equalsIgnoreCase(title)) {
				for(String s : film.getComment()) {
					if(s.equalsIgnoreCase(comment)) {
						film.getComment().remove(comment);
					}
				}
			}
		}
	}
	

	public void setRating(String title, int rating) throws IllegalArgumentException{
		if (rating >= 0 && rating <= 10) {
			for (Film film : db) {
				if(film.getTitle().equalsIgnoreCase(title)) film.addRating(rating);
			}
		} else throw new IllegalArgumentException("Ocena filmu musi byc w skali od 0 do 10");
	}
	

	public float getAverageRating(String title) {
		float average = 0;
		int ratingCount = 0;
		for (Film film : db) {
			if(film.getTitle().equalsIgnoreCase(title)) {
				ratingCount = film.getRating().size();
				for(Integer rating : film.getRating()) {
					average += rating;
				}
			}
		}
		return average /= ratingCount;
	}
	

	public void addActor(String title, Actor actor) {
		for(Film film : db) {
			if(film.getTitle().equalsIgnoreCase(title)) {
				for(Actor a : film.getActor()) {
					a.setId(currentActorId);
					film.getActor().add(actor);
					++currentActorId;
				}
			}
		}
	}
	

	public void addFilmToActor(String filmTitle, String actorName) {
		for(Film film : db) {
			if(film.getTitle().equalsIgnoreCase(filmTitle)) {
				for(Actor actor : film.getActor()) {
					if(actor.getName().equalsIgnoreCase(actorName)) {
						actor.addFilm(film);
					}
				}
			}
		}
	}
	

	public List<Actor> getAllActorForFilm(String filmTitle) {
		for (Film film : db) {
			if(film.getTitle().equalsIgnoreCase(filmTitle)) {
				return film.getActor();
			}
		}
		return null;
	}
	

	public List<Film> getAllFilmForActor(String actorSurname) {
		List<Film> result = new ArrayList<Film>();
		for (Film film : db) {
			for(Actor actor : film.getActor()) {
				if(actor.getName().equalsIgnoreCase(actorSurname)) {
					result.add(film);
				}
			}
		}
		return result;
	}
	
}
