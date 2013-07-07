<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
<h2>Company sign up</h2>
<form:form method="post" commandName="company">
 
    <table>
    <tr>
        <td><form:label path="companyName">Company Name</form:label></td>
        <td><form:input path="companyName"  /></td> 
    </tr>
        <tr>
        <td><form:label path="password">password</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="category">Category</form:label></td>
        <td><form:input path="category" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="create company"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>