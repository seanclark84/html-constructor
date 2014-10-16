<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Manage Section</title>
</head>
<body>
	<h1>Manage Section</h1>
	<c:url value="/document/section/manage" var="url"/>
	<form:form modelAttribute="section" action="${url}" method="post">
		<form:hidden path="nodeId"/>
		<p>
			<label for="name">Section Title:</label>
			<form:input path="title" />
		</p>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>