<%--
  Created by IntelliJ IDEA.
  User: 吴先生
  Date: 2022/5/16
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/asserts/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/asserts/css/dashboard.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#"><shiro:principal property="name"/></a>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Sign out</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="${pageContext.request.contextPath}/emp/emps" target="center">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home">
                                <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                                <polyline points="9 22 9 12 15 12 15 22"></polyline>
                            </svg>
                            雇员管理 <span class="sr-only">(current)</span>
                        </a>
                    </li>
                </ul>


            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <iframe src="center.html" width="100%" height="700px" frameborder="0" name="center"></iframe>

        </main>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/jquery-3.2.1.slim.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/popper.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/asserts/js/bootstrap.min.js" ></script>

</body>

</html>