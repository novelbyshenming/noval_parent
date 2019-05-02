<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html ">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>免费专区</title>
	<link type="text/css" rel="stylesheet" href="css/basic.css">
	<link type="text/css" rel="stylesheet" href="css/free.css">
</head>
<body>
<!-- 头部 -->
<%@ include file="head.jsp"  %>

<!--主体-->
	<div id="freeing">
		<div id="freeLable">
			<ul>
				<li><a href="free.jsp">免费专区</a></li>
			</ul>
		</div>
		<div id="freeMain">
			<div id="screen">
				<div id="classify">
					<h3>分类</h3>
					<ul id="ulClassify">
						<li onclick="changeClassify(this)"><a href="#">全部</a></li>
						<li onclick="changeClassify(this)"><a href="#">玄幻</a></li>
						<li onclick="changeClassify(this)"><a href="#">仙侠</a></li>
						<li onclick="changeClassify(this)"><a href="#">都市</a></li>
						<li onclick="changeClassify(this)"><a href="#">悬疑</a></li>
						<li onclick="changeClassify(this)"><a href="#">灵异</a></li>
						<li onclick="changeClassify(this)"><a href="#">游戏</a></li>
						<li onclick="changeClassify(this)"><a href="#">科幻</a></li>
						<li onclick="changeClassify(this)"><a href="#">穿越</a></li>
					</ul>
				</div>
				
				<div id="state">
					<h3>状态</h3>
					<ul id="ulState">
						<li onclick="changeState(this)"><a href="#">全部</a></li>
						<li onclick="changeState(this)"><a href="#">完本</a></li>
						<li onclick="changeState(this)"><a href="#">连载</a></li>
					</ul>
				</div>
				
				<div id="updateTime">
					<h3>更新时间</h3>
					<ul id="ulUpdate">
						<li onclick="changeUpdate(this)"><a href="#">全部</a></li>
						<li onclick="changeUpdate(this)"><a href="#">三日内</a></li>
						<li onclick="changeUpdate(this)"><a href="#">七日内</a></li>
						<li onclick="changeUpdate(this)"><a href="#">一个月内</a></li>
						<li onclick="changeUpdate(this)"><a href="#">三个月内</a></li>
					</ul>
				</div>
			</div>
			<div id="freeShow">
				<div id="freeShowHead">
					<span>共计1111本相关作品&nbsp;|</span>
				</div>
				<div id="freeShowAll">
					<ul>
						<li>
							<div id="novelImg">
								<img src="images/150.jpg" style="width:100%;height:90%;"/>
							</div>
							<div id="novelMsg">
								<h4>凡人修仙传·仙界篇</h4>
								<p id="novelP1">
									<a href="#">忘语</a>
									<em>|</em>
									<a href="#">仙侠</a>
									<em>|</em>
									<span>连载</span>
								</p>
								<p style="font-size:15px;padding-top:15px;">凡人修仙，风云再起时空穿梭，轮回逆转金仙太乙，大罗道祖三千大道，法则至尊《凡人修仙传》
								仙界篇，一个韩立叱咤仙界的故事，一个凡人小子修仙的不灭传说。</p>
								<p style="padding-top:10px;color:#B9A6A6;">80万字</p>
							</div>
						</li>
						<li>
							<div id="novelImg">
								<img src="images/150.jpg" style="width:100%;height:90%;"/>
							</div>
							<div id="novelMsg">
								<h4>凡人修仙传·仙界篇</h4>
								<p id="">
									<a href="#">忘语</a>
									<em>|</em>
									<a href="#">仙侠</a>
									<em>|</em>
									<span>连载</span>
								</p>
								<p style="font-size:15px;padding-top:15px;">凡人修仙，风云再起时空穿梭，轮回逆转金仙太乙，大罗道祖三千大道，法则至尊《凡人修仙传》
								仙界篇，一个韩立叱咤仙界的故事，一个凡人小子修仙的不灭传说。</p>
								<p style="padding-top:10px;color:#B9A6A6;">80万字</p>
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
		</div>
	</div>
<!--主体结束-->

<!-- 底部 -->
<%@ include file="footer.jsp"  %>

<script type="text/javascript">

	function changeClassify(obj){
		var temp = document.getElementById("ulClassify");
		var liArr = temp.getElementsByTagName("li");
		for(var i=0;i<liArr.length;i++){
			liArr[i].setAttribute("style","background-color:#fff;")
		}
		obj.setAttribute("style","background-color:#FF7301;")
	}
	
	function changeState(obj){
		var temp = document.getElementById("ulState");
		var liArr = temp.getElementsByTagName("li");
		for(var i=1;i<liArr.length;i++){
			liArr[i].setAttribute("style","background-color:#fff;")
		}
		obj.setAttribute("style","background-color:#FF7301;")
	}
	
	function changeUpdate(obj){
		var temp = document.getElementById("ulUpdate");
		var liArr = temp.getElementsByTagName("li");
		for(var i=1;i<liArr.length;i++){
			liArr[i].setAttribute("style","background-color:#fff;")
		}
		obj.setAttribute("style","background-color:#FF7301;")
	}
</script>
</body>	
</html>

