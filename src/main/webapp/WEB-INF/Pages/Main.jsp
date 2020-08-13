<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>

<body>
<form action="login" method="post" enctype="multipart/form-data">
<!--  Enter name: <input name="name" type="text"><br>
Enter password: <input name="password" type="password"><br>-->

Enter file: <input name="photo" type="file" accept=".pdf" size="50"><br>
<input type="submit" value="Login">
</form>

</body>
</html>