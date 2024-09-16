<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download</title>
<%String emailid=(String)session.getAttribute("emailid");
String username=(String)request.getAttribute("username");
ArrayList<String> filelist= (ArrayList<String>)request.getAttribute("filelist");
%>
<script type="text/javascript">
function onfileselect()
{
	document.getElementById("path").value=document.getElementById("file_upload").value;
	
	}

</script>
<style type="text/css">
body {
	font-family: 'Lucida Grande', 'Helvetica Neue', sans-serif;
	font-size: 13px;
}

div.custom_file_upload {
	width: 230px;
	height: 20px;
	margin: 40px auto;
}

input.file {
	width: 150px;
	height: 20px;
	border: 1px solid #BBB;
	border-right: 0;
	color: #888;
	padding: 5px;
	
	-webkit-border-top-left-radius: 5px;
	-webkit-border-bottom-left-radius: 5px;
	-moz-border-radius-topleft: 5px;
	-moz-border-radius-bottomleft: 5px;
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	
	outline: none;
}

div.file_upload {
	width: 80px;
	height: 24px;
	background: #7abcff;
	background: -moz-linear-gradient(top,  #7abcff 0%, #60abf8 44%, #4096ee 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#7abcff), color-stop(44%,#60abf8), color-stop(100%,#4096ee));
	background: -webkit-linear-gradient(top,  #7abcff 0%,#60abf8 44%,#4096ee 100%);
	background: -o-linear-gradient(top,  #7abcff 0%,#60abf8 44%,#4096ee 100%);
	background: -ms-linear-gradient(top,  #7abcff 0%,#60abf8 44%,#4096ee 100%);
	background: linear-gradient(top,  #7abcff 0%,#60abf8 44%,#4096ee 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#7abcff', endColorstr='#4096ee',GradientType=0 );

	display: inline;
	position: absolute;
	overflow: hidden;
	cursor: pointer;
	
	-webkit-border-top-right-radius: 5px;
	-webkit-border-bottom-right-radius: 5px;
	-moz-border-radius-topright: 5px;
	-moz-border-radius-bottomright: 5px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	
	font-weight: bold;
	color: #FFF;
	text-align: center;
	padding-top: 8px;
}
div.file_upload:before {
	content: 'UPLOAD';
	position: absolute;
	left: 0; right: 0;
	text-align: center;
	
	cursor: pointer;
}

div.file_upload input {
	position: relative;
	height: 30px;
	width: 250px;
	display: inline;
	cursor: pointer;
	opacity: 0;
}

</style>
</head>
<body>

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="37%" align="center"><table width="195" border="0"
					cellspacing="0" cellpadding="0">
					<table cellspacing='0'> <!-- cellspacing='0' is important, must stay -->

	<!-- Table Header -->
	<thead>
		<tr>
			<th>File Name</th>
			<th>Download</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>
<%for(int i=0;i<filelist.size();i++){ %>
		<tr>
			<td><%=filelist.get(0) %></td>

			<td><a href="<%=request.getContextPath()%>/FileDownloader?filename=<%=filelist.get(0)%>" >Download</a></td>

		</tr><!-- Table Row -->

	<%} %>

	</tbody>
	<!-- Table Body -->

</table>
					
					
					<tr>
					</tr>
				</table></td>
		</tr>
	</table>

</body>
</html>