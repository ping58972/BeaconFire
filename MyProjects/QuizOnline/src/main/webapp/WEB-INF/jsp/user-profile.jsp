<%@include file="head.jsp" %>


<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <header class="card-header">
                    ${user.firstName}'s Profile</p>
                    <img class="card-img-top" src="/images/thankdog.png" style="width:150px;height:150px;"
                         alt="${user.firstName}'s Photo">
                </header>
                <article class="card-body">
                    <form action="/user/profile" method="post">
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
                                   value="${user.email}" readonly>
                        </div>
                        <div class="form-group">
                            <label>Phone Number</label>
                            <input type="phone" name="phone" class="form-control" placeholder="Your Phone Number"
                                   value="${user.phone}">

                        </div>
                        <div class="form-group">
                            <label>Face URL</label>
                            <input class="form-control" name="faceUrl" type="text"
                                   value="${user.faceUrl}">
                        </div>

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
                            <label>password</label>
                            <input class="form-control" name="password" type="password" value="${user.password}">
                        </div> <!-- form-group end.// -->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Update</button>
                        </div> <!-- form-group// -->


                        <input name="isAdmin" type="hidden"
                               value="value="${user.admin}"">
                        <input name="isActive" type="hidden"
                               value="value="${user.active}"">
                        <input name="message" type="hidden"
                               value="value="${user.message}"">
                    </form>
                </article> <!-- card-body end .// -->
            </div> <!-- card.// -->
        </div> <!-- col.//-->

    </div> <!-- row.//-->


</div>
<!--container end.//-->
<%@include file="foot.jsp" %>