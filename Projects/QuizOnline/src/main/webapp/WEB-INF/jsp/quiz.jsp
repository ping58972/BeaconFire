<%@include file="head.jsp" %>

<div class="container">
    <h3>Choose a Category To Quiz</h3>
    <c:forEach items="${categories}" var="cate" varStatus="loop">
        <div class="card">
            <div class="card-header">
                    ${cate.name}
            </div>
            <div class="card-body">
                <img class="card-img-top" src="${cate.imageUrl}" alt="Card image cap"
                     style="max-width: 200px; max-height: 150px">
                <a href="/quiz/table/${cate.categoryId}/question/1" class="btn btn-primary">${cate.name}</a>
            </div>
        </div>
    </c:forEach>
</div>
<br> <br>
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
                <td><a href="/quiz/result/${quiz.quizId}"> More Detail</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="foot.jsp" %>