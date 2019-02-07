$(document).ready(function(){
	$("#success").on('click',function(){
		var datos = {
			primerNombre:$("#primerNombre").val(),
			segundoNombre:$("#segundoNombre").val(),
			primerApellido:$("#primerApellido").val(),
			segundoApellido:$("#segundoApellido").val(),
			tipoDoc:$("#tipoDoc").val(),
			numeroDoc:$("#numeroDoc").val(),
			fechaNacimiento:$("#fechaNacimiento").val(),
			estado:$("#estado").val()
			}
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://localhost:9090/persona/",
			data: JSON.stringify(datos),
			success:function(data){
				alert("Agregaste persona");
			},
			error:function(data){
				alert("Error");
			},
		});
	});
	
	$("#editar").on("click",function(){
		var id;
		$(".editar").each(function(){
			if($(this).prop('checked')){
				id=$(this).attr('id');
			}	
			
		});
		$.ajax({
			type: "GET",
			url: "http://localhost:9090/persona/" + id,
			success: function(data){
			$("#primerNombre").val(data.primerNombre);
			$("#segundoNombre").val(data.segundoNombre);
			$("#primerApellido").val(data.primerApellido);
			$("#segundoApellido").val(data.segundoApellido);
			$("#tipoDoc").val(data.tipoDoc);
			$("#numeroDoc").val(data.numeroDoc);
			$("#fechaNacimiento").val(data.fechaNacimiento);
			$("#estado").val(data.estado)
			},
		error: function(data){
			alert(data);
		},
			
		});
	});
});