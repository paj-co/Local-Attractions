<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${loggedUser.firstName} | Lokalne Atrakcje</title>
</head>
<body>

    <a href="<c:url value="/userapp/logout/" />">
        <button>Wylogowanie</button>
    </a>
    <h1>Witaj, ${loggedUser.firstName}!</h1>

</body>
</html>
