<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="assets/css/style.css">
  <title>ユーザー管理画面</title>
</head>

<body class="user-admin">
  <div class="side">
    <ul class="sidenav">
    <li><img class="admin-header" src="../../shinor/img/Header.PNG" alt=""></li>
    <li><a class="active" href="User-Admin">ユーザ管理</a></li>
    <li><a href="Itemadmin">商品一覧管理</a></li>
    <li><a href="Orderadmin">注文データ一覧</a></li>
    <li><a href="#about">Logout</a></li>
  </ul>
  </div>
  <div class="container">
    <h1 class="user-h1">ユーザー管理画面</h1>
    <input type="text" id="orderSearchInput" oninput="filterOrders()" placeholder="ユーザーを検索...">
<c:forEach var="UserAdmin" items="${user}">
      <div class="user">
        <div class="user-info">
          <label>名前:</label>
          <span>${UserAdmin.username}</span>
        </div>
        <div class="user-info">
          <label>フリガナ:</label>
          <span>${UserAdmin.furigana}</span>
        </div>
        <div class="user-info">
          <label>住所:</label>
          <span>${UserAdmin.adress}</span>
        </div>
        <div class="user-info">
          <label>電話番号:</label>
          <span>${UserAdmin.username}</span>
        </div>
      </div>
</c:forEach>
  </div>
<script>
    function filterOrders() {
      var input, filter, userItems, i, txtValue;
      input = document.getElementById("orderSearchInput");
      filter = input.value.toUpperCase();
      userItems = document.querySelectorAll('.user');

      userItems.forEach(function (item) {
        txtValue = item.textContent || item.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          item.style.display = "";
        } else {
          item.style.display = "none";
        }
      });
    }
  </script>
</body>

</html>
