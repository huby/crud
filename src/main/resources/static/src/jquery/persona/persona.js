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
				$("#table").append("<tr>" +
						"<td scope='row'><input type='checkbox' class='table'id="+data.id+"></td>" +
						"<td>" +data.id +"</td>" +
						"<td>"+$("#primerNombre").val() + $("#segundoNombre").val()+$("#primerApellido").val()+$("#segundoApellido").val()+"</td>" +
						"<td>"+$("#numeroDoc").val()+"</td>"+
						"</tr>");
			},
			error:function(data){
				alert("Error");
			},
		});
	});
	
	$("#editar").on("click",function(){
		var id;
		$(".table").each(function(){
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
	
	$("#eliminar").on("click",function(){
		var id;
		$(".table").each(function(){
			if($(this).prop('checked')){
				id=$(this).attr('id');
				$(id).remove();
			}
		});
		$.ajax({
			type:"DELETE",
			url:"http://localhost:9090/persona/" + id,
			success: function(data){
				alert(data.mensaje)
				//eliminar fila
				var etiqueta = document.getElementById(id);
				$(etiqueta).closest("tr").remove();
			},
			error: function(data){
				alert(data.mensaje);
			},
		});
	});
});