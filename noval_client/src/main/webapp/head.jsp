<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="topOne">
		<div class="nav-link">
			<a class="act" href="" >起点中文网</a><em>|</em>
			<a href="" target="_blank" >起点女生网</a><em>|</em>
			<a href="" target="_blank" >创世中文网</a><em>|</em>
			<a href="" target="_blank" >云起书院</a><em>|</em>
			<a href="javascript:" id="switchEl" data-eid="qd_A182">繁体版</a>
			<div class="user">
			<font>
				<a href="denglu.html">登录</a>
				|
			</font>
			<font>
				<a href="#">注册</a>
			</font>
		</div>
		</div>
	</div>
	<div id="Top">
		<div class="logo">
			<a href="#">
				<img src="images/timg.jpg" width="200px" height="50px" />
			</a>
		</div>
		<div class="search">
			<form>
				<div id="searchTxt" class="searchTxt">

					<div class="searchMenu">

						<div class="searchSelected" id="searchSelected">玄幻</div>
						<div style="display:none;" class="searchTab" id="searchTab">

							<ul>
								<li class="">玄幻</li>
								<li>奇幻</li>
								<li>武侠</li>
								<li>仙侠</li>
								<li>都市</li>
								<li>现实</li>
								<li>军事</li>
								<li>历史</li>
								<li>游戏</li>
							</ul>

						</div>

					</div>

					<input name="w" type="text" />
					<div class="searchBtn">
						<button id="searchBtn" type="submit"></button>
					</div>
				</div>

			</form>
		</div>
	</div>

	<div id="Logo">
		<ul>
			<li class="first">
				<span class="iconfont">
					<!-- <div>
						<i></i>
						<i></i>
						<i></i>
					</div> -->
					作品分类
				</span>
			</li>
			<li>
				<a href="index.jsp" title="首页">全部作品</a>
			</li>
			<li>
				<a href="rank.jsp" title="排行">排行</a>
			</li>
			<li>
				<a href="#">完本</a>
			</li>
			<li>
				<a href="free.jsp">免费</a>
			</li>
			<li>
				<a href="#">作家专区</a>
			</li>
			<li>
				<a href="#">客户端</a>
			</li>
			<li class="last"></li>
		</ul>
	</div>
	<!--引用外部jquery文件-->
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript">
			$("img.prev").click(function() {

				$(".imgList ul").animate({
					"left": -280
				}, 500, function() {
					$(this).append($(this).find("li:first"));
					$(this).css("left", 0);
				});

			});

			$("img.next").click(function() {

				autoPlay();

			});

			var cleartime = setInterval(autoPlay, 2000);
			//鼠标放上去，停止播入
			$("img.next,img.prev").hover(function() {
				clearInterval(cleartime);
			}, function() {
				cleartime = setInterval(autoPlay, 3000);
			});

			function autoPlay() {

				$(".imgList ul").prepend($(".imgList ul li:last"));
				$(".imgList ul").css("left", -280);
				$(".imgList ul").animate({
					"left": 0
				}, 500);
			}
			//鼠标导航滑块跟随效果

			$(".PartM ul li:nth-of-type(n)").hover(function() {
				$(".PartM ul li:nth-of-type(n)").css({
					"background": "#efefef",
					"color": "#666"
				});
				$(this).css({
					"width": "100%",
					"background": "#00A1D2",
					"border": "none"
				});
			});

			//图片选项卡
			$(function() {
				$(".PartR>div").hide();
				$(".PartR>div:eq(0)").show();

				$(".PartM a").click(function() {
					var n = $(".PartM a").index(this);
					$(".PartM a").index(this);
					$(".PartR>div").hide();
					$(".PartR>div:eq(" + n + ")").show();
				})

			})

			//下拉
			$(function() {

				$("#searchSelected").click(function() {
					$("#searchTab").show();
					$(this).addClass("searchOpen");
				});

				$("#searchTab li").hover(function() {
					$(this).addClass("selected");
				}, function() {
					$(this).removeClass("selected");
				});

				$("#searchTab li").click(function() {
					$("#searchSelected").html($(this).html());
					$("#searchTab").hide();
					$("#searchSelected").removeClass("searchOpen");
				});

			});
		</script>