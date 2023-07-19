$(document).ready(function () {

    let cod = parseInt(localStorage.getItem("idUsuario"));

    $.ajax({
        url: "https://picserv.up.railway.app/BuscarCliente/" + cod,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            
            var imagen = respuesta.imagen;
            $("#icono").attr("src", imagen);

        }
    });

});