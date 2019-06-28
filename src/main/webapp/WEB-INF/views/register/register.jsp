<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Rejestracja | Lokalne Atrakcje</title>
    <link href='<c:url value="/css/formErrors.css"/>' rel="stylesheet">

</head>
<body>

    <div class="loginBlock">
        <h3>Zarejestruj się!</h3>

        <a href="<c:url value="/register/user" />" >
            <button>Jako użytkownik</button>
        </a>
        <a href="<c:url value="/register/business" />" >
            <button>Jako firma</button>
        </a>
    </div>


</body>
</html>
