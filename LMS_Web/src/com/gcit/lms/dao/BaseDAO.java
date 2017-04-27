package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDAO {
	public static Connection conn = null;

	public BaseDAO(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Prepare statement based on @param query and @param vals, then execute the
	 * update.
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
}
