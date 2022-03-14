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
<fmt:message bundle="${loc}" key="refillContainer.amount" var="amount"/>
<fmt:message bundle="${loc}" key="refillContainer.topUp" var="topUp"/>
<fmt:message bundle="${loc}" key="refillContainer.balance" var="balance"/>
<div class="container">
    <form method="post" action="controller?command=refill">
        <label class="label__refill">${amount}</label>
        <input class="input__field" type="number" placeholder="0.00" name="amount">
        <button class="refill__btn" type="submit" type="submit" value="Refill">${topUp}</button>
        <img class="img__money" src="${pageContext.request.contextPath}/static/img/money.png" alt="money.png">
    </form>
    <div class="balance">
        ${balance}${sessionScope.user.amount}
    </div>
</div>