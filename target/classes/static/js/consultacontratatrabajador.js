$(document).ready(function () {

    let cod = parseInt(localStorage.getItem("idUsuario"));

    $.ajax({
        url: "http://localhost:8080/BuscarContratacion/"+cod,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            var tablaCuerpo = $("#contraraciontrabajo");

            respuesta.forEach(function (contratacion) {
                var fila = $("<tr></tr>");

                var idCelda = $("<th class='table-success' scope='row'></th>").text(contratacion.id_contratacion);
                var fechaCelda = $("<td></td>").text(contratacion.fecha_contratacion);

                // Obtener los valores de las llaves foráneas desde la respuesta del servidor
                var idServicio = contratacion.servicio.id_servicio;
                var nombreServicio = contratacion.servicio.titulo;
                var idTrabajador = contratacion.trabajador.id_trabajador;
                var nombreTrabajador = contratacion.trabajador.nombre;

                var idservicioCelda = $("<td></td>").text(idServicio);
                var idtrabajadorCelda = $("<td></td>").text(idTrabajador);


            
                fila.append(idCelda, fechaCelda, idservicioCelda, idtrabajadorCelda );
                tablaCuerpo.append(fila);
            });
        }
    });

});
