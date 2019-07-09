<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Szczegóły usługi | Lokalne Atrakcje</title>
    <link href="<c:url value="/css/formErrors.css" />" rel="stylesheet" >
</head>
<body>

    <%@include file="/WEB-INF/views/app/businessHeader.jsp"%>

    <div id="serviceDetails" class="center">

        <div class="mainDetails">
            <div id="picture">
                <%--TODO mainPicture--%>
                <img src="<c:url value="/image/picture1.jpg" /> "/>
            </div>
            <div class="padding">
                <a class="left" href="<c:url value="/businessapp/service/update/${service.id}" /> ">
                    <button>
                        Edytuj
                    </button>
                </a>

                <a class="right" href="<c:url value="/businessapp/service/delete/confirm/${service.id}" /> ">
                    <button>
                        Usuń
                    </button>
                </a>
                <h3 class="inline">Główne informacje</h3>

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

                <div><span class="topic">E-mail usługi: </span><span class="content">${service.email}</span></div>
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

                <hr/>
                <div>
                    <div id="category" class="lists">
                        <span class="topic">Kategorie</span>
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
                        <span class="topic">Tagi</span>
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
                    <div id="panel" class="lists">
                        <%--TODO link--%>
                        <a href="<c:url value="/businessapp/service/${service.id}/categories/" /> ">
                            <button>
                                Zarządzaj kategoriami
                            </button>
                        </a>
                        <a href="<c:url value="" /> ">
                            <button>
                                Zarządzaj tagami
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="secondaryDetails padding">

            <div id="newsFeed" class="lists">
                <%--TODO link--%>
                <a class="right" href="<c:url value="/businessapp/service/${service.id}/news" /> ">
                    <button>
                        Dodaj
                    </button>
                </a>

                <h3 class="topic">Wydarzenia</h3>

                <span class="insideTopic">Przyszłe</span>
                <c:choose>
                    <c:when test="${empty futureNewsFeeds}">
                        <span class="empty">Brak</span>
                    </c:when>
                    <c:otherwise>
                        <hr/>
                        <c:forEach items="${futureNewsFeeds}" var="futureNewsFeed">
                            <div class="itemBody">
                                <span class="contentTopic">${futureNewsFeed.name}</span>
                                <span class="contentInfo">
                                    ${futureNewsFeed.starts} - ${futureNewsFeed.ends}
                                </span>
                                <span class="content">${futureNewsFeed.description}</span>
                            </div>
                            <%--TODO link--%>
                            <a  href="<c:url value="" /> ">
                                <button class="functionalButton">
                                    Edytuj
                                </button>
                            </a>
                            <%--TODO link--%>
                            <a class="right" href="<c:url value="" /> ">
                                <button class="functionalButton">
                                    Usuń
                                </button>
                            </a>
                            <hr/>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>

                <span class="insideTopic">Obecne</span>
                <c:choose>
                    <c:when test="${empty currentNewsFeeds}">
                        <span class="empty">Brak</span>
                    </c:when>
                    <c:otherwise>
                        <hr/>
                        <c:forEach items="${currentNewsFeeds}" var="currentNewsFeed">
                            <div class="itemBody">
                                <span class="contentTopic">${currentNewsFeed.name}</span>
                                <span class="contentInfo">${currentNewsFeed.starts} - ${currentNewsFeed.ends}</span>
                                <span class="content">${currentNewsFeed.description}</span>
                            </div>
                            <hr/>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                
                <span class="insideTopic">Przeszłe</span>
                <c:choose>
                    <c:when test="${empty pastNewsFeeds}">
                        <span class="empty">Brak</span>
                    </c:when>
                    <c:otherwise>
                        <hr/>
                        <c:forEach items="${pastNewsFeeds}" var="pastNewsFeed">
                            <div class="itemBody">
                                <span class="contentTopic">${pastNewsFeed.name}</span>
                                <span class="contentInfo">${pastNewsFeed.starts} - ${pastNewsFeed.ends}</span>
                                <span class="content">${pastNewsFeed.description}</span>
                            </div>
                            <hr/>
                        </c:forEach>
                </c:otherwise>
            </c:choose>
            </div>

            <div id="offers" class="lists">

                <%--TODO link--%>
                <a class="right" href="<c:url value="" /> ">
                    <button>
                        Dodaj
                    </button>
                </a>

                <h3 class="topic">Promocje</h3>

                <span class="insideTopic">Przyszłe</span>
                <c:choose>
                    <c:when test="${empty futureOffers}">
                        <span class="empty">Brak</span>
                    </c:when>
                    <c:otherwise>
                        <hr/>
                        <c:forEach items="${futureOffers}" var="futureOffer">
                            <div class="itemBody">
                                <span class="contentTopic">${futureOffer.name}</span>
                                <span class="contentInfo">${futureOffer.starts} - ${futureOffer.ends}</span>
                                <span class="content">${futureOffer.description}</span>
                            </div>
                            <hr/>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>

                <span class="insideTopic">Obecne</span>
                <c:choose>
                    <c:when test="${empty currentOffers}">
                        <span class="empty">Brak</span>
                    </c:when>
                    <c:otherwise>
                        <hr/>
                        <c:forEach items="${currentOffers}" var="currentOffer">
                            <div class="itemBody">
                                <span class="contentTopic">${currentOffer.name}</span>
                                <span class="contentInfo">${currentOffer.starts} - ${currentOffer.ends}</span>
                                <span class="content">${currentOffer.description}</span>
                            </div>
                            <hr/>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>

                <span class="insideTopic">Zakończone</span>
                <c:choose>
                    <c:when test="${empty pastOffers}">
                        <span class="empty">Brak</span>
                    </c:when>
                    <c:otherwise>
                        <hr/>
                        <c:forEach items="${pastOffers}" var="pastOffer">
                            <div class="itemBody">
                                <span class="contentTopic">${pastOffer.name}</span>
                                <span class="contentInfo">${pastOffer.starts} - ${pastOffer.ends}</span>
                                <span class="content">${pastOffer.description}</span>
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
