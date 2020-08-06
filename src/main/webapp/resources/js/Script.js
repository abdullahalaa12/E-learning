var uploadphoto = document.getElementById("AddPhoto-btn"),
    imge = document.getElementById("image"),
    i,
    inputs = "input-field",
    selectContent=document.querySelectorAll("#Page-Content div"),
    selectLabels = document.querySelectorAll(".Labels"),
    MenuDiv = document.getElementById("Menu"),
    imge2 = document.getElementById("ProPho").style.background,
    Menudivs = document.querySelectorAll("#Container div");
    
function CloseBar(){
    MenuDiv.style.width="0%";
    document.getElementById("Page-Content").style.width="100%";
    document.getElementById("logo").style.display="none";
    document.getElementById("Container").style.width="0%";
    document.getElementsByClassName("openmenu").style.display="block";
}
function OpenMenu(){
    MenuDiv.style.width="15%";
    document.getElementById("Page-Content").style.width="85%";
    document.getElementsByClassName("openmenu").style.display="none";
    document.getElementById("logo").style.display="block";
    document.getElementById("Container").style.width="100%";
}
function ShowContent(contentID){
    for(i=0;i<selectContent.length;i++)
    {
        if(i == contentID-1)
        {
            selectContent[i].style.display="block";
        }
        else
        selectContent[i].style.display="none";
    }
}
function Showbtn(){
    document.getElementById("Re").style.width = "150px";
    document.getElementById("Re").innerHTML = "<strong><i class=\"fas fa-user-plus\"></i></strong>&nbsp; <strong>Register</strong>";
}
function ShowMenu(){
    document.getElementById("Container").style.transform = "translate(80%)";
    document.getElementById("Container").style.backgroundColor= "rgb(44,58,71)";

    for(i = 0;i<Menudivs.length;i++)
    {
        /*Menudivs[i].style.marginTop = "0";*/
        Menudivs[i].style.borderBottomRightRadius = "0";
        Menudivs[i].style.borderTopRightRadius = "0";
        Menudivs[i].style.backgroundColor = "transperant";
        Menudivs[i].style.borderBottom = "0.5px solid white";
    }
}
function AddPhoto()
{
    uploadphoto.click();
}
function loadFile(event) {
    imge.src = URL.createObjectURL(event.target.files[0]);
}
$(function() {

    //populate our years select box
    for (i = new Date().getFullYear(); i > 1900; i--){
        $('#years').append($('<option />').val(i).html(i));
    }
    //populate our months select box
    for (i = 1; i < 13; i++){
        $('#months').append($('<option />').val(i).html(i));
    }
    //populate our Days select box
    updateNumberOfDays(); 

    //"listen" for change events
    $('#years, #months').change(function(){
        updateNumberOfDays(); 
    });

});

//function to update the days based on the current values of month and year
function updateNumberOfDays(){
    $('#days').html('');
    month = $('#months').val();
    year = $('#years').val();
    days = daysInMonth(month, year);

    for(i=1; i < days+1 ; i++){
            $('#days').append($('<option />').val(i).html(i));
    }
}

//helper function
function daysInMonth(month, year) { return new Date(year, month, 0).getDate();
}

