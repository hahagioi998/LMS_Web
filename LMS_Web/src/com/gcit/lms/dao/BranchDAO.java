package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Branch;

public class BranchDAO extends BaseDAO {
	public BranchDAO(Connection conn) {
		super(conn);
	}

	public void addBranch(Branch branch) throws ClassNotFoundException, SQLException {
		save("insert into tbl_library_branch (branchName, branchAddress) values (?, ?)",
				new Object[] { branch.getBranchName(), branch.getBranchAddress() });
	}
	

	@SuppressWarnings("unchecked")
	public List<Branch> readAllBranches() throws SQLException {
		return (List<Branch>) read("select * from tbl_library_branch", null);
	}

	@Override
	public List<Branch> extractData(ResultSet rs) throws SQLException {
		List<Branch> branches = new ArrayList<>();
		while (rs.next()) {
			Branch br = new Branch();
			br.setBranchId(rs.getInt("branchId"));
			br.setBranchName(rs.getString("branchName"));
			br.setBranchAddress(rs.getString("branchAddress"));
			branches.add(br);
		}
		return branches;
	}

	@Override
	public List<Branch> extractDataFirstLevel(ResultSet rs) throws SQLException {
		return null;
	}

}