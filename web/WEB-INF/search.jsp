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
        <h3>Welcome to My awesome project</h3>
        <h2>Bonjour
            <%
                String attribut = (String) request.getAttribute("user");
                out.println(attribut);
            %>
        </h2>
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

    <h1>Result</h1>
    <table class="table table-stripped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Login</th>
        </tr>
        </thead>

        <c:forEach items="${users}" var="search">
            <tr>
                <td><c:out value="${search.id}"/></td>
                <td><c:out value="${search.login}"/></td>
                <td><a class="btn btn-info" role="button" href="/modifier?id=${search.id}">Modifier</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
