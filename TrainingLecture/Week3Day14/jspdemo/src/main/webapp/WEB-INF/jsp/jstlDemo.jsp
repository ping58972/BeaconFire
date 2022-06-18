<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSTL Demo</title>
</head>

<body>
<h1>JSTL Demo</h1>

<p>There are ${animals.size()} animals in the zoo.</p>
<p>There are <c:out value="${animals.size()}"/> animals in the zoo.</p>

<c:if test="${animals.size() < 3}"><p>This is a small zoo</p></c:if>

<table>
    <thead>
    <tr>
        <th>Index</th>
        <th>Name</th>
        <th>Is baby animal?</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${animals}" var="animal" varStatus="loop">
        <tr>
            <td>${loop.index}</td>
            <td>${animal.name}</td>
            <td>
                <c:choose>
                    <c:when test="${animal.age <= 10}">Yes</c:when>
                    <c:otherwise>No</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>