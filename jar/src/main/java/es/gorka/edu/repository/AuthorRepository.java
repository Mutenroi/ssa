package es.gorka.edu.repository;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.gorka.edu.assembler.Assembler;

import es.gorka.edu.connection.AbstractConnectionManager;
import es.gorka.edu.dto.AuthorDTO;
import es.gorka.edu.dto.UserDTO;
import es.gorka.edu.model.User;
import es.gorka.edu.models.Author;


@Service
public class AuthorRepository {
	private static final Logger logger = LogManager.getLogger(AuthorRepository.class.getName());

	@Autowired
	private AbstractConnectionManager conManager;

	@Autowired
	private Assembler<AuthorDTO, Author> asesembler;

	public void insertAuthor(AuthorDTO authorDto) {

		Connection connection = null;
	PreparedStatement preparedStatement = null;

	Author author = new Author();
	asesembler.toEntity(authorDto, author);

		try {
			connection = conManager.open();
			preparedStatement = connection.prepareStatement("INSERT INTO AUTHOR(nameAuthor, dateOfBirth) " + "VALUES (?, ?)");
			preparedStatement.setString(1, author.getNameAuthor());
			preparedStatement.setDate(2, (Date) author.getDateOfBirth());
			preparedStatement.executeUpdate();
			conManager.close(preparedStatement);

		} catch (Exception e) {
			logger.error(e);
			throw new RuntimeException(e);
		}
	}

	public ArrayList<AuthorDTO> findAuthors(AuthorDTO authorDto) {
		 		ArrayList<AuthorDTO> list = new ArrayList<AuthorDTO>();
		 		Connection connection = null;
		 		PreparedStatement preparedStatement = null;
		 		ResultSet resultSet = null;

		 		try {
		 			connection = conManager.open();
		 			preparedStatement = connection.prepareStatement("SELECT * FROM AUTHOR WHERE nameAuthor LIKE ? OR dateOfBirth = ?");
		 			preparedStatement.setString(1, "%" + authorDto.getName() + "%");
		 			preparedStatement.setDate(2, authorDto.getDateOfBirth());
		 			resultSet = preparedStatement.executeQuery();
		 		while (resultSet.next()) {
		 				Author author = new Author();
		 				author.setNameAuthor(resultSet.getString(1));
		 				author.setDateOfBirth(resultSet.getDate(2));
		 				list.add(asesembler.toDto(new AuthorDTO(), author));
		 			}
		 		} catch (Exception e) {
		 			logger.error(e);
		 			throw new RuntimeException(e);
		 		}
		 		return list;
		 	}
}