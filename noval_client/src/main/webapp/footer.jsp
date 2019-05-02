<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="Footer">
		<div class="footer_nav">
			<a>关于Chen小说网</a>&#12288;|&#12288;
			<a>商务合作</a>&#12288;|&#12288;
			<a>友情链接</a>&#12288;|&#12288;
			<a>帮助中心</a>&#12288;|&#12288;
			<a>用户守则</a>&#12288;|&#12288;
			<a>网站地图</a>&#12288;|&#12288;
			<a>诚聘精英</a>&#12288;|&#12288;
			<a>Chen</a>
		</div>
		<p>
			<a>Copyright (C) 2018-2019 www.chenyij.com All Rights Reserved </a>
			<br />本网站纯属练手。--Chen权利声明。
		</p>
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