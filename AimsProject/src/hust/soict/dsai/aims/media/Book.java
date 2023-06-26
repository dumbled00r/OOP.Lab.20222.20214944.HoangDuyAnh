package hust.soict.dsai.aims.media;
import java.io.IOException;
import java.util.*;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public Book(String title, String category, float cost) throws IOException {
		// TODO Auto-generated constructor stub
		super(title, category, cost);
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
		// Check if the author already exists in the list
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
		// Check if the author already exists in the list
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println(authorName + " has been removed from the list");
		}
		else {
			System.out.println(authorName + " does not exist in the list");
		}
	}
	
	// Print out book infos
	@Override
	public String toString() {
		return "Book - " + this.getTitle() + " - " + this.getCategory() + ": "+ this.getCost() + "$";
	}
}