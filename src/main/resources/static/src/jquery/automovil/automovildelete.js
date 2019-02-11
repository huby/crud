$(document).ready(function() {
	$("#delete").on('click', function() {
		
		var id = $("#id").val();
			
		
		$.ajax({
			type: "DELETE",
			contentType: "application/json",
			url: "http://localhost:9090/automovil/" + id,
			data: JSON.stringify(id),
			success: function(data){
				alert("El automovil a sido eliminado  " );
			},
			error: function(data){
				alert(data);
			},
		});
	});
});


