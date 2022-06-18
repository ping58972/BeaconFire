<%@include file="head.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <form action="/feedback" method="post">
                    <input type="hidden" name="userId" value="${user.userId}">
                    <div class="form-group">
                        <label>Rating</label>
                        <select id="Rating" class="form-control " name="rating">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option selected value="5">5</option>
                        </select>
                    </div>
                    <div class="form-group green-border-focus">
                        <label>Message</label>
                        <textarea class="form-control" type="text" name="message" placeholder="Write something.."
                                  style="height:200px"></textarea>
                    </div>
                    <div class="form-group btn">
                        <input class="form-control" type="submit" value="Submit">
                    </div>
                </form>

                <c:if test="${isSuccess}"><h4>Thanks for your Feedback!, We will do better.</h4></c:if>
            </div>
        </div>
    </div>
</div>
<%@include file="foot.jsp" %>