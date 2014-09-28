<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 引入jstl解析标签 -->
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %><!-- 引入自定义权限标签 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>冰川网贷平台</title>
   	<!-- 引入公用的js和样式库 -->
	<jsp:include page="../inc.jsp"/>
	<style type="text/css">
		body {
		    padding-top: 100px;
		}
		ol, ul {
		    list-style: none outside none;
		    margin: 0;
    		padding: 0;
		}
	</style>
  </head>
  <script type="text/javascript">
	$(function(){   
		var type='<%=request.getAttribute("type")%>'; 
		//取到列表
		var li=$("#u2").children(); 
		var clas=null;
		$.each(li, function(key, val) {
			clas = $(val).attr('name');
		    if(type == clas){
		    	$("#u2").children().eq(key).addClass("active");
		    	return false;
		    } 
		});
		 
		$("#new").click(function(){ 
			//用于改变选择了的样式
			 $("li").removeClass("active");
			 $(this).parent().addClass("active"); 
			$("#u2").slideToggle("slow"); 
		});
	});
	</script>
  <body>
    <jsp:include page="../nav.jsp"/>
       
	    <div class="container">
	  	<div class="row">
		    <div class="col-md-2">
			    <div class="panel-group" id="accordion">
			    	<div class="panel panel-default">
				  		<div class="bs-example">
					      <ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
					        <li><a href="${ctx}/aboutUs.htm">公司简介</a></li>
					        <li><a href="${ctx}/announcement/announcement.htm?&p=1">网站公告</a></li>
						      <li><a href="#" id="new">新闻资讯</a>
							    <ul  class="nav nav-pills nav-stacked" style="max-width: 300px;" id="u2">
							       <li name="trade"><a href="${ctx}/news/news.htm?&p=1&type=trade">贸易新闻</a></li>
							       <li name="land"><a href="${ctx}/news/news.htm?&p=1&type=land">陆运新闻</a></li>
							       <li name="airlift"><a href="${ctx}/news/news.htm?&p=1&type=airlift">空运新闻</a></li>
							       <li name="sea"><a href="${ctx}/news/news.htm?&p=1&type=sea">海运新闻</a></li>
							    </ul> 
						    </li>
							       
					        <li><a href="${ctx}/hiring/hiring.htm?&p=1">招纳贤士</a></li>
					        <li><a href="${ctx}/contactUs.htm">联系我们</a></li>
					        <li><a href="${ctx}/others/otherAddress.htm">公司地图</a></li>
					        <li><a href="${ctx}/others/others.htm">其他业务</a></li>
					      </ul>
				  		</div>
				  	</div>
				  	<div class="panel panel-default">
						<img src="${pageContext.request.contextPath}/resources/images/newbie/about001.jpg" alt="联系我们">
					</div>
					<div class="panel panel-default">
						<img src="${pageContext.request.contextPath}/resources/images/index/weixin.jpg" width="163" height="163" alt="联系我们">
						<p>扫描二维码关注冰川越海物流微信，获取冰川越海物流最新动态 </p>
					</div>
			  	</div>
	  		</div>
	    	<div class="col-md-10">
	    		<div class="panel panel-default">
				  <div class="panel-heading">
				    <h3 class="panel-title">关于我们 / 网站新闻</h3>
				  </div>
				  <div class="panel-body">
			          
			          <h3>新闻详细</h3>
				      
			          <div>
							<div align="center">${newsData.webNewsTheme}</div>
							<h5></h5>
					        <div>${newsData.webNewsContent}</div>
					        <h5></h5>
					        <div align="right">发布时间：<fmt:formatDate value="${newsData.createTime}" type="both"/></div>
				      </div>
			          
				  </div>
				</div>
	    	</div>
	    </div>
	    <hr class="featurette-divider2">
	    
	    </div>   
	    <jsp:include page="../foot.jsp"/>
  </body>
</html>