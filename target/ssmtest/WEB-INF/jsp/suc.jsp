<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>注册成功!</h1>
    <c:forEach var="u" items="${users}">
        ${u.name}
    </c:forEach>


</body>
</html>
