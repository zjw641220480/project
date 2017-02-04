<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>测试请求参数</h1>
	<a href="/tom-web/RequestParam?xxx=XXX&yyy=YYYY">Get的测试</a><br/>
	<form action="/tom-web/RequestParam" method="POST">
		用户名<input type="text" name="username"><br/>
		密  码<input type="password" name="password"><br/>
		爱  好<input type="checkbox" name="hobby" value="cf">吃饭<br/>
			<input type="checkbox" name="hobby" value="sleep">睡觉<br/>
			<input type="checkbox" name="hobby" value="ddm">打代码<br/>
			<input type="submit" value="提交">
	</form>
</body>
</html>