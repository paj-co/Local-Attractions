<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Usuń usługę | Lokalne Atrakcje</title>
    <link href="<c:url value="/css/formErrors.css" />" rel="stylesheet" >
</head>
<body>
    <%@include file="/WEB-INF/views/app/businessHeader.jsp"%>

    <div class="center">
        <div class="loginBlock">
            <h4>Czy na pewno chcesz skasować usługę ${serviceToDelete.name}?</h4>
            <a href="<c:url value="/businessapp/service/details/${serviceToDelete.id}" /> ">
                <button>
                    Anuluj
                </button>
            </a>
            <a class="right" href="<c:url value="/businessapp/service/delete/${serviceToDelete.id}" /> ">
                <button>
                    Tak, chcę usunąć
                </button>
            </a>
        </div>
    </div>

</body>
</html>
