<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Student2.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@600&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Sonsie+One&display=swap" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"> 
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tamma+2&display=swap" rel="stylesheet">
<title>Main</title>
</head>
<body>
<div id="Menu">
       <div class="LogoBox">
       <div class="Logo"></div>
       <p>Online Coursera</p>
       </div>
       <div class="divider divider1"></div>
       <div class="Dashboard_btn PageButtons" onclick="ShowContent(1)" onclick="MenubtnFocused('Dashboard_btn')" onmousemove="MenubtnIn('Dashboard_btn')" onmouseout="MenubtnOut('Dashboard_btn')"><label for="Dashboard_btn"><i class="fas fa-tachometer-alt"></i>&nbsp;Dashboard</label></div>
       <div class="divider divider2"></div>
       <div class="Files_btn PageButtons" onclick="ShowContent(2)" onmousemove="MenubtnIn('Files_btn')" onmouseout="MenubtnOut('Files_btn')"> <a id="coursesbutton"><label for="Files_btn"><i class="fas fa-file-word"></i>&nbsp;Files</label></a></div>
       <div class="Quizes_btn PageButtons" onclick="ShowContent(3)" onclick="MenubtnFocused('Quizes_btn')" onmousemove="MenubtnIn('Quizes_btn')" onmouseout="MenubtnOut('Quizes_btn')"><label for="Quizes_btn"><i class="fas fa-pen-square"></i>&nbsp;Quizes</label></div>
       <div class="Announcements_btn PageButtons" onclick="ShowContent(4)" onmousemove="MenubtnIn('Announcements_btn')" onmouseout="MenubtnOut('Announcements_btn')"><a id="announcementsbutton"><label for="Announcements_btn"><i class="fas fa-bullhorn"></i>&nbsp; Announcements</label></a></div>
       <div class="Grades_btn PageButtons" onclick="ShowContent(5)" onmousemove="MenubtnIn('Grades_btn')" onmouseout="MenubtnOut('Grades_btn')"><a id="gradesbutton"><label for="Grades_btn"><i class="fas fa-pen"></i>&nbsp;Grades</label></a></div>
       <div class="divider divider3"></div>
       <div class="Logout_btn PageButtons" onmousemove="MenubtnIn('Logout_btn')" onmouseout="MenubtnOut('Logout_btn')"><a href="logout"><label for="Logout_btn"><i class="fas fa-sign-out-alt"></i>&nbsp;Logout</label></a></div>
   </div>
   <div id="Page-Content">
       <div id="Bar">
           <div class="SearchBox">
           <input type="text" placeholder="Search" class="SearchField">
           <a><button class="Search_btn"><i class="fas fa-search"></i></button></a>
           </div>
           <div class="MessagesBox">
               <div class="Message_con">
               <div class="envlope_icon Bar_icon"><i class="fas fa-envelope"></i></div>
               <div class="bell_icon Bar_icon"><i class="fas fa-bell"></i></div>
               <div class="divider"></div>
               <p>${Member.getFullname()}</p>
               <div class="userImg" style="background-image: url(${Member.getPhoto()})"></div>
               </div>
           </div>
       </div>
       <div id="Dashboard" class="page">
       </div>
       <div id="Files" class="page">
           <button class="ShowFormbtn" onclick="ShowForm('FileForm')"><strong><i class="fas fa-plus"></i></strong>&nbsp;</button>
           <div id="FileForm">
            <button class="CloseFormbtn" onclick="CloseForm('FileForm')"><i class="fas fa-times"></i></button>
            <form action="">
                <Label id="FileInfo">File Information</Label>
                <input type="text" name="" id="FileTitle" placeholder="File Title">
                <Label for="file" id="UploadFilebtn" onclick="FileInputClicked()"><i class="fas fa-upload"></i></Label>
                <Label id="FileValue">No File Added</Label>
                <input type="file" name="" id="file" accept="image/*" hidden="hidden" onchange="loadFile2(event)">
                <select name="" id="FileType">
                    <option value="Word">Word</option>
                    <option value="PPtx">PPtx</option>
                    <option value="Excel">Excel</option>
                    <option value="PDF">PDF</option>
                    <option value="Video">Video</option>
                    <option value="Image">Image</option>
                </select>
                <button id="FileSubmit" type="button" onclick="ShowFile()">Submit</button>
           </form>
           </div>
       </div>
       <div id="Quizes" class="page"></div>
       <div id="Announcements" class="page">
           <div id="ann1">
               <header>Hello World</header>
               <p>Customer testimonials are a tried and true way to demonstrate the effectiveness and popularity of a product. Call on your customers to submit testimonials that you can then use to let their talking speak for your product.
                It also helps build trust in a company and give faces to the name when you showcase your employees on your "About Us" page. Your customers will enjoy seeing that glimpse into your company, and it will remind them that there are real people behind the product.</p>
                <button onclick="bigdiv('ann1')">Click me</button>
            </div>
            <div id="ann2">
                <header>Hello World</header>
                <p>Customer testimonials are a tried and true way to demonstrate the effectiveness and popularity of a product. Call on your customers to submit testimonials that you can then use to let their talking speak for your product.
                 It also helps build trust in a company and give faces to the name when you showcase your employees on your "About Us" page. Your customers will enjoy seeing that glimpse into your company, and it will remind them that there are real people behind the product.</p>
                 <button>Click me</button>
            </div>
       </div>
       <div id="Grades" class="page"></div>    
   </div>
        <script src="/resources/js/Script.js"></script>
        <script type="text/javascript">
            function ShowForm(FormName){
                var FileForm = document.getElementById(FormName);
                FileForm.style.width = "700px";
            }
            function CloseForm(FormName){
                var FileForm = document.getElementById(FormName);
                FileForm.style.width="0";
            }
        </script>
</body>
</html>