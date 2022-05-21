<%@include file="head.jsp" %>
<div class="container">
    <table class="table table-striped">
        <h3>All Question</h3>
        <a href="/admin/question/new" type="submit" class="btn btn-info">Create New Question</a>
        <thead>
        <tr>
            <th scope="col">ID</th> &emsp; &emsp;
            <th scope="col">Category</th> &emsp; &emsp; &emsp;
            <th scope="col">Description</th> &emsp; &emsp; &emsp;
            <th scope="col">Type</th> &emsp; &emsp; &emsp;
            <th scope="col">Choice</th> &emsp; &emsp; &emsp;
            <th scope="col">Status</th>
            <th scope="col">Operation</th>
            <th scope="col">Update</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${questions}" var="question" varStatus="loop">
            <tr>
                <td>${question.questionId}</td> &emsp; &emsp;
                <td>${question.categoryName}</td> &emsp;
                <td>${question.description}</td> &emsp; &emsp; &emsp;
                <td>${question.type}</td>

                <td>
                    <c:forEach items="${question.choiceMap}" var="entry" varStatus="loop">
                    <span
                            <c:if test="${entry.value.correct}">style="color: blue" </c:if>
                    >
                           | ${entry.value.choiceDesription}
                    </span>
                    </c:forEach></td>
                <td>${question.active}</td>
                <td><a href="/admin/question/changeState/${question.questionId}">Change Statue</a></td>
                <td><a href="/admin/question/update/${question.questionId}">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<hr>
<p class="text-center">
    End</p>

<%@include file="foot.jsp" %>