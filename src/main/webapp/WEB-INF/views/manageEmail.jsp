<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>company</title>
</head>
<body>
	<h2>manage email</h2>
	<table border="1">

		<c:forEach var="i" items="${company.email}">
			<tr>
				<td><c:out value="${i}" /></td>
				<td><a
					href="<c:url value="/company/${company.guid}/emailManagement/remove"/>?oldEmail=${i}">remove</a></td>
				<td><a
					href="<c:url value="/company/${company.guid}/emailManagement/update"/>?oldEmail=${i}">update</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>