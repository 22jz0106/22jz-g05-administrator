<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/style.css">
<title>商品画面</title>
<style>
.new-product-form {
	display: none;
}
</style>
<script>
	function toggleNewProductForm() {
		var form = document.getElementById("newProductForm");
		form.style.display = form.style.display === "none" ? "block" : "none";
	}

	// 商品画像のプレビュー表示
	function previewImage(input) {
		var preview = document.getElementById('previewImage');
		var file = input.files[0];
		var reader = new FileReader();

		reader.onloadend = function() {
			preview.src = reader.result;
		};

		if (file) {
			reader.readAsDataURL(file);
		} else {
			preview.src = "";
		}
	}

	// 商品情報の更新
	function updateProductDetails() {
		// ここで商品情報を保存・更新する処理を追加
		alert('商品情報が登録されました。');
	}

	function filterOrders() {
		var input, filter, orderItems, i, txtValue;
		input = document.getElementById("orderSearchInput");
		filter = input.value.toUpperCase();
		orderItems = document.querySelectorAll('.product-item');

		orderItems.forEach(function(item) {
			txtValue = item.textContent || item.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				item.style.display = "";
			} else {
				item.style.display = "none";
			}
		});
	}
</script>
</head>

<body class="product-admin">
	<main>
		<ul class="sidenav">
			<li><img class="admin-header" src="../../shinor/img/Header.PNG"
				alt=""></li>
			<li><a class="active" href="Useradmin">ユーザ管理</a></li>
			<li><a href="Itemadmin">商品一覧管理</a></li>
			<li><a href="Orderadmin">注文データ一覧</a></li>
			<li><a href="Logout">ログアウト</a></li>
		</ul>

		<h2 class="product-title">商品管理</h2>
		<div class="product-form">
			<div class="product-list">
				<h3>商品一覧</h3>
				<input type="text" id="orderSearchInput" oninput="filterOrders()"
					placeholder="商品を検索...">
				<c:forEach var="item" items="${item_list}">
    <div class="product-item">
        <span>${item.itemID}</span> <span>${item.itemName}</span> <span>${item.itemPrice}</span>
        <button class="button" value="${item.itemID}">更新</button>
       <button type="button" class="delete-button" onclick="deleteItem(${item.itemID});">削除</button>
       

    </div>
</c:forEach>
			</div>

			<div class="product-container">
				<button class="button" onclick="toggleNewProductForm()">新規商品登録</button>

				<div id="newProductForm" class="new-product-form">
					<h3>新規商品登録</h3>
					<form method="POST" id="product-form" enctype="multipart/form-data">
						<label for="productName">商品名:</label>
						 <input type="text" id="productName" name="productName" required>
						  <label for="productCode">商品コード:</label>
						  <input type="text" id="productCode" name="productCode" required>
						   <label for="price">価格:</label>
						   <input type="number" id="price" name="price" value="1000" required>
						   <label for="stockQuantity">在庫数:</label>
						   <input type="number"id="stockQuantity" name="stockQuantity" min="0" value="0"
							required> <label for="description">説明:</label>
						<textarea id="description" name="description" rows="4" required></textarea>

						<label for="size">サイズ:</label> <input type="text" id="size"
							name="size"> <label for="color">色:</label> <select
							name="color">
							<option value="gold">ゴールド</option>
							<option value="silver">シルバー</option>
						</select> <label for="productImage">商品画像:</label> <input type="file"
							id="productImage" name="productImage" accept="image/*"
							onchange="previewImage(this)">

						<button type="submit" onclick="updateProductDetails()">登録</button>
					</form>
				</div>
			</div>
		</div>
	</main>
	<script>
	// 商品登録フォームを表示する関数
	function showAddItemForm() {
	    document.getElementById('addItemForm').style.display = 'block';
	
	    function deleteItem(itemId) {
	        if (confirm('この商品を削除してもよろしいですか？')) {
	            // POSTリクエストで削除を実行するためのフォームを動的に作成
	            var form = document.createElement('form');
	            document.body.appendChild(form);
	            form.method = 'POST';
	            form.action = 'Itemadmin'; // 正しいサーブレットのURLを指定

	            // アクションタイプを指定
	            var actionInput = document.createElement('input');
	            actionInput.type = 'hidden';
	            actionInput.name = 'action';
	            actionInput.value = 'delete';
	            form.appendChild(actionInput);

	            // 削除するアイテムIDを指定
	            var idInput = document.createElement('input');
	            idInput.type = 'hidden';
	            idInput.name = 'itemId';
	            idInput.value = itemId;
	            form.appendChild(idInput);

	            form.submit();
	        }
	    }
</script>
</body>

</html>
