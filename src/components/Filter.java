package components;

import java.util.HashSet;

public class Filter {
	private HashSet<String> authors;
	private HashSet<String> domains;
	private HashSet<String> subdomains;
	
	public Filter () {
		this.authors = new HashSet<>();
		this.domains = new HashSet<>();
		this.subdomains = new HashSet<>();
	}
	
	public void addFilter(String filter) {
		int c = filter.indexOf(':');
		switch (filter.substring(0,c)) {
			case "Author": authors.add(filter.substring(c+2));
			case "Domain": domains.add(filter.substring(c+2));
			case "Subdomain": subdomains.add(filter.substring(c+2));
		}
	}
	
	public HashSet<String> getAuthors() {
		return this.authors;
	}
	
	public HashSet<String> getDomains() {
		return this.domains;
	}

	public HashSet<String> getSubdomains() {
		return this.subdomains;
	}
}
