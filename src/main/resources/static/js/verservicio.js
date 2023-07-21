$(document).ready(function () {

    let cod = parseInt(localStorage.getItem("id_servicio"));

    $.ajax({
        url: "https://picserv.up.railway.app/BuscarServicioServicio/" + cod,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            var titulo = respuesta.titulo;
            var descripcion = respuesta.descripcion;
            var ubicacion = respuesta.ubicacion;
            var pago = respuesta.pago;
            var fecha_fin = respuesta.hora;

            // Asignar los valores a los inputs
            $("#titulo").text(titulo);
            $("#descripcion").text(descripcion);
            $("#ubicacion").text(ubicacion);
            $("#pago").text(pago);
            $("#fecha_fin").text(fecha_fin);


        }
    });
});

document.getElementById('boton').addEventListener('click', function () {
    var direccion = $("#ubicacion").text();

    // Reemplaza los espacios en blanco en la dirección con el símbolo '+'
    direccion = direccion.replace(/ /g, '+');

    // URL de Google Maps con la dirección
    var url = 'https://www.google.com/maps/place/' + direccion;

    // Abre la dirección en una nueva pestaña del navegador
    window.open(url, '_blank');
});