<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Internet shop</title>
<link rel="icon" href="/resources/images/logoico.ico" type="images/x-icon">
<link rel="stylesheet" href="/resources/css/screen.css">
<script  src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/form_login.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function() {
		$("select").chosen();
	});
</script>
<style type="text/css">
body{
style="padding:0 14%; "
}
</style>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
 
	<div class="container-fluid" style="padding:0px;">
		<tiles:insertAttribute name="body" />
	</div>
	
</body>
</html>