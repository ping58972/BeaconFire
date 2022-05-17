<%@include file="head.jsp" %>
<div class="container">
    <form method="post" action="">
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text"
                   class="form-control"
                   id="email"
                   name="email"
                   placeholder="Enter Your Email">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password"
                   class="form-control"
                   id="password"
                   name="password"
                   placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <br>
    <a class="btn" href="/register">Register to take a Quiz?</a>
</div>
<%@include file="foot.jsp" %>


