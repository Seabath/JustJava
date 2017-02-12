<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My awesome Project</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container" style="margin-top:65px">
    <div class="jumbotron">
        <h3>Search</h3>
    </div>
    <form method="post" action="/search" role="form" class="row">
        <fieldset>
            <div class="form-group col-sm-4">
                <label for="login">Login</label>
                <input type="text" class="form-control" id="login" name='login'/>
            </div>
            <div class="col-sm-12">
                <button type="submit" class="btn btn-default">Search</button>
            </div>
            <p>${form.result}</p>
        </fieldset>
    </form>

    <c:if test="${users != null}">
        <h1>Result</h1>
        <table class="table table-stripped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Login</th>
            </tr>
            </thead>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.login}"/></td>
                    <td><a class="btn btn-info" role="button" href="/change?id=${user.id}">Modifier</a></td>
                    <c:if test="${sessionUser.id != user.id}">
                        <td><a class="btn btn-danger" role="button" href="/delete?id=${user.id}">Supprimer</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
