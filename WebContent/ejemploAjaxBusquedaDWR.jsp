<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css" />
<title>Teoria de Ajax</title>
<!-- Importamos el js que creamos incluido los de dwr.xml -->
<script src='js/ajaxDWRBusqueda.js'></script>
<script src='dwr/interface/VendedorService.js'></script>
<script src='dwr/interface/SedeService.js'></script>
<!-- Siempre se deben importar -->
<script src='dwr/engine.js'></script>
<script src='dwr/util.js'></script>
</head>
<body leftmargin="0" topmargin="0" rightmargin="0" bottommargin="0" marginheight="0" marginwidth="0">
	<jsp:include page="menu.jsp" />
	<br>
	<br>
	<table class="texto">
		<tr>
			<td>Ingrese el codigo de un Vendedor</td>
		</tr>
		<tr>
			<td>Teclee aqui:</td>
			<td><input type="text" id="txtCodigo" name="txtCodigo" onkeyup="buscaVendedor();"></td>
		</tr>
		<tr>
			<td>Nombre:</td>
			<td><input type="text" id="txtNombre" disabled></td>
		</tr>
		<tr>
			<td>Edad:</td>
			<td><input type="text" id="txtEdad" disabled></td>
		</tr>
		<tr>
			<td>Distrito:</td>
			<td><input type="text" id="txtDistrito" disabled></td>
		</tr>
		<tr>
			<td>Estado Civil:</td>
			<td><input type="text" id="txtEstado" disabled></td>
		</tr>
	</table>
	<br/>
	<table class="texto">
		<tr>
			<td colspan="2">Ingrese el código de una Sede</td>
		</tr>
		<tr>
			<td>Teclee aquuí:</td>
			<td><input type="text" id="txtSede" onkeyup="buscaSede();"/></td>
		</tr>
		<tr>
			<td>Nombre:</td>
			<td><input type="text" id="txtNombreSede" disabled/></td>
		</tr>
		<tr>
			<td>Dirección:</td>
			<td><input type="text" id="txtDireccion" disabled/></td>
		</tr>
		<tr>
			<td>Fecha:</td>
			<td><input type="text" id="txtFecha" disabled/></td>
		</tr>
		<tr>
			<td>Ferente:</td>
			<td><input type="text" id="txtGerente" disabled/></td>
		</tr>
		<tr>
			<td>Distrito:</td>
			<td><input type="text" id="txtDistritoSede" disabled/></td>
		</tr>
	</table>
</body>
</html>