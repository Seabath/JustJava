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
</div>
</body>
</html>
