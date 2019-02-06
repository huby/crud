
$(document).ready(function(){
	$("#agregar").on('click', function(){
		
		var datos = {
			marca : $("#marca").val(),
			modelo : $("#modelo").val(),
			color : $("#color").val(),
			placa : $("#placa").val(),
			fabricacion : $("#fabricacion").val()
		}
		
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://localhost:9090/automovil/",
			data: JSON.stringify(datos),
			success: function(data){
				alert("Se agrego el automovil: " + data.id);
			},
			error: function(data){
				alert(data);
			}
		});
	});
});