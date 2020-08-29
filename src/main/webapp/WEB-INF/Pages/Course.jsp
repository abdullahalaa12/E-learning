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
<link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
<title>Main</title>
</head>
<body>
<div id="Menu">
       <div class="LogoBox">
       <div class="Logo"></div>
       <p>Online Coursera</p>
       </div>
       <div class="divider divider1"></div>
       <div class="Dashboard_btn PageButtons" onclick="ShowContent(1)" onclick="MenubtnFocused('Dashboard_btn')" onmousemove="MenubtnIn('Dashboard_btn')" onmouseout="MenubtnOut('Dashboard_btn')"><a href="/Main">"<label for="Dashboard_btn"><i class="fas fa-tachometer-alt"></i>&nbsp;Dashboard</label></a></div>
       <div class="divider divider2"></div>
       <div class="Files_btn PageButtons" onclick="ShowContent(2)" onmousemove="MenubtnIn('Files_btn')" onmouseout="MenubtnOut('Files_btn')"> <a id="coursesbutton"><label for="Files_btn"><i class="fas fa-file-word"></i>&nbsp;Files</label></a></div>
       <div class="Quizes_btn PageButtons" onclick="ShowContent(3)" onclick="MenubtnFocused('Quizes_btn')" onmousemove="MenubtnIn('Quizes_btn')" onmouseout="MenubtnOut('Quizes_btn')"><label for="Quizes_btn"><i class="fas fa-pen-square"></i>&nbsp;Quizes</label></div>
       <div class="Announcements_btn PageButtons" onclick="ShowContent(4)" onmousemove="MenubtnIn('Announcements_btn')" onmouseout="MenubtnOut('Announcements_btn')"><a id="announcementsbutton"><label for="Announcements_btn"><i class="fas fa-bullhorn"></i>&nbsp; Announcements</label></a></div>
       <div class="Grades_btn PageButtons" onclick="ShowContent(5)" onmousemove="MenubtnIn('Grades_btn')" onmouseout="MenubtnOut('Grades_btn')"><a id="gradesbutton"><label for="Grades_btn"><i class="fas fa-pen"></i>&nbsp;Grades</label></a></div>
       <div class="divider divider3"></div>
       <div class="Logout_btn PageButtons" onmousemove="MenubtnIn('Logout_btn')" onmouseout="MenubtnOut('Logout_btn')"><a href="/logout"><label for="Logout_btn"><i class="fas fa-sign-out-alt"></i>&nbsp;Logout</label></a></div>
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
       <c:if test="${Member.getUserType() == 'Instructor'}">
           <button class="ShowFormbtn" onclick="ShowForm('FileForm')"><strong><i class="fas fa-plus"></i></strong>&nbsp;</button>
           <div id="FileForm">
            <button class="CloseFormbtn" onclick="CloseForm('FileForm')"><i class="fas fa-times"></i></button>
            <form action="/Main/Course/AddFile" method="post" enctype="multipart/form-data">
                <Label id="FileInfo">File Information</Label>
                <input type="text" name="FileTitle" id="FileTitle" placeholder="File Title" required>
                <Label for="file" id="UploadFilebtn" onclick="FileInputClicked()"><i class="fas fa-upload"></i></Label>
                <Label id="FileValue">No File Added</Label>
                <input type="file" name="UploadedFile" id="file"  hidden="hidden" onchange="loadFile2(event)" required>
                <select  id="FileType">
                    <option value="Word">Word</option>
                    <option value="PPtx">PPtx</option>
                    <option value="Excel">Excel</option>
                    <option value="PDF">PDF</option>
                    <option value="Video">Video</option>
                    <option value="Image">Image</option>
                </select>
                <button id="FileSubmit" type="submit" onclick="ShowFile()">Submit</button>
           </form>   
           </div>
        </c:if>
            <c:forEach items="${FilesArray }" var="file">
            <div class="FileBox">
            	<p>
            		<a href="/Main/Course/ViewFile?FileID=${file.getFileID() }" class="FileLink">${file.getFileTitle() }</a>
            		<c:if test="${Member.getUserType() == 'Instructor'}">
            			<a href="/Main/Course/DeleteFile?FileID=${file.getFileID() }"><button type="button" class="DeleteFile" ><i class="fas fa-trash-alt"></i></button></a>
            		</c:if>
            	</p>
            </div>
            </c:forEach>
       </div>
       <div id="Quizes" class="page">
       <c:if test="${Member.getUserType() == 'Instructor'}">
           <button class="ShowFormbtn" onclick="ShowForm('QuizForm')"><strong><i class="fas fa-plus"></i></strong>&nbsp;</button>
           <div id="QuizForm">
                   <button class="CloseFormbtn" onclick="CloseForm('QuizForm')"><i class="fas fa-times"></i></button>
                   <Label id="QuizInfo">Quiz Information</Label>
		           <button onclick="AddQuestion()" class="AddQuestion">Add Question</button>
					<form action="/Main/Course/AddQuiz" method="post">
					<br>
					<div id="form-div" class="Quiz-form-class"></div>
					<input id="counter" type="hidden" name="QuestionCounter" value="0"/>
					<input type="submit" value="Upload Quiz"><br>    
					</form>
					<br>
            <form action="/Main/Course/AddFile" method="post" enctype="multipart/form-data">
           </form>   
           </div>
        </c:if>
       	<c:forEach items="${QuizesArray }" var="quiz">
            	<p>
            		<a href="/Main/Course/ViewQuiz?QuizID=${quiz.getQuiz_id() }">${quiz.getTitle() }</a>
					<c:if test="${Member.getUserType() == 'Instructor'}">
            			<a href="/Main/Course/DeleteQuiz?QuizID=${quiz.getQuiz_id() }"><button type="button" >Delete</button></a>
            		</c:if>
            	</p>
            </c:forEach>
       </div>
       <div id="Announcements" class="page">
        <c:if test="${Member.getUserType() == 'Instructor'}">
           <button class="ShowFormbtn" onclick="ShowForm('AnnouncementForm')"><strong><i class="fas fa-plus"></i></strong>&nbsp;</button>
           <div id="AnnouncementForm">
            <button class="CloseFormbtn" onclick="CloseForm('AnnouncementForm')"><i class="fas fa-times"></i></button>
            <form action="/Main/Course/AddFile" method="post" enctype="multipart/form-data">
                <Label id="AnnounceInfo">Announcement Information</Label>
              	<textarea name="" id="AnnouncementMessage" placeholder="Your Announcement"></textarea>
                <button id="AnnouncementSubmit" type="submit" onclick="ShowFile()">Submit</button>
           </form>   
           </div>
        </c:if>
       </div>
       <div id="Grades" class="page"></div>    
   </div>
        <script src="/resources/js/Script.js"></script>
        <script type="text/javascript">
            function ShowForm(FormName){
                var FileForm = document.getElementById(FormName);
                FileForm.style.borderLeft = "1px solid rgb(44,58,71)";

            	if(FormName ==="QuizForm"){
                    FileForm.style.width = "80%";
                    document.getElementById("QuizInfo").style.display = "block";
            	}
            	else
                	FileForm.style.width = "700px";
            }
            function CloseForm(FormName){
                var FileForm = document.getElementById(FormName);
                FileForm.style.width="0";
                FileForm.style.border = "none";
                document.getElementById("QuizInfo").style.display = "none";
            }
            function FileInputClicked(){
            	document.document.getElementById("file").click();
            }
            function loadFile2(event) {
            	document.getElementById("FileValue").innerHTML = document.getElementById("file").value.match( /[\/\\]([\w\d\s\.\-\(\)]+)$/)[1];

			}
        </script>
</body>
</html>