<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../assets/css/style.css">
  <title>商品 詳細画面</title>
</head>

<body>
  <div class="side">
    <ul>
      <li><a href="#"><img class="side-img" src="../../shinor/img/Header.PNG" alt=""></a></li>
      <li><a href="../注文データ一覧画面/index.html">注文データ一覧</a></li>
      <li><a href="../商品画面/index.html">商品管理</a></li>
      <li><a href="../ユーザ管理画面/index.html">ユーザ管理</a></li>
      <li><a href="../review画面/index.html">review</a></li>
    </ul>
  </div>
  <div id="product-details">
    <h2>商品詳細</h2>
    <form id="product-form">
      <label for="productName">商品名:</label>
      <input type="text" id="productName" name="productName" required>

      <label for="productCode">商品コード:</label>
      <input type="text" id="productCode" name="productCode" required>

      <label for="price">価格:</label>
      <input type="number" id="price" name="price" value="1000" required>

      <label for="stockQuantity">在庫数:</label>
      <input type="number" id="stockQuantity" name="stockQuantity" min="0" value="0" required>

      <label for="description">説明:</label>
      <textarea id="description" name="description" rows="4" required></textarea>

      <label for="size">サイズ:</label>
      <input type="text" id="size" name="size">

      <label for="color">色:</label>
      <select name="color">
        <option value="gold">ゴールド</option>
        <option value="silver">シルバー</option>
      </select>

      <img id="previewImage" src="" alt="商品画像">

      <button type="button" onclick="updateProductDetails()">更新</button>
    </form>
  </div>
  <script>
    // 商品画像のプレビュー表示
    document.getElementById('productImage').addEventListener('input', function() {
        document.getElementById('previewImage').src = this.value;
    });

    // 商品情報の更新
    function updateProductDetails() {
        // ここで商品情報を保存・更新する処理を追加
        alert('商品情報が更新されました。');
    }
  </script>
</body>

</html>
