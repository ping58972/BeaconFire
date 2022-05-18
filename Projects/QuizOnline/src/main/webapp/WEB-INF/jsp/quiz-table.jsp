<%@include file="head.jsp" %>


<div class="container">
    <div class="card text-center">
        <form method="post" action="/quiz/table/${cateId}/question/${page_num}">
            <div class="card-header">
                <h3>Quiz Name: ${takeQuiz.quizName}</h3>
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


            <button class="btn btn-primary" type="submit">Save -> Next</button>
            <c:if test="${isSuccess}"> <span>Answer for Question # ${page_num} has Saved!</span></c:if>
        </form>
    </div>
</div>

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

<%--dfk
<style>
    #my-popup {
        Width: 600px;
        Height: 400px;
        Background: gray;
        Box-sizing: border-box; /* for inside padding */
        Padding: 10px;

        /* for center */
        Position: absolute;
        top: 50%;
        left: 50%;
        Transform: translate(-50%, -50%);

        /* for hider */
        display: none;
    }
</style>
<div id="my-popup">
    <button id=”close-bnt”>X</button>
    // your content goes here
    <button onclick="ClosePopUp()">Close</button>
</div>
<script>
    function showPopUp() {
        my_popup.style.display = "block";
    }

    function hidePopUp() {
        my_popup.style.display = "none";
    }

    // function showPopUp() {
    //     my_popup.style.display = "block";
    // }
    //
    // setTimeout(showPopUp, 60000);

    // function ClosePopUp() {
    //     my_popup.style.display = "none";
    // }

    setTimeout(ClosePopUp, 120000)

    function ClosePopUp() {
        my_popup.style.display = "none";
    }

    var time_in_sec = 0;
    var start_calling = ‘’;

    function showPopUp() {
        // start time update after popup modal show
        start_calling = setInterval(countdownTime, 1000); // call every one sec
    }

    function countdownTime() {
        time_in_sec++;
        html_tag.innerHTML = time_in_sec; // show time in html tag
        if (time_in_sec == 10) {
            clearInterval(start_calling) // stop calling
            ClosePopUp();
            ;
        }
    }
</script>

--%>