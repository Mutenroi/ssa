package es.gorka.edu.components;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

/**
 * sample homepage
 *
 * @author Stefan Kloe
 *
 */
public class MainPage extends BaseAuthWebPage {

	public MainPage() {
		add(new Label("title", "Listado de errores incluidos"));
		add(new Link<String>("homeLink", Model.of(getString("linkLabelCloseSession"))) {
			@Override
			public void onClick() {
				AuthenticatedWebSession.get().invalidate();
				setResponsePage(HomePage.class);
			}
		});
		add(new BookmarkablePageLink<String>("boardLink1", BoardPage.class));
		add(new BookmarkablePageLink<String>("boardLink2", BoardPage.class));
		add(new BookmarkablePageLink<String>("boardLink3", BoardPage.class));
		add(new BookmarkablePageLink<String>("ListUsersLink", ListUsersPage.class));
	}

}
