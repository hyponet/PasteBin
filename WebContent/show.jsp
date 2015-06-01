<%@page import="net.ihypo.db.CodeDrive"%>
<%@page import="net.ihypo.code.Code"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%
    	long id = Long.parseLong(request.getParameter("id"));
    	Code code = (Code)session.getAttribute("" + id);
    	//Code code = null;
    	if(code == null){
    		code = CodeDrive.getCode(id);
    		session.setAttribute("" + id, code);
    	}
    %>
 <!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>PasteBin</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="google-code-prettify/prettify.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="google-code-prettify/prettify.js"></script>
    <style type="text/css">
        .row{
            margin: 10px auto;
        }
    </style>
</head>
<body onload="prettyPrint()">
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.html">PasteBin</a>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
                <div class="row">
                    <div class="col-md-6">
                        <label for="poster">Poster:<%=code.getName()%></label>
                    </div>
                    <div class="col-md-6">
                    	<label for="lang">
                    		Title:<%=code.getTitle() %> 
                    	</label>
                    </div>
                    <div class="col-md-6">
                        <label for="poster">Syntax:<%=code.getLang().toUpperCase() %></label>
                    </div>
                    <div class="col-md-6">
                    	<label for="lang">
                    		Time:<%=code.getTime() %> 
                    	</label>
                    </div>
                </div>
        </div>
        <div class="row">
                    <div class="col-md-12">
                    	<pre class="prettyprint linenums lang-<%=code.getLang() %>"><%=code.getContent()%></pre>
                    </div>
                </div>
    </div>

</div>
</body>
</html>