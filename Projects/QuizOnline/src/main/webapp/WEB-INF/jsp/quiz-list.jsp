<%@include file="head.jsp" %>
<div class="container">
    <h3>Quiz Result List</h3>
    <label>Category</label>
    <select id="categoryId" class="form-control " name="categoryId"
            onchange="if (this.value) window.location.href=this.value">
        <option value="/admin/quiz/all"
                <c:if test="${categoryId ==0}">selected</c:if>
        >all
        </option>
        <c:forEach items="${categories}" var="cate" varStatus="loop">

            <option value="/admin/quiz/${cate.categoryId}"
                    <c:if test="${categoryId == cate.categoryId}">selected</c:if>
            >${cate.name}</option>
        </c:forEach>
    </select>
    <label>Fail/Pass</label>
    <select id="resultId" class="form-control " name="resultId"
            onchange="if (this.value) window.location.href=this.value">
        <option value="/admin/quiz/all"
                <c:if test="${empty tf}">selected</c:if>
        >
            all
        </option>
        <option value="/admin/quiz/result/0"
                <c:if test="${tf == 0}">selected</c:if>
        >Fail
        </option>
        <option value="/admin/quiz/result/1"
                <c:if test="${tf == 1}">selected</c:if>
        >Pass
        </option>
    </select>
    <br>
    <label>Search By Quiz Name</label>
    <div class="form-group">
        <form action="/admin/quiz/result/search" method="post">
            <input type="text" name="search">
            <button type="submit">Search</button>
        </form>
    </div>
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