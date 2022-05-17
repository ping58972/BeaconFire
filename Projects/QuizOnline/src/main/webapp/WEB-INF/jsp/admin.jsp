<%@include file="head.jsp" %>
<div class="container">
    <h3>Admin Page </h3>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Full Name</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
            <th scope="col">Phone</th>
            <th scope="col">Active</th>
            <th scope="col">Address</th>
            <th scope="col">Operation</th>

        </tr>
        </thead>
        <tbody>

        <c:forEach var="user" items="${users}">
            <tr>
                <th scope="row">${user.userId}</th>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.phone}</td>
                <td>${user.active}</td>
                <td>${user.address}</td>
                <td><a href="#"> Suspend User</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div/>

    <br> <br>
    <div class="container">
        <h3>All Quiz</h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th> &emsp; &emsp;
                <th scope="col">Name</th> &emsp; &emsp; &emsp;
                <th scope="col">Category</th> &emsp; &emsp; &emsp;
                <th scope="col">Start Time</th> &emsp; &emsp; &emsp;
                <th scope="col">End Time</th> &emsp; &emsp; &emsp;
                <th scope="col">Score</th> &emsp; &emsp; &emsp;
                <th scope="col">Details</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${quizzes}" var="quiz" varStatus="loop">
                <tr>
                    <td>${quiz.quizId}</td> &emsp; &emsp;
                    <td>${quiz.quizName}</td> &emsp; &emsp;&emsp;
                    <td>${quiz.categoryName}</td> &emsp; &emsp; &emsp;
                    <td>${quiz.startTime}</td> &emsp; &emsp; &emsp;
                    <td>${quiz.endTime}</td> &emsp; &emsp;
                    <th scope="row">${quiz.score}/10</th>
                    <td><a href="/quiz/result/${quiz.quizId}"> More Detail</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <br> <br>
    <div class="container">
        <h3>All Feedback</h3>
        <table class="table table-dark">
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

        <br> <br>
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
        <br> <br>
<%@include file="foot.jsp" %>