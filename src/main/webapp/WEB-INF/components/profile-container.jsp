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
<fmt:message bundle="${loc}" key="userContainer.name" var="name"/>
<fmt:message bundle="${loc}" key="userContainer.surname" var="surname"/>
<fmt:message bundle="${loc}" key="userContainer.tariff" var="tariff"/>
<fmt:message bundle="${loc}" key="userContainer.login" var="login"/>
<fmt:message bundle="${loc}" key="userContainer.btn.changeName" var="changeName"/>
<fmt:message bundle="${loc}" key="userContainer.btn.changeSurname" var="changeSurname"/>
<fmt:message bundle="${loc}" key="userContainer.btn.changeTariff" var="changeTariff"/>
<fmt:message bundle="${loc}" key="containerUser.balance" var="balance"/>
<div class="container">
    <img class="img__user" src="${pageContext.request.contextPath}/static/img/user.png" alt="user.png">
    <div class="info__fields">
        <span>${login}: ${sessionScope.user.login}</span>
        <span>${name}: ${sessionScope.user.name}</span>
        <span>${surname}: ${sessionScope.user.surname}</span>
        <span>${tariff}: ${requestScope.tariff.name}</span>
    </div>
    <div class="change__btns">
        <form method="post" action="controller?command=change-name">
            <button class="change__btn" type="submit">${changeName}</button>
        </form>
        <button class="change__btn" type="submit">${changeSurname}</button>
        <button class="change__btn" type="submit">${changeTariff}</button>
    </div>
    <div class="balance">
         ${balance}: ${sessionScope.user.amount}
    </div>
</div>