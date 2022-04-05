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
<fmt:message bundle="${loc}" key="adminUsersContainer.isBlocked" var="isBlocked"/>
<fmt:message bundle="${loc}" key="adminUsersContainer.block" var="block"/>

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
                        ${isBlocked}
                    </th>
                    <th>
                        ${block}
                    </th>
                    </tr>
                    <tr>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        partizan
                    </td>
                    <td>
                        Evgeniy
                    </td>
                    <td>
                        Sobol
                    </td>
                    <td>
                        1000
                    </td>
                    <td>
                        Is blocked
                    </td>
                    <td>
                        delete
                    </td>
                </tr>
            </table>
        </div>