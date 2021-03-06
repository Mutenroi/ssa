package es.gorka.edu.components;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class LibraryHomePage extends WebPage{

	public LibraryHomePage() {
		add(new Label("title", "Library"));
		add(new BookmarkablePageLink<String>("authorLink", AuthorPage.class));
		add(new BookmarkablePageLink<String>("authorListLink", AuthorPage.class));
		add(new BookmarkablePageLink<String>("bookLink", BookPage.class));
 	}

 }