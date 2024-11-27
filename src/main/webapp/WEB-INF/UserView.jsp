<%--
  Created by IntelliJ IDEA.
  User: alex6
  Date: 24. 11. 26.
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        .user-info-container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .user-info-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .user-info-table {
            width: 100%;
            border-collapse: collapse;
            justify-content: center;
        }
        .user-info-table th,
        .user-info-table td {
            text-align: left;
            padding: 10px;
            border: 1px solid #ccc;
            justify-content: space-between;
        }
        .user-info-table th {
            background-color: #f2f2f2;
        }
        .button-container {
            text-align: center;
            margin-top: 20px;
        }
        .button-container button {
            padding: 10px 20px;
            margin: 5px;
            font-size: 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            color: #fff;
        }
        .button-container .update-button {
            background-color: #4CAF50; /* Green */
        }
        .button-container .delete-button {
            background-color: #f44336; /* Red */
        }
        .button-container button:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>
<div class="user-info-container">
    <h2>사용자 정보</h2>
    <table class="user-info-table">
        <tr>
            <th>번호</th>
            <td>${userVO.userNo}</td>
        </tr>
        <tr>
            <th>아이디</th>
            <td>${userVO.userID}</td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td>${userVO.userPassword}</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>${userVO.userName}</td>
        </tr>
        <tr>
            <th>등록일</th>
            <td>${userVO.registerDate}</td>
        </tr>
    </table>
    <div class="button-container">
        <a href="/user/update?userNo=${userVO.userNo}">
            <button type="submit" class="update-button">수정</button>
        </a>
        <form action="/user/delete?userNo=${userVO.userNo}" method="post" style="display:inline;">
            <button type="submit" class="delete-button">삭제</button>
        </form>
    </div>
</div>
</body>
</html>

