<%@include file="head.jsp" %>
<div class="container">
    <table class="table">
        <h3>All Question</h3>
        <thead>
        <tr>
            <th scope="col">ID</th> &emsp; &emsp;
            <th scope="col">Category</th> &emsp; &emsp; &emsp;
            <th scope="col">Description</th> &emsp; &emsp; &emsp;
            <th scope="col">Type</th> &emsp; &emsp; &emsp;
            <th scope="col">Choice</th> &emsp; &emsp; &emsp;
            <th scope="col">Status</th>
            <th scope="col">Operation</th>
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
                <td><a href="/admin/question/change/${question.questionId}">Change Statue</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<hr>
<p class="text-center">
    End</p>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <h3>Create a Question</h3>
                <form action="/admin/question/all" method="post">
                    <div class="form-group">
                        <label>Question</label>
                        <textarea class="form-control" name="description" placeholder="Write a Question"
                                  style="height:50px"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select id="categoryId" class="form-control " name="categoryId">
                            <c:forEach items="${categories}" var="cate" varStatus="loop">
                                <option value="${cate.categoryId}">${cate.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Type</label>
                        <select id="type" class="form-control " name="type">
                            <option value="SHORT_ANSWER">Short Answer</option>
                            <option value="MULTIPLE_CHOICE">Multiple Choice</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Correct Answer</label>
                        <input class="form-control" type="text" name="correctAnswer">
                    </div>
                    <div class="form-group">
                        <label>choice1</label>
                        <input class="form-control" type="text" name="choice1">
                    </div>
                    <div class="form-group">
                        <label>choice2</label>
                        <input class="form-control" type="text" name="choice2">
                    </div>
                    <div class="form-group">
                        <label>choice3</label>
                        <input class="form-control" type="text" name="choice3">
                    </div>


                    <div class="form-group">
                        <input type="submit" value="Create New Question">
                        <%--                        <a class="btn btn-primary btn-block" href="/admin/question/new"></a>--%>
                    </div>
                </form>
                <c:if test="${isSuccess}"><h4>New Question Created!</h4></c:if>

            </div>
        </div>
    </div>
</div>
<%@include file="foot.jsp" %>