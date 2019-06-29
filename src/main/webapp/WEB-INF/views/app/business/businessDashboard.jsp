<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${loggedBusiness.name} | Lokalne Atrakcje</title>
</head>
<body>

    <a href="<c:url value="/businessapp/logout/" />">
        <button>Wylogowanie</button>
    </a>
    <h1>Witaj, ${loggedBusiness.name}!</h1>

    <a href="<c:url value="/businessapp/service/add" />">
        <button>Dodaj usługę</button>
    </a>


</body>
</html>