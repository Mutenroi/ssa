package es.gorka.edu.components;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import es.gorka.edu.models.Book;
import es.gorka.edu.dto.BookDTO;

public class BookPage extends WebPage{
	public BookPage() {
		add(new Label("title", getString("title")));
		Form form = new Form("addingNewBook", new CompoundPropertyModel(new Book())){};
		form.add(new Label("nameBookLabel", getString("book.name")));
		form.add(new Label("ISBNLabel", getString("ISBN")));
		form.add(new Label("nameAuthorLabel", getString("author.name")));

		form.add(new RequiredTextField("nameBook"));
		form.add(new RequiredTextField("ISBN"));
		form.add(new RequiredTextField("nameAuthor"));

		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
	 	feedbackPanel.setOutputMarkupId(true);
	 	add(feedbackPanel);

	 	add(form);
	}
}
