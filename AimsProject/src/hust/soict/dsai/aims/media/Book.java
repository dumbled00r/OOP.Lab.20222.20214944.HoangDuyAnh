package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();

	public Book() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the authors
	 */
	public List<String> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	
	
	// Adding an author to the list of authors
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println(authorName + " is already in the list");
		}
		else {
			authors.add(authorName);
			System.out.println(authorName + " has been added to the list");
		}
	}
	
	
	
	// Remove an author from the list of authors
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println(authorName + " has been removed from the list");
		}
		else {
			System.out.println(authorName + " does not exist in the list");
		}
	}
	
}
