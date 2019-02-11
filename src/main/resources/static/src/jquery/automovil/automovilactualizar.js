
$(document).ready(function() {
	$("#actualizar").on('click', function() {
		
		var datos = {
			id : $("#id").val(),	
			marca : $("#marca").val(),
			modelo : $("#modelo").val(),
			color : $("#color").val(),
			placa : $("#placa").val(),
			fabricacion : $("#fecha").val(),
			

			
		}
		
		$.ajax({
			type: "PUT",
			contentType: "application/json",
			url: "http://localhost:9090/automovil/",
			data: JSON.stringify(datos),
			success: function(data){
				alert("El automovil a sido actualizado  ");
			},
			error: function(data){
				alert(data);
			},
		});
	});
});
