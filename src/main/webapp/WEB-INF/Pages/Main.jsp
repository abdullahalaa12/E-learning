<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import ="com.coursera.Service.User" %>
    <%@ page import ="com.coursera.Service.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            $(document).on("click", "#coursesbutton", function() {
                $.get("/Main/Courses");
            });
            $(document).on("click", "#announcementsbutton", function() {
                $.get("/Main/Announcement");
            });
            $(document).on("click", "#gradesbutton", function() {
                $.get("/Main/Grades");
            });
        </script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Student.css">
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
       <div class="Courses_btn PageButtons" onclick="ShowContent(3)" onclick="MenubtnFocused('Courses_btn')" onmousemove="MenubtnIn('Courses_btn')" onmouseout="MenubtnOut('Courses_btn')"><label for="Courses_btn"><i class="fas fa-user"></i>&nbsp;Profile</label></div>
      <div class="Profile_btn PageButtons" onclick="ShowContent(2)" onmousemove="MenubtnIn('Profile_btn')" onmouseout="MenubtnOut('Profile_btn')"> <a id="coursesbutton"><label for="Profile_btn"><i class="fas fa-book-open"></i>&nbsp;Courses</label></a></div>
       <div class="Announcements_btn PageButtons" onclick="ShowContent(4)" onmousemove="MenubtnIn('Announcements_btn')" onmouseout="MenubtnOut('Announcements_btn')"><a id="announcementsbutton"><label for="Announcements_btn"><i class="fas fa-bell"></i>&nbsp; Announcements</label></a></div>
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
               <div class="userBox">
                <p>${Member.getFullname() }</p>
                <div class="userImg"></div>
                	<img src="data:image/jpg;base64,${Member.getPhoto()}" />
               </div>
               </div>
           </div>
       </div>
       <div id="Dashboard" class="page"></div>
       <div id="Courses" class="page">   
  		<c:forEach items="${Member.getCourses()}" var="course">
				<p>course.getName()</p>
			</c:forEach>
       </div>
       <div id="Profile" class="page">
           <div class="ProPho-Background">
           		
               <div class="Blured"><img src="data:image/jpg;base64,${Member.getPhoto()}" /></div>
           </div>
           <div class="ProPho">
            <div class="shadow">
                <i class="fas fa-camera"></i>
            </div>
           </div>
           <div class="info-container">
           <div class="Account-infoBox infoBox">
               <header>Account information</header>
               <div class="divider"></div>
               <div class="FullNameBox Box" id="Tata">
                   <Label class="Title">Full Name</Label>
                   <p class="info">${Member.getFullname() }</p>
                    <form action=""><input type="text" name="" id="" placeholder="New Name"></form>
                    <a><button class="edit" onclick="ShowEditFeild('Tata')"><i class="far fa-edit"></i></button></a>
                    <a><button class="cancel" onclick="CancelEditing('Tata')"><i class="fas fa-times"></i></button></a>
               </div>
               <div class="EmailBox Box">
                <Label class="Title">Email Address</Label>
                <p class="info">${Member.getEmail() }</p>
                <form>
                    <input type="text" name="" id="" placeholder="New Email">
                    <button class="edit"><i class="far fa-edit"></i></button>
                    <button class="cancel"><i class="fas fa-times"></i></button>
                 </form>
               </div>
               <div class="PasswordBox Box">
                <Label class="Title">Password</Label>
                <p class="info">${Member.getPassword() }</p>
                <form>
                    <input type="text" name="" id="" placeholder="New Password">
                    <button class="edit"><i class="far fa-edit"></i></button>
                    <button class="cancel"><i class="fas fa-times"></i></button>
                 </form>
               </div>
           </div>
           <div class="Additional-infoBox infoBox">
            <header>Additional information</header>
               <div class="divider"></div>
               <div class="GenderBox Box">
                   <Label class="Title">Gender</Label>
                   <p class="info">${Member.getGender() }</p>
                   <form>
                       <input type="text" name="" id="" placeholder="New Name">
                       <button class="edit"><i class="far fa-edit"></i></button>
                       <button class="cancel"><i class="fas fa-times"></i></button>
                    </form>
               </div>
               <div class="EducationLevel Box">
                <Label class="Title">Education Level</Label>
                <p class="info">3rd Year Fcis</p>
                <form>
                    <input type="text" name="" id="" placeholder="New Password">
                    <button class="edit"><i class="far fa-edit"></i></button>
                    <button class="cancel"><i class="fas fa-times"></i></button>
                 </form>
               </div>
               <div class="BirthDate Box">
                <Label class="Title">BirthDate</Label>
                <p class="info">${Member.getBirthdate() }</p>
                <form>
                    <input type="text" name="" id="" placeholder="New Email">
                    <button class="edit"><i class="far fa-edit"></i></button>
                    <button class="cancel"><i class="fas fa-times"></i></button>
                 </form>
               </div>
           </div>
           <div class="Contact-infoBox infoBox">
            <header>Contact information</header>
            <div class="divider"></div>
               <div class="Phone Box">
                   <Label class="Title">Phone</Label>
                   <p class="info">${Member.getPhone() }</p>
                   <form>
                       <input type="text" name="" id="" placeholder="New Name">
                       <button class="edit"><i class="far fa-edit"></i></button>
                       <button class="cancel"><i class="fas fa-times"></i></button>
                    </form>
               </div>
               <div class="Nationality/City Box">
                <Label class="Title">Nationality/City</Label>
                <p class="info">${Member.getNationality() }</p>
                <form>
                    <input type="text" name="" id="" placeholder="New Email">
                    <button class="edit"><i class="far fa-edit"></i></button>
                    <button class="cancel"><i class="fas fa-times"></i></button>
                 </form>
               </div>
               <div class="Website Box">
                <Label class="Title">Website</Label>
                <p class="info">Add Website</p>
                <form>
                    <input type="text" name="" id="" placeholder="New Password">
                    <button class="edit"><i class="far fa-edit"></i></button>
                    <button class="cancel"><i class="fas fa-times"></i></button>
                 </form>
               </div>
           </div>
           <div class="Jop-infoBox infoBox">
            <header>Jop information</header>
            <div class="divider"></div>
               <div class="Company Box">
                   <Label class="Title">Company</Label>
                   <p class="info">Add Company</p>
                   <form>
                       <input type="text" name="" id="" placeholder="New Name">
                       <button class="edit"><i class="far fa-edit"></i></button>
                       <button class="cancel"><i class="fas fa-times"></i></button>
                    </form>
               </div>
               <div class="JopTitle Box">
                <Label class="Title">Jop Title</Label>
                <p class="info">Add Jop Title</p>
                <form>
                    <input type="text" name="" id="" placeholder="New Email">
                    <button class="edit"><i class="far fa-edit"></i></button>
                    <button class="cancel"><i class="fas fa-times"></i></button>
                 </form>
               </div>
               <div class="Department Box">
                <Label class="Title">Department</Label>
                <p class="info">Add Department</p>
                <form>
                    <input type="text" name="" id="" placeholder="New Password">
                    <button class="edit"><i class="far fa-edit"></i></button>
                    <button class="cancel"><i class="fas fa-times"></i></button>
                 </form>
               </div>
           </div>
           </div>
       </div>
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
<!--<img src="data:image/jpg;base64,${Member.getPhoto()}" /><br>
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
<p>${Member.getUserType() }</p><br>-->
</body>
</html>