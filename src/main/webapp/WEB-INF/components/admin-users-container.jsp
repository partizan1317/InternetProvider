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
<fmt:message bundle="${loc}" key="adminUsersContainer.userLogin" var="login"/>
<fmt:message bundle="${loc}" key="adminUsersContainer.userName" var="name"/>
<fmt:message bundle="${loc}" key="adminUsersContainer.userLastName" var="lastName"/>
<fmt:message bundle="${loc}" key="adminUsersContainer.balance" var="balance"/>
<fmt:message bundle="${loc}" key="adminUsersContainer.isBlocked" var="isBlock"/>
<fmt:message bundle="${loc}" key="adminUsersContainer.block" var="block"/>
<c:set var="number" value="0" scope="request"/>
<div class="container">
    <table class="users__table" border="1">
        <tr>
            <th>
                №
            </th>
            <th>
                ${login}
            </th>
            <th>
                ${name}
            </th>
            <th>
                ${lastName}
            </th>
            <th>
                ${balance}
            </th>
            <th>
                ${isBlock}
            </th>
            <th>
                ${block}
            </th>
        </tr>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td>
                    <c:set var="number" value="${number + 1}" scope="request"/>
                    ${number}
                </td>
                <td>
                    ${user.login}
                </td>
                <td>
                    ${user.name}
                </td>
                <td>
                    ${user.surname}
                </td>
                <td>
                    ${user.amount}
                </td>
                <td>
                    ${user.blocked}
                </td>
                <td>
                    delete
                </td>
            </tr>
        </c:forEach>
    </table>
</div>