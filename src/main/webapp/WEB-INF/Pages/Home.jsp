<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/Home.css">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Sonsie+One&display=swap" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"> 

<title>Home</title>
</head>
<body>
    <div id="Page-Content">
        <div id="navb">
            <div id="shadow">
              <a href="file:///D:/Web/Online%20Coursera/Login.html"><button class="ToLoginPage-btn" id="Lo" title="Login"><strong>Get Started</strong></button></a>
              <a href="file:///D:/Web/Online%20Coursera/Login.html"><button class="ToRegisterPage-btn" id="Re" onmousemove="Showbtn()"><strong><i class="fas fa-user-plus"></i></strong>&nbsp;</button></a>
                <div id="title">
                    <header>Online Coursera</header>
                    <p>The Way To Success</p>
                </div>
            </div>
            <svg class="svg1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#fff" fill-opacity="1" d="M0,160L48,176C96,192,192,224,288,250.7C384,277,480,299,576,309.3C672,320,768,320,864,277.3C960,235,1056,149,1152,144C1248,139,1344,213,1392,250.7L1440,288L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"></path></svg>
        </div>
        <div id="aboutus">
          <div class="aboutus-con">
            <header>About us</header>
            <div class="divider"></div>
            <div class="photo"></div>
            <div class="paragraph">
              <header>Who We Are</header>
              <p>Customer testimonials are a tried and true way to demonstrate the effectiveness and popularity of a product. Call on your customers to submit testimonials that you can then use to let their talking speak for your product.
                It also helps build trust in a company and give faces to the name when you showcase your employees on your "About Us" page. Your customers will enjoy seeing that glimpse into your company, and it will remind them that there are real people behind the product.</p>
            </div>
          </div>
        </div>
        <div id="photo-divider">
          <div id="shadow"></div>
        </div>
        <div id="Contact">
          <div class="contact-con">
            <header>Contact</header>
            <div class="divider"></div>
            <form action="" class="message-info">
              <input type="text" name="" id="fullname" placeholder="Full Name">
              <input type="text" name="" id="email" placeholder="Email">
              <textarea name="" id="message" placeholder="Your Message"></textarea>
              <button class="send-btn">Send</button>
            </form>
            <div class="our-resources">
              <div class="box">
                <div class="icon"><i class="fas fa-map-marker-alt"></i>\</div>                
                <p>Al-Qaed, Bridge of the Dome, Wayli, Cairo Governorate, Egypt</p>
              </div>
              <div class="box">
                <div class="icon"><i class="fas fa-envelope-square"></i></div>
                <p>Tareq.20127020@gmail.com</p>
              </div>
              <div class="box">
                <div class="icon"><i class="fas fa-phone"></i></div>                
                <p>01097437338</p>
              </div>
            </div>
          </div>
        </div>
        <footer class="footer"></footer>
    </div>
    <script src="/resources/js/Script.js"></script>
</body>
</html>