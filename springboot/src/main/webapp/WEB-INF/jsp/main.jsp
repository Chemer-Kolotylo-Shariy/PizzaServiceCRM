<%--
  Created by IntelliJ IDEA.
  User: Sergiy
  Date: 23.10.2017
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello PIZZA</title>
    <link href="https://fonts.googleapis.com/css?family=Encode+Sans" rel="stylesheet">

    <style>
        <%@include file="/static/js/parser.js"%>
    </style>
</head>
<body>

    <main>
        <nav>
            <a href="/pizza">PIZZA</a>
            <a href="/products">PRODUCTS</a>  <!-- onclick="fetch_json()" -->
            <a href="#">philosohpy</a>
            <a href="#">contact</a>
        </nav>
    </main>


    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>

    <style>
        <%@include file="../../static/css/menu.css"%>
    </style>
</body>
</html>
