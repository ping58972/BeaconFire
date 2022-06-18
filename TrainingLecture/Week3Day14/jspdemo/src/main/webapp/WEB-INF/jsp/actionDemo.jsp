<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Action Demo</title>
</head>

<body>
    <h1>Action Demo</h1>
    <jsp:include page="toBeIncludedInActionDemo.jsp">
        <jsp:param name="greeting" value="Hello from the other side!"/>
    </jsp:include>
</body>

</html>