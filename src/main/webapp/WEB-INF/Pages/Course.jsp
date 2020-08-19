<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<button onclick="AddQuestion()">Add Question</button>
<form action="/Main/Course/AddQuiz" method="post">
	<br>
	<div id="form-div" class="Quiz-form-class"></div>
	<input id="counter" type="hidden" name="QuestionCounter" value="0"/>
	<input type="submit" value="Upload Quiz"><br>    
</form>
<br>

<script>
var counter=0;
function AddQuestion() {
	var Question = document.createElement('input');
	SetAtt("name",counter+'Q',Question);
	SetAtt("id",counter+'Q',Question);
	document.getElementById("form-div").appendChild(Question);
	
	var Delete = document.createElement('button');
	SetAtt("type","button",Delete);
	SetAtt("onclick","DeleteQuestion(this.id)",Delete);
	SetAtt("id",counter,Delete);
	Delete.innerHTML = "Delete";

  	document.getElementById("form-div").appendChild(document.createElement('br'));
	for(var i=0;i<4;i++)
		{
		var Answer = document.createElement('input');
		SetAtt("name",counter+'A'+i,Answer);
		SetAtt("id",counter+'A'+i,Answer);
	  	document.getElementById("form-div").appendChild(Answer);
	  	document.getElementById("form-div").appendChild(document.createElement('br'));
		}
	document.getElementById("form-div").appendChild(Delete);
	document.getElementById("form-div").appendChild(document.createElement('br'));
  	document.getElementById("counter").value=++counter;
}

function DeleteQuestion(index){
	var id=parseInt(index,10);
	document.getElementById(id).remove();
	document.getElementById(id+'Q').remove();
	for(var i=0;i<4;i++)
	{
		document.getElementById(id+'A'+i).remove();
	}

	for(var i=id+1;i<counter;i++)
	{
		document.getElementById(i).id=i-1;
		document.getElementById(i+'Q').name=(i-1)+'Q';
		document.getElementById(i+'Q').id=(i-1)+'Q';
		for(var j=0;j<4;j++)
		{
			document.getElementById(i+'A'+j).name=(i-1)+'A'+j;
			document.getElementById(i+'A'+j).id=(i-1)+'A'+j;
			
		}
	}
	document.getElementById("counter").value=--counter;
}

function SetAtt(Att,Val,Ele)
{
	var att = document.createAttribute(Att);
	att.value=Val;
	Ele.setAttributeNode(att);
}

</script>
</body>
</html>