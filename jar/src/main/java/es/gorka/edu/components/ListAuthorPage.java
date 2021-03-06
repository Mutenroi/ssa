package es.gorka.edu.components;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import es.gorka.edu.dto.AuthorDTO;
import es.gorka.edu.service.AuthorService;

public class ListAuthorPage {
	private static final long serialVersionUID = 1L;

	 	@SpringBean
	 	AuthorService authorService;

	 	@SpringBean
	 	AuthorDTO authorDto;

	 	private static final Logger logger = LogManager.getLogger(ListAuthorPage.class.getName());

	 	private String authorName = null;

	 	private List<AuthorDTO> listAuthor = Collections.emptyList();

	 	public ListAuthorPage(PageParameters parameters) {
	 		authorName = parameters.get("authorName").toString();
	 		logger.debug("Cargando la pagina con el parametro Autor: " + authorName);
	 		initComponents();
	 	}

	 	public ListAuthorPage() {
	 		initComponents();
	 	}

	 	private void initComponents() {
	 		add(new Label("title", "Listar Autores"));
	 		addForm();
	 		addFeedBackPanel();
	 		addListAuthorView();
	 		add(new BookmarkablePageLink<String>("libraryLink", LibraryHomePage.class));
	 	}

	 	private void addForm() {
	 		Form<AuthorDTO> form = new Form<AuthorDTO>("formListAuthor", new CompoundPropertyModel<AuthorDTO>(authorDto)){

	 			private static final long serialVersionUID = 1L;
	 			@Override
	 			protected void onSubmit() {
	 				super.onSubmit();
	 				listAuthor.clear();
	 				PageParameters pageParameters = new PageParameters();
	 			pageParameters.add("authorName", getModelObject().getName());
	 				setResponsePage(ListAuthorPage.class, pageParameters);
	 			}
	 		};
	 		form.add(new TextField<String>("nameAuthor"));
	 		DateTextField  datetimePicker = new DateTextField ("dateOfBirth", "yyyy-MM-dd");
	 	form.add(datetimePicker);
	 		add(form);
	 	}

	 	private void addFeedBackPanel() {
	 		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
	 		add(feedbackPanel);
	 	}

	 	private void addListAuthorView() {
	 		AuthorDTO author = new AuthorDTO();
	 		author.setName(authorName);
	 		listAuthor = authorService.findAuthors(author);
	 		ListView<AuthorDTO> listview = new ListView<AuthorDTO>("author-group", listAuthor) {

	 			private static final long serialVersionUID = 1L;

	 			@Override
	 			protected void populateItem(ListItem<AuthorDTO> item) {
	 				AuthorDTO author = item.getModelObject();
	 				item.add(new Label("authorName", author.getName()));
	 				item.add(new Label("dateOfBirth", author.getDateOfBirth()));
	 			}
	 		};
	 		add(listview);
	 	}
}
