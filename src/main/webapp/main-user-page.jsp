<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main-user-page-style.css">
</head>
<body>
    <jsp:include page="/WEB-INF/components/header.jsp"/>
    <main>
        <div class="nav__section">
            <div class="btns">
                <button class="nav__btn" type="submit">Profile</button>
                <button class="nav__btn" type="submit">Refill</button>
                <button class="nav__btn" type="submit">Tariffs</button>
            </div>
        </div>
        <div class="container">
            <span>Welcome back!</span>
        </div>
    </main>

    <footer>

    </footer>


</body>
</html>