<%@include file="head.jsp" %>

<div class="container">
    <h3>All Contacts</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th> &emsp; &emsp;
            <th scope="col">Full Name</th> &emsp; &emsp; &emsp;
            <th scope="col">Subject</th> &emsp; &emsp; &emsp;
            <th scope="col">Message Time</th> &emsp; &emsp; &emsp;

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contacts}" var="contact" varStatus="loop">
            <tr>
                <td>${contact.contactId}</td> &emsp; &emsp;
                <td>${contact.firstName} ${contact.lastName}</td> &emsp; &emsp;&emsp;
                <td>${contact.subject}</td> &emsp; &emsp; &emsp;
                <td>${contact.message}</td> &emsp; &emsp; &emsp;

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<hr>
<p class="text-center">
    End</p>
<%@include file="foot.jsp" %>