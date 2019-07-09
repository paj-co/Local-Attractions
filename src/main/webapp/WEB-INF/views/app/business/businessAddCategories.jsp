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

            <c:forEach items="${serviceCategories.remainingCategories}" var="category" >
                <form:checkbox path="remainingCategories" value="${category.id}" label="${category.name}" />
            </c:forEach>

            <form:checkboxes path="serviceCategories" items="${serviceCategories.serviceCategories}" itemLabel="name" itemValue="id"/>


            <input type="submit" value="Zapisz">
            <a href="<c:url value="/businessapp/service/details/${serviceCategories.serviceId}" />">
                <button type="button">Anuluj</button>
            </a>

        </form:form>
    </div>

</body>
</html>
