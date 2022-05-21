<%@include file="head.jsp" %>

<div class="container">
    <br>
    <p class="text-center">
        Choose a Category To Quiz</p>

    <div class="row justify-content-center">


        <c:forEach items="${categories}" var="cate" varStatus="loop">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                            ${cate.name} Category
                    </div>
                    <div class="card-body">
                        <img class="card-img-top" src="${cate.imageUrl}" alt="Card image cap"
                             style="max-width: 200px; max-height: 150px">
                        <a href="/quiz/table/${cate.categoryId}/new" class="btn btn-primary">Take a ${cate.name}'s
                            Quiz</a>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>

<hr>
<div class="container">
    <h3 class="text-center">
        Your Quiz Result List</h3>
    <div class="form-group">
        <label>Category</label>
        <select id="categoryId" class="form-control " name="categoryId"
                onchange="if (this.value) window.location.href=this.value">
            <option value="/quiz"
                    <c:if test="${categoryId ==0}">selected</c:if>
            >all
            </option>
            <c:forEach items="${categories}" var="cate" varStatus="loop">

                <option value="/quiz/results/${cate.categoryId}"
                        <c:if test="${categoryId == cate.categoryId}">selected</c:if>
                >${cate.name}</option>
            </c:forEach>
        </select>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th> &emsp; &emsp;
            <th scope="col">Name</th> &emsp; &emsp; &emsp;
            <th scope="col">Category</th> &emsp; &emsp; &emsp;
            <th scope="col">Start Time</th> &emsp; &emsp; &emsp;
            <th scope="col">End Time</th> &emsp; &emsp; &emsp;
            <th scope="col">Score</th> &emsp; &emsp; &emsp;
            <th scope="col">Pass/Fail</th>
            <th scope="col">Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${quizzes}" var="quiz">
            <tr>
                <td>${quiz.quizId}</td> &emsp; &emsp;
                <td>${quiz.quizName}</td> &emsp; &emsp;&emsp;
                <td>${quiz.categoryName}</td> &emsp; &emsp; &emsp;
                <td>${quiz.startTime}</td> &emsp; &emsp; &emsp;
                <td>${quiz.endTime}</td> &emsp; &emsp;
                <td>${quiz.score}/10</td>
                <td><c:if test="${quiz.score < 6}"> Fail</c:if>
                    <c:if test="${quiz.score >= 6}"> Pass</c:if></td>
                <td><a href="/quiz/result/${quiz.quizId}"> More Detail</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="foot.jsp" %>