<%--
  Created by IntelliJ IDEA.
  User: Andrii
  Date: 29.11.2017
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="app">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <%--<script type="text/javascript" src="/.../static/js/angularjsGetPost.js"/>--%>
    <style>
        <%@include file="/static/js/angularjsGetPost.js"%>
    </style>

    <style>
        <%@include file="/static/js/parser.js"%>
    </style>
</head>
<body ng-controller="jsaController">
    <table id="productsResult" class="data-contacts-js table table-striped" >
        <tr>
            <th>Nazwa</th>
            <th>Opis</th>
            <th>Foto</th>
            <th>Cena</th>
            <th>Rabat</th>
            <th colspan="3">Size</th>
        </tr>


        <%--<style>--%>
            <%--<%@include file="/static/js/parser.js"%>--%>
        <%--</style>--%>


        <%--<tr ng-repeat="product in listCustomers | orderBy : 'name'" ng-class-even="'info'" ng-class-odd="'success'">--%>
            <%--<td>{{ product.id }}</td>--%>
            <%--<td>{{ product.name }}</td>--%>
            <%--<td>{{ product.specification }}</td>--%>
            <%--<td>{{ product.photo }}</td>--%>
            <%--<td>{{ product.priceWithPersent }}</td>--%>
            <%--<td>{{ product.persent }}</td>--%>
            <%--<td>{{ product.size.size }}</td>--%>
            <%--<td>{{ product.priceWithPersent }}</td>--%>
            <%--<td><a ng-click="editEmployee( product )" class="button">Edit</a> | <a ng-click="removeEmployee( product )" class="button">Remove</a></td>--%>
        <%--</tr>--%>




        <%--<script>--%>
            <%--function getAll()--%>
            <%--{--%>

                <%--$.getJSON("http://localhost:8888/products/all",  function(data)--%>
                <%--{--%>
                    <%--for (var i in data) {--%>
                        <%--var product = '<tr>' +--%>
                            <%--'<td>' + data[i].name + '</td>' +--%>
                            <%--'<td>' + data[i].specification + '</td>' +--%>
                            <%--'<td>' + data[i].photo + '</td>' +--%>
                            <%--'<td>' + data[i].priceWithPersent + '</td>' +--%>
                            <%--'<td>' + data[i].persent + '</td>' +--%>
                            <%--'<td>' + data[i].size.size + '</td>' +--%>
                            <%--'</tr>';--%>
                        <%--$('#productsResult').append(product)--%>
                    <%--}--%>
                <%--});--%>
            <%--}--%>
        <%--</script>--%>

        <%--<tr ng-repeat="product in employees">--%>
            <%--<td>{{ product.name }}</td>--%>
            <%--<td>{{ product.specification }}</td>--%>
            <%--<td>{{ product.photo }}</td>--%>
            <%--<td>{{ product.priceWithPersent }}</td>--%>
            <%--<td>{{ product.persent }}</td>--%>
            <%--<td>{{ product.size.id }}</td>--%>
            <%--<td><a ng-click="editEmployee( product )" class="button">Edit</a> | <a ng-click="removeEmployee( product )" class="button">Remove</a></td>--%>
        <%--</tr>--%>
    </table>


</body>
</html>
