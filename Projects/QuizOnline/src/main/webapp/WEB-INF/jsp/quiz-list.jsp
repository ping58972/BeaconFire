<%@include file="head.jsp" %>
<div class="container">
    <h3>All Quiz</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th> &emsp; &emsp;
            <th scope="col">Name</th> &emsp; &emsp; &emsp;
            <th scope="col">Category</th> &emsp; &emsp; &emsp;
            <th scope="col">Start Time</th> &emsp; &emsp; &emsp;
            <th scope="col">End Time</th> &emsp; &emsp; &emsp;
            <th scope="col">Score</th> &emsp; &emsp; &emsp;
            <th scope="col">Pass/Fail</th> &emsp; &emsp; &emsp;
            <th scope="col">Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${quizzes}" var="quiz" varStatus="loop">
            <tr>
                <th>${quiz.quizId}</th> &emsp; &emsp;
                <td>${quiz.quizName}</td> &emsp; &emsp;&emsp;
                <td>${quiz.categoryName}</td> &emsp; &emsp; &emsp;
                <td>${quiz.startTime}</td> &emsp; &emsp; &emsp;
                <td>${quiz.endTime}</td> &emsp; &emsp;
                <td>${quiz.score}/10</td>
                <td><c:if test="${quiz.score < 6}"> Fail</c:if>
                    <c:if test="${quiz.score >= 6}"> Pass</c:if></td>
                <td><a href="/quiz/result/${quiz.quizId}"> Result Detail</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<hr>
<p class="text-center">
    End</p>
<%@include file="foot.jsp" %>