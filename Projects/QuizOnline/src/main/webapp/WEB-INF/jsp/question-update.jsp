<%@include file="head.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <h3>Update a Question #${question.questionId}</h3>
                <form action="/admin/question/update/${question.questionId}" method="post">
                    <div class="form-group">
                        <label>Question</label>
                        <textarea class="form-control" name="description" placeholder="Write a Question"
                                  style="height:50px">${question.description}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select id="categoryId" class="form-control " name="categoryId">
                            <c:forEach items="${categories}" var="cate" varStatus="loop">
                                <option value="${cate.categoryId}"
                                        <c:if test="${cate.categoryId == question.categoryId}">selected</c:if>
                                >${cate.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Type</label>
                        <select id="type" class="form-control " name="type">
                            <option value="SHORT_ANSWER"
                                    <c:if test="${question.type eq 'SHORT_ANSWER'}">selected</c:if>

                            >Short Answer
                            </option>
                            <option value="MULTIPLE_CHOICE"
                                    <c:if test="${question.type eq 'MULTIPLE_CHOICE'}">selected</c:if>
                            >Multiple Choice
                            </option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Correct Answer</label>
                        <input class="form-control" type="text" name="correctAnswer"
                               value="${question.correctAnswer}">
                    </div>
                    <div class="form-group">
                        <label>choice1</label>
                        <input class="form-control" type="text" name="choice1"
                               value="${question.choice1}">
                    </div>
                    <div class="form-group">
                        <label>choice2</label>
                        <input class="form-control" type="text" name="choice2"
                               value="${question.choice2}">
                    </div>
                    <div class="form-group">
                        <label>choice3</label>
                        <input class="form-control" type="text" name="choice3"
                               value="${question.choice3}">
                    </div>


                    <div class="form-group">
                        <input type="submit" value="Update">
                        <%--                        <a class="btn btn-primary btn-block" href="/admin/question/new"></a>--%>
                    </div>
                </form>
                <c:if test="${isSuccess}"><h4>The Question Updated!</h4></c:if>

            </div>
        </div>
    </div>
</div>


<%@include file="foot.jsp" %>