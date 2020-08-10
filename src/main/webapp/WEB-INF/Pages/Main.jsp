<!DOCTYPE html>
<html>
<head>
<title>Coursera</title>
</head>

<body>
<form action="/login" method="post">
<p><font color="red">${ErrorMsg }</font></p>
Enter name: <input name="name" type="text"><br>
Enter password: <input name="password" type="password"><br>
Enter file: <input name="file" type="file"><br>
<input type="submit" value="Login">
</form>
</body>
</html>