<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Search Resume</title>
<script>
function schName(){
	var name = document.form1.myname.value;

	if ( name == "") {
		alert("검색할 이름을 입력하세요");
		return;
	}
	else
		document.form1.submit();
}
</script>
</head>
<body>
<form name="form1" method="post" action="schPerson">
	<input type="text" name="myname" size="20"> <input type="button" value="이름검색" onclick="schName()">
	<br><a href='add'> 신규등록 </a><br>
</form>
</body>
</html>