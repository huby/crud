$(document).ready(function() {

	// $('#editar').hide();
	// $('#eliminar').hide();

	$("#agregar").on('click', function() {

		var id;

		$('.select').each(function() {

			if ($(this).prop('checked')) {
				id = $(this).attr('id');
			}

		});

		if (id != null) {

			var datos = {
				id : id,
				marca : $("#marca").val(),
				modelo : $("#modelo").val(),
				color : $("#color").val(),
				placa : $("#placa").val(),
				fabricacion : $("#fecha").val(),

			}

			$.ajax({
				type : "PUT",
				contentType : "application/json",
				url : "http://localhost:9090/automovil/",
				data : JSON.stringify(datos),
				success : function(data) {

					alert("El automovil a sido actualizado  ");
					location.reload();
					$(":text").each(function() {
						$($(this)).val('');
					});

				},
				error : function(data) {
					alert(data);
				},
			});
		} else {

			var datos = {
				marca : $("#marca").val(),
				modelo : $("#modelo").val(),
				color : $("#color").val(),
				placa : $("#placa").val(),
				fabricacion : $("#fecha").val(),

			}

			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "http://localhost:9090/automovil/",
				data : JSON.stringify(datos),
				success : function(data) {
					alert("El automovil a sido agregado  " + data.id);

					$(":text").each(function() {
						$($(this)).val('');
					});
					location.reload();
				},
				error : function(data) {
					alert(data);
				},

			});

		}

	});

	$(document).ready(function() {

		$("#editar").on('click', function() {

			var id;

			$('.select').each(function() {
				if ($(this).prop('checked')) {
					id = $(this).attr('id');
				}

			});

			$.ajax({

				type : 'GET',
				url : "http://localhost:9090/automovil/" + id,

				success : function(data) {

					var datos = {
						id : $("#id").val(data.id),
						marca : $("#marca").val(data.marca),
						modelo : $("#modelo").val(data.modelo),
						color : $("#color").val(data.color),
						placa : $("#placa").val(data.placa),
						fabricacion : $("#fecha").val(data.fabricacion),
					}

				}
			});

		});

	});

	$(document).ready(function() {
		$("#eliminar").on('click', function() {
			var id;

			$('.select').each(function() {

				if ($(this).prop('checked')) {
					id = $(this).attr('id');

				}
			});

			/*
			 * $('.select').each(function(index, item) {
			 * 
			 * if ($(this).prop('checked')) { id = $(this).prop('id'); } });
			 */

			$.ajax({
				type : 'DELETE',
				url : "http://localhost:9090/automovil/" + id,
				success : function(data) {
					alert(data.mensaje);
					var Id = document.getElementById(id);
					Id.closest("tr").remove();
				},
				error : function(data) {
					alert(data.mensaje);
				}
			});

		});

	});

});
