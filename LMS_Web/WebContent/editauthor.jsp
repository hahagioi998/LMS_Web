<%@page import="com.gcit.lms.entity.Author"%>
<%@page import="com.gcit.lms.service.AdminService"%>
<%AdminService service = new AdminService();
	Integer authorId = Integer.parseInt(request.getParameter("authorId"));
	Author author = service.getAuthorByPk(authorId);
%>
<div>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title">Update Author Details</h4>
	</div>
	<form action="editAuthor" method="post">
		<div class="modal-body">
			<p>Enter the details of your Author:</p>
			<input type="text" name="authorName" value="<%=author.getAuthorName()%>"> <br />
			<input type="hidden" name="authorId" value="<%=author.getAuthorId()%>">
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="submit" class="btn btn-primary">Save changes</button>
		</div>
	</form>
</div>