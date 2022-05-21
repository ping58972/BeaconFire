<%@include file="head.jsp" %>

<div class="container">
    <h3>Admin Page </h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Full Name</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
            <th scope="col">Phone</th>
            <th scope="col">Status</th>
            <th scope="col">Operation</th>
            <th scope="col">Detail</th>

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
                <td><c:if test="${user.active}">Active</c:if><c:if test="${not user.active}">Suspend</c:if></td>
                </td>
                <td><a href="/admin/user/suspend/${user.userId}">
                    <c:if test="${user.active}">Disable</c:if><c:if test="${not user.active}">Enable</c:if></a></td>
                <td><a href="/admin/user/profile/${user.userId}"> Profile Detail</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div/>
    <hr>
    <p class="text-center">
        End</p>
<%@include file="foot.jsp" %>