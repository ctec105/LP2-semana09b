function cargaProducto(){
	DWRUtil.removeAllOptions("idProducto");
	ProductoService.listarTodos(muestraProductos);
}

function muestraProductos(data){
	DWRUtil.addOptions("idProducto",data,"codigo","nombre");
}

// Pausaré el video

function cargaDepartamento(){
	DWRUtil.removeAllOptions("idDepartamento");
	UbigeoService.traerDepartamentos(muestraDataDepartamento);
}
function muestraDataDepartamento(data){
    DWRUtil.addOptions("idDepartamento", data,"idDepartamento", "departamento");
}

function cargaProvincia(){
	DWRUtil.removeAllOptions("idProvincia");
	var departamento = document.getElementById("idDepartamento").value;
	UbigeoService.traerProvincias(muestraDataProvincia,departamento);
}
function muestraDataProvincia(data){
    DWRUtil.addOptions("idProvincia", data,"idProvincia", "provincia");
	document.getElementById("idDepartamento").disabled = false;
}

function cargaDistrito(){
	DWRUtil.removeAllOptions("idDistrito");
	var departamento = document.getElementById("idDepartamento").value;
	var provincia = document.getElementById("idProvincia").value;
	UbigeoService.traerDistritos(muestraDataDistrito,departamento,provincia);
}
function muestraDataDistrito(data){
	 DWRUtil.addOptions("idDistrito", data, "idDistrito","distrito");
}