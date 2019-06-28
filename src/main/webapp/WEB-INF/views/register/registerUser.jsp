<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href='<c:url value="/css/formErrors.css"/>' rel="stylesheet">
</head>
<body>

    <div class="loginBlock">

        <h3>Zarejestruj się:</h3>

        <form:form method="post" modelAttribute="user">
            <div>
                Imię:
                <form:input path="firstName"/>
                <div class="error">
                    <form:errors path="firstName" cssClass="error" />
                </div>
            </div>
            <div>
            Nazwisko:
                <form:input path="lastName"/>
                <div class="error">
                    <form:errors path="lastName" cssClass="error" />
                </div>
            </div>
            <div>
                Nick:
                <form:input path="nickName"/> *opcjonalnie
                <div class="error">
                    <form:errors path="nickName" cssClass="error" />
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
            <div>
                Hasło:
                <form:password path="password"/>
                <div class="error">
                    <form:errors path="password" cssClass="error" />
                </div>
            </div>
            <input type="submit" value="Zaloguj sie">
        </form:form>

    </div>

</body>
</html>
