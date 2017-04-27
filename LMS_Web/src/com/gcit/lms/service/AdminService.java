package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.entity.Author;

public class AdminService {

	/**
	 * Add given passed by
	 * 
	 * @param author
	 * @throws ClassNotFoundException
	 */
	public void addAuthor(Author author) throws SQLException, ClassNotFoundException {
		Connection conn = null;

		conn = ConnectionUtil.getConnection();
		AuthorDAO auDAO = new AuthorDAO(conn);
		auDAO.addAuthor(author);
		conn.commit();
	}

	/**
	 * 
	 * @return List of all authors stored in library database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Author> getAllAtuhors() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		conn = ConnectionUtil.getConnection();
		AuthorDAO auDAO = new AuthorDAO(conn);

		return (List<Author>) auDAO.readAllAuthors();
	}
}
