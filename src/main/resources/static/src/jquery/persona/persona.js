$(document).ready(function() {
	$("#agregar").on('click', function() {
	
		
		var id; 
		
		$('.select').each(function(){
			
			if($(this).prop('checked')){
				id = $(this).attr('id');
			}
				
		});
		
		if(id!=null){
			
			var datos = {
					id:id,
					primerNombre : $("#1nombre").val(),
					segundoNombre : $("#2nombre").val(),
					primerApellido : $("#1apellido").val(),
					segundoApellido : $("#2apellido").val(),
					tipoDoc : $("#tdocumento").val(),
					numeroDoc : $("#ndocumento").val(),
					fechaNacimiento : $("#fnacimiento").val(),
			}
			
			
			
				$.ajax({
						
						
						type : "PUT",
						contentType : "application/json",
						url : "http://localhost:9090/persona/",
						data : JSON.stringify(datos),
						success : function(data) {

							alert("El persona a sido actualizado  ");
							refrescar();
							
							limpiar();

						},
						error : function(data) {
							alert(data);
						},
						
				});
			
			
		}else{
			
			var datos = {
					primerNombre : $("#1nombre").val(),
					segundoNombre : $("#2nombre").val(),
					primerApellido : $("#1apellido").val(),
					segundoApellido : $("#2apellido").val(),
					tipoDoc : $("#tdocumento").val(),
					numeroDoc : $("#ndocumento").val(),
					fechaNacimiento : $("#fnacimiento").val()

					
				}
			
			if ($("#1nombre").val() ===""|| $("#2nombre").val() ==="" ||
					$("#1apellido").val() ===""  || $("#2apellido").val() === "" ||
					$("#tdocumento").val() ==="" || $("#ndocumento").val() ==="" ||  $("#fnacimiento").val()==="")
			{
				alert("Ingrese todos los datos solicitados");
			}
			else	{
				$.ajax({
					type: "POST",
					contentType: "application/json",
					url: "http://localhost:9090/persona/",
					data: JSON.stringify(datos),
					success: function(data){
						alert("La persona agregada fue: " + data.id);
						refrescar();
					
						limpiar();
					},
					error: function(data){
						alert(data);
					},
				});
				}
		
		}
		
	
	});
	
	
	$("#editar").on('click',function(){
	
		var id;
		
		
		$('.select').each(function(){
			if ($(this).prop('checked')){
				id=$(this).attr('id');
			}
			
			
			
		});


		$.ajax({
			type:"GET",
			
			url:"http://localhost:9090/persona/" + id,
			
			success : function(data) {
				
				
				var datos = {
					id : $("#id").val(data.id),
					primerNombre : $("#1nombre").val(data.primerNombre),
					segundoNombre : $("#2nombre").val(data.segundoNombre),
					primerApellido : $("#1apellido").val(data.primerApellido),
					segundoApellido : $("#2apellido").val(data.segundoApellido),
					tipoDoc : $("#tdocumento").val(data.tipoDoc),
					numeroDoc : $("#ndocumento").val(data.numeroDoc),
					fechaNacimiento : $("#fnacimiento").val(data.fechaNacimiento),
				}

			}
			
		});
		
		
		
	});
	
	
	$("#eliminar").on('click',function(){
		
		var id;
		
		
		$('.select').each(function(){
			
			if($(this).prop('checked')){
				id = $(this).attr('id');
			}
		})
		
		$.ajax({
			
			type : 'DELETE',
			url : "http://localhost:9090/persona/" + id,
			
			success : function(data) {
				alert(data.mensaje);
				var Id = document.getElementById(id);
				Id.closest("tr").remove();
				refrescar();
				limpiar();
			},
			error : function(data) {
				alert(data.mensaje);
			}
			
		});
		
		
		
	});
	
	
	function refrescar ()
	{
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
	
	// metodos que son reusados
	
	function limpiar()
	{
		$(":text").each(function() {
			$($(this)).val('');
				
		});
		
	}

	
	
	
	$(function(){
		

		  $("#register-form").validate({
		    rules: {
		    	prnombre: {
		    	required: true,
		    	nowhitespace: true,
		    	lettersonly: true,
		    	
		       
		      },
		      	srnombre:{
		      		required: true,
		      		nowhitespace: true,
			    	lettersonly: true,
		      },
		      
		      	unoapellido:{
		      		required: true,
		      		nowhitespace: true,
			    	lettersonly: true,
		    	  
		      },
		      
		      	dosapellido:{
		      		required: true,
		      		nowhitespace: true,
			    	lettersonly: true,
		      },
		      
		      ndocumentos: {
		          required: true,
		          digits: true,
		        //  pattern: /(^([0-9]{8,8}\)$/,
		         

		          
		      },
		    },
		  messages: {
			  prnombre: {
		        required: 'Por favor ingrese  primer nombre',
		        lettersonly:'Solo letras por favor',
		       
		       },
		    	srnombre:{
		    	required: 'Por favor ingrese segundo nombre',
			     lettersonly:'Solo letras por favor',
		    	},
		    	unoapellido:{
		    	required: 'Por favor ingrese primer apellido',
			     lettersonly:'Solo letras por favor',
		    	},
		    	dosapellido:{
		    	required: 'Por favor ingrese segundo apellido',
			     lettersonly:'Solo letras por favor',
		    	},
		    	
		    	ndocumentos:{
		    		required: 'Por favor ingrese número de documento',
		    		digits:'Solo Números por favor',
		    		
		    	},
		  }
		      
		    
		});
	
	});
	
	
});

