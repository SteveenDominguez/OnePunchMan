<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Monstruos</title>

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
</head>
<body>

	<jsp:include page="plantillas/menu.jsp"></jsp:include>
	<table border="1" id="myTable">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Amenaza</th>
				<th>Tiene Celulas</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${monstruos}" var="monstruo">
				<tr>
					<td>${monstruo.id}</td>
					<td>${monstruo.nombre}</td>
					<td>${monstruo.amenaza}</td>
					<td>${monstruo.tiene_celula}</td>
					<td><a href="editarMonstruo/${monstruo.id}"
						class="btn btn-success btn-sm" role="button" title="Edit"> <span
							class="glyphicon glyphicon-pencil"></span>editar
					</a> <a href="eliminarMonstruo/${monstruo.id}"
						onclick='return confirm("¿Estas seguro?")'
						class="btn btn-danger btn-sm" role="button" title="Eliminar">
							<span class="glyphicon glyphicon-trash"></span>Eliminar
					</a>
					</a> <a href="listarPatrocinadoresDeMonstruo/${monstruo.id}" 
						class="btn btn-primary btn-sm" role="button" title="Eliminar">
							<span class="glyphicon glyphicon-trash"></span>Patrocinadores
					</a>
					<a href="listarCombatesDeMonstruo/${monstruo.id}" 
						class="btn btn-primary btn-sm" role="button" title="Eliminar">
							<span class="glyphicon glyphicon-trash"></span>Combates
					</a>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<jsp:include page="plantillas/footer.jsp"></jsp:include>

</body>
</html>