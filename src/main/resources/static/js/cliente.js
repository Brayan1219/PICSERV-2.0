$(document).ready(function () {

    let cod = parseInt(localStorage.getItem("idUsuario"));

    $.ajax({
        url: "http://localhost:8080/BuscarCliente/" + cod,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            
            var imagen = respuesta.imagen;
            $("#icono").attr("src", imagen);

        }
    });

});