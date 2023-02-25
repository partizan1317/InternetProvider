<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<c:if test = "${empty sessionScope.locale}">
    <fmt:setLocale value="en"/>
</c:if>
<c:if test = "${not empty sessionScope.locale}">
    <fmt:setLocale value="${sessionScope.locale}"/>
</c:if>
<fmt:setBundle basename="locale" var="loc"/>
<fmt:message bundle="${loc}" key="adminTariffsContainer.tariffName" var="name"/>
<fmt:message bundle="${loc}" key="adminTariffsContainer.tariffPrice" var="price"/>
<fmt:message bundle="${loc}" key="adminTariffsContainer.isDeleted" var="deleted"/>
<fmt:message bundle="${loc}" key="adminTariffsContainer.delete" var="delete"/>
<fmt:message bundle="${loc}" key="adminTariffsContainer.retrieve" var="retrieve"/>
<fmt:message bundle="${loc}" key="adminTariffsContainer.createTariffBtn" var="createTariffBtn"/>
<c:set var="number" value="0" scope="request"/>
<div class="container">
    <table class="tariffs__table" border="1">
        <tr>
            <th>
                №
            </th>
            <th>
                ${name}
            </th>
            <th>
                ${price}
            </th>
            <th>
                ${deleted}
            </th>
            <th>
                ${delete}
            </th>
        </tr>
        <c:forEach var="tariff" items="${requestScope.tariffs}">
            <tr>
                <td>
                    <c:set var="number" value="${number + 1}" scope="request"/>
                    ${number}
                </td>
                <td>
                    ${tariff.name}
                </td>
                <td>
                    ${tariff.price}
                </td>
                <td>
                    ${tariff.deleted}
                </td>
                <c:if test = "${tariff.deleted}">
                    <td>
                        <form method="post" action="controller?command=retrieve-tariff">
                            <button class="retrieve" type="submit" value="">${retrieve}</button>
                            <input type="hidden" name="tariffId" value="${tariff.id}">
                        </form>
                    </td>
                </c:if>
                <c:if test = "${!tariff.deleted}">
                    <td>
                        <form method="post" action="controller?command=delete-tariff">
                            <button class="delete" type="submit" value="">${delete}</button>
                            <input type="hidden" name="tariffId" value="${tariff.id}">
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <form method="post" action="controller?command=create_tariff_page">
        <button class="container_nav_btn" type="submit">${createTariffBtn}</button>
    </form>
</div>