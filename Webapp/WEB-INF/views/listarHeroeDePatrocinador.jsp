<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista</title>

<!--Termina jQuery DataTable-->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<!-- jQuery DataTable -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/dt/dt-1.10.20/r-2.2.3/datatables.min.css" />

<script type="text/javascript"
	src="https://cdn.datatables.net/v/dt/dt-1.10.20/r-2.2.3/datatables.min.js"></script>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/navbars/">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script>
<!--Función para darle formato a la Tabla-->
	$(document).ready(function() {
		$('#myTable').DataTable();
		responsive = True;
	});
</script>
<style type="text/css">
* {margin: 0; padding: 0;}
#container {height: 50%; width:100%; font-size: 0;}
#left, #right {display: inline-block; *display: inline; zoom: 1; vertical-align: top; font-size: 12px;}
#left {width: 25%;}
#right {width: 50%;}
</style>

</head>
<body>
	<jsp:include page="plantillas/menu.jsp"></jsp:include>
	<div id="container">
		<div id="left">
			<table border="1">
				<thead>
					<tr>
						<th>Id Patrocinador</th>
						<th>Nombre</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${visitasConComida}" var="visitaConComida">
						<tr>
							<td>${visitaConComida.id}</td>
							<td>${visitaConComida.descripcion}</td>
							<td>${visitaConComida.fecha}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="right">
			<table border="1">
				<thead>
					<tr>
						<th>ID Comida</th>
						<th>Nombre</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${comidaDeVisitas}" var="comidaDeVisita">
						<tr>
							<td>${comidaDeVisita.id}</td>
							<td>${comidaDeVisita.nombre}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="plantillas/footer.jsp"></jsp:include>
</body>
</html>