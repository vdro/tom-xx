
package domain;

import java.util.ArrayList;
import java.util.List;


public class Film {
	
	private int id = 0;
	private String title = "";
	private int year = 0;
	private List<Actor> actor = new ArrayList<Actor>();
	private List<String> comment = new ArrayList<String>();
	private List<Integer> rating = new ArrayList<Integer>();
	

	private static int count = 0;
	
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<Actor> getActor() {
		return actor;
	}
	public void addActor(Actor actor) {
		this.actor.add(actor);
	}
	
	public List<String> getComment() {
		return comment;
	}
	public void addComment(String comment) {
		this.comment.add(comment);
	}
	
	public List<Integer> getRating() {
		return rating;
	}
	public void addRating(int rating) {
		this.rating.add(rating);
	}

		
}
