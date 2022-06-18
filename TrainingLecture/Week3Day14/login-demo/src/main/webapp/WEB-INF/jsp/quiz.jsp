<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quiz</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form method="post" action="quiz">
        <h3>What is 1 + 1</h3>
        <c:forEach begin="0" end="3" varStatus="loop">
            <div class="form-check">
                <label class="form-check-label">
                    <input type="radio" name="math" class="form-check-input" value="${loop.index}"/>${loop.index}
                </label>
            </div>
        </c:forEach>
        <button class="btn btn-primary" type="submit">submit</button>
    </form>
</div>
</body>
</html>
