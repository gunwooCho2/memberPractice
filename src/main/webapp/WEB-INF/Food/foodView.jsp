<%--
  Created by IntelliJ IDEA.
  User: alex6
  Date: 24. 11. 28.
  Time: 오전 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.busanit501.firstpractice.Food.VO.FoodVO" %>
<!DOCTYPE html>
<html>
<head>
    <title>Food Details</title>
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
        .detail {
            margin-top: 20px;
        }
        .detail p {
            margin: 10px 0;
        }
        .detail span {
            font-weight: bold;
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
    <h1>Food Details</h1>
    <div class="detail">
        <%
            // foodVO는 서버에서 전달된 VO 객체라고 가정
            FoodVO foodVO = (FoodVO) request.getAttribute("foodVO");
            if (foodVO != null) {
        %>
        <p><span>음식 번호:</span> <%= foodVO.getFoodNo() %></p>
        <p><span>음식 이름:</span> <%= foodVO.getFoodName() %></p>
        <p><span>음식 설명:</span> <%= foodVO.getFoodExplain() %></p>
        <p><span>작성자:</span> <%= foodVO.getWriter() %></p>
        <p><span>등록일:</span> <%= foodVO.getRegisterDate() %></p>
        <%
        } else {
        %>
        <p>음식 정보를 불러올 수 없습니다.</p>
        <%
            }
        %>
    </div>
    <form action="/food/list" method="get">
        <button type="submit" class="back-btn">목록으로 돌아가기</button>
    </form>
</div>
</body>
</html>

