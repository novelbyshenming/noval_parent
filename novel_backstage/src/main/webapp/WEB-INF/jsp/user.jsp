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
<title></title>

<link rel="stylesheet" href="css/amazeui.min.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/app.css">
</head>

<body>

	<div class="am-cf admin-main" style="padding-top: 0px;">
		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body">

				<div class="container" style="padding: 0px 10px 0px 10px">
					
					<div class="am-g" style="margin-top: 5px;">
						<div class="am-u-sm-12">
							<form class="am-form" action="user/delAll.action">
								<table
									class="am-table am-table-striped am-table-hover table-main">
									<thead>
										<tr>
											<th class="table-check"><input id="chkAll"
												type="checkbox"></th>
											<th class="table-id">ID</th>
											<th>用户名</th>
											<th class="table-title">姓名</th>
											<th>性别</th>
											<th>是否VIP</th>
											<th>邮箱</th>
											<th class="table-set">操作</th>
										</tr>
									</thead>
									
									<tbody id="tUser">
									<c:if test="${!empty userList }">
										<c:forEach items="${userList}" var="user">
												<tr>
													<td><input name="ids" value="1" type="checkbox"></td>
													<td>${user.uid }</td>
													<td>${user.userName }</td>
													<td>${user.name }</a></td>
													<td><span class="am-badge am-badge-secondary">${user.sex }</span></td>
													<td>${user.vip }</td>
													<td>${user.email }</td>
													<td>
														<div class="am-btn-toolbar">
															<div class="am-btn-group am-btn-group-xs">
																
																<button type="button"
																	class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
																	onclick="delUser(1,1)">
																	<span class="am-icon-trash-o"></span> 禁止登陆
																</button>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
									</c:if>


									</tbody>
								</table>

							</form>
						</div>
					</div>
				</div>

			</div>
			<!-- content end -->
		</div>
	</div>


	
</body>

</html>