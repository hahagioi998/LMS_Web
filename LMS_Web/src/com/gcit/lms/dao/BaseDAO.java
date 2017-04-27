package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO {
	public Connection conn = null;

	public BaseDAO(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Prepare a general saving statement based on
	 * 
	 * @param query
	 *            and
	 * @param vals,
	 *            then execute the update.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void save(String query, Object[] vals) throws ClassNotFoundException, SQLException {

		PreparedStatement pstmt = conn.prepareStatement(query);
		if (vals != null) {
			int count = 1;
			for (Object obj : vals) {
				pstmt.setObject(count, obj);
				count++;
			}
		}
		pstmt.executeUpdate();
	}

	/**
	 * Prepare a general reading statement based on
	 * 
	 * @param query
	 *            and
	 * @param vals,
	 *            then execute the update.
	 * @return
	 * @throws SQLException
	 */
	public List<?> read(String query, Object[] vals) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(query);
		if (vals != null) {
			int count = 1;
			for (Object obj : vals) {
				pstmt.setObject(count, obj);
				count++;
			}
		}

		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}

	public abstract List<?> extractData(ResultSet rs) throws SQLException;
}
