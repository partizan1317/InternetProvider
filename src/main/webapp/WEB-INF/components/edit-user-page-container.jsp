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
<fmt:message bundle="${loc}" key="editUserContainer.changeBtn" var="apply"/>
<div class="container">
    <form method="post" action="controller?command=applyChanges">
        <div class="name__container">
            <label>${name}</label>
            <input class="input__field" type="text" placeholder="${requestScope.userName}" name="name">
        </div>
        <div class="surname__container">
            <label>${surname}</label>
            <input class="input__field" type="text" placeholder="${requestScope.userSurname}" name="surname">
        </div>
        <button class="change__btn" type="submit">${apply}</button>
    </form>
</div>