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
    <table class="table">
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
        <c:forEach items="${quizzes}" var="quiz" varStatus="loop">
            <tr>
                <td>${quiz.quizId}</td> &emsp; &emsp;
                <td>${quiz.quizName}</td> &emsp; &emsp;&emsp;
                <td>${quiz.categoryName}</td> &emsp; &emsp; &emsp;
                <td>${quiz.startTime}</td> &emsp; &emsp; &emsp;
                <td>${quiz.endTime}</td> &emsp; &emsp;
                <td scope="row">${quiz.score}/10</td>
                <th scope="row"><c:if test="${quiz.score < 6}"> Fail</c:if>
                    <c:if test="${quiz.score >= 6}"> Pass</c:if></th>
                <td><a href="/quiz/result/${quiz.quizId}"> More Detail</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<%@include file="foot.jsp" %>