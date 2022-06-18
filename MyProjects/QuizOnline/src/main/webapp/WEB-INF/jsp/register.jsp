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

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<div class="container">
    <br>
    <p class="text-center">
        Well Come Register to Online Quiz</p>
    <hr>


    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <header class="card-header">
                    <a href="/login" class="float-right btn btn-outline-primary mt-1">Log in</a>
                    <h4 class="card-title mt-2">Sign up</h4>

                    <c:if test="${not empty user.message}"><h5 style="color: red">${user.message}</h5></c:if>

                </header>
                <article class="card-body">
                    <form action="/register" method="post">
                        <div class="form-row">
                            <div class="col form-group">
                                <label>First name </label>
                                <input name="firstName" type="text" class="form-control" placeholder=""
                                       value="${user.firstName}">
                            </div> <!-- form-group end.// -->
                            <div class="col form-group">
                                <label>Last name</label>
                                <input name="lastName" type="text" class="form-control" placeholder=""
                                       value="${user.lastName}">
                            </div> <!-- form-group end.// -->
                        </div> <!-- form-row end.// -->
                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" name="email" class="form-control" placeholder="Your Email"
                                   value="${user.email}">
                            <small class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label>Phone Number</label>
                            <input type="phone" name="phone" class="form-control" placeholder="Your Phone Number"
                                   value="${user.phone}">
                            <small class="form-text text-muted">We'll never share your Phone Number with anyone
                                else.</small>
                        </div>
                        <input name="faceUrl" type="hidden"
                               value="${user.faceUrl}">
                        <!--   <div class="form-group">
                              <label class="form-check form-check-inline">
                                  <input class="form-check-input" type="radio" name="gender" value="option1">
                                  <span class="form-check-label"> Male </span>
                              </label>
                              <label class="form-check form-check-inline">
                                  <input class="form-check-input" type="radio" name="gender" value="option2">
                                  <span class="form-check-label"> Female</span>
                              </label>
                          </div> form-group end.// -->

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Street</label>
                                <input name="street" type="text" class="form-control" value="${user.street}">
                            </div>
                            <div class="form-group col-md-6">
                                <label>City</label>
                                <input name="city" type="text" class="form-control" value="${user.city}">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Zipcode</label>
                                <input name="zipcode" type="text" class="form-control" value="${user.zipcode}">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Country</label>
                                <input name="country" type="text" class="form-control" value="${user.country}">
                            </div>
                            <div class="form-group col-md-6">
                                <label>State</label>
                                <input name="state" type="text" class="form-control" value="${user.state}">
                            </div>


                        </div> <!-- form-row.// -->
                        <div class="form-group">
                            <label>Create password</label>
                            <input class="form-control" name="password" type="password" value="${user.password}">
                        </div> <!-- form-group end.// -->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Register</button>
                        </div> <!-- form-group// -->
                        <small class="text-muted">By clicking the 'Sign Up' button, you confirm that you accept our <br>
                            Terms of use and Privacy Policy.</small>
                        <%--                        <input name="address" type="hidden"--%>
                        <%--                               value="null">--%>
                        <input name="isAdmin" type="hidden"
                               value="value="${user.admin}"">
                        <input name="isActive" type="hidden"
                               value="value="${user.active}"">
                        <input name="message" type="hidden"
                               value="value="${user.message}"">
                    </form>
                </article> <!-- card-body end .// -->
                <div class="border-top card-body text-center">Have an account? <a href="/login">Log In</a></div>
            </div> <!-- card.// -->
        </div> <!-- col.//-->

    </div> <!-- row.//-->


</div>
<!--container end.//-->

<br><br>
<article class="bg-secondary mb-3">
    <div class="card-body text-center">
        <h3 class="text-white mt-3">Good Luck!</h3>

    </div>
    <br><br>
</article>

<%@include file="foot.jsp" %>