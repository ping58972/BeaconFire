<%@include file="head.jsp" %>


<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <header class="card-header">
                    ${userA.firstName}'s Profile</p>
                    <img class="card-img-top" src="/images/thankdog.png" style="width:150px;height:150px;"
                         alt="${userA.firstName}'s Photo">
                </header>
                <article class="card-body">
                    <form action="/admin/user/profile/${userA.userId}" method="post">
                        <div class="form-row">
                            <div class="col form-group">
                                <label>First name </label>
                                <input name="firstName" type="text" class="form-control" placeholder=""
                                       value="${userA.firstName}">
                            </div> <!-- form-group end.// -->
                            <div class="col form-group">
                                <label>Last name</label>
                                <input name="lastName" type="text" class="form-control" placeholder=""
                                       value="${userA.lastName}">
                            </div> <!-- form-group end.// -->
                        </div> <!-- form-row end.// -->
                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" name="email" class="form-control" placeholder="Your Email"
                                   value="${userA.email}" readonly>
                        </div>
                        <div class="form-group">
                            <label>Phone Number</label>
                            <input type="phone" name="phone" class="form-control" placeholder="Your Phone Number"
                                   value="${userA.phone}">

                        </div>
                        <div class="form-group">
                            <label>Face URL</label>
                            <input class="form-control" name="faceUrl" type="text"
                                   value="${userA.faceUrl}">
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Street</label>
                                <input name="street" type="text" class="form-control" value="${userA.street}">
                            </div>
                            <div class="form-group col-md-6">
                                <label>City</label>
                                <input name="city" type="text" class="form-control" value="${userA.city}">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Zipcode</label>
                                <input name="zipcode" type="text" class="form-control" value="${userA.zipcode}">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Country</label>
                                <input name="country" type="text" class="form-control" value="${userA.country}">
                            </div>
                            <div class="form-group col-md-6">
                                <label>State</label>
                                <input name="state" type="text" class="form-control" value="${userA.state}">
                            </div>


                        </div> <!-- form-row.// -->
                        <div class="form-group">
                            <label>password</label>
                            <input class="form-control" name="password" type="password" value="${userA.password}">
                        </div> <!-- form-group end.// -->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Update</button>
                        </div> <!-- form-group// -->


                        <input name="isAdmin" type="hidden"
                               value="value="${userA.admin}"">
                        <input name="isActive" type="hidden"
                               value="value="${userA.active}"">
                        <input name="message" type="hidden"
                               value="value="${userA.message}"">
                    </form>
                </article> <!-- card-body end .// -->
            </div> <!-- card.// -->
        </div> <!-- col.//-->

    </div> <!-- row.//-->


</div>
<!--container end.//-->
<%@include file="foot.jsp" %>