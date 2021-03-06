package es.gorka.edu.service;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.gorka.edu.dto.AuthorDTO;
import es.gorka.edu.dto.UserDTO;
import es.gorka.edu.models.Author;
import es.gorka.edu.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository repository;

	public boolean insertAuthor(AuthorDTO authorDto) {
		repository.insertAuthor(authorDto);
		return true;
	}

	public ArrayList<AuthorDTO> findAuthors(AuthorDTO authorDto) {
		 		return repository.findAuthors(authorDto);
		 	}

}