<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>formulario</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
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
</head>
<body>
	<jsp:include page="plantillas/menu.jsp"></jsp:include>
	<form action="guardarHeroes" method="post">
		<div class="form-group">
			<label for="exampleInputText1">id</label> <input type="number"
				class="form-control" id="id" name="id" placeholder="id" required>
		</div>
		<div class="form-group">
			<label for="exampleInputText1">Nombre</label> <input type="text"
				class="form-control" id="nombre" name="nombre" placeholder="nombre"
				required>
		</div>
		<div class="form-group">
			<label for="exampleInputText1">Rango</label> <input type="text"
				class="form-control" id="rango" name="rango" placeholder="rango"
				required>
		</div>
		<div class="form-group">
			<label for="exampleInputText1">Habilidad</label> <input type="text"
				class="form-control" id="habilidad" name="habilidad"
				placeholder="habilidad" required>
		</div>
		<div class="form-group">
			<label for="exampleInputText1">Residencia</label> <input type="text"
				class="form-control" id="residencia" name="residencia"
				placeholder="residencia" required>
		</div>
		<div class="form-group">
			<label for="exampleInputText1">Telefono</label> <input type="text"
				class="form-control" id="telefono" name="telefono"
				placeholder="telefono" required>
		</div>
		<div class="form-group">
			<label for="exampleInputText1">Tiene Celula</label> <input
				type="text" class="form-control" id="tiene_celula"
				name="tiene_celula" placeholder="tiene_celula" required>
		</div>
		<div class="form-group">
			<label for="exampleInputText1">Fan</label> <select name="fan">
				<c:forEach items="${heroes}" var="heroe">
					<option value="${heroe.id }">${heroe.nombre}</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">Guardar</button>
	</form>
	<jsp:include page="plantillas/footer.jsp"></jsp:include>
</body>
</html>