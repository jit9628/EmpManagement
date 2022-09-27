<%@page import="org.aspectj.weaver.ast.Test"%>
<%@page import="org.apache.taglibs.standard.tag.el.core.IfTag"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="link.jsp"%>

</head>
<body>
	<%@ include file="indexHeader.jsp"%>

	<div
		class="container rounded text-center text-white box-shadow jumbotron">

		
			<div class="card-body" style="width: 18rem;">
				<form class="w-100 offset-3 " method="post" action="register"
					id="form-valid">
					<div class="form-group">
						<input type="text" class="form-control" id="fname"
							aria-describedby="emailHelp" placeholder="Enter first name"
							name="first">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="lname"
							placeholder="enter last name" name="last">
					</div>
					<div class="form-group">
						<input type="email" class="form-control" id="email"
							aria-describedby="emailHelp" placeholder="Enter email"
							name="email">
					</div>
					<div class="form-group">
						<input type="date" class="form-control" id="exampleInputPassword1"
							placeholder="date of birth" name="dob">
					</div>
					<div class="form-group">
						<input type="date" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter  joining date"
							name="doj">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="exampleInputPassword1"
							placeholder="department" name="dept">
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Enter password">
					</div>
					<button type="submit" class="btn btn-primary w-100">Submit</button>
				</form>
			</div>
		</div>




	<!-- end main div -->
	<c:if test="${success!=null }">
		<script>
swal("Good job!", "You clicked the button!", "success");
</script>
	</c:if>
</body>
</html>