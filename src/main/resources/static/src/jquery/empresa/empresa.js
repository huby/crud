$(document).ready(function(){
	
	$("#success").on('click',function(){
		var datos = { 
		ruc : $("#ruc").val(),
		razonsocial : $("#razonsocial").val(),
		direccion : $("#direccion").val(),
		telefono : $("#telefono").val(),
		rubro : $("#rubro").val()
		}
		$.ajax({
			type: "POST",
			contentType : "application/json",
			url: "http://localhost:9090/empresa/",
			data: JSON.stringify(datos),
			success: function(data){
				alert("Agregaste empresa");
			}, 
			error: function(data){
				alert(data);
			},
		});
	});
});