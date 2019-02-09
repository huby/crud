$(document).ready(function() {
	/* Metodo de agregar cliente */
	$("#success").on('click', function() {
		var id;
		$('.select').each(function() {
			if ($(this).prop('checked')) {
				id = $(this).attr('id');
			}
		});
		if (id != null) {
			var datos = {
				id : id,
				nombre : $("#nombre").val(),
				apellido : $("#apellido").val(),
				direccion : $("#direccion").val(),
				email : $("#email").val(),
				fechanac : $("#fechanac").val()
			}
			$.ajax({
				type : "PUT",
				contentType : "application/json",
				url : "http://localhost:9090/cliente/",
				data : JSON.stringify(datos),
				success : function(data) {
				},
				error : function(data) {
					alert(data);
				},
			});
		} else {
			var datos = {
				nombre : $("#nombre").val(),
				apellido : $("#apellido").val(),
				direccion : $("#direccion").val(),
				email : $("#email").val(),
				fechanac : $("#fechanac").val()
			}
				var primN = $("#nombre").val();
				var segN = $("#apellido").val();
				var primA = $("#direccion").val();
				var segA = $("#email").val()
				var tip = $("#fechanac").val();
		if (primN === "" || segN === "" || primA === "" || segA === "" || tip === "") {
			alert("¡Ingrese los datos completos de la persona!");
			} else {				
			$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "http://localhost:9090/cliente/",
					data : JSON.stringify(datos),
					success : function(data) {
						alert("Agregaste la cliente con id: " + data.id);
						Form.ajax.reload();
						document.getElementById("Form").reset();
					},
					error : function(data) {
						alert(data);
					},
				});
			}
		}

	});
	/* Eliminar Cliente */
	$("#eliminar").on('click', function() {
		var id;
		$('.select').each(function() {
			if ($(this).prop('checked')) {
				id = $(this).attr('id');
			}
		});
		$.ajax({
			type : 'DELETE',
			url : "http://localhost:9090/cliente/" + id,
			success : function(data) {
				if (data.codigo === 1) {
					refrescar();
				} else {
					alert(data.mensaje);
				}
			},
			error : function(data) {
				alert(data.mensaje);
			}
		});
	});
	/* Actualizar cliente */
	$("#editar").on('click', function() {
		var id;
		$('.select').each(function() {
			if ($(this).prop('checked')) {
				id = $(this).attr('id');
			}
		});
		$.ajax({
			type : 'GET',
			url : "http://localhost:9090/cliente/" + id,
			success : function(data) {
				$("#id").val(data.id);
				$("#nombre").val(data.nombre);
				$("#direccion").val(data.direccion);
				$("#apellido").val(data.apellido);
				$("#fechanac").val(data.fechanac);
				$("#email").val(data.email);
			}
		});
	});

	$('#checkp').toggle(function() {

		$('.check').attr('Checked', 'Checked');
	}, function() {
		$('.check').removeAttr('Checked');
	});
	/*Function refrescar*/
	$("#limpiar").on('click', 
		function limpiarFormulario() {
	    document.getElementById("Form").reset();
		});
	$("#refrescar").on('click', function (){
		refrescar();
	});
	function refrescar() {
			$.ajax({
				type : 'GET',
				contentType : "application/json",
				url : "http://localhost:9090/cliente/",
				success : function(data) {
					var tabla = '';
					$.each(data, function (index, item) {
						tabla += '<tr>';
						tabla += '<td><input type="checkbox" class="select" value="" id="' + item.id + '"/></td>';
						tabla += '<td>' + item.id + '</td>';
						tabla += '<td>' + item.direccion + '</td>';
						tabla += '<td>' + item.apellido + '</td>';
						tabla += '<td>' + item.fechanac + '</td>';
						tabla += '<td>' + item.email + '</td>';
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