<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>whatever</title>
</head>
<body>
	<h2>update email</h2>
	<form method="post" >
	<c:out value="${company.companyName}"></c:out>
	<table border="1">
		<tr>
			<td>old email</td>
			<td width=300><c:out value="${oldEmail}"></c:out></td>
			        <td>new email</td>
        <td><input type="text" name="newEmail" /></td> 
		</tr>
		<tr>
        <td colspan="2">
            <input type="submit" value="update"/>
        </td>
    </tr>
		
	</table>
</form>
</body>
</html>