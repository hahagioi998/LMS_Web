package com.gcit.lms.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import com.gcit.lms.entity.Branch;
import com.gcit.lms.service.LibrarianService;

/**
 * Servlet implementation class LibrarianServlet
 */
@WebServlet("/librarianServlet")
public class LibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LibrarianServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost(): Adding new branch..");

		Branch branch = new Branch();
		branch.setBranchName(request.getParameter("branchName"));
		branch.setBranchAddress(request.getParameter("branchAddress"));
		LibrarianService service = new LibrarianService();

		try {
			service.addBranch(branch);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("/viewbranches.jsp");
		rd.forward(request, response);
	}

}
