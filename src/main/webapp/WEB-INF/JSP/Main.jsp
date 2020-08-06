<!DOCTYPE html>
<html>
<head>
<title>Coursera</title>
</head>

<body>
<form action="/login.do" method="post">
<p><font color="red">${ErrorMsg }</font></p>
Enter name: <input name="name" type="text"><br>
Enter password: <input name="password" type="password"><br>
<input type="submit" value="Login">
</form>
</body>
</html>