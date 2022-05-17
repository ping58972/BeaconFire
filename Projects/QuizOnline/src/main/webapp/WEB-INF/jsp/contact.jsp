<%@include file="head.jsp" %>
<div class="container">
    <form action="/contact">
        <div class="form-group">
            <label>First Name</label>
            <input type="text" name="firstName" placeholder="Your name..">
        </div>
        <div class="form-group">
            <label>Last Name</label>
            <input type="text" name="lastName" placeholder="Your last name..">
        </div>
        <div class="form-group">
            <label>Subject</label>
            <input name="subject" placeholder="Write something.."></input>
        </div>
        <div class="form-group">
            <label>Message</label>
            <textarea name="message" placeholder="Write something.." style="height:200px"></textarea>
        </div>
        <div class="form-group">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
<%@include file="foot.jsp" %>