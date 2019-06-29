<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj usługę | Lokalne Atrakcje</title>
    <style>
        .inline{
            display: inline-block;
        }
    </style>
</head>
<body>

<div class="loginBlock">

    <h3>Zarejestruj się:</h3>

    <form:form method="post" modelAttribute="service">
        <div>
            Nazwa usługi:
            <form:input path="name"/>
            <div class="error">
                <form:errors path="name" cssClass="error" />
            </div>
        </div>
        <div>
            Krótki opis:
            <form:input path="description"/>
            <div class="error">
                <form:errors path="description" cssClass="error" />
            </div>
        </div>
        <div class="inline">
            Ulica:
            <form:input path="street"/>
            <div class="error">
                <form:errors path="street" cssClass="error" />
            </div>
        </div>
        <div class="inline">
            Nr domu:
            <form:input path="houseNumber"/>
            <div class="error">
                <form:errors path="houseNumber" cssClass="error" />
            </div>
        </div>
        <div class="inline">
            Nr mieszkania:
            <form:input path="apartmentNumber"/>
            <div class="error">
                <form:errors path="apartmentNumber" cssClass="error" />
            </div>
        </div>

        <%--TODO delete br tag       --%>
        <br>

        <div class="inline">
            Miejscowość:
            <form:input path="locality"/>
            <div class="error">
                <form:errors path="locality" cssClass="error" />
            </div>
        </div>
        <div class="inline">
            Wojewódźtwo:
            <form:input path="province"/>
            <div class="error">
                <form:errors path="province" cssClass="error" />
            </div>
        </div>
        <div class="inline">
            Powiat:
            <form:input path="district"/>
            <div class="error">
                <form:errors path="district" cssClass="error" />
            </div>
        </div>
        <div class="inline">
            Gmina:
            <form:input path="commune"/>
            <div class="error">
                <form:errors path="commune" cssClass="error" />
            </div>
        </div>

        <%--TODO delete br tag       --%>
        <br>

        <div>
            Kod pocztowy:
            <form:input path="zipCode"/>
            <div class="error">
                <form:errors path="zipCode" cssClass="error" />
            </div>
        </div>

        <div>
            E-mail usługi:
            <form:input path="email"/>
            <div class="error">
                <form:errors path="email" cssClass="error" />
            </div>
        </div>
        <div>
            Nr telefonu:
            <form:input path="phone"/> *opcjonalnie
            <div class="error">
                <form:errors path="phone" cssClass="error" />
            </div>
        </div>
        <div>
            Informacje (dokładny opis usługi):
            <form:textarea path="informations"/> *opcjonalnie
            <div class="error">
                <form:errors path="informations" cssClass="error" />
            </div>
        </div>
        <div>
            Kategorie:
            <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id" multiple="true"/>
            <%--TODO categories errors --%>
            <div class="error">
                <form:errors path="categories" cssClass="error" />
            </div>
        </div>


        <%--TODO        --%>
<%--        <div>--%>
<%--            Godzina otwarcia:--%>
<%--            <form:input path="email"/>--%>
<%--            <div class="error">--%>
<%--                <form:errors path="email" cssClass="error" />--%>
<%--                <c:if test="${not empty emailError}">--%>
<%--                    <span class="error">${emailError}</span>--%>
<%--                </c:if>--%>
<%--            </div>--%>
<%--        </div>--%>
        <input type="submit" value="Zaloguj sie">
    </form:form>

</div>


</body>
</html>
