$(document).ready(function() {

	$("#agregar").on('click', function() {

		
		var id;
		
		$('.select').each(function(){
			
			if($(this).prop('checked')){
				id = $(this).attr('id');
			}
			
		});
		
		
		if(id!=null){
			
			var datos ={
				id:id,
				direccion : $("#direccion").val(),
				nombre : $("#nombre").val(),
				ruc : $("#ruc").val(),
			}
			
			$.ajax({
				
				
				type : "PUT",
				contentType : "application/json",
				url : "http://localhost:9090/empresa/",
				data : JSON.stringify(datos),
				success : function(data) {

					alert("El empresa a sido actualizado  ");
					refrescar();
					$(":text").each(function() {
						$($(this)).val('');
					});

				},
				error : function(data) {
					alert(data);
				},
				
			});
			
		}else
		{
			
			var datos = {
					direccion : $("#direccion").val(),
					nombre : $("#nombre").val(),
					ruc : $("#ruc").val(),
				}

				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "http://localhost:9090/empresa/",
					data : JSON.stringify(datos),
					success : function(data) {
						alert("la Empresa se ingreso" + data.id);
						refrescar();

						$("type:text").each(function() {
							$($(this)).val('');

						});
					},
					error : function(data) {
						alert(data);
					},

				});
				
		}
			
		
		
		
	});

	$("#editar").on('click', function() {
		var id;

		$('.select').each(function() {
			if ($(this).prop('checked')){
				id=$(this).attr('id');
			}
			
		});
		
		
		$.ajax({
			type:"GET",
			
			url:"http://localhost:9090/empresa/" + id,
			
			success : function(data) {

				var datos = {
					id : $("#id").val(data.id),
					direccion : $("#direccion").val(data.direccion),
					nombre : $("#nombre").val(data.nombre),
					ruc : $("#ruc").val(data.ruc),
				}

			}
			
		});
		
		
		
	});
	
	
	
	$("#eliminar").on('click',function(){
		
		var id;
		
		$('.select').each(function(){
			
			if($(this).prop('checked')){
				id= $(this).attr('id');
			}
		});
		
		$.ajax({
			
			type : 'DELETE',
			url : "http://localhost:9090/empresa/" + id,
			success : function(data) {
				alert(data.mensaje);
				var Id = document.getElementById(id);
				Id.closest("tr").remove();
				refrescar();
			},
			error : function(data) {
				alert(data.mensaje);
			}
			
			
		});
		
	});
	
	
	
	function refrescar(){
		
		$.ajax({
			
			type:'GET',
			contentType: "application/json",
			url: "http://localhost:9090/persona/",
			success : function(data){
				var tabla ='';
				$.each(data,function(index,item){
					
					tabla += '<tr>';
					tabla += '<td><input type="checkbox" class="select" th:id="' + item.id +'"></td>';
					tabla += '<td>' + item.id + '</td>';
					tabla += '<td>' + item.direccion + '</td>';
					tabla += '<td>' + item.nombre   + '</td>';
					tabla += '<td>' + item.ruc + '</td>';
					tabla += '</tr>';
					
				});
				$("#tableBody").empty().append(tabla);
			},
			error : function(data) {
				alert(data);
			}
		});
		
		
	}

});
