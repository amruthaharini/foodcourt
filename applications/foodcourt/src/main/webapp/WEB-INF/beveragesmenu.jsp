<%--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
  <meta charset="utf-8">
  <title>Beverage Menu</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Le styles -->
  <link href="assets/css/bootstrap.css" rel="stylesheet">
  <link href="assets/css/beverage.css" rel="stylesheet">
  <style>
    body {
      padding-top: 60px;
      /* 60px to make the container go all the way to the bottom of the topbar */
    }
  </style>
  <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a class="btn btn-navbar" data-toggle="collapse"
         data-target=".nav-collapse"> <span class="icon-bar"></span> <span
          class="icon-bar"></span> <span class="icon-bar"></span>
      </a> <a class="brand" href="#">Foodcourt</a>

      <form class="navbar-form pull-right">
        <select name="field">
          <option value="title">Title</option>
          <option value="size">Size</option>

        </select> <input type="text" name="key" size="20">
        <button type="submit" class="btn">Search</button>
      </form>

      <!--/.nav-collapse -->
    </div>
  </div>
</div>

<div class="container">

  <h1>Beverages</h1>

  <form class="beverage-input-form form-inline" action="beveragesmenu"
        method="post">
    <p>Add Beverage</p>
    <input type="text" name="title" placeholder="Title" size="29"/>
    <input type="text" name="price" placeholder="Price" size="17"/>
    <input type="text" name="size" placeholder="Size" size="14"/>
    <input type="text" name="rating" placeholder="Rating" size="27"/>
    <input type="submit" name="action" class="btn btn-primary" value="Add"/>
  </form>

  <table class="table table-striped table-bordered">
    <thead>
    <tr>
      <th>Title</th>
      <th>Price</th>
      <th>Size</th>
      <th>Rating</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${beverages}" var="beverage">
      <tr>
        <td><c:out value="${beverage.title}"/></td>
        <td><c:out value="${beverage.price}"/></td>
        <td><c:out value="${beverage.size}"/></td>
        <td><c:out value="${beverage.rating}"/></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <c:if test="${count > 0}">
    <c:if test="${page > 1}">
      <a href="<c:url value="beveragesmenu"><c:param name="page" value="${page - 1}"/><c:param name="field" value="${field}"/><c:param name="key" value="${key}"/></c:url>">&lt; Prev</a>&nbsp;
    </c:if>
    Showing records ${start} to ${end} of ${count}
    <c:if test="${page < pageCount}">
      &nbsp;<a href="<c:url value="beveragesmenu"><c:param name="page" value="${page + 1}"/><c:param name="field" value="${field}"/><c:param name="key"
                                                                                                                                        value="${key}"/></c:url>">Next &gt;</a>
    </c:if>
  </c:if>
</div>
<!-- /container -->
</body>
</html>
