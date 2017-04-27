
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.entity.Author"%>
<%@page import="com.gcit.lms.service.AdminService"%>


<%
	AdminService service = new AdminService();
	List<Author> authors = service.getAllAtuhors();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LMS</title>
</head>
<body>
	<h1>Welcome to GCIT Library Management System.</h1>
	<h2>Hello, Admin!</h2>
	<h3>List of Authors in LMS</h3>
	<table>
		<tr>
			<th>Author ID</th>
			<th>Author Name</th>
		</tr>
		<%
			for (Author a : authors) {
		%>
		<tr>
			<td>
				<%
					out.println(a.getAuthorId());
				%>
			</td>
			<td><%=a.getAuthorName()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>