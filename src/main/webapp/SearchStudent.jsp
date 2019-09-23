<%@page isELIgnored="false"%>
<html>
<body>
	<form action="findStudent">

		<table>

			<tr>
				<td>Enter Roll.No</td>
				<td><input type="text" name="rno"></td>
			</tr>
			<tr>
			<tr>
				<input type="submit" value="Add">
			</tr>
		</table>
	</form>

	<h3>Result-Page</h3>
	<hr>
	<pre>
		Roll No  : ${info.rno}
		Name     : ${info.sname}
		Branch 	 : ${info.branch}
		Marks	 : ${info.marks}
		</pre>
	<hr>
</body>
</html>

