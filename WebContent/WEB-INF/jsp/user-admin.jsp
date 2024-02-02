<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <ul>
      <li><a href="#"><img class="side-img" src="../../shinor/img/Header.PNG" alt=""></a></li>
      <li><a href="Orderadmin">注文データ一覧</a></li>
      <li><a href="Itemadmin">商品管理</a></li>
      <li><a href="Useradmin">ユーザ管理</a></li>
      <li><a href="../review画面/index.html">review</a></li>
    </ul>
  </div>
  <div class="container">
    <h1 class="user-h1">ユーザー管理画面</h1>

      <div class="user">
        <div class="user-info">
          <label>名前:</label>
          <span>${useradmin.username}</span>
        </div>
        <div class="user-info">
          <label>フリガナ:</label>
          <span>${useradmin.furigana }</span>
        </div>
        <div class="user-info">
          <label>住所:</label>
          <span>${useradmin.adress }</span>
        </div>
        <div class="user-info">
          <label>電話番号:</label>
          <span>${useradmin.phonnumber }</span>
        </div>
        <div class="user-info">
          <label>パスワード:</label>
          <span>${useradmin.password }</span>
        </div>
      </div>

  </div>

</body>

</html>
