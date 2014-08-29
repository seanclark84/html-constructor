<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Add Document</title>
	</head>
	<body>
	
		<h1>Add Document</h1>
		<div class="error">${error}</div>
		
		<form action="<c:url value="/document/add"/>" method="post" >
      <p>
        <label for="name">Document Name:</label>
        <input id="name" name="name" type="text" value="${name}"/>
      </p>
      <p>
        <label for="description">Description:</label>
        <input id="description" name="description" type="text" value="${description}"/>
      </p>
      <input  type="submit" value="Create"/>
    </form>
	</body>
</html>