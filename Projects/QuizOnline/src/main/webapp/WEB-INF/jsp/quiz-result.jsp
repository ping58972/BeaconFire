<%@include file="head.jsp" %>
<div class="container">
    <h3>Your Quiz Result: ${quizResult.score} / 10 </h3>
    <c:forEach var="quizQuestion" items="${quizQuestions}">
        <div class="card" style="width: 35rem; height: 15rem;">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-9">
                        <h5 class="card-title"> ${quizQuestion.question.description} </h5>
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
                </div>
            </div>
        </div>
        <br/>
        <br/>
    </c:forEach>
</div>
<%@include file="foot.jsp" %>