<%@include file="head.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <form action="/contact" method="post">
                    <div class="form-group">
                        <label>First Name</label>
                        <input class="form-control" type="text" name="firstName" placeholder="Your name..">
                    </div>
                    <div class="form-group">
                        <label>Last Name</label>
                        <input class="form-control" type="text" name="lastName" placeholder="Your last name..">
                    </div>
                    <div class="form-group">
                        <label>Subject</label>
                        <input class="form-control" name="subject" placeholder="Write something.."></input>
                    </div>
                    <div class="form-group">
                        <label>Message</label>
                        <textarea class="form-control" name="message" placeholder="Write something.."
                                  style="height:200px"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Submit">
                    </div>
                </form>
                <c:if test="${isSuccess}"><h4>Thanks for Contact us!, We will Contact back Soon.</h4></c:if>

            </div>
        </div>
    </div>
</div>
<%@include file="foot.jsp" %>