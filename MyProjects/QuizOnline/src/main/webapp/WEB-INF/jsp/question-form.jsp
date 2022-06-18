<%@include file="head.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <h3>Create a Question</h3>
                <form action="/admin/question/all" method="post">
                    <div class="form-group">
                        <label>Question</label>
                        <textarea class="form-control" name="description" placeholder="Write a Question"
                                  style="height:50px"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select id="categoryId" class="form-control " name="categoryId">
                            <c:forEach items="${categories}" var="cate" varStatus="loop">
                                <option value="${cate.categoryId}">${cate.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Type</label>
                        <select id="type" class="form-control " name="type">
                            <option value="SHORT_ANSWER">Short Answer</option>
                            <option value="MULTIPLE_CHOICE">Multiple Choice</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Correct Answer</label>
                        <input class="form-control" type="text" name="correctAnswer"
                        >
                    </div>
                    <div class="form-group">
                        <label>choice1</label>
                        <input class="form-control" type="text" name="choice1">
                    </div>
                    <div class="form-group">
                        <label>choice2</label>
                        <input class="form-control" type="text" name="choice2">
                    </div>
                    <div class="form-group">
                        <label>choice3</label>
                        <input class="form-control" type="text" name="choice3">
                    </div>


                    <div class="form-group">
                        <input type="submit" value="Create New Question">
                        <%--                        <a class="btn btn-primary btn-block" href="/admin/question/new"></a>--%>
                    </div>
                </form>
                <c:if test="${isSuccess}"><h4>New Question Created!</h4></c:if>

            </div>
        </div>
    </div>
</div>


<%@include file="foot.jsp" %>