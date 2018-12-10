package components;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import actor.Actor;

public class Article {
	private String domain;
	private String subdomain;
	private String title;
	private String author;
	private Date dateCreated;
	private Date dateModified;
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private int views = 0;
	
	public Article (String title, String domain, String subdomain, String author) {
		this.domain = domain;
		this.subdomain = subdomain;
		this.title = title;
		this.author = author;
		this.dateCreated = new Date();
		this.dateModified = new Date();
	}
	
	public void readArticle(){
		this.views += 1;
	}

	public String getTitle () {
		return this.title;
	}
	
	public int getViews () {
		return this.views;
	}
	
	public boolean compareInterests(Filter f){
		
		if (f.getAuthors().contains(this.author)) {
			return true;
		}
		
		if (f.getDomains().contains(this.domain)) {
			return true;
		}
		
		if (f.getSubdomains().contains(this.domain)) {
			return true;
		}
		
		return false;
	}
}
