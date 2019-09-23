<%@page isELIgnored="false"%>
<%@page import="java.util.*"%>
<%@page import="com.ssi.Student"%>
<html>
<body>
	<h3>Result-Page</h3>
	<%-- 	<hr>
		<pre>
		Roll No  : ${info.id}
		Name     : ${info.name}
		Branch 	 : ${info.phno}
		Marks	 : ${info.marks}
		</pre>
	<hr> --%>

	<pre>
	
		<%
				List<Student> al = (List<Student>) request.getAttribute("infoAll");

				for (Student student : al) {
			%>
		<hr>
		<pre>
		Roll No  : <%=student.getRno()%>
		Name     : <%=student.getSname()%>
		Branch 	 : <%=student.getBranch()%>
		Marks	 : <%=student.getMarks()%>
		</pre>
	<hr>
		 
		<%
		 			}
		 		%>
	
	</pre>
</body>
</html>