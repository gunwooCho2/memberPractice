<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex6
  Date: 24. 11. 26.
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Food List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        .food-list-container {
            max-width: 800px;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .food-list-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .food-table {
            width: 100%;
            border-collapse: collapse;
        }
        .food-table th,
        .food-table td {
            text-align: left;
            padding: 10px;
            border: 1px solid #ccc;
        }
        .food-table th {
            background-color: #f2f2f2;
        }
        .food-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<div class="food-list-container">
    <h2>Food List</h2>
    <table class="food-table">
        <thead>
        <tr>
            <th>Food No</th>
            <th>Food Name</th>
            <th>Food Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="food" items="${foodList}">
            <tr>
                <td>${food.foodNo}</td>
                <td>${food.foodName}</td>
                <td>${food.foodDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
