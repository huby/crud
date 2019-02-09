
/*$(document).ready(function() {
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
	
});*/
$(document).ready(function() {
	
	$("#eliminar").on('click', function() {

		var id;
		
		$('.select').each(function() {
			
			if ($(this).prop('checked')) {
				 id = $(this).attr('id');
			}
		});
		
		$.ajax({
			type : 'DELETE',
			url : "http://localhost:9090/persona/" + id,
			success : function(data) {
				
					if (data.codigo === 1) {
						refrescar();
					} else {
						alert(data.mensaje);
						
					}
					refrescar();
				
			},
			error : function(data) {
				alert(data.mensaje);
			}
		});  
		
	});
	
	$("#agregar").on('click', function() {
		
		var id;
		
		$('.select').each(function() {
			
			if ($(this).prop('checked')) {
				 id = $(this).attr('id');
			}		
		});
		
		if (id!=null) {
		
			var datos = {
				id : $("#id").val(),
				primerNombre : $("#primerNombre").val(),
				segundoNombre : $("#segundoNombre").val(),
				primerApellido : $("#primerApellido").val(),
				segundoApellido : $("#segundoApellido").val(),
				tipoDoc : $("#tipoDoc").val(),
				numeroDoc : $("#numeroDoc").val(),
				fechaNacimiento : $("#fechaNacimiento").val(),
			}
			
			$.ajax({
				type : 'PUT',
				contentType : "application/json",
				url : "http://localhost:9090/persona/",
				data : JSON.stringify(datos),
				success : function(data) {
					alert("Se actualizaron los datos de la Persona");
					refrescar();
				},
				error : function(data) {
					alert(data);
				}
			});
			
		} else {
			
			var datos = {
				primerNombre : $("#primerNombre").val(),
				segundoNombre : $("#segundoNombre").val(),
				primerApellido : $("#primerApellido").val(),
				segundoApellido : $("#segundoApellido").val(),
				tipoDoc : $("#tipoDoc").val(),
				numeroDoc : $("#numeroDoc").val(),
				fechaNacimiento : $("#fechaNacimiento").val(),
				}
				var primN = $("#primerNombre").val();
				var segN = $("#segundoNombre").val();
				var primA = $("#primerApellido").val();
				var segA = $("#segundoApellido").val()
				var tip = $("#tipoDoc").val();
				var numD = $("#numeroDoc").val();
				var fech = $("#fechaNacimiento").val();

				if (primN === "" || segN === "" || primA === "" || segA === "" || tip === "" || numD === "" || fech === "") {
				alert("¡Ingrese los datos completos del cliente!");
				} else {
					$.ajax({
						type : "POST",
						contentType : "application/json",
						url : "http://localhost:9090/persona/",
						data : JSON.stringify(datos),
						success : function(data) {
						alert("Se agrego los datos de la persona: "+ data.id);
						refrescar();
			},
			error : function(data) {
				alert(data);
		     }
	       }); 		
		  };
		};
		
	});
	
	$("#actualizar").on('click', function() {
			
			var id;
			
			$('.select').each(function() {
				
				if ($(this).prop('checked')) {
					 id = $(this).attr('id');
						
				}		
			});
			
			$.ajax({
				type : 'GET',
				contentType : "application/json",
				url : "http://localhost:9090/persona/"+ id,
				success : function(data) {
					
					$("#id").val(data.id);
					$("#primerNombre").val(data.primerNombre);
					$("#segundoNombre").val(data.segundoNombre);
					$("#primerApellido").val(data.primerApellido);
					$("#segundoApellido").val(data.segundoApellido);
					$("#tipoDoc").val(data.tipoDoc);
					$("#numeroDoc").val(data.numeroDoc);
					$("#fechaNacimiento").val(data.fechaNacimiento);
				},
				error : function(data) {
					alert(data);
				}
			});
		});

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
			url : "http://localhost:9090/persona/",
			success : function(data) {
				var tabla = '';
				$.each(data, function (index, item) {
					tabla += '<tr>';
					tabla += '<td><input type="checkbox" class="select" value="" id="' + item.id + '"/></td>';
					tabla += '<td>' + item.id + '</td>';
					tabla += '<td>' + item.primerNombre + ' ' + item.segundoNombre + ' ' +  item.primerApellido + ' ' + item.segundoApellido + '</td>';
					tabla += '<td>' + item.numeroDoc + '</td>';
					tabla += '</tr>';
				});
				
				$("#tableBody").empty().append(tabla);
				
			},
			error : function(data) {
				alert(data);
			}
		});
		
	}
	
	//*Validar todo los campos del formulario con sus respectivas mensajes*/
	$('#Form').submit(function(e) {
	    e.preventDefault();
	    var first_name = $('#primerNombre').val();
	    var last_name = $('#segundoNombre').val();
	    var ape_patern = $('#primerApellido').val();
	    var ape_matern = $('#segundoApellido').val();
	    var telefono = $('#tipoDoc').val();
	    var dni = $('#numeroDoc').val();
	    var fecha = $('#fechaNacimiento').val();
	    
	
	 
	    $(".error").remove();
	 
	    if (first_name.length < 1) {
	      $('#primerNombre').after('<span style="color:red;" class="error">Por favor, escriba su nombre</span>');
	    }
	    if (last_name.length < 1) {
	      $('#segundoNombre').after('<span style="color:red;" class="error">Por favor, escriba su segundo nombre</span>');
	    }
	    if (ape_patern.length < 1) {
		      $('#primerApellido').after('<span style="color:red;" class="error">Por favor, escriba su apellido</span>');
		}
	    if (ape_matern.length < 1) {
		      $('#segundoApellido').after('<span  style="color:red;" class="error">Por favor, escriba su apellido materno</span>');
		}
	    if (telefono.length < 1) {
		      $('#tipoDoc').after('<span style="color:red;" class="error">Por favor, escriba su telefono</span>');
		}
	    if (dni.length < 1) {
		      $('#numeroDoc').after('<span style="color:red;" class="error">Por favor, escriba su DNI</span>');
		}
	    if (fecha.length < 1) {
		      $('#fechaNacimiento').after('<span style="color:red;" class="error">Por favor, escribala fecha</span>');
		}
	    
	  
	  });

	
});