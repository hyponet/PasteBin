<%@page import="net.ihypo.db.CodeDrive"%>
<%@page import="net.ihypo.code.Code"%>
<%@page import="java.lang.StringBuffer,java.lang.String"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String poster = new String(request.getParameter("poster").getBytes("ISO-8859-1"),"UTF-8");
	String lang = new String(request.getParameter("lang").getBytes("ISO-8859-1"),"UTF-8");
	String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
	String con = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
	Code code = new Code(poster,title,lang,con);
	if(poster.length()>20){
%>
	<script type="text/javascript">
		window.location="index.html";
		alert("poster must < 20");//好丑，暂时实现功能
	</script>
<%		
	}else if(title.length() > 30){
%>
	<script type="text/javascript">
		window.location="index.html";
		alert("title must < 30");//好丑，暂时实现功能
	</script>
<%		
	}else if(con.length() == 0){
%>
	<script type="text/javascript">
		window.location="index.html";
		alert("content must > 0");//好丑，暂时实现功能
	</script>
<%
	}else{
		CodeDrive.addCode(code); 
		session.setAttribute("" + code.getId(), code);
%>
<script type="text/javascript">
	window.location="show.jsp?id=<%=code.getId()%>"
</script>
<%} %>
