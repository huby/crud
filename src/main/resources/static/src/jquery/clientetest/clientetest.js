$(document).ready(function() {
    
    $("#success").on('click', function() {
    	var datos = {
    		nombre : $("#nombre").val(),
    		apellidop : $("#apellidop").val(),
    		apellidom : $("#apellidom").val(),
    		telefono : $("#telefono").val(),
    		direccion : $("#direccion").val()
    	}
    	
    	$.ajax({
    		type: "POST",
    		contentType: "application/json",
    		url: "http://localhost:9090/clientetest/",
    		data: JSON.stringify(datos),
    		success: function(data){
    	        alert("Agregaste la clientetest con id: " + data.id);
    	    },
    	    error: function(data){
    	        alert(data);
    	    },
    	});
    });
    
});