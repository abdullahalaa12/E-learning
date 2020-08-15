<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="com.coursera.Service.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
</head>

<img src="data:image/jpg;base64,${Member.getPhoto()}" /><br>
<p>${Member.getId() }</p><br>
<p>${Member.getFullname() }</p><br>
<p>${Member.getPassword() }</p><br>
<p>${Member.getEmail() }</p><br>
<p>${Member.getNationality() }</p><br>
<p>${Member.getPhone() }</p><br>
<p>${Member.getBirthdate() }</p><br>
<p>${Member.getAge() }</p><br>
<p>${Member.getEducationlevel() }</p><br>
<p>${Member.getCompany() }</p><br>
<p>${Member.getJoptitle() }</p><br>
<p>${Member.getDepartment() }</p><br>
<p>${Member.getWebsite() }</p><br>
<p>${Member.getUserType() }</p><br>
</body>
</html>