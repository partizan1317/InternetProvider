<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="locale" var="loc"/>
<fmt:message bundle="${loc}" key="header.language" var="language"/>
<fmt:message bundle="${loc}" key="header.logo" var="logo"/>
<fmt:message bundle="${loc}" key="header.login" var="login"/>
<fmt:message bundle="${loc}" key="header.dropdown.ru" var="rus"/>
<fmt:message bundle="${loc}" key="header.dropdown.eng" var="eng"/>
<fmt:message bundle="${loc}" key="header.dropdown.by" var="by"/>
<fmt:message bundle="${loc}" key="header.logout" var="logout"/>
<header>
    <div class="header__inner">
        <a class="header__logo" href="#">${logo}</a>
        <nav class="nav__header">
            <div class="dropdown">
                <form method="post" action="controller?command=language-change" id="language-change">
                    <button class="dropbtn">${language}</button>
                    <div class="dropdown-content">
                        <button type="submit" name="locale" value="en_US" href="#">${eng}</button>
                        <button type="submit" name="locale" value="ru_RU" href="#">${rus}</button>
                        <button type="submit" name="locale" value="bel_BEL" href="#">${by}</button>
                    </div>
                </form>
            </div>
            <c:if test="${!sessionScope.isLoggedIn}">
                <a class ="nav__link" href="#">${logout}</a>
            </c:if>
            <c:if test="${sessionScope.isLoggedIn}">
                <a class ="nav__link" href="#">${logout}</a>
            </c:if>
        </nav>
    </div>
</header>