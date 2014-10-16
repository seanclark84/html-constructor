<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>List Documents</title>
	</head>
	<body>
		<h1>List Documents</h1>
		
		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Extra</th>
				<th></th>
			</tr>
			<c:forEach items="${documents}" var="doc">
				<c:url value="/document/delete" var="deleteUrl">
					<c:param name="id" value="${doc.nodeId}"/>
				</c:url>
				<c:url value="/document/edit/${doc.nodeId}" var="editUrl"/>
				<tr>
					<td>${doc.name}</td>
					<td>${doc.description}</td>
					<td>
						<c:forEach items="${doc.sections}" var="section">
							<b>${section.title}</b><br>
							<c:forEach items="${section.components}" var="component">
								${component.html}<br/>
							</c:forEach>
						</c:forEach>
					</td>
					<td>
						<a href="${editUrl}">Edit</a>
						<a href="${deleteUrl}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>