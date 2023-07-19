$(document).ready(function () {

    let cod = parseInt(localStorage.getItem("idUsuario"));

    $.ajax({
        url: "https://picserv.up.railway.app/BuscarTrabajador/" + cod,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            
            var imagen = respuesta.imagen;
            $("#iconos").attr("src", imagen);

        }
    });

});