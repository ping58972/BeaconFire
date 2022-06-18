<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Demo</title>
</head>
<body>
<h1>JSP Demo</h1>
<%--Declaration--%>
<%! int num = 4; %>

<%
    out.println("<p>The variable declared in jsp declaration is: " + num + "</p>");
    out.println("<p>The value of the model attribute is: " + request.getAttribute("name") + "</p>");
%>

<p>
    num * 10 = <%= num * 10 %>
</p>
</body>
</html>