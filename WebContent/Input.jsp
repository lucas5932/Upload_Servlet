<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

input.jsp<br><br>

<form action = "FileServ" method = "post" enctype="multipart/form-data"> 
	이름 : <input type="text"	name="name"> <br><br>
	화일 : <input type="file" name = "file"><br><br>
	
	<input type="submit" value="전송">
</form>