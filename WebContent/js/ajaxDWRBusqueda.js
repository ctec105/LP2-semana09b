function buscaVendedor(){
	var codigo = document.getElementById("txtCodigo").value;
	VendedorService.obtenerPorPK(muestraData,codigo);
}

function muestraData(data){
	document.getElementById("txtNombre").value = data.nombre;
	document.getElementById("txtEdad").value = data.edad;
	document.getElementById("txtDistrito").value = data.distrito;
	document.getElementById("txtEstado").value = data.estadoCivil;
	limpiar();
	foco();
}

function limpiar(){
	document.getElementById("txtCodigo").value = "";
	document.getElementById("txtSede").value = "";
}
function foco(){
	document.getElementById("txtCodigo").focus();
	document.getElementById("txtSede").focus();
}

function buscaSede(){
	var codigo = document.getElementById("txtSede").value;
	SedeService.obtenerPorPK(muestraSede,codigo);
}

function muestraSede(data){
	document.getElementById("txtNombreSede").value = data.nombre;
	document.getElementById("txtDireccion").value = data.direccion;
	document.getElementById("txtFecha").value = data.fecha;
	document.getElementById("txtGerente").value = data.gerente;
	document.getElementById("txtDistritoSede").value = data.distrito;
	limpiar();
	foco();
}