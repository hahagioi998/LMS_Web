
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.entity.Branch"%>
<%@page import="com.gcit.lms.entity.Book"%>
<%@page import="com.gcit.lms.service.LibrarianService"%>


<%
	LibrarianService service = new LibrarianService();
	List<Branch> branches = service.getAllBranches();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LMS</title>
</head>
<body>
	<h1>Welcome to GCIT Library Management System.</h1>
	<h2>Hello, Librarian!</h2>
	<h3>List of Authors in LMS</h3>
	<table>
		<tr>
			<th>Branch ID</th>
			<th>Branch Name</th>
			<th>Branch Address</th>
		</tr>
		<%
			for (Branch br : branches) {
		%>
		<tr>
			<td>
				<%
					out.println(br.getBranchId());
				%>
			</td>
			<td>
				<%
					out.println(br.getBranchName());
				%>
			</td>
			<td>
				<%
					out.println(br.getBranchAddress());
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>