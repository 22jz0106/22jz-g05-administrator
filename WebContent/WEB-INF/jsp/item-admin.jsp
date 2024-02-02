<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/style.css">
  <title>商品画面</title>
</head>

<body class="product-admin">
  <main>
    <div class="side">
      <ul>
        <li><a href="#"><img class="side-img" src="../../shinor/img/Header.PNG" alt=""></a></li>
        <li><a href="Orderadmin">注文データ一覧</a></li>
      <li><a href="Itemadmin">商品管理</a></li>
      <li><a href="Useradmin">ユーザ管理</a></li>
        <li><a href="../review画面/index.html">review</a></li>
      </ul>
    </div>
    <div class="product-container">
      <h2 class="product-title">商品管理</h2>
      <div class="product-form">
        <div class="product-list">
          <h3>商品一覧</h3>
          <c:forEach var="item" items="${list}">
	          <div class="product-item">
	            <span>${Item.ItemId}</span>
	            <span>${Item.ItemName}</span>
	            <span>${Item.ItemPrice}</span>
	            <button class="button">詳細</button>
	            <button class="delete-button" onclick="deleteProduct('商品B')">削除</button>
	          </div>
          </c:forEach>
        </div>
        <button><a href="../商品追加画面/index.html">商品登録する</a></button>
      </div>
      <p>${ list }</p>
    </div>
  </main>
</body>

</html>
