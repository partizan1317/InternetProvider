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
<fmt:message bundle="${loc}" key="navSectionAdmin.users" var="users"/>
<fmt:message bundle="${loc}" key="navSectionAdmin.register" var="register"/>
<fmt:message bundle="${loc}" key="navSection.tariffs" var="tariffs"/>
<div class="nav__section">
    <div class="btns">
        <form method="post" action="controller?command=admin-users-page">
            <button class="nav__btn" type="submit">${users}</button>
        </form>
        <form method="post" action="controller?command=admin-register-page">
            <button class="nav__btn" type="submit">${register}</button>
        </form>
        <form method="post" action="controller?command=admin-tariffs-page">
            <button class="nav__btn" type="submit">${tariffs}</button>
        </form>
    </div>
</div>