<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex6
  Date: 24. 11. 28.
  Time: 오전 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.busanit501.firstpractice.Food.DTO.FoodViewDTO" %>
>
<!DOCTYPE html>
<html>
<head>
    <title>Food List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            padding: 10px 15px;
            border-bottom: 1px solid #ddd;
        }
        li a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        li a:hover {
            color: #0056b3;
        }
        .back-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            text-align: center;
        }
        .back-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Food List</h1>
    <ul>
        <%
            // foodList는 서버에서 전달된 String 리스트라고 가정
            List<FoodViewDTO> foodList = (List<FoodViewDTO>) request.getAttribute("foodList");
            if (foodList != null && !foodList.isEmpty()) {
                for (FoodViewDTO foodViewDTO : foodList) {
                    String foodName = foodViewDTO.getFoodName();
                    int foodNo = foodViewDTO.getFoodNO();
        %>

        <li>
            <a href="/food/view?foodNo=<%= foodNo %>">
                <%= foodName %>
            </a>
        </li>
        <%
            }
        } else {
        %>
        <li>등록된 음식이 없습니다.</li>
        <%
            }
        %>
        <c:if test="${not empty lastRecord}">
            <li>
                <a href="/food/view?foodNo=${lastRecord.foodNo}">
                        마지막으로 본 음식: ${lastRecord.foodName}
                </a>
            </li>
        </c:if>
    </ul>
    <form action="/food/insert" method="get">
        <button type="submit" class="back-btn">Food 추가하기</button>
    </form>
</div>
</body>
</html>

