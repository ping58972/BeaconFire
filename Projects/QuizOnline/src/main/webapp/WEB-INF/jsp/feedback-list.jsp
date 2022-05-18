<%@include file="head.jsp" %>
<div class="container">
    <h3>All Feedback</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Message</th>
            <th scope="col">Rating</th>
            <th scope="col">DateTime</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="feedback" items="${feedbacks}">
            <tr>
                <th scope="row">${feedback.feedbackId}</th>
                <td>${feedback.message}</td>
                <td>${feedback.rating}</td>
                <td>${feedback.feedbackTime}</td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div/>
    <hr>
    <p class="text-center">
        End</p>
<%@include file="foot.jsp" %>