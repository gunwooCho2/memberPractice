<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-container label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        .form-container input[type="text"],
        .form-container input[type="password"],
        .form-container input[type="checkbox"],
        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container input[type="checkbox"] {
            width: auto;
            margin-right: 10px;
        }
        .form-container input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error-message {
            color: red;
            font-size: 0.9em;
            margin-bottom: 15px;
            text-align: center;
        }
        .checkbox-container {
            display: flex;
            align-items: center;
            justify-content: flex-start;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>로그인</h2>
    <!-- 에러 메시지가 있으면 출력 -->
    <c:if test="${not empty error}">
        <div class="error-message">${error}</div>
    </c:if>
    <form action="/user/logIn" method="post">
        <label for="userID">아이디</label>
        <input type="text" id="userID" name="userID" placeholder="아이디를 입력하세요" required />

        <label for="userPassword">비밀번호</label>
        <input type="password" id="userPassword" name="userPassword" placeholder="비밀번호를 입력하세요" required />

        <div class="checkbox-container">
            <input type="checkbox" id="autoLogin" name="autoLogin" value="true" />
            <label for="autoLogin">자동 로그인</label>
        </div>

        <input type="submit" value="로그인" />
    </form>
    <form action="/user/register" method="get">
        <input type="submit" value="회원가입"/>
    </form>
</div>
</body>
</html>
