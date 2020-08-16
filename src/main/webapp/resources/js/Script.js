var uploadphoto = document.getElementById("AddPhoto-btn"),
    imge = document.getElementById("image"),
    i,
    inputs = "input-field",
    selectContent=document.querySelectorAll("#Page-Content .page"),
    selectLabels = document.querySelectorAll(".Labels"),
    MenuDiv = document.getElementById("Menu"),
    imge2 = document.getElementById("ProPho").style.background,
    Menudivs = document.querySelectorAll("#Container div")
    Menubtns = document.querySelectorAll(".PageButtons");
    
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
function MenubtnIn(btnName){
    document.querySelector("." + btnName + " label").style.paddingLeft="10px";
    document.querySelector("." + btnName + " label").style.color="white";
}
function MenubtnOut(btnName){
    document.querySelector("." + btnName + " label").style.paddingLeft="0";
    document.querySelector("." + btnName + " label").style.color="#ced6e0";
}
function MenubtnFocused(btnName){
    for(i=0;i<Menubtns.length;i++)
    {
        if(Menubtns[i] === document.querySelector("." + btnName))
        {
            document.querySelector("." + btnName + " label").style.color="#D6A2E8";
            continue;
        }
        else
        Menubtns[i].childNodes[0].style.color="#ced6e0";
    }
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
function ShowEditFeild(BoxName){
    var childs= document.getElementById(BoxName).childNodes;
    var Paragraph = childs[3];
    var editbtn = childs[7];
    var cancelbtn = childs[9];  
    console.log(childs[5].nodeName);  
    for(i=0;i<childs.length;i++)
    {
        if(childs[i].nodeName == "FORM")
        {
            childs[i].firstChild.style.borderBottom = "3px solid #2C3A47";
            childs[i].firstChild.style.width = "250px";
            Paragraph.style.display="none";
            editbtn.firstChild.style.display="none";
            cancelbtn.firstChild.style.display = "block";
        }
        else
            continue;
    }
}
function CancelEditing(BoxName){
    var childs= document.getElementById(BoxName).childNodes;
    var Paragraph = childs[3];
    var editbtn = childs[7];
    var cancelbtn = childs[9];
    console.log(childs[3].nodeName);
    for(i=0;i<childs.length;i++)
    {
        if(childs[i].nodeName == "FORM")
        {
            childs[i].firstChild.style.borderBottom = "3px solid white";
            childs[i].firstChild.style.width = "0px";
            Paragraph.style.display="block";
            editbtn.firstChild.style.display="block";
            cancelbtn.firstChild.style.display = "none";
        }
        else
            continue;
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
function bigdiv(divname){
    document.getElementById(divname).style.height="10%";
    var newDiv = document.createElement("DIV");
    document.getElementById("Announcements").appendChild(newDiv);
}
