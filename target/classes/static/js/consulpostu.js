$(document).ready(function () {
    $.ajax({
        url: "https://picserv.up.railway.app/ListarPostulados",
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            var tablaCuerpo = $("#tablapostulados");
            var serviciosContratados = [];

            // Obtener los IDs de los servicios contratados
            respuesta.forEach(function (postulado) {
                var idServicioContratado = postulado.servicio.id_servicio;
                serviciosContratados.push(idServicioContratado);
            });

            respuesta.forEach(function (postulado) {
                var fila = $("<tr></tr>");

                var idCelda = $("<th class='table-success' scope='row'></th>").text(postulado.id_postulados);
                var fechaCelda = $("<td></td>").text(postulado.fecha_postulacion);

                var idServicio = postulado.servicio.id_servicio;
                var nombreServicio = postulado.servicio.titulo;
                var idTrabajador = postulado.trabajador.id_trabajador;
                var nombreTrabajador = postulado.trabajador.nombre;

                var idservicioCelda = $("<td></td>").text(nombreServicio);
                var idtrabajadorCelda = $("<td></td>").text(nombreTrabajador);

                var agregarCelda = $("<td></td>");
                var contratarBoton = $("<button class='btn btn-primary btn-sm'></button>").text("Contratar");
                

                var agregarotro = $("<td></td>");
                var VerBoton = $("<button class='btn btn-primary btn-sm' id='ver'></button>").text("Ver");

                contratarBoton.data("id_servicio", idServicio);
                contratarBoton.data("id_trabajador", idTrabajador);

                VerBoton.data("id_trabajador", idTrabajador);

                VerBoton.on("click", function () {
                    var idTrabajador = $(this).data("id_trabajador");
                    localStorage.setItem("id_trabajador", idTrabajador);
                    window.location.href = '../html/vertrabajador.html';
                });

                agregarCelda.append(contratarBoton);
                agregarotro.append(VerBoton);
                fila.append(idCelda, fechaCelda, idservicioCelda, idtrabajadorCelda, agregarCelda, agregarotro);
                tablaCuerpo.append(fila);



            });
        }
    });

    $(document).on("click", ".btn-primary", function () {
        var button = $(this);
        var id_servicio = button.data("id_servicio");
        var cod = button.data("id_trabajador");
        var url = "https://picserv.up.railway.app/AgregarContratacion/" + cod + "/" + id_servicio;

        $.ajax({
            url: url,
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            success: function (respuesta) {

            },
            error: function (xhr, status, error) {
                // Manejar la respuesta del servidor si es necesario
                // Reemplazar el botón por el texto "Postulado"
                button.parent().html("Contratado");
            }
        });

    });

});
