<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン | J'z VoD</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body id="body-createUser">
    <main class="login-main">
        <c:if test="${not empty msg}">
            <%-- メッセージが存在するときのみ表示 --%>
            <p>${msg}</p>
        </c:if>
        <section>
            <h1>ログイン</h1>
            <form action="Login" method="POST" class="login-form">
                <dl>
                    <div class="form-item">
                        <dt><label for="login-email">メールアドレス</label></dt>
                        <dd><input type="email" name="email" id="login-email" required></dd>
                    </div>
                    <div class="form-item">
                        <dt><label for="login-pass">パスワード</label></dt>
                        <dd><input type="password" name="password" id="login-pass" required></dd>
                    </div>
                </dl>
                <button class="btn">ログイン</button>
                <a href="CreateUser" class="btn blur">アカウント新規登録</a>
            </form>
        </section>
    </main>
</body>
</html>

