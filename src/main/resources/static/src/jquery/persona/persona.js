
$(document).ready(function() {
	$("#agregar").on('click', function() {
		
		var datos = {
			primerNombre : $("#pnombre").val(),
			segundoNombre : $("#snombre").val(),
			primerApellido : $("#papellido").val(),
			segundoApellido : $("#sapellido").val(),
			tipoDoc : $("#tdocumento").val(),
			numeroDoc : $("#ndocumento").val(),
			fechaNacimiento : $("#nacimiento").val()
		}
		
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://localhost:9090/persona/",
			data: JSON.stringify(datos),
			success: function(data){
				alert("La persona agregada fue: " + data.id);
			},
			error: function(data){
				alert(data);
			},
		});
	});
});