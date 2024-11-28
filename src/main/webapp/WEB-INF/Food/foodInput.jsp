<%@ page import="com.busanit501.firstpractice.User.DTO.RegisterDTO" %><%--
  Created by IntelliJ IDEA.
  User: alex6
  Date: 24. 11. 28.
  Time: 오전 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Food 작성</title>
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
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input, .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group textarea {
            height: 100px;
            resize: none;
        }
        .form-group .readonly {
            background: #f9f9f9;
            color: #666;
            cursor: not-allowed;
        }
        .btn-container {
            text-align: center;
        }
        .btn {
            background: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Food 작성</h1>
    <form action="/food/insert" method="post">
        <!-- 작성자 표시 (읽기 전용) -->
        <div class="form-group">
            <label for="writer">작성자</label>
            <input type="text" id="writer" name="uesrName" class="readonly" readonly value="${userName}">
        </div>
        <!-- Food 이름 입력 -->
        <div class="form-group">
            <label for="foodName">Food 이름</label>
            <input type="text" id="foodName" name="foodName" placeholder="음식 이름을 입력하세요" required>
        </div>
        <!-- Food 설명 입력 -->
        <div class="form-group">
            <label for="foodExplain">Food 설명</label>
            <textarea id="foodExplain" name="foodExplain" placeholder="음식 설명을 입력하세요" required></textarea>
        </div>
        <!-- 제출 버튼 -->
        <div class="btn-container">
            <button type="submit" class="btn">작성 완료</button>
        </div>
    </form>
</div>
</body>
</html>
