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
<fmt:message bundle="${loc}" key="adminRegisterUserContainer.label" var="label"/>
<fmt:message bundle="${loc}" key="adminRegisterUserContainer.name" var="name"/>
<fmt:message bundle="${loc}" key="adminRegisterUserContainer.exampleName" var="exampleName"/>
<fmt:message bundle="${loc}" key="adminRegisterUserContainer.surname" var="surname"/>
<fmt:message bundle="${loc}" key="adminRegisterUserContainer.exampleSurname" var="exampleSurname"/>
<fmt:message bundle="${loc}" key="adminRegisterUserContainer.login" var="login"/>
<fmt:message bundle="${loc}" key="adminRegisterUserContainer.exampleLogin" var="exampleLogin"/>
<fmt:message bundle="${loc}" key="adminRegisterUserContainer.password" var="password"/>
<fmt:message bundle="${loc}" key="adminRegisterUserContainer.examplePassword" var="examplePassword"/>
<fmt:message bundle="${loc}" key="adminRegisterUserContainer.registerBtn" var="registerBtn"/>

<div class="container">
    <label class="register__label">${label}</label>
    <form method="post" action="controller?command=register-user";
        <div class="form">
            <div class="labels">
                <label class="label">${name}</label>
                <label class="label">${surname}</label>
                <label class="label">${login}</label>
                <label class="label">${password}</label>
            </div>
            <div class="fields">
                <input class="input__field" type="text" placeholder="${exampleName}" name="name">
                <input class="input__field" type="text" placeholder="${exampleSurname}" name="surname">
                <input class="input__field" type="text" placeholder="${exampleLogin}" name="login">
                <input class="input__field" type="text" placeholder="${examplePassword}" name="password">
            </div>
        </div>
    <button class="register__btn" type="submit">${registerBtn}</button>
</div>
