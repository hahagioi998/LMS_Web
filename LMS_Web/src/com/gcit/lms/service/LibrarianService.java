package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

	/**
	 * 
	 * @return List of all branches in library dataabse
	 * @throws SQLException
	 */
	public List<Branch> getAllBranches() throws SQLException {
		Connection conn = null;

		try {
			conn = ConnectionUtil.getConnection();
			BranchDAO brDAO = new BranchDAO(conn);
			return (List<Branch>) brDAO.readAllBranches();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}

		return null;
	}

}
