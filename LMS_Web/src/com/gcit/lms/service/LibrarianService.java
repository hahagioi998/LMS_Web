package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.entity.Branch;

public class LibrarianService {

	/**
	 * Add given branch passed by
	 * 
	 * @param branch
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void addBranch(Branch branch) throws SQLException {
		Connection conn = null;

		try {
			conn = ConnectionUtil.getConnection();
			BranchDAO brDAO = new BranchDAO(conn);
			brDAO.addBranch(branch);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null)
				conn.close();
		}

	}


}
