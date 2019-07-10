<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Strona główna | Lokalne Atrakcje</title>
    <link href="<c:url value="/css/formErrors.css" />" rel="stylesheet" >
</head>
<body>
    <div id="home">

        <%@include file="/WEB-INF/views/header.jsp"%>

        <div id="main">
            <h1>Witaj na Lokalnych Atrakcjach!</h1>
            <p>Jeśli masz już konto, zaloguj się!</p>
            <p>Jeśli jakimś cudem nie założyłeś jeszcze konta, zarejestruj się!</p>
        </div>

    </div>

</body>
</html>
