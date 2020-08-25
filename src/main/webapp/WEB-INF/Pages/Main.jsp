<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
               <p>${Member.getFullname() }</p>
               <div class="userImg" style="background-image: url(${Member.getPhoto()})"></div>
               </div>
           </div>
       </div>
       <div id="Dashboard" class="page">
       </div>
       <div id="Courses" class="page">
       <c:if test="${Member.getUserType() == 'Instructor'}">
    	<button class="ShowFormbtn" onclick="ShowForm('CourseForm')"><strong><i class="fas fa-plus"></i></strong>&nbsp;</button>	
    		<div id="CourseForm">
            <button class="CloseFormbtn" onclick="CloseForm('CourseForm')"><i class="fas fa-times"></i></button>
            <form action="/Main/Course/AddCourse" method="post" enctype="multipart/form-data" class="AddCourseForm">
                <Label id="CourseInfo">Course Information</Label>
                <input type="text" name="CourseName" id="CourseName" placeholder="Name">
                <input type="text" name="CourseField" id="CourseField" placeholder="Field">
                <div id="StartDate-div">
                    <label>Start Date</label><br>
		            <select name="StartDay" id="days">
		        	    <option>Day</option>
		           		<c:forEach var = "i" begin = "1" end = "31">
		        			<option value="${i }">${i }</option>
		     	 		</c:forEach>
		     	 	</select>
		            <select name="StartMonth" id="months">
		                <option>Month</option>
		           		<c:forEach var = "i" begin = "1" end = "12">
		        			<option value="${i }">${i }</option>
		     	 		</c:forEach>
		     	 	</select>
		            <select name="StartYear" id="years">
		                <option>Year</option>
		           		<c:forEach var = "i" begin = "1900" end = "2020">
		        			<option value="${i }">${i }</option>
		     	 		</c:forEach>
		     	 	</select>
            	</div>
            	<div id="EndDate-div">
            	    <label>End Date</label><br>
		            <select name="EndDay" id="days">
		            	<option>Day</option>
		           		<c:forEach var = "i" begin = "1" end = "31">
		        			<option value="${i }">${i }</option>
		     	 		</c:forEach>
		     	 	</select>
		            <select name="EndMonth" id="months">
		            <option>Month</option>
		           		<c:forEach var = "i" begin = "1" end = "12">
		        			<option value="${i }">${i }</option>
		     	 		</c:forEach>
		     	 	</select>
		            <select name="EndYear" id="years">
		            <option>Year</option>
		           		<c:forEach var = "i" begin = "1900" end = "2020">
		        			<option value="${i }">${i }</option>
		     	 		</c:forEach>
		     	 	</select>
            	</div>
            	 <Label for="file" id="UploadFilebtn" onclick="FileInputClicked()"><i class="fas fa-upload"></i></Label>
                <Label id="FileValue">No File Added</Label>
            	<input name="Photo" type="file" value="Add Photo" id="AddPhoto-btn" hidden="hidden" accept="image/*" onchange="loadFile3(event)">
            	 <img src="" alt="" id="ImgCourse">
                <button id="CourseSubmit" type="submit" onclick="ShowFile()">Submit</button>
           </form>   
           </div>
		</c:if>
		 <c:if test="${Member.getUserType() == 'Student'}">
		 <form action="/Main/Course/Enroll" method="post" class="CourseIDForm">
		 	<input name="CourseID" type="text" placeholder="Enter Course ID" class="CourseIDInput" required>
		 	<button class="ShowCourseIDbtn" type="submit"><strong>Enroll</strong>&nbsp;</button>
		  </form>	
		 </c:if>
  		<c:forEach items="${Member.getCourses()}" var="course">
				<div class="CourseBox">
				<div class="CourseImg"></div>
				<p>${course.getCourseID()}</p><br>
				<p>${course.getName()}</p>
				
				<input value="${course.getCourseID()}" name="CourseID" type="hidden">
				<button id="GoToCoursebtn" type="submit"><i class="fas fa-sign-in-alt"></i></button>
				<button id="DeleteCoursebtn" type="submit"><i class="fas fa-trash-alt"></i></button>
				<div class="InstructorImg"><img src="${course.getInstructor().getPhoto() }"/></div>
				<label class="InstructorName">${course.getInstructor().getFullname() }</label>
				<label class="CourseName">${course.getName()}</label>
				<label class="CourseField">${course.getField()}</label>
				<label class="CourseEndDate">${course.getEndDate()}</label>
				</div>
			</c:forEach>
       </div>
       <div id="Profile" class="page">
           <div class="ProPho-Background" style="background-image: url(${Member.getPhoto()})">
               <div class="Blured"></div>
           </div>
           <div class="ProPho" style="background-image: url(${Member.getPhoto()})">
              <div class="shadow">
                <i class="fas fa-camera"></i>
           </div>
           </div>
          <div class="info-container">
           <div class="Account-infoBox infoBox">
               <header>Account information</header>
               <div class="divider"></div>
               <div class="FullNameBox Box" id="FullName">
                   <Label class="Title">Full Name</Label>
                   <p class="info">${Member.getFullname() }</p>
                   <form action="EditProfile" method="post"><input type="text" name="Value">
                   <input type="hidden" name="column" value="FullName">
                   </form>
                    <a><button class="edit" onclick="ShowEditFeild('FullName')"><i class="far fa-edit"></i></button></a>
                    <a><button class="cancel" onclick="CancelEditing('FullName')"><i class="fas fa-times"></i></button></a>
               </div>
               <div class="EmailBox Box" id="Email">
                <Label class="Title">Email Address</Label>
                <p class="info">${Member.getEmail() }</p>
                   <form action="EditProfile" method="post"><input type="text" name="Value">
                   <input type="hidden" name="column" value="Email">
                   </form>
                    <a><button type ="button" class="edit" onclick="ShowEditFeild('Email')"><i class="far fa-edit"></i></button></a>
                    <a><button type ="button" class="cancel" onclick="CancelEditing('Email')"><i class="fas fa-times"></i></button></a>
                 
               </div>
               <div class="PasswordBox Box" id="Password">
                <Label class="Title">Password</Label>
                <p class="info">${Member.getPassword() }</p>
                <form action="EditProfile" method="post"><input type="text" name="Value">
                   <input type="hidden" name="column" value="Password">
                   </form>
                    <a><button type ="button" class="edit" onclick="ShowEditFeild('Password')"><i class="far fa-edit"></i></button></a>
                    <a><button type ="button" class="cancel" onclick="CancelEditing('Password')"><i class="fas fa-times"></i></button></a>
               </div>
           </div>
           <div class="Additional-infoBox infoBox">
            <header>Additional information</header>
               <div class="divider"></div>
               <div class="GenderBox Box" id="Gender">
                   <Label class="Title">Gender</Label>
                   <p class="info">${Member.getGender() }</p>
                   
               </div>
               <div class="EducationLevel Box" id="EducationalLevel">
                <Label class="Title">Education Level</Label>
                <p class="info">3rd Year Fcis</p>

               </div>
               <div class="BirthDate Box">
                <Label class="Title">BirthDate</Label>
                <p class="info">${Member.getBirthdate() }</p>
                
               </div>
           </div>
           <div class="Contact-infoBox infoBox">
            <header>Contact information</header>
            <div class="divider"></div>
               <div class="Phone Box" id="Phone">
                   <Label class="Title">Phone</Label>
                   <p class="info">${Member.getPhone() }</p>
                    <form action="EditProfile" method="post"><input type="text" name="Value">
                   <input type="hidden" name="column" value="Phone">
                   </form>
                    <a><button type ="button" class="edit" onclick="ShowEditFeild('Phone')"><i class="far fa-edit"></i></button></a>
                    <a><button type ="button" class="cancel" onclick="CancelEditing('Phone')"><i class="fas fa-times"></i></button></a>
               </div>
               <div class="Nationality/City Box" id="Nationality">
                <Label class="Title">Nationality/City</Label>
                <p class="info">${Member.getNationality() }</p>
                
               </div>
               <div class="Website Box" id="Website">
                <Label class="Title">Website</Label>
                <p class="info">${Member.getWebsite() }</p>
                 <form action="EditProfile" method="post"><input type="text" name="Value">
                   <input type="hidden" name="column" value="Website">
                   </form>
                    <a><button type ="button" class="edit" onclick="ShowEditFeild('Website')"><i class="far fa-edit"></i></button></a>
                    <a><button type ="button" class="cancel" onclick="CancelEditing('Website')"><i class="fas fa-times"></i></button></a>
               </div>
           </div>
           <div class="Jop-infoBox infoBox">
            <header>Jop information</header>
            <div class="divider"></div>
               <div class="Company Box" id="Company">
                   <Label class="Title">Company</Label>
                   <p class="info">${Member.getCompany() }</p>
                   <form action="EditProfile" method="post"><input type="text" name="Value">
                   <input type="hidden" name="column" value="Company">
                   </form>
                    <a><button type ="button" class="edit" onclick="ShowEditFeild('Company')"><i class="far fa-edit"></i></button></a>
                    <a><button type ="button" class="cancel" onclick="CancelEditing('Company')"><i class="fas fa-times"></i></button></a>
               </div>
               <div class="JopTitle Box" id="Joptitle">
                <Label class="Title">Jop Title</Label>
                <p class="info">${Member.getJoptitle() }</p>
                <form action="EditProfile" method="post"><input type="text" name="Value">
                   <input type="hidden" name="column" value="Joptitle">
                   </form>
                    <a><button type ="button" class="edit" onclick="ShowEditFeild('Joptitle')"><i class="far fa-edit"></i></button></a>
                    <a><button type ="button" class="cancel" onclick="CancelEditing('Joptitle')"><i class="fas fa-times"></i></button></a>
               </div>
               <div class="Department Box" id="Department">
                <Label class="Title">Department</Label>
                <p class="info">${Member.getDepartment() }</p>
                <form action="EditProfile" method="post"><input type="text" name="Value">
                   <input type="hidden" name="column" value="Department">
                   </form>
                    <a><button type ="button" class="edit" onclick="ShowEditFeild('Department')"><i class="far fa-edit"></i></button></a>
                    <a><button type ="button" class="cancel" onclick="CancelEditing('Department')"><i class="fas fa-times"></i></button></a>
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
       <script type="text/javascript">
            function ShowForm(FormName){
                var FileForm = document.getElementById(FormName);
                FileForm.style.width = "700px";
                FileForm.style.borderLeft = "1px solid rgb(44,58,71)";
            }
            function CloseForm(FormName){
                var FileForm = document.getElementById(FormName);
                FileForm.style.width="0";
                FileForm.style.border = "none";
            }
            function loadFile3(event) {
            	document.getElementById("ImgCourse").src = URL.createObjectURL(event.target.files[0]);
            	document.getElementById("FileValue").innerHTML = document.getElementById("AddPhoto-btn").value.match( /[\/\\]([\w\d\s\.\-\(\)]+)$/)[1];
            }
            function FileInputClicked(){
            	document.getElementById("AddPhoto-btn").click();
            }
        </script>
<!--<img src="${Member.getPhoto()}" /><br>
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