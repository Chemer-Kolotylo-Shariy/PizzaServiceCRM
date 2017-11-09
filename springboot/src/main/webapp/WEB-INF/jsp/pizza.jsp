<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrii
  Date: 08.11.2017
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <div>
        <table class="table_price">
            <caption>PIZZA</caption>
            <thead>
            <tr>
                <th>Nazwa</th>
                <th>Opis</th>
                <th>Foto</th>
                <th>Cena</th>
                <th>Rabat</th>
                <th colspan="3">Size</th>
            </tr>
            </thead>

            <tbody>
                <c:forEach items="${allPizza}" var="pizza">
                    <tr>
                        <td>${pizza.name}</td>
                        <td>${pizza.specification}</td>
                        <td>${pizza.photo}</td>
                        <td>${pizza.price}</td>
                        <td>${pizza.persent}</td>
                        <td>${pizza.size}</td>
                        <th><a href="/updateProduct?id=${pizza.id}">Update</a></th>
                        <th><a href="/deleteProduct?id=${pizza.id}">Delete</a></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


    <style>
        <%@include file="../../static/css/mainTable.css"%>
    </style>

</body>
</html>
