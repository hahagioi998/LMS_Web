package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.gcit.lms.entity.Book;

public class BookDAO extends BaseDAO {
	public BookDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Book> extractData(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}
}
