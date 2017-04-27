package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;

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
		AuthorDAO aDAO = new AuthorDAO(conn);
		aDAO.addAuthor(author);
		conn.commit();
	}
}
