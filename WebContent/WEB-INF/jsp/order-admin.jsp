<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="assets/css/style.css">
  <title>注文データ一覧画面</title>
</head>

<body class="order-admin">
  <main class="order-main">
    <ul class="sidenav">
      <li><img class="admin-header" src="../../shinor/img/Header.PNG" alt=""></li>
      <li><a class="active" href="Useradmin">ユーザ管理</a></li>
      <li><a href="Itemadmin">商品一覧管理</a></li>
      <li><a href="Orderadmin">注文データ一覧</a></li>
      <li><a href="#about">Logout</a></li>
    </ul>
    <div class="container">
      <h2 class="order-title">注文データ管理</h2>
      <div class="order-form">
        <div class="order-list">
          <h3>注文データ一覧</h3>
          <input type="text" id="orderSearchInput" oninput="filterOrders()" placeholder="注文を検索...">
          <div class="order-item">
            <p><strong>注文ID:</strong> ${Orderadmin.UserName}</p>
            <p><strong>顧客名:</strong> 顧客A</p>
            <p><strong>注文日時:</strong> 2024-01-27 10:30</p>
            <p><strong>合計数量:</strong> 5</p>
            <p><strong>合計金額:</strong> ￥5,000</p>
            <p><strong>支払状態:</strong> 未払い</p>
            <button class="order-button">詳細</button>
          </div>
          <div class="order-item">
            <p><strong>注文ID:</strong> 001</p>
            <p><strong>顧客名:</strong> 磯邊 大志</p>
            <p><strong>注文日時:</strong> 2024-01-27 10:30</p>
            <p><strong>合計数量:</strong> 5</p>
            <p><strong>合計金額:</strong> ￥5,000</p>
            <p><strong>支払状態:</strong> 支払済み</p>
            <button class="order-button">詳細</button>
          </div>
        </div>
      </div>
    </div>
  </main>
  <script>
    function filterOrders() {
      var input, filter, orderItems, i, txtValue;
      input = document.getElementById("orderSearchInput");
      filter = input.value.toUpperCase();
      orderItems = document.querySelectorAll('.order-item');

      orderItems.forEach(function (item) {
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
