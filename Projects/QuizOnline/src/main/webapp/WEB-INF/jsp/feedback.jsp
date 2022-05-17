<%@include file="head.jsp" %>
<div class="container">
    <form action="/feedback">
        <input type="hidden" name="userId" value="${user.userId}">
        <div class="form-group">
            <label>Rating</label>
            <select id="Rating" name="rating">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
        </div>
        <div class="form-group">
            <label>Message</label>
            <textarea type="text" name="message" placeholder="Write something.." style="height:200px"></textarea>
        </div>
        <div class="form-group">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
<%@include file="foot.jsp" %>