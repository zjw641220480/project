<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button id="btn" onclick="getRequest();">GET请求</button>
	<br>
	<button id="btn" onclick="postRequest();">POST请求</button>
	<br>
	<button id="btn" onclick="postRequestJson();">POST请求,体为Json</button>
</body>
<script type="text/javascript">
	// 创建异步对象
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();//大多数浏览器
		} catch (e) {
			try {
				return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
			} catch (e) {
				try {
					return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本	
				} catch (e) {
					alert("哥们儿，您用的是什么浏览器啊？");
					throw e;
				}
			}
		}
	}

	function getRequest() {
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("GET", "http://127.0.0.1:8080/tom-jsjquery/ajaxServlet?id=123&username=zhagnsan",
				true);
		xmlHttp.send(null);//GET请求没有请求体，但也要给出null，不然FireFox可能会不能发送！
		xmlHttp.onreadystatechange = function() {//当xmlHttp的状态发生变化时执行
			// 双重判断：xmlHttp的状态为4（服务器响应结束），以及服务器响应的状态码为200（响应成功）
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				// 获取服务器的响应结束
				var text = xmlHttp.responseText;
				alert(text);
			}
		};
	};
	function postRequest(){
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("POST", "http://127.0.0.1:8080/tom-jsjquery/ajaxServlet",
				true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttp.send("id=123&username=lisi");//GET请求没有请求体，但也要给出null，不然FireFox可能会不能发送！
		xmlHttp.onreadystatechange = function() {//当xmlHttp的状态发生变化时执行
			// 双重判断：xmlHttp的状态为4（服务器响应结束），以及服务器响应的状态码为200（响应成功）
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				// 获取服务器的响应结束
				var text = xmlHttp.responseText;
				alert(text);
			}
		};
	};
	function postRequestJson(){
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("POST", "http://127.0.0.1:8080/tom-jsjquery/jsonServlet",
				true);
		xmlHttp.setRequestHeader("Content-Type", "application/json");
		xmlHttp.send(JSON.stringify({"id":"postJosn","username":"postJson"}));//GET请求没有请求体，但也要给出null，不然FireFox可能会不能发送！
		xmlHttp.onreadystatechange = function() {//当xmlHttp的状态发生变化时执行
			// 双重判断：xmlHttp的状态为4（服务器响应结束），以及服务器响应的状态码为200（响应成功）
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				// 获取服务器的响应结束
				var text = xmlHttp.responseText;
				alert(text);
			}
		};
	}
</script>
</html>