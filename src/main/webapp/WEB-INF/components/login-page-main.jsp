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
<fmt:message bundle="${loc}" key="header.welcome" var="welcome"/>
<fmt:message bundle="${loc}" key="header.btn.submit" var="submit"/>
<main>
    <form class="login__form" method="post" action="controller?command=login">
        <div class="login__title">${welcome}</div>
            <input class="login" type="text" placeholder="login" name="login"><br>
            <input class="password" type="password" placeholder="password" name="password"><br>
            <input class="btn__sumbit" type="submit" value=${submit}>
    </form>
</main>