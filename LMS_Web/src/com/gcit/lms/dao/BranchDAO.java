package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.entity.Branch;

public class BranchDAO extends BaseDAO {
	public BranchDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<?> extractData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> extractDataFirstLevel(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBranch(Branch branch) throws ClassNotFoundException, SQLException {
		save("insert into tbl_library_branch (branchName, branchAddress) values (?, ?)",
				new Object[] { branch.getBranchName(), branch.getBranchAddress() });
	}

}
