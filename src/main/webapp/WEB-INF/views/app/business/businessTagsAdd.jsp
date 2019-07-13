<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tagi | Lokalne Atrakcje</title>
    <link href="<c:url value="/css/formErrors.css" />" rel="stylesheet" >
</head>
<body>

    <%@include file="/WEB-INF/views/app/businessHeader.jsp"%>

    <div id="tagAdd" class="tag base center">

        <div>
            <form:form method="post" modelAttribute="tag" >
                <form:hidden path="service.id" value="${serviceId}" />
                <div>
                    Nowy tag:
                    <form:input path="name"/>
                    <input type="submit" value="Dodaj">
                    <div class="error">
                        <form:errors path="name" cssClass="error" />
                    </div>
                </div>

            </form:form>

        </div>

        <div>
            <span class="topic">Tagi</span>
            <c:choose>
                <c:when test="${empty tagList}">
                    <span class="empty">Nie dodano</span>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${tagList}" var="tag">
                        <div class="tagItem">
                            <span class="content">${tag.name}</span>
                            <a href="<c:url value="/businessapp/service/${serviceId}/tag/delete/${tag.id}" /> ">
                                <button class="deleteButton">
                                    Usuń
                                </button>
                            </a>
                        </div>



                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="buttonRight">
            <a class="right" href="<c:url value="/businessapp/service/details/${serviceId}" /> ">
                <button type="button">
                    Anuluj
                </button>
            </a>
        </div>
    </div>


</body>
</html>
