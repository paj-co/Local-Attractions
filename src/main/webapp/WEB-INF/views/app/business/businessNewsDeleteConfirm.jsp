<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Skasować wydarzenie? | Lokalne Atrakcje</title>
    <link href="<c:url value="/css/formErrors.css" />" rel="stylesheet" >
</head>
<body>
<%@include file="/WEB-INF/views/app/businessHeader.jsp"%>

<div class="center">
    <div class="loginBlock">
        <h4>Czy na pewno chcesz skasować wydarznie "${newsFeed.name}"?</h4>
        <a href="<c:url value="/businessapp/service/details/${serviceId}" /> ">
            <button>
                Anuluj
            </button>
        </a>
        <a href="<c:url value="/businessapp/service/${serviceId}/news/delete/${newsFeed.id}" /> ">
            <button>
                Tak, chcę usunąć
            </button>
        </a>
    </div>
</div>
</body>
</html>

