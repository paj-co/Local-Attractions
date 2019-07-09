<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj wydarzenie | Lokalne Atrakcje</title>
</head>
<body>

    <div id="newsFeed center">

        <form:form method="post" modelAttribute="newsFeed">

            <form:hidden path="service.id" value="${serviceId}" />
            <div>
                Tytuł:
                <form:input path="name"/>
                <div class="error">
                    <form:errors path="name" cssClass="error" />
                </div>
            </div>

            <div>
                Opis:
                <form:textarea path="description"/>
                <div class="error">
                    <form:errors path="description" cssClass="error" />
                </div>
            </div>

            <div class="inline">
                Data i czas rozpoczęcia (yyyy-mm-dd):
                <form:input path="starts"/>
                <div class="error">
                    <form:errors path="starts" cssClass="error" />
                </div>
            </div>

            <div class="inline short">
                Data i czas zakończenia (yyyy-mm-dd):
                <form:input path="ends"/>
                <div class="error">
                    <form:errors path="ends" cssClass="error" />
                </div>
            </div>

            <div>
                <input type="submit" value="Zapisz">

                <a href="<c:url value="/businessapp/service/details/${serviceId}" />">
                    <button type="button">Anuluj</button>
                </a>
            </div>
        </form:form>


    </div>

</body>
</html>
