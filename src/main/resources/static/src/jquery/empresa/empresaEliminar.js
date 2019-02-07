$(document).ready(function() {
	$("#eliminar").on('click', function() {

		var id  = $("#id").val();

		$.ajax({
			type : 'DELETE',
			contentType : "application/json",
			url : "http://localhost:9090/empresa/" + id,
			success : function(data) {
				alert("Se eliminó la Empresa");
				location.reload();
			},
			error : function(data) {
				alert(data);
				
			}
		});
	});
});