<%--
  Created by IntelliJ IDEA.
  User: paxu614
  Date: 10/02/2017
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="header.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />

<div class="container" style="margin-top:65px">
    <div class="jumbotron">
        <h3>Login</h3>
    </div>

    <form role="form" action="javascript:searchTestDatabase();" class="row">
        <div class="form-group col-sm-4">
            <label for="login">Login</label>
            <input type="text" class="form-control" id="p_name" name='name'>
        </div>
        <div class="form-group col-sm-4">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="p_jira" name="jira">
        </div>
        <div class="col-sm-12">
            <button type="submit" class="btn btn-default">Login</button>
        </div>
    </form>
</div>
</body>
</html>
