<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<base href="<%=basePath%>">
<title>首页</title>
<link href="https://www.biqukan.cc/novel/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://www.biqukan.cc/novel/css/font-awesome.min.css"
	rel="stylesheet">
<link href="https://www.biqukan.cc/novel/css/site.css" rel="stylesheet">
<link rel="apple-touch-icon-precomposed"
	href="https://www.biqukan.cc/novel/images/apple-touch-icon-precomposed.png">
</head>
<body>
	<div class="container body-content">
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default hidden-xs">

					<div class="panel-body">
					<c:if test="${!empty indexnovelList }">
						<c:forEach items="${indexnovelList}" var="indexnovel">
							<div class="col-md-3 col-xs-6 mb10 mt10">
								<a class="thumbnail" href="#"
									title="${indexnovel.novelName }"><img
									src="${indexnovel.picture }"
									alt="${indexnovel.novelName }" style="height: 182px;">
									<div class="caption">
										<strong>${indexnovel.novelName }</strong><br>
										<span class="text-muted fs-12">${indexnovel.author } / 著</span><br>
										<span class="text-warning fs-12">${indexnovel.readPeople }人在看</span>
									</div> 
									</a>
							</div>
						</c:forEach>
					</c:if>
						
						<div class="clear"></div>
					</div>
				</div>
			</div>
</body>
</html>