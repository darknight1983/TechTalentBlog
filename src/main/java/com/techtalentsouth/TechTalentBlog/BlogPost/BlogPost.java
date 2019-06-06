package com.techtalentsouth.TechTalentBlog.BlogPost;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private String author;  
	private String blogEntry;
	
	// STATIC BLOCK: The code inside of a static block is executed only once: the first time you make an object of the 
	// class or the first time you access a static member of a class
	
	
	static {
		System.out.println("static block called");
	}
		
		
    
	// Create non argument constructor
	public BlogPost() {
		// Non-argument constructor needed for JPA
	}
	
	// Create constructor that accepts arguments
	public BlogPost(String title, String author, String blog_entry) {
		this.title = title;
		this.author = author;
		this.blogEntry = blog_entry;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBlogEntry() {
		return blogEntry;
	}

	public void setBlogEntry(String blogEntry) {
		this.blogEntry = blogEntry;
	}
	
	public long getId() {
		return id;
	}
	
	// You could add an @Override annotation here. Why would you is the question?
	public String toString() {
		// Return a string with the private properties
		return "string";
	}
	
}
