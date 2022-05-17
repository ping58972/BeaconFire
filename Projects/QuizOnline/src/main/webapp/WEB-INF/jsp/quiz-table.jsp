<%@include file="head.jsp" %>


<div class="container">
    <form method="post" action="/quiz/table/${cateId}/question/${page_num}">
        <h3>Take the Quiz: ${takeQuiz.quizName} + ${takeQuiz.quizId}</h3>
        <div class="card" style="width: 50rem; height: 15rem;">
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-9">
                        <h5 class="card-title"> ${quizQuestion.question.description} </h5>
                        <div class="row">
                            <c:forEach var="entry" items="${quizQuestion.question.choiceMap}">
                                <div class="col-8 col-sm-6">

                                    <c:if test="${quizQuestion.question.type eq 'MULTIPLE_CHOICE'}">
                                        <c:if test="${entry.key == quizQuestion.userChoiceId}">
                                            <input type="radio" name="userChoiceId" class="form-check-input"
                                                   value="${entry.key}" checked/>${entry.value.choiceDesription}
                                        </c:if>
                                        <c:if test="${entry.key != quizQuestion.userChoiceId}">
                                            <input type="radio" name="userChoiceId" class="form-check-input"
                                                   value="${entry.key}"/>${entry.value.choiceDesription}

                                        </c:if>
                                        <input type="hidden" name="userShortAnswer" value="">
                                    </c:if>
                                    <c:if test="${quizQuestion.question.type eq 'SHORT_ANSWER'}">
                                        <%--                                        <c:if test="${}"></c:if>--%>
                                        <input type="text" name="userShortAnswer" class="form-control"
                                               value="${quizQuestion.userShortAnswer}">
                                        <input type="hidden" name="userChoiceId" value="0">
                                    </c:if>
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                </div>
            </div>
        </div>


        <button class="btn btn-primary" type="submit">Save -> Next</button>
    </form>


    <nav aria-label="...">
        <ul class="pagination pagination-lg">
            <c:forEach begin="1" end="${takeQuiz.quizQuestionMap.size()}" varStatus="loop">
                <c:if test="${page_num == loop.index}">
                    <li class="page-item active" aria-current="page">
                        <span class="page-link">${loop.index}<span class="sr-only"></span></span>
                    </li>
                </c:if>
                <c:if test="${page_num != loop.index}">
                    <li class="page-item"><a class="page-link"
                                             href="/quiz/table/${cateId}/question/${loop.index}">${loop.index}</a>
                    </li>
                </c:if>

            </c:forEach>
        </ul>
    </nav>

    <a class="btn btn-warning" href="/quiz/result/${takeQuiz.quizId}" type="submit">Get Result</a>
</div>
<%@include file="foot.jsp" %>