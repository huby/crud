$(document).ready(function() {
	$("#agregar").on('click', function() {

		var datos = {
			primerNombre : $("#primerNombre").val(),
			segundoNombre : $("#segundoNombre").val(),
			primerApellido : $("#primerApellido").val(),
			segundoApellido : $("#segundoApellido").val(),
			tipoDoc : $("#tipoDoc").val(),
			numeroDoc : $("#numeroDoc").val(),
			fechaNacimiento : $("#fechaNacimiento").val(),

		}

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:9090/persona/",
			data : JSON.stringify(datos),
			success : function(data) {
				alert("Se agrego los datos de la persona: " + data.id);
			},
			error : function(data) {
				alert(data);
			}
		});
	});
});