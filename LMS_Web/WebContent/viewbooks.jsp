
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.entity.Author"%>
<%@page import="com.gcit.lms.entity.Book"%>
<%@page import="com.gcit.lms.service.AdminService"%>


<%
	AdminService service = new AdminService();
	List<Book> books = service.getAllBooks();
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
	<h3>List of Books in LMS</h3>
	<table>
		<tr>
			<th>Book ID</th>
			<th>Book Title</th>
			<th>Author(s)</th>
		</tr>
		<%
			for (Book bk : books) {
		%>
		<tr>
			<td>
				<%
					out.println(bk.getBookId());
				%>
			</td>
			<td>
				<%
					out.println(bk.getTitle());
				%>
			</td>
			<td>
				<%
					List<Author> authors = bk.getAuthors();
						if (authors != null) {
							for (Author au : authors) {
								out.print("\t" + au.getAuthorName());
							}
						}
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>