<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Aktualizacja wydarzenia | Lokalne Atrakcje</title>
    <link href="<c:url value="/css/formErrors.css" />" rel="stylesheet" >
</head>
<body>

    <%@include file="/WEB-INF/views/app/businessHeader.jsp"%>

    <div id="newsFeed" class="center base">

        <form:form method="post" modelAttribute="newsFeed">

            <form:hidden path="service.id" />
            <form:hidden path="id" />
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

            <div class="inline medium">
                Data rozpoczęcia (yyyy-mm-dd):
                <form:input path="starts"/>
                <div class="error">
                    <form:errors path="starts" cssClass="error" />
                    <c:if test="${not empty dateError}">
                        <span class="error">${dateError}</span>
                    </c:if>
                </div>
            </div>

            <div class="inline medium">
                Data zakończenia (yyyy-mm-dd):
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
