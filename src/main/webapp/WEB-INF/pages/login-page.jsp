<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/components/header.jsp"/>
    <main>
        <form class="login__form" method="post" action="controller?command=login">
            <div class="login__title">Welcome</div>
            <input class="login" type="text" placeholder="login" name="login"><br>
            <input class="password" type="password" placeholder="password" name="password"><br>
            <input class="btn__sumbit" type="submit" value="Submit">
        </form>
    </main>

</body>
</html>   