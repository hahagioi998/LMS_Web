package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;

public class BookDAO extends BaseDAO {
	public BookDAO(Connection conn) {
		super(conn);
	}

	@SuppressWarnings("unchecked")
	public List<Book> readAllBooks() throws SQLException {
		return (List<Book>) read("select * from tbl_book", null);
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksAtBranch(Integer branchId) throws SQLException {
		return (List<Book>) read(
				"select * from tbl_book where bookid IN (Select bookid from tbl_book_copies where branchId = ?)",
				new Object[] { branchId });
	}

	public Integer getNumOfCopiesAtBranch(Integer branchId, Integer bookId) throws SQLException {

		String query = "select * from tbl_book_copies where branchId = ? AND bookid = ?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, branchId);
		pstmt.setInt(2, bookId);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			return rs.getInt("noOfCopies");

		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> extractData(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<>();
		AuthorDAO auDAO = new AuthorDAO(conn);
		while (rs.next()) {
			Book b = new Book();
			b.setTitle(rs.getString("title"));
			b.setBookId(rs.getInt("bookId"));
			b.setAuthors((List<Author>) auDAO.readFirstLevel(
					"select * from tbl_author where authorId IN (Select authorId from tbl_book_authors where bookId = ?)",
					new Object[] { b.getBookId() }));
			books.add(b);
		}
		return books;
	}

	@Override
	public List<Book> extractDataFirstLevel(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<>();
		while (rs.next()) {
			Book b = new Book();
			b.setTitle(rs.getString("title"));
			b.setBookId(rs.getInt("bookId"));
			books.add(b);
		}
		return books;
	}

}
