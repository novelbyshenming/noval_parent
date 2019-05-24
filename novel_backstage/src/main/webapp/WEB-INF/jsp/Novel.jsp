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
		<meta charset="UTF-8">
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
						<div class="am-g">
							<div class="am-u-sm-12 am-u-md-6">
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
							
									<button type="button" class="am-btn am-btn-default btnAdd">
										<span class="icon-plus"></span> 新增
									</button>
                               
									</div>
								</div>
							</div>
							<form action="<%=basePath%>novel/findByName" method="post">
							<div class="am-u-sm-12 am-u-md-3">
								<div class="am-input-group am-input-group-sm">
									
										<input  class="am-form-field" placeholder="请输入小说名" type="text" name="search">
										
										<span class="am-input-group-btn" >
										<button class="am-btn am-btn-default" type="button">
											搜索
										</button> </span>
										
								</div>
							</div>
							</form>
						</div>

						<div class="am-g" style="margin-top: 5px;">
							<div class="am-u-sm-12">
								<form class="am-form">
									<table class="am-table am-table-striped am-table-hover table-main">
										<thead>
											<tr>
												<th class="table-id">
													<input id="chkAll" type="checkbox">
												</th>

												<th>小说名称</th>
												
												<th>作者</th>
												<th>类型</th>
												<th>更新章节</th>
												<th>小说描述</th>
												<th>更新时间</th>
												<th class="table-set">操作</th>
											</tr>
										</thead>
										<tbody id="tUser">
										<c:if test="${!empty novelList }">
										<c:forEach items="${novelList}" var="novel">
											<tr>
												<td><input name="chks" value="701" type="checkbox"></td>
												<td>${novel.novelName }</td>
												
												<td>${novel.author }</td>
												<td>${novel.type }</td>
												<td>${novel.latestChapters }</td>
												<td>${novel.introduction }</td>
												<td>${novel.tdate }</td>	
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs">
															<button type="button" id="role_701"
																class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit">
																<span class="am-icon-pencil-square-o"></span> 编辑
															</button>
															<button type="button"  
																class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" 
																onclick="del()" >
																<span class="am-icon-trash-o"></span> 删除
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