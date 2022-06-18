<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${title}</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
            crossorigin="anonymous"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<div class="container">
    <br>
    <p class="text-center">
        Well Come Login to Online Quiz</p>
    <hr>


    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <article class="card-body">
                    <form method="post" action="/login">
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
                    <c:if test="${not empty message}"><span style="color: red">${message}</span> </c:if>
                </article>
            </div>
        </div>
        <br>
        <div class="border-top card-body text-center">Have an account? <a type="submit" href="/register">Go Register</a>
        </div>
    </div>
    <%@include file="foot.jsp" %>


