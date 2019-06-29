<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login | Lokalne Atrakcje</title>
    <link href='<c:url value="/css/formErrors.css"/>' rel="stylesheet">

</head>
<body>

    <div class="main">
        <div class="form loginBlock">
            <h3>Zaloguj się jako użytkownik:</h3>

            <form:form method="post" modelAttribute="userLogin">
                <div class="formElement">
                    E-mail:
                    <form:input path="email"/>
                    <div class="error">
                        <form:errors path="email" cssClass="error" />
                    </div>
                </div>
                <div class="formElement">
                    Hasło:
                    <form:password path="password"/>
                    <div class="error">
                        <form:errors path="password" cssClass="error" />
                        <c:if test="${not empty passwordError}">
                            <span class="error">${passwordError}</span>
                        </c:if>
                    </div>
                </div>
                <input type="hidden" name="action" value="user">
                <input type="submit" value="Zaloguj się">
            </form:form>
        </div>

        <div class="loginBlock">
            <h4>Zaloguj się jako firma:</h4>

            <a href="<c:url value="/authentication/login/business" />">
                <button>Logowanie</button>
            </a>

            <h4>Przejdź do rejestracji:</h4>

            <a href="<c:url value="/register" />">
                <button>Rejestracja</button>
            </a>
        </div>
    </div>

</body>
</html>


