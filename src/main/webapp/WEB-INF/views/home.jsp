<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Strona główna | Lokalne Atrakcje</title>
</head>
<body>
    <div id="home">
        <a href="<c:url value="/authentication/login/user" />">
            <button>Logowanie</button>
        </a>
        <a href="<c:url value="/register" />">
            <button>Rejestracja</button>
        </a>
        <h1>Witaj na naszej stronie głównej</h1>

    </div>

</body>
</html>
