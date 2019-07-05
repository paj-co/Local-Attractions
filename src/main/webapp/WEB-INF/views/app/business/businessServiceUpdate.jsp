<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Zaktualizuj | Lokalne Atrakcje</title>
    <link href='<c:url value="/css/formErrors.css"/>' rel="stylesheet">
    <style>

    </style>
</head>
<body>

<%@include file="/WEB-INF/views/app/businessHeader.jsp"%>

<div id="addService">

    <h2>Zaktualizuj usługę:</h2>

    <form:form method="post" modelAttribute="service">
        <form:hidden path="business.id" />
        <form:hidden path="id" />
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
        <div class="inline short">
            Nr domu:
            <form:input path="houseNumber"/>
            <div class="error">
                <form:errors path="houseNumber" cssClass="error" />
            </div>
        </div>
        <div class="inline short">
            Nr lokalu:
            <form:input path="apartmentNumber"/>
            <div class="error">
                <form:errors path="apartmentNumber" cssClass="error" />
            </div>
        </div>

        <%--TODO delete br tag       --%>
        <br>

        <div class="inline">
            Wojewódźtwo:
            <form:select path="province" items="${provinces}" itemLabel="name" itemValue="id"/>
            <div class="error">
                <form:errors path="province" cssClass="error" />
            </div>
        </div>
        <div class="inline">
            Powiat:
            <form:select path="district" items="${districts}" itemLabel="name" itemValue="id"/>
            <div class="error">
                <form:errors path="district" cssClass="error" />
            </div>
        </div>
        <div class="inline">
            Gmina:
            <form:select path="commune" items="${communes}" itemLabel="name" itemValue="id"/>
            <div class="error">
                <form:errors path="commune" cssClass="error" />
            </div>
        </div>
        <div class="inline">
            Miejscowość:
            <form:select path="locality" items="${localities}" itemLabel="name" itemValue="id"/>
            <div class="error">
                <form:errors path="locality" cssClass="error" />
            </div>
        </div>

        <%--TODO delete br tag       --%>
        <br>

        <div class="short">
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
        <div class="medium">
            Nr telefonu:
            <form:input path="phone"/>
            <div class="error">
                <form:errors path="phone" cssClass="error" />
            </div>
        </div>
        <div class="large">
            <span class="inline top">Informacje (dokładny opis usługi):</span>
            <form:textarea path="informations"/>
            <div class="error">
                <form:errors path="informations" cssClass="error" />
            </div>
        </div>
        <div>
            Główne zdjęcie:
            <input type="file" name="mainPicture">
            <div class="error">

            </div>
        </div>

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
                    <span class="short"><form:input path="openHourMonday"/> - </span>
                </td>
                <td>
                    <span class="short"><form:input path="closeHourMonday"/></span>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <div class="error">
                        <form:errors path="openHourMonday" cssClass="error" />
                        <form:errors path="closeHourMonday" cssClass="error" />
                    </div>
                </td>
            </tr>
            <tr>
                <th>
                    <span>Wtorek:</span>
                </th>
                <td>
                    <span class="short"><form:input path="openHourTuesday"/> - </span>
                </td>
                <td>
                    <span class="short"><form:input path="closeHourTuesday"/></span>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <div class="error">
                        <form:errors path="openHourTuesday" cssClass="error" />
                        <form:errors path="closeHourTuesday" cssClass="error" />
                    </div>
                </td>
            </tr>
            <tr>
                <th>
                    <span>Środa:</span>
                </th>
                <td>
                    <span class="short"><form:input path="openHourWednesday"/> - </span>
                </td>
                <td>
                    <span class="short"><form:input path="closeHourWednesday"/></span>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <div class="error">
                        <form:errors path="openHourWednesday" cssClass="error" />
                        <form:errors path="closeHourWednesday" cssClass="error" />
                    </div>
                </td>
            </tr>
            <tr>
                <th>
                    <span>Czwartek:</span>
                </th>
                <td>
                    <span class="short"><form:input path="openHourThursday"/> - </span>
                </td>
                <td>
                    <span class="short"><form:input path="closeHourThursday"/></span>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <div class="error">
                        <form:errors path="openHourThursday" cssClass="error" />
                        <form:errors path="closeHourThursday" cssClass="error" />
                    </div>
                </td>
            </tr>
            <tr>
                <th>
                    <span>Piątek:</span>
                </th>
                <td>
                    <span class="short"><form:input path="openHourFriday"/> - </span>
                </td>
                <td>
                    <span class="short"><form:input path="closeHourFriday"/></span>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <div class="error">
                        <form:errors path="openHourFriday" cssClass="error" />
                        <form:errors path="closeHourFriday" cssClass="error" />
                    </div>
                </td>
            </tr>
            <tr>
                <th>
                    <span>Sobota:</span>
                </th>
                <td>
                    <span class="short"><form:input path="openHourSaturday"/> - </span>
                </td>
                <td>
                    <span class="short"><form:input path="closeHourSaturday"/></span>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <div class="error">
                        <form:errors path="openHourSaturday" cssClass="error" />
                        <form:errors path="closeHourSaturday" cssClass="error" />
                    </div>
                </td>
            </tr>
            <tr>
                <th>
                    <span>Niedziela:</span>
                </th>
                <td>
                    <span class="short"><form:input path="openHourSunday"/> - </span>
                </td>
                <td>
                    <span class="short"><form:input path="closeHourSunday"/></span>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <div class="error">
                        <form:errors path="openHourTuesday" cssClass="error" />
                        <form:errors path="closeHourTuesday" cssClass="error" />
                    </div>
                </td>
            </tr>


        </table>

        <input class="left" type="submit" value="Zapisz">
        <a class="right" href="<c:url value="/businessapp/service/details/${serviceId}" />">
            <button type="button">Anuluj</button>
        </a>
    </form:form>



</div>

</body>
</html>
