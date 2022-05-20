<%@include file="head.jsp" %>

<jsp:useBean id="dateValue" class="java.util.Date"/>
<jsp:setProperty name="dateValue" property="time" value="${h.time}"/>
<div class="container">
    <div class="card text-center">
        <span>${dateValue}</span>
        <form method="post" action="/quiz/table/${cateId}/question/${page_num}">
            <div class="card-header">
                <h3>Quiz Name: ${takeQuiz.quizName}</h3>
                <div id="countdown"></div>
            </div>
            <div class="card-body">
                <h3 class="card-text"> ${quizQuestion.question.description} </h3>
                <p></p>
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
                        </div>
                        <c:if test="${quizQuestion.question.type eq 'SHORT_ANSWER'}">
                            <%--                                        <c:if test="${}"></c:if>--%>
                            <input class="card-text" type="text" name="userShortAnswer" class="form-control"
                                   value="${quizQuestion.userShortAnswer}">
                            <input type="hidden" name="userChoiceId" value="0">
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <br><c:if test="${isSuccess}"><p
                style="color: blue">Answer for Question #${page_num -1} has Saved!</p></c:if>
            <button class="btn btn-primary" type="submit">Save -> Next</button>

        </form>

    </div>
</div>
<br>
<div class="container">
    <div class="card text-center">
        <nav aria-label="...">
            <ul class="pagination pagination-lg">
                <%--                <c:forEach begin="1" end="${takeQuiz.quizQuestionMap.size()}" varStatus="loop">--%>
                <c:forEach var="quizQuest" items="${quizQuestions}">
                    <c:if test="${page_num == quizQuest.orderNum}">
                        <li class="page-item active" aria-current="page">
                            <span class="page-link">${quizQuest.orderNum}<span class="sr-only"></span></span>
                        </li>
                    </c:if>
                    <c:if test="${page_num != quizQuest.orderNum}">
                        <c:choose>
                            <c:when test="${quizQuest.marked}">
                                <li class="page-item"><a class="page-link"
                                                         href="/quiz/table/${cateId}/question/${quizQuest.orderNum}"><span
                                        style="color: green">${quizQuest.orderNum}</span></a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link"
                                                         href="/quiz/table/${cateId}/question/${quizQuest.orderNum}">${quizQuest.orderNum}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
        <br>
        <a class="btn btn-warning" id="get-result" href="/quiz/result/${takeQuiz.quizId}" type="submit">Get Result</a>
    </div>
</div>

<button id="popup" hidden type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    Launch demo modal
</button>
<!-- Modal -->
<div class="modal fade" id="exampleModal" data-backdrop="false" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Your Quiz is Over</h5>
            </div>
            <div class="modal-body">
                Your Time is Run out.
            </div>
            <div class="modal-footer">
                <a class="btn btn-warning" href="/quiz/result/${takeQuiz.quizId}" type="submit">Get Result</a>
            </div>
        </div>
    </div>
</div>

<script>
    $('#myModal').on('shown.bs.modal', function () {
        $('#myInput').trigger('focus')
    })
    var timeleft = 10;
    var te = ${page_num};
    var downloadTimer = setInterval(function () {
        if (timeleft <= 0) {
            clearInterval(downloadTimer);
            document.getElementById("countdown").innerHTML = "NONE";
            // document.getElementById("popup").click();

        } else {
            document.getElementById("countdown").innerHTML = "" + te + " Time Remain:" + timeleft;
        }
        timeleft -= 1;
    }, 1000);
</script>
<%@include file="foot.jsp" %>
