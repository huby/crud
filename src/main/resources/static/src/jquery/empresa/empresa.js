$(document).ready(function() {
	$("#validar").on('click', function()
			{
				validar();
			});
	
	$("#eliminar").on('click', function()
	{
		var id;
		
		$('.select').each(function() {
			if ($(this).prop('checked'))
			{
				 id = $(this).attr('id');
			}
		});
		
		$.ajax(
		{
			type : 'DELETE',
			url : "http://localhost:9090/empresa/" + id,
			success : function(data)
			{	
				if (data.codigo === 1)
				{
					refrescar();
				}
				else
				{
					alert(data.mensaje);
				}	
			},
			error : function(data)
			{
				alert(data.mensaje);
			}
		});
		
	});
	
	$("#agregar").on('click', function() {
		
		var id;
		
		$('.select').each(function()
		{			
			if ($(this).prop('checked')) 
			{
				 id = $(this).attr('id');
			}		
		});
		
		
		if (id != null) 
		{
			validar();
	/*	var datos = 
			{
			id : $("#id").val(),
			razonSocial : $("#razonSocial").val(),
			numeroRuc : $("#numeroRuc").val(),
			fechaCreacion : $("#fechaCreacion").val(),
			condicion : $("#condicion").val(),
			}
		
		$.ajax(
		{
			type : 'PUT',
			contentType : "application/json",
			url : "http://localhost:9090/empresa/",
			data : JSON.stringify(datos),
			success : function(data)
			{
				alert("Se actualizaron los datos de la Empresa");
				refrescar();
				limpiarFormulario();
			},
			error : function(data)
			{
				alert(data);
			}
		});
		*/
		} 
		else
		{
			var datos =
			{
				razonSocial : $("#razonSocial").val(),
				numeroRuc : $("#numeroRuc").val(),
				fechaCreacion : $("#fechaCreacion").val(),
				condicion : $("#condicion").val(),
			}
			
			var razS = $("#razonSocial").val();
			var numR = $("#numeroRuc").val();
			var fech = $("#fechaCreacion").val();
			var cond = $("#condicion").val();
			
			
			if (razS === "" || numR === ""|| fech === ""|| cond === "")
			{
			alert("¡Ingrese los datos completos de la empresa!");
		} 
		else
		{
			validar(); 
		};	};
	});
	
	$("#actualizar").on('click', function() {
			
			var id;
			
			$('.select').each(function() {
				if ($(this).prop('checked')) 
				{
					 id = $(this).attr('id');		
				}		
			});
			
			$.ajax(
			{
				type : 'GET',
				contentType : "application/json",
				url : "http://localhost:9090/empresa/"+ id,
				success : function(data)
				{
					console.log(data.id);
					
					$("#id").val(data.id);
					$("#razonSocial").val(data.razonSocial);
					$("#numeroRuc").val(data.numeroRuc);
					$("#fechaCreacion").val(data.fechaCreacion);
					$("#condicion").val(data.condicion);
				},
				error : function(data) {
					alert(data);
				}
			});
		});

	$("#limpiar").on('click', function () 
	{
		limpiarFormulario();
	});
	
	$("#refrescar").on('click', function (){
		refrescar();
		$("#razonSoc").each(function() {
            $($(this)).val('');
                
        });

	});
	
	function limpiarFormulario()
	{
		 document.getElementById("Form").reset();
	}
	
	function refrescar()
	{
		
		$.ajax({
			type : 'GET',
			contentType : "application/json",
			url : "http://localhost:9090/empresa/",
			success : function(data) {
				var tabla = '';
				$.each(data, function (index, item) {
					tabla += '<tr>';
					tabla += '<td><input type="checkbox" class="select" value="" id="' + item.id + '"/></td>';
					tabla += '<td>' + item.id + '</td>';
					tabla += '<td>' + item.razonSocial + '</td>';
					tabla += '<td>' + item.numeroRuc + '</td>';
					tabla += '</tr>';
				});
				
				$("#tableBody").empty().append(tabla);
				
			},
			error : function(data) {
				alert(data);
			}
		});
		
	}
	
	
	function validar()
	{
		var razS = $("#razonSocial").val();
		var numR = $("#numeroRuc").val();
		var fech = $("#fechaCreacion").val();
		var cond = $("#condicion").val();
		
		var contRazon = razS.length;
		var contRuc = numR.length;

		var razonSoc = document.getElementById('razonSoc');
		var numerRuc = document.getElementById('numerRuc');
		var id;
		
		$('.select').each(function()
		{			
			if ($(this).prop('checked')) 
			{
				 id = $(this).attr('id');
			}		
		});
		
		if(contRazon>10)
		{
			razonSoc.innerHTML ='*Ingresa menos de 10 caracteres para la Razón Social';
				if(contRuc!=11)
					{
					numerRuc.innerHTML = '*Ingresa un RUC correcto';
					} }
		else
			{
				if(contRuc!=11)	
					{
					numerRuc.innerHTML = '*Ingresa un RUC correcto';
					}
				else
					{
			
					if (id != null) 
					{
					var datos = 
						{
						id : $("#id").val(),
						razonSocial : $("#razonSocial").val(),
						numeroRuc : $("#numeroRuc").val(),
						fechaCreacion : $("#fechaCreacion").val(),
						condicion : $("#condicion").val(),
						}
					
					$.ajax(
					{
						type : 'PUT',
						contentType : "application/json",
						url : "http://localhost:9090/empresa/",
						data : JSON.stringify(datos),
						success : function(data)
						{
							alert("Se actualizaron los datos de la Empresa");
							refrescar();
							limpiarFormulario();
						},
						error : function(data)
						{
							alert(data);
						}
					});
					
					} else {
					var datos =
					{
						razonSocial : $("#razonSocial").val(),
						numeroRuc : $("#numeroRuc").val(),
						fechaCreacion : $("#fechaCreacion").val(),
						condicion : $("#condicion").val(),
					}
					
					$.ajax({
						type : "POST",
						contentType : "application/json",
						url : "http://localhost:9090/empresa/",
						data : JSON.stringify(datos),
						success : function(data)
						{
							alert("Se agrego los datos de la empresa: "+ data.id);
							limpiarFormulario();
							refrescar();
						},
				error : function(data) {
					alert(data);
				}
			}); 
					
					};
					
					}
			};	
		};
		
});