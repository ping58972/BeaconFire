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
        <p></p>
        <%--        <div class="col-md-6">--%>
        <%--            <div class="card"><p class="text-center">--%>
        <%--                <a class="btn btn-primary" href="/admin/categories/new">Create a New Category</a></p></div>--%>
        <%--        </div>--%>
    </div>
</div>

<hr>
<p class="text-center">
    End</p>
<%@include file="foot.jsp" %>