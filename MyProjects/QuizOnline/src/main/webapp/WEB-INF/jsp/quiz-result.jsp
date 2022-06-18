<%@include file="head.jsp" %>
<div class="container">

    <div class="card text-center">
        <div class="card-header">
            ${quizResult.quizName} Quizzes
        </div>
        <div class="card-body">
            <p class="card-text">Category: ${quizResult.categoryName}</p>
            <p class="card-text">User Name: ${quizResult.userName}</p>
            <p class="card-text">Start Time: ${quizResult.startTime}</p>
            <p class="card-text">End Time: ${quizResult.endTime}</p>
            <c:if test="${user.admin}"><a href="/admin/quiz/all" class="btn btn-primary">Back Home Page</a></c:if>
            <c:if test="${not user.admin}"><a href="/quiz" class="btn btn-primary">Back Home Page</a></c:if>

        </div>
        <div class="card-footer text-muted">
            <h5 class="card-title">Score: ${quizResult.score} / 10
                <c:if test="${quizResult.score < 6}"> Fail</c:if>
                <c:if test="${quizResult.score >= 6}"> Pass</c:if>
            </h5>
        </div>
    </div>
    <hr>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <c:forEach var="quizQuestion" items="${quizQuestions}">
                <div class="card" style="width: 35rem; height: 15rem;">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-9">
                                <h5 class="card-title"> ${quizQuestion.question.description} </h5>
                                <hr>
                                <div class="row">
                                    <c:forEach var="entry" items="${quizQuestion.question.choiceMap}">
                                        <div class="col-8 col-sm-6">
                                            <c:if test="${quizQuestion.question.type eq 'MULTIPLE_CHOICE'}">
                                                <c:if test="${entry.key == quizQuestion.userChoiceId}">
                                                    &#9677; ${entry.value.choiceDesription}
                                                </c:if>
                                                <c:if test="${entry.key != quizQuestion.userChoiceId}">
                                                    ${entry.value.choiceDesription}

                                                </c:if>
                                                <c:if test="${entry.value.correct }">&#10003;</c:if>
                                            </c:if>
                                            <c:if test="${quizQuestion.question.type eq 'SHORT_ANSWER'}">

                                                <input type="text" name="userShortAnswer" class="form-control"
                                                       value="${quizQuestion.userShortAnswer}" readonly>
                                                <p>The answer is: ${entry.value.choiceDesription}</p>
                                            </c:if>
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                            <p></p>
                            <h6
                                    <c:if test="${quizQuestion.correct}">style="color: blue" </c:if>
                                    <c:if test="${not quizQuestion.correct}">style="color: red" </c:if>
                            >${quizQuestion.message}</h6>
                        </div>
                    </div>
                </div>
                <br>
            </c:forEach>
        </div>
    </div>
    <br/>
    <br/>

</div>
<hr>
<p class="text-center">
    End</p>
<%@include file="foot.jsp" %>