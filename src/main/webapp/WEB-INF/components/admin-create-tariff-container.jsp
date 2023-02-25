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
<fmt:message bundle="${loc}" key="adminCreateTariffContainer.label" var="label"/>
<fmt:message bundle="${loc}" key="adminCreateTariffContainer.name" var="name"/>
<fmt:message bundle="${loc}" key="adminCreateTariffContainer.exampleName" var="exampleName"/>
<fmt:message bundle="${loc}" key="adminCreateTariffContainer.price" var="price"/>
<fmt:message bundle="${loc}" key="adminCreateTariffContainer.examplePrice" var="examplePrice"/>
<fmt:message bundle="${loc}" key="adminCreateTariffContainer.createBtn" var="createBtn"/>

<div class="container">
    <label class="create__label">${label}</label>
    <form method="post" action="controller?command=create-tariff">
        <div class="form">
            <div class="labels">
                <label class="label">${name}</label>
                <label class="label">${price}</label>
            </div>
            <div class="fields">
                <input class="input__field" type="text" placeholder="${exampleName}" name="name">
                <input class="input__field" type="number" placeholder="${examplePrice}" name="amount">
            </div>
        </div>
        <button class="create__btn" type="submit">${createBtn}</button>
    </form>
</div>