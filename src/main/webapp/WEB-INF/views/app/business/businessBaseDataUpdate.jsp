<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Zmień dane | Lokalne Atrakcje</title>
    <link href='<c:url value="/css/formErrors.css"/>' rel="stylesheet">
</head>
<body>

<%@include file="/WEB-INF/views/header.jsp"%>

<div class="center">
    <div class="registerBlock">

        <h3>Zaktualizuj swoje dane:</h3>

        <form:form method="post" modelAttribute="business">
            <form:hidden path="id" />
            <div>
                Nazwa:
                <form:input path="name"/>
                <div class="error">
                    <form:errors path="name" cssClass="error" />
                </div>
            </div>
            <div>
                NIP:
                <form:input path="nip"/>
                <div class="error">
                    <form:errors path="nip" cssClass="error" />
                </div>
            </div>
            <div>
                REGON:
                <form:input path="regon"/>
                <div class="error">
                    <form:errors path="regon" cssClass="error" />
                </div>
            </div>
            <div>
                E-mail:
                <form:input path="email"/>
                <div class="error">
                    <form:errors path="email" cssClass="error" />
                    <c:if test="${not empty emailError}">
                        <span class="error">${emailError}</span>
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
