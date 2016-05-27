<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button id="b01">JqueryGET请求</button>
</body>
<script type="text/javascript" src="/tom-jsjquery/js/jquery.min.js"</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#b01").click(function() {
			$.get("http://127.0.0.1:8080/tom-jsjquery/ajaxServlet", function(data) {
				alert("Data: " + data);
			});
		});
	});
</script>
</html>