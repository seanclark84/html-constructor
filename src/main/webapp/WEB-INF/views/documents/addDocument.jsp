<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Document</title>
</head>
<body>
	<h1>Add Document</h1>
	<c:url value="/document/add" var="url"/>
	<form:form modelAttribute="document" action="${url}" method="post">
		<form:hidden path="nodeId"/>
		<p>
			<label for="name">Document Name:</label>
			<form:input path="name" />
		</p>
		<p>
			<label for="description">Description:</label>
			<form:input path="description" />
		</p>
		<h2>Sections</h2>
		<p>
			<input type="submit" value="Add Section" name="section"/>
		</p>
		<p>
		<c:choose>
			<c:when test="${ not empty document.sections }">
				<ul>
				<c:forEach items="${document.sections}" var="section">
					<li><c:out value="${section.title}"/></li>
				</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				No Sections
			</c:otherwise>
		</c:choose>
		</p>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>