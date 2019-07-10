<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Kategorie | Lokalne Atrakcje</title>
    <link href="<c:url value="/css/formErrors.css" />" rel="stylesheet" >
</head>
<body>

    <%@include file="/WEB-INF/views/app/businessHeader.jsp"%>

    <div id="serviceCategories" class="center">
        <form:form method="post" modelAttribute="serviceCategories">

            <c:forEach  items="${mainCategories}" var="mainCategory" >
                <div class="mainCategory">
                    <span class="categoryTitle">${mainCategory.name}</span>
                    <c:forEach items="${serviceCategories.serviceCategories}" var="category" >
                        <c:if test="${mainCategory.id eq category.mainCategory.id}" >
                            <span class="checkbox">
                                <form:checkbox path="serviceCategories" value="${category.id}" label="${category.name}" checked="true" />
                            </span>
                        </c:if>
                    </c:forEach>

                    <c:forEach items="${serviceCategories.remainingCategories}" var="category" >
                        <c:if test="${mainCategory.id eq category.mainCategory.id}" >
                            <span class="checkbox">
                                <form:checkbox path="remainingCategories" value="${category.id}" label="${category.name}" />
                            </span>
                        </c:if>
                    </c:forEach>
                </div>
            </c:forEach>

            <div>
            <input type="submit" value="Zapisz">
                <a href="<c:url value="/businessapp/service/details/${serviceCategories.serviceId}" />">
                    <button type="button">Anuluj</button>
                </a>
            </div>

        </form:form>
    </div>

</body>
</html>
