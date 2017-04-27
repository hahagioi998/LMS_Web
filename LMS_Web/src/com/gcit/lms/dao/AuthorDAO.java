package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.gcit.lms.entity.Author;

public class AuthorDAO extends BaseDAO {
	public AuthorDAO(Connection conn) {
		super(conn);
	}

	public void addAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("insert into tbl_author (authorName) values (?)", new Object[] {author.getAuthorName()});
	}
}
