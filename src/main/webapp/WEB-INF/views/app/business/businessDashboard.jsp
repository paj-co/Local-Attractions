<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${loggedBusiness.name} | Lokalne Atrakcje</title>
    <link href="<c:url value="/css/formErrors.css" />" rel="stylesheet" >
</head>
<body>

    <%@include file="/WEB-INF/views/app/businessHeader.jsp"%>


        <div id="mainDashboard" class="center">
            <div id="data">
                <div id="info" class="inline">
                    <span class="block topic">Twoje podstawowe dane:</span>
                    <span class="inline">
                        <span class="insideTopic">Email: </span>${loggedBusiness.email}
                    </span>
                    <span class="inline">
                        <span class="insideTopic">NIP: </span>${loggedBusiness.nip}
                    </span>
                    <span class="inline">
                        <span class="insideTopic">REGON: </span>${loggedBusiness.regon}
                    </span>
                </div>
                <div class="right">
                    <a class="block alignRight" href="<c:url value="/businessapp/service/add" />">
                    <button>Zmień podstawowe dane</button>
                    </a>
                    <a class="block alignRight" href="<c:url value="/businessapp/service/add" />">
                        <button>Zmień hasło</button>
                    </a>
                </div>
                <div style="clear: both"></div>

            </div>

            <hr class="thick"/>

            <a class="right" href="<c:url value="/businessapp/service/add" />">
                <button>Dodaj nową usługę</button>
            </a>
            <h2>Moje usługi:</h2>

            <c:choose>
                <c:when test="${empty services}">
                    <p>Nie masz jeszcze dodanych rządnych usług!</p>
                </c:when>
                <c:otherwise>
                    <hr class=""/>
                    <c:forEach items="${services}" var="service" >
                        <div class="service">
                            <span>- ${service.name}</span>
                            <a href="<c:url value="/businessapp/service/details/${service.id}" />">Szczegóły</a>
                        </div>
                        <hr />
                    </c:forEach>
                </c:otherwise>
            </c:choose>

        </div>






</body>
</html>