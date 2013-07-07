<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>whatever</title>
</head>
<body>
	<h2>Company edit</h2>
	<form:form method="post" commandName="company2">
	<table border="1">
		<tr>
			<td>company name</td>
			<td><c:out value="${company.companyName}"></c:out></td>
			   <td><form:label path="companyName">new name</form:label></td>
        <td><form:input path="companyName"  /></td> 
		</tr>
		<tr>
			<td>company password</td>
			<td><c:out value="****"></c:out></td>
			        <td><form:label path="password">new password</form:label></td>
        <td><form:input path="password" /></td>
		</tr>
		<tr>
			<td>start date</td>
			<td><c:out value="${company.addDate}"></c:out></td>
		</tr>
		<c:if test="${company.activeDate}!=null">
			<tr>
				<td>expire date</td>
				<td><c:out value="${company.activeDate}"></c:out></td>
			</tr>
		</c:if>
		<tr>
        <td colspan="2">
            <input type="submit" value="update"/>
        </td>
    </tr>
		
	</table>
</form:form>
</body>
</html>