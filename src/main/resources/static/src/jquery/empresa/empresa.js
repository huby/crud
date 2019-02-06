$(document).ready(function() {
	$("#agregar").on('click', function() {

		var datos = {
			razonSocial : $("#razonSocial").val(),
			numeroRuc : $("#numeroRuc").val(),
			fechaCreacion : $("#fechaCreacion").val(),
			condicion : $("#condicion").val(),
		}

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:9090/empresa/",
			data : JSON.stringify(datos),
			success : function(data) {
				alert("Se agrego la empresa: " + data.id);
			},
			error : function(data) {
				alert(data);
			}
		});
	});
});