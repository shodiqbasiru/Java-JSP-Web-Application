<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="assets/index.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"> </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"> </script>
    <script src="assets/login.js"></script>
</head>
<body>
    <div class="container">
        <form action="loginServlet" method="post" id="loginForm">
            <h1>Login</h1>
            <div class="form-group">
                <label for="userId">User ID:</label><br>
                <input type="text" id="userId" name="userId"><br>
            </div>
            <div class="form-group">
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password"><br>
            </div>
            <div class="form-group">
                <input type="submit" value="Login">
            </div>
        </form>
    </div>
</body>
</html>