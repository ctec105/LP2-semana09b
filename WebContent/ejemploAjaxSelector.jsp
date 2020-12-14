<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css" />
<title>Teoria de Ajax</title>
<!-- El que tiene que agregar las funciones -->
<script src='js/ajaxDWRSelector.js'></script>
<!-- Según los objetos que necesita del dwr -->
<script src="dwr/interface/ProductoService.js"></script>
<script src="dwr/interface/UbigeoService.js"></script>
<!-- Necesarios -->
<script src="dwr/util.js"></script>
<script src="dwr/engine.js"></script>

</head>
<body leftmargin="0" topmargin="0" rightmargin="0" bottommargin="0"
	marginheight="0" marginwidth="0"  onload="cargaProducto(); cargaDepartamento();">
	<jsp:include page="menu.jsp" />
	<br>
	<table class="texto">
		<tr>
			<td colspan="2">Seleccione el Combo</td>
		</tr>
		<tr>
			<td>Productos</td>
			<td>
				<select id="idProducto">
					<option value="">[Seleccione]</option>
				</select>
			</td>
		</tr>
	</table>
	<br>
	<table class="texto">
		<tr>
			<td colspan="2">Seleccione el Combo</td>
		</tr>
		<tr>
			<td>Departamento</td>
			<td><select id="idDepartamento" onchange="cargaProvincia();">
					<option value="">[Seleccione]</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>Provincia</td>
			<td><select id="idProvincia" onchange="cargaDistrito();">
					<option value="">[Seleccione]</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>Distrito</td>
			<td><select id="idDistrito">
					<option value="">[Seleccione]</option>
			</select>
			</td>
		</tr>
	</table>
	<br>
</body>
</html>