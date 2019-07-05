<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${loggedBusiness.name} | Lokalne Atrakcje</title>
    <link href="<c:url value="/css/formErrors.css" />" rel="stylesheet" >
</head>
<body>

    <%@include file="/WEB-INF/views/app/businessHeader.jsp"%>

    <h1>Witaj, ${loggedBusiness.name}!</h1>

    <h2>Moje usługi:</h2>
    <a href="<c:url value="/businessapp/service/add" />">
        <button>Dodaj nową usługę</button>
    </a>
    <c:choose>
        <c:when test="${empty services}">
            <p>Nie masz jeszcze dodanych rządnych usług!</p>
        </c:when>
        <c:otherwise>
            <c:forEach items="${services}" var="service" >
                <p>${service.name}</p>
                <a href="<c:url value="/businessapp/service/details/${service.id}" />">Szczegóły</a>
            </c:forEach>
        </c:otherwise>
    </c:choose>





</body>
</html>