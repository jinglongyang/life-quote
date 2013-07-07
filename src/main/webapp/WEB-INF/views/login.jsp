<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>
    Please login
</h1>

<form action="j_spring_security_check" id="login" method="post">
    <input type="text" id="username" name="username">
    <input type="password" id="password" name="password">
    <input type="submit"/>
</form>
</body>
</html>
