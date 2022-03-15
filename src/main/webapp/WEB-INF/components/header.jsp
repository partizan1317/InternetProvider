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
<fmt:message bundle="${loc}" key="header.language" var="lang"/>
<fmt:message bundle="${loc}" key="header.logo" var="logo"/>
<fmt:message bundle="${loc}" key="header.login" var="login"/>
<fmt:message bundle="${loc}" key="header.dropdown.ru" var="rus"/>
<fmt:message bundle="${loc}" key="header.dropdown.eng" var="eng"/>
<fmt:message bundle="${loc}" key="header.dropdown.by" var="by"/>
<fmt:message bundle="${loc}" key="header.logout" var="logout"/>
<header>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <div class="header__inner">
        <c:if test="${sessionScope.isLoggedIn}">
            <a class="header__logo" href="<c:url value="controller?command=main-page"/>">${logo}</a>
        </c:if>
        <c:if test="${!sessionScope.isLoggedIn}">
            <a class="header__logo" href="<c:url value="controller?command=login-page"/>">${logo}</a>
        </c:if>
        <nav class="nav__header">
            <div class="dropdown">
                <form method="post" action="controller?command=language-change">
                    <button class="dropbtn">${lang}</button>
                    <div class="dropdown-content">
                        <button type="submit" name="locale" value="en_US">${eng}</button>
                        <button type="submit" name="locale" value="ru_RU">${rus}</button>
                        <button type="submit" name="locale" value="by_BY">${by}</button>
                    </div>
                </form>
            </div>
            <c:if test="${!sessionScope.isLoggedIn}">
                <a class ="nav__link" href="#">${login}</a>
            </c:if>
            <c:if test="${sessionScope.isLoggedIn}">
                <a class ="nav__link" href="<c:url value="controller?command=logout"/>">${logout}</a>
            </c:if>
        </nav>
    </div>
</header>