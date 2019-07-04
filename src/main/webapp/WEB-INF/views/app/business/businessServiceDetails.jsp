<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Szczegóły usługi | Lokalne Atrakcje</title>
    <link href="<c:url value="/css/formErrors.css" />" rel="stylesheet" >
</head>
<body>

    <div id="serviceDetails">
        <div id="picture">
            <%--TODO mainPicture--%>
            <img src="<c:url value="/image/picture1.jpg" /> "/>
        </div>
        <div class="mainDetails">
            <h3>Główne informacje:</h3>
            
            <div><span class="topic">Nazwa: </span><span class="content">${service.name}</span></div>
            <div><span class="topic">Krótki opis: </span><span class="content">${service.description}</span></div>
            <div><span class="topic">Informacje (dokładny opis usługi): </span><span class="content">${service.informations}</span></div>

            <div><span class="topic">Adres: </span>
                <div><span class="topic">Ulica: </span><span class="content">${service.street}</span></div>
                <div><span class="topic">Nr domu: </span><span class="content">${service.houseNumber}</span></div>
                <div><span class="topic">Nr lokalu: </span><span class="content">${service.apartmentNumber}</span></div>
            </div>

            <div><span class="topic">Wojewódźtwo: </span><span class="content">${service.province}</span></div>
            <div><span class="topic">Powiat: </span><span class="content">${service.district}</span></div>
            <div><span class="topic">Gmina: </span><span class="content">${service.commune}</span></div>
            <div><span class="topic">Miejscowość: </span><span class="content">${service.locality}</span></div>
            <div><span class="topic">Kod pocztowy: </span><span class="content">${service.zipCode}</span></div>

            <div><span class="topic">E-mail usługi:: </span><span class="content">${service.email}</span></div>
            <div><span class="topic">Nr telefonu: </span><span class="content">${service.phone}</span></div>


                <table>
                    <tr>
                        <th colspan="3">
                            <p class="topic">Godziny otwarcia:</p>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <span>Poniedziałek:</span>
                        </th>
                        <td>
                            <span>${service.openHourMonday} - </span>
                        </td>
                        <td>
                            <span>${service.closeHourMonday}</span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <span>Wtorek:</span>
                        </th>
                        <td>
                            <span>${service.openHourTuesday} - </span>
                        </td>
                        <td>
                            <span>${service.closeHourTuesday}</span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <span>Środa:</span>
                        </th>
                        <td>
                            <span>${service.openHourWednesday} - </span>
                        </td>
                        <td>
                            <span>${service.closeHourWednesday}</span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <span>Czwartek:</span>
                        </th>
                        <td>
                            <span>${service.openHourThursday} - </span>
                        </td>
                        <td>
                            <span>${service.closeHourThursday}</span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <span>Piątek:</span>
                        </th>
                        <td>
                            <span>${service.openHourFriday} - </span>
                        </td>
                        <td>
                            <span>${service.closeHourFriday}</span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <span>Sobota:</span>
                        </th>
                        <td>
                            <span>${service.openHourSaturday} - </span>
                        </td>
                        <td>
                            <span>${service.closeHourSaturday}</span>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <span>Niedziela:</span>
                        </th>
                        <td>
                            <span>${service.openHourSunday} - </span>
                        </td>
                        <td>
                            <span>${service.closeHourSunday}</span>
                        </td>
                    </tr>
                </table>

            
        </div>

        <div class="secondaryDetails">
            <div id="category" class="lists">
                <span class="topic">Kategorie:</span>
                <c:choose>
                    <c:when test="${empty categories}">
                        <span class="empty">Nie dodano</span>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${categories}" var="category">
                            <span class="content">${category.name}</span>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            <div id="tag" class="lists">
                <span class="topic">Tagi:</span>
                <c:choose>
                    <c:when test="${empty tags}">
                        <span class="empty">Nie dodano</span>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${tags}" var="tag">
                            <span class="content">${tag.name}</span>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            <div id="newsFeed" class="lists">
                <span class="topic">Aktualności:</span>
                <hr/>
                <c:choose>
                    <c:when test="${empty newsFeeds}">
                        <span class="empty">Nie dodano</span>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${newsFeeds}" var="newsFeed">
                            <div class="itemBody">
                                <span class="contentTopic">${newsFeed.name} Aktywna: ${newsFeed.active}</span>
                                <span class="contentInfo">${newsFeed.starts} - ${newsFeed.ends}</span>
                                <span class="content">${newsFeed.description}</span>
                            </div>
                            <hr/>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            <div id="offers" class="lists">
                <span class="topic">Promocje:</span>
                <hr/>
                <c:choose>
                    <c:when test="${empty offers}">
                        <span class="empty">Nie dodano</span>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${offers}" var="offer">
                            <div class="itemBody">
                                <span class="contentTopic">${offer.name} Aktywna: ${offer.active}</span>
                                <span class="contentInfo">${offer.starts} - ${offer.ends}</span>
                                <span class="content">${offer.description}</span>
                            </div>
                            <hr/>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            
        </div>





    </div>



</body>
</html>
