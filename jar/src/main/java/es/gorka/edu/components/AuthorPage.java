package es.gorka.edu.components;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import es.gorka.edu.service.AuthorService;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import es.gorka.edu.models.Author;
import es.gorka.edu.dto.AuthorDTO;


public class AuthorPage extends WebPage{

	@SpringBean
	AuthorService authorService;

	@SpringBean
	AuthorDTO authorDto;

	public AuthorPage(){
		add(new Label("title", getString("title")));
		Form<AuthorDTO> formAuthor = new Form<AuthorDTO>("formAddNewAuthor", new CompoundPropertyModel<AuthorDTO>(authorDto)){

			private static final long serialVersionUID = 1L;
			  			@Override
			  			protected void onSubmit() {
			  				super.onSubmit();
			 				boolean isInserted = authorService.insertAuthor(getModelObject());
			  				FeedbackMessage message;
			  				if(isInserted){
			  					message = new FeedbackMessage(this, "AUTHOR INSERTED", FeedbackMessage.INFO);
			  				} else {
			 					message = new FeedbackMessage(this, "CAN NOT INSERT", FeedbackMessage.INFO);
			 				}
			  				getFeedbackMessages().add(message);
			  			}
		};

		formAuthor.add(new Label("nameAuthorLabel", getString("author.name")));
		formAuthor.add(new Label("dateOfBirthLabel", getString("date.of.birth")));
		formAuthor.add(new RequiredTextField<String>("nameAuthor"));

		DateTextField datetimePicker = new DateTextField("dateOfBirth", "yyyy-MM-dd");
		formAuthor.add(datetimePicker);

		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		add(formAuthor);
		add(new BookmarkablePageLink<String>("libraryLink", LibraryHomePage.class));
	}
}
