<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html ">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>小说网</title>
	<link type="text/css" rel="stylesheet" href="css/basic.css">
	<link type="text/css" rel="stylesheet" href="css/search.css">
</head>
<body>
<!-- 头部 -->
<%@ include file="head.jsp"  %>	
<!--主体-->
	
	<div id="searcherAll">
		<div class="searcherTop">
			<span>共计1111本相关作品&nbsp;|</span>
		</div>
		
		<div class="searcherFoot">
			<ul>
				<li>
					<div id="novelImg">
						<a href="#" style="cursor: pointer;"><img src="images/150.jpg" style="width:100%;height:90%;margin:10px;"/></a>
					</div>
					<div id="novelMsg">
						<a href="#" style="cursor: pointer;"><h4>凡人修仙传·仙界篇</h4></a>
						<p id="novelP1">
							<a href="#">忘语</a>
							<em>|</em>
							<a href="#">仙侠</a>
							<em>|</em>
							<span>连载</span>
						</p>
						<p style="font-size:15px;padding-top:10px;">凡人修仙，风云再起时空穿梭，轮回逆转金仙太乙，大罗道祖三千大道，法则至尊《凡人修仙传》
						仙界篇，一个韩立叱咤仙界的故事，一个凡人小子修仙的不灭传说。</p>
						<p style="padding-top:10px;color:#B9A6A6;">80万字</p>
						<a href="#" onclick="#" class="addCollection">加入收藏</a>
					</div>
				</li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
		<div id="page">
					<ul>
						<li><a href="#"> < </a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li>...</li>
						<li><a href="#">687</a></li>
						<li><a href="#">></a></li>
						<li><input type="text" value="" id="textChange"/></li>
						<li><a href="#">Go</a></li>
					</ul>
				</div>
	</div>
	
<!--主体结束-->
<!-- 底部 -->
<%@ include file="footer.jsp"  %>
</body>	
</html>

