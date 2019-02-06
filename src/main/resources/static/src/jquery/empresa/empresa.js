$(document).ready(function() {
    
    $("#success").on('click', function() {
    	var datos = {
    		ruc : $("#ruc").val(),
    		razonSocial : $("#razon").val(),
    		direccion : $("#direccion").val(),
    		rubro : $("#rubro").val(),
    		telefonoContacto : $("#telefono").val(),
    		fechaCreacion : $("#creacion").val()
    	}
    	
    	$.ajax({
    		type: "POST",
    		contentType: "application/json",
    		url: "http://localhost:9090/empresa/",
    		data: JSON.stringify(datos),
    		success: function(data){
    	        alert("Agregaste la empresa con id: " + data.id);
    	    },
    	    error: function(data){
    	        alert(data);
    	    },
    	});
    });
    
});