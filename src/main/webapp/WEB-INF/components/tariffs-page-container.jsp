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
<fmt:message bundle="${loc}" key="containerUser.balance" var="balance"/>
<fmt:message bundle="${loc}" key="tariffsContainer.tariff" var="tariff"/>
<fmt:message bundle="${loc}" key="tariffsContainer.price" var="price"/>
<fmt:message bundle="${loc}" key="tariffsContainer.btn.buy" var="buy"/>
<div class="container">
    <c:forEach var="tariffs" items="${requestScope.tariffs}">
        <div class="tariff">
            <img src="${pageContext.request.contextPath}/static/img/flash.png" alt="flash.png">
            <span>${tariff}: ${tariffs.name}</span>
            <span>${price}: ${tariffs.price}</span>
            <button class="buy__btn" type="submit">${buy}</button>
        </div>
    </c:forEach>
    <div class="balance">
        ${balance}: ${sessionScope.user.amount}
    </div>
</div>