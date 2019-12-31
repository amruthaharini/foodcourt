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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
  <meta charset="utf-8">
  <title>Foodcourt</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Le styles -->
  <link href="../assets/css/bootstrap.css" rel="stylesheet">
  <link href="../assets/css/beverage.css" rel="stylesheet">
  <style>
    body {
      padding-top: 60px;
      /* 60px to make the container go all the way to the bottom of the topbar */
    }
  </style>
  <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a class="btn btn-navbar" data-toggle="collapse"
         data-target=".nav-collapse"> <span class="icon-bar"></span> <span
          class="icon-bar"></span> <span class="icon-bar"></span>
      </a> <a class="brand" href="#">Foodcourt</a>
      <!--/.nav-collapse -->
    </div>
  </div>
</div>

<div class="container">
  <h1 style="text-align:center">Foodcourt</h1>
  <h4 style="text-align:left"><strong>Please select one of the following links:</strong></h4>
  <ul style="list-style-type:disc;">
  <li><a href="setup"><b>Setup</b></a> : Sets up the application with some sample data<br/></br></li>
  <li><a href="beveragesmenu"><b>Beverages</b><br/>
    <img src="https://www.getflavor.com/wp-content/uploads/2017/01/2017-trends-non-alcoholic-beverages.jpg" width="500" height="80"
    alt="Beverages"></br></br></li>
  <li><a href="appetizers"><b>Appetizers</b><br/>
  <img src="https://purewows3.imgix.net/images/articles/2018_12/brussels_sprouts_sliders.png?auto=format,compress&cs=strip" width="500" height="80"
                  alt="Appetizers"></br></br></li>
  </ul>
  </div>
</div>
<!-- /container -->
</body>
</html>
