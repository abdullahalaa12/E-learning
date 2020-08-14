<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Login.css">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"> 

<title>Login</title>
</head>
<body>
<div class="page">
<div class="Big">
<div class="clips1"></div>
<div class="clips2"></div>
    <div class="container">
        <div class="left-form">
            <div class="logo">
                <img src="/resources/images/design.png">
            </div>
            <div class="login-form">
                <div class="profile-pic">
                    <img src="/resources/images/pf.svg">
                </div>
                <form class="loginform" action="login" method="post">
                <input id="input-field1" type="text" placeholder="Username"><br>
                <input id="input-field2" type="password" placeholder="Password">
                <a href="#" class="Forget">Forget Password ?</a>
            </div>
            <button class="login">Login</button>
            </form>
            <button id="eye-visible" onclick="hidePass()"><i class="far fa-eye"></i></button>
            <button id="eye-hide" onclick="showPass()"><i class="far fa-eye-slash"></i></button>
           <a href="/Register"><button class="Signup">Sign Up</button></a>
            <div class="media">
                <a href="#" class="m1"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="m2"><i class="fab fa-twitter"></i></a>
                <a href="#" class="m3"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="m4"><i class="fab fa-instagram"></i></a>
            </div>  
        </div>
        <div class="right-form">
            <img src="/resources/images/gg.svg">
        </div>
    </div>
</div>
</div>
<div class="load-page"> 
    <img src="/resources/images/58.png" alt="" id="logo">
</div>
<script>
    window.onload = function()
    {
        $(".load-page").fadeOut(2000);
    }
    function showPass(){

        var ans = document.getElementById("input-field2");
        
        if (ans.type ==="password")
        {
            ans.type = "text";
        }
        else 
        {
            ans.type = "password";
        }

        document.getElementById("eye-hide").style.display="none";
        document.getElementById("eye-visible").style.display="block";
      
    }
    function hidePass(){
        var ans = document.getElementById("input-field2");
        
        if (ans.type ==="text")
        {
            ans.type = "password";
        }
        else 
        {
            ans.type = "text";
        }
        document.getElementById("eye-visible").style.display="none";
        document.getElementById("eye-hide").style.display="block";
    }
</script>
</body>
</html>