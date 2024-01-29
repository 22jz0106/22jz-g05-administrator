<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../assets/css/style.css">
  <title>商品画面</title>
</head>

<body class="product-admin">
  <main>
    <div class="side">
      <ul>
        <li><a href="#"><img class="side-img" src="../../shinor/img/Header.PNG" alt=""></a></li>
        <li><a href="../注文データ一覧画面/index.html">注文データ一覧</a></li>
        <li><a href="../商品画面/index.html">商品管理</a></li>
        <li><a href="../ユーザ管理画面/index.html">ユーザ管理</a></li>
        <li><a href="../review画面/index.html">review</a></li>
      </ul>
    </div>
    <div class="product-container">
      <h2 class="product-title">商品管理</h2>
      <div class="product-form">
        <div class="product-list">
          <h3>商品一覧</h3>
          <div class="product-item">
            <span>商品ID</span>
            <span>商品A</span>
            <span>¥1000</span>
            <button class="button">詳細</button>
            <button class="delete-button" onclick="deleteProduct('商品B')">削除</button>
          </div>
          <div class="product-item">
            <span>商品ID</span>
            <span>商品A</span>
            <span>¥1000</span>
            <button class="button">詳細</button>
            <button class="delete-button" onclick="deleteProduct('商品B')">削除</button>
          </div>
          <div class="product-item">
            <span>商品ID</span>
            <span>商品A</span>
            <span>¥1000</span>
            <button class="button">詳細</button>
            <button class="delete-button" onclick="deleteProduct('商品B')">削除</button>
          </div>
          <div class="product-item">
            <span>商品ID</span>
            <span>商品A</span>
            <span>¥1000</span>
            <button class="button">詳細</button>
            <button class="delete-button" onclick="deleteProduct('商品B')">削除</button>
          </div>
          <div class="product-item">
            <span>商品ID</span>
            <span>商品A</span>
            <span>¥1000</span>
            <button class="button">詳細</button>
            <button class="delete-button" onclick="deleteProduct('商品B')">削除</button>
          </div>
          <div class="product-item">
            <span>商品ID</span>
            <span>商品A</span>
            <span>¥1000</span>
            <button class="button">詳細</button>
            <button class="delete-button" onclick="deleteProduct('商品B')">削除</button>
          </div>
          <!-- 追加の商品アイテムをここに追加 -->
        </div>
        <button><a href="../商品追加画面/index.html">商品登録する</a></button>
      </div>
    </div>
  </main>
</body>

</html>
