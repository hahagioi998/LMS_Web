package com.gcit.lms.entity;

import java.util.HashMap;

public class Branch {
	private Integer branchId;
	private String branchName;
	private String branchAddress;
	private HashMap<Book, Integer> branchBookCopies;

	/**
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId
	 *            the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName
	 *            the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the branchAddress
	 */
	public String getBranchAddress() {
		return branchAddress;
	}

	/**
	 * @param branchAddress
	 *            the branchAddress to set
	 */
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	/**
	 * @return the bookCopies
	 */
	public HashMap<Book, Integer> getBranchBookCopies() {
		if (this.branchBookCopies == null) {
			branchBookCopies = new HashMap<Book, Integer>();
			return branchBookCopies;
		}
		return branchBookCopies;
	}

	/**
	 * @param bookCopies
	 *            the bookCopies to set
	 */
	public void setBranchBookCopies(HashMap<Book, Integer> bookCopies) {
		this.branchBookCopies = bookCopies;
	}

	/**
	 * 
	 * @param bk
	 * @param copies
	 */
	public void addBranchBookCopies(Book bk, Integer copies) {
		this.getBranchBookCopies().put(bk, copies);
	}

	/**
	 * 
	 * @param bk
	 * @param copies
	 */
	public void updateBranchBookCopies(Book bk, Integer copies) {
		this.getBranchBookCopies().put(bk, copies);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchAddress == null) ? 0 : branchAddress.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		if (branchAddress == null) {
			if (other.branchAddress != null)
				return false;
		} else if (!branchAddress.equals(other.branchAddress))
			return false;
		if (branchId == null) {
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		return true;
	}

}
