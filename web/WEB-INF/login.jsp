<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div class="container" style="margin-top:65px">
    <div class="jumbotron">
        <h3>Login</h3>
    </div>

    <form method="post" action="/" role="form" class="row">
        <fieldset>
            <div class="form-group col-sm-4">
                <label for="login">Login*</label>
                <input type="text" class="form-control" id="login" name='login'>
                <span class="">${form.errors['login']}</span>
            </div>
            <div class="form-group col-sm-4">
                <label for="password">Password*</label>
                <input type="password" class="form-control" id="password" name="password">
                <span class="">${form.errors['password']}</span>
            </div>
            <div class="col-sm-12">
                <button type="submit" class="btn btn-default">Login</button>
                <a class="btn btn-info" role="button" href="/create">Create Account</a>
            </div>
            <p>${form.result}</p>
        </fieldset>
    </form>
</div>
</body>
</html>
