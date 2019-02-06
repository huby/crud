$(document).ready(function() {
	$("#actualizar").on('click', function() {

		var datos = {
			id : $("#id").val(),
			razonSocial : $("#razonSocial").val(),
			numeroRuc : $("#numeroRuc").val(),
			fechaCreacion : $("#fechaCreacion").val(),
			condicion : $("#condicion").val(),
		}

		$.ajax({
			type : 'PUT',
			contentType : "application/json",
			url : "http://localhost:9090/empresa/",
			data : JSON.stringify(datos),
			success : function(data) {
				alert("Se actualizaron los datos de la Empresa");
			},
			error : function(data) {
				alert(data);
			}
		});
	});
});