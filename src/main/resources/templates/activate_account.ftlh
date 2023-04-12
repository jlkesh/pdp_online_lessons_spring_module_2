<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body style="background-color: magenta;margin: 0; padding: 0;">
<h1 style="text-align: center; color: green">Hello ${username}</h1>
<h3>You have successfully registered!!!</h3>
<h3>In order to Activate your account please click link below !!!</h3>
<a href="http://localhost:8080/activate?token=${token}">Activate</a>
</body>
</html>