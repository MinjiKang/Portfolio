<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Create portfolio</title>
<meta name="description" content="">
<meta name="author" content="">

  <style>
  p#topic{
    font-size:15pt;
    color: black;
    font-weight: bold;
    text-decoration: underline;
    font-family: Times New Roman;
  }
  p#name{
    font-size:20pt;
    color: black;
    font-weight: bold;
    font-family: Times New Roman;
  }
  h1{
    font-size:30pt;
    color: black;
    text-align: center;
    font-family: Times New Roman;
  }
  </style>
  <script language="javascript">
var oTbl;
//Objective Row추가
function ObjectiveinsRow() {
  oTbl = document.getElementById("ObjectiveaddTable");
  var oRow = oTbl.insertRow();
  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex}; //clickedRowIndex - 클릭한 Row의 위치를 확인;
  var oCell = oRow.insertCell();

  //삽입될 Form Tag
  var frmTag = "<input type=text size = 80 id = 'obj_content' name = 'obj_content' placeholder = Content> ";
  frmTag += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
  oCell.innerHTML = frmTag;
}

//Activities Row 추가
function ActivitiesinsRow() {
  oTbl = document.getElementById("ActivitiesaddTable");
  var oRow = oTbl.insertRow();
  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex}; //clickedRowIndex - 클릭한 Row의 위치를 확인;
  var oCell = oRow.insertCell();

  //삽입될 Form Tag
  var frmTag = "<input type=text id = 'act_content' name = 'act_content' size = 80 placeholder = Content> ";
  frmTag += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
  oCell.innerHTML = frmTag;
}

var count=0; //경험1
var count1=0; //경험2

//Experiences Row 추가
function ExperiencesinsRow() {
  ++count1;
  alert(count1);
  oTbl = document.getElementById("ExperiencesaddTable");
  var oRow = oTbl.insertRow();
  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex}; //clickedRowIndex - 클릭한 Row의 위치를 확인;
  var oCell = oRow.insertCell();

  //삽입될 Form Tag
  var frmDateTag = "<input type=text id = 'exp_date' name = 'exp_date1' placeholder = Date> ";
  var frmPlaceTag = "<input type=text id = 'exp_place' name = 'exp_place1' placeholder = Place> ";
  var frmTag = "<input type=text id = 'exp_content' name = 'exp_content1' size = 80 placeholder = Content> ";
  frmTag += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
  oCell.innerHTML = frmDateTag + frmPlaceTag + frmTag;
}

//Experiences content Row 추가
function ExpContentinsRow() {
  ++count;
  alert(count);
  oTbl = document.getElementById("ExpContentaddTable");
  var oRow = oTbl.insertRow();
  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex}; //clickedRowIndex - 클릭한 Row의 위치를 확인;
  var oCell = oRow.insertCell();

  //삽입될 Form Tag
  var frmTag = "<input type=text id = 'exp_content' name = 'exp_content' size = 80 placeholder = Content> ";
  frmTag += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
  oCell.innerHTML = frmTag;
}

//Works Row 추가
function WorksinsRow() {
  oTbl = document.getElementById("WorksaddTable");
  var oRow = oTbl.insertRow();
  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex}; //clickedRowIndex - 클릭한 Row의 위치를 확인;
  var oCell = oRow.insertCell();

  //삽입될 Form Tag
  var frmTag = "<input type=text  id = 'work_content' name = 'work_content' size = 80 placeholder = Content> ";
  var frmDateTag = "<input type = text id = 'work_date' name = 'work_date' size = 20 placeholder = Date>";
  frmTag += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
  oCell.innerHTML = frmDateTag + frmTag;
  
}

//Row 삭제
function removeRow() {
  oTbl.deleteRow(oTbl.clickedRowIndex);
}

function insert(){
	document.insForm.count.value=count+1;
	document.insForm.count1.value=count1;
	document.insForm.action = 'insert';
	document.insForm.submit();
}


</script>
</head>
<body>

<form method ='post' name='insForm'>
<input type="hidden" name="count">
<input type="hidden" name="count1">
<input type="button" value="등록"  onclick="insert()">

  <div class="container">
    <div class="row">
      <div id="header" ailgn = "center">
      <h1>RESUME</h1><br><br>
      <!-- <div class="col-md-12 text-center">
      </div> -->
      <p id="name"><input type = "text" id = 'my_name' name = 'my_name'placeholder = "Name" size = 50 ></p>
          <input type = "text" id = 'my_address' name = 'my_address' placeholder = "Address" size = 50 ><br>
          <input type = "text" id = 'my_email' name = 'my_email' placeholder = "Email"size = 50 ><br>
          <input type = "text" id = 'my_phone' name = 'my_phone' placeholder = "Phone" size = 50 ><br>
             
         <!-- 구분선 -->
        <div style="height: auto; width:150%; border-bottom:1px solid black; border-style:double">
        </div> 


          <p id="topic">Objective</p>
          <input type = "text" id = 'obj_content' name = 'obj_content' placeholder = "Content" size = 80 >
          <input name="addButton" type="button" style="cursor:hand" onClick="ObjectiveinsRow()" value="추가">
          <table id="ObjectiveaddTable" width="400" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" border="0"></table>

        
          <p id="topic">Experiences</p>
          
          <input type = "text" id = 'exp_date' name = 'exp_date' placeholder = "Date">
          <input type = "text" id = 'exp_place' name = 'exp_place' placeholder = "Place"><br>
          <input type = "text" id = 'exp_content' name = 'exp_content' placeholder = "Content" size = 80><br>
          <input name="addButton" type="button" style="cursor:hand" onClick="ExpContentinsRow()" value="내용추가">
          <table id="ExpContentaddTable" width="400" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" border="0"></table>
          
          <input name="addButton" type="button" style="cursor:hand" onClick="ExperiencesinsRow()" value="경험추가">
          <table id="ExperiencesaddTable" width="400" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" border="0"></table>
          
          <!-- <input type = "text" id = 'exp_date' name = 'exp_date' placeholder = "Date">
          <input type = "text" id = 'exp_place' name = 'exp_place' placeholder = "Place"><br>
          <input type = "text" id = 'exp_content' name = 'exp_content' placeholder = "Content" size = 80><br> -->
          <!-- <input name="addButton" type="button" style="cursor:hand" onClick="ExpContentinsRow()" value="내용추가">
          <table id="ExpContentaddTable" width="400" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" border="0"></table>
          <input name="addButton" type="button" style="cursor:hand" onClick="ExperiencesinsRow()" value="경험추가">
          <table id="ExperiencesaddTable" width="400" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" border="0"></table> -->
          

          <p id="topic">Education</p>
          <input type = "text" id = 'edu_school' name = 'edu_school' placeholder = "School">
          <input type = "text" id = 'edu_city' name = 'edu_city' placeholder = "City"><br>
          <input type = "text" id = 'edu_mojor' name = 'edu_mojor' placeholder = "Major">
          <input type = "text" id = 'edu_date' name = 'edu_date' placeholder = "Date"><br>
          

          <p id="topic">Activities</p>
          <input type = "text" id = 'act_content' name = 'act_content' placeholder = "Content" size = 80>
          <input name="addButton" type="button" style="cursor:hand" onClick="ActivitiesinsRow()" value="추가">
          <table id="ActivitiesaddTable" width="400" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" border="0"></table>
          
		
          <p id="topic">Skills</p>
          <input type = "text" id = 'skill_language' name = 'skill_language' placeholder = "Language" size = 80  ><br>
          <input type = "text" id = 'skill_tool' name = 'skill_tool' placeholder = "Tool" size = 80  ><br>
          <input type = "text" id = 'skill_software' name = 'skill_software' placeholder = "Software" size = 80  ><br>
          
		
          <p id="topic">Volunteer Works</p>
          <input type = "text" id = 'work_date' name = 'work_date' placeholder = "Date" size = 20  >
		  <input type = "text" id = 'work_content' name = 'work_content' placeholder = "Content" size = 80  >
          <input name="addButton" type="button" style="cursor:hand" onClick="WorksinsRow()" value="추가">
          <table id="WorksaddTable" width="400" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" border="0"></table>
          
    </div>
  </div>
</div>
</form>
</body>
