package es.gorka.edu.models;
import java.util.List;
import java.io.Serializable;
import java.sql.Date;

public class Author implements Serializable{

	private String nameAuthor;
	private Date dateOfBirth;


	public String getNameAuthor() {
		return nameAuthor;
	}
	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
