<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showall.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <table align="center" width="600" border="1">  	 	
   		<tr align ="center">  	 		
   			<td>ISBN:</td>
   			<td>Title:</td>
   			<td>AuthorID:</td>
   			<td>Publisher:</td>
   			<td>PubishDate:</td>
   			<td>Price</td>
   			<td>删除</td>
		</tr>
		<%@taglib prefix="s" uri="/struts-tags" %>
		<s:iterator id="item" value="list">
		 <tr>
		 <td><s:property value="#item.ISBN"/>  </td>
		 <td><s:property value="#item.Title"/>  </td>  	
		 <td><s:property value="#item.AuthorID"/>  </td>
		 <td><s:property value="#item.Publisher"/>  </td>
		 <td><s:property value="#item.PublishDate"/> </td>
		 <td><s:property value="#item.Price"/> </td>
		 <td>
				<s:url id="url" action="BookAction!Del">
					<s:param name="book.ISBN" value="#item.ISBN"></s:param>
				</s:url>
				<s:a href="%{url}" onclick="return confirm('你确定要删除该图书吗？');">删除</s:a>
			</td>
		 </tr>  	 	
		 </s:iterator>
	</table> 
  </body>
</html>
