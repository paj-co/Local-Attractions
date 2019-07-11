<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Zmień hasło | Lokalne Atrakcje</title>
    <link href='<c:url value="/css/formErrors.css"/>' rel="stylesheet">
</head>
<body>

<%@include file="/WEB-INF/views/header.jsp"%>

<div class="center">
    <div class="registerBlock">

        <h3>Zaktualizuj swoje dane:</h3>

        <form:form method="post" modelAttribute="businessChangePassword">
            <form:hidden path="userId" />
            <form:hidden path="email" />
            <div>
                Obecne hasło:
                <form:password path="oldPassword"/>
                <div class="error">
                    <form:errors path="oldPassword" cssClass="error" />
                    <c:if test="${not empty passwordError}">
                        <span class="error">${passwordError}</span>
                    </c:if>
                </div>
            </div>
            <div>
                Nowe hasło:
                <form:password path="newPassword"/>
                <div class="error">
                    <form:errors path="newPassword" cssClass="error" />
                </div>
            </div>
            <div>
                Powtórz hasło:
                <form:password path="repeatPassword"/>
                <div class="error">
                    <form:errors path="repeatPassword" cssClass="error" />
                    <c:if test="${not empty reEnterPasswordError}">
                        <span class="error">${reEnterPasswordError}</span>
                    </c:if>
                </div>
            </div>
            <input type="submit" value="Zapisz">
            <a href="<c:url value="/businessapp/dashboard/" />">
                <button type="button">Anuluj</button>
            </a>
        </form:form>

    </div>
</div>

</body>
</html>
