$(document).ready(function () {

    let cod = parseInt(localStorage.getItem("idUsuario"));

    $.ajax({
        url: "https://picserv.up.railway.app/BucarServicio/" + cod,
        type: "GET",
        datatype: "json",
        success: function (respuesta) {
            var tablaCuerpo = $("#tablaServicio");

            respuesta.forEach(function (servicio) {
                var fila = $("<tr></tr>");

                var oficio = servicio.oficio.id_Oficio;
                var horaservicio=servicio.hora;

                var idCelda = $("<th class='table-success' scope='row'></th>").text(servicio.id_servicio);
                var idoficioCelda = $("<td></td>").text(oficio);
                var descripcionCelda = $("<td></td>").text(servicio.descripcion);
                var fechaInicioCelda = $("<td></td>").text(servicio.fecha_publicacion);
                var fechaFinCelda = $("<td></td>").text(servicio.fecha_fin);
                var celdahora = $("<td></td>").text(horaservicio);
                var pagoCelda = $("<td></td>").text(servicio.pago);
                var tituloCelda = $("<td></td>").text(servicio.titulo);
                var ubicacionCelda = $("<td></td>").text(servicio.ubicacion);
                var agregarCelda = $("<td></td>");
                var ActualizarBoton = $("<button class='btn btn-primary btn-sm'></button>").text("Actualizar");

                ActualizarBoton.on("click", function () {
                    localStorage.setItem("id_servicio", servicio.id_servicio);
                    localStorage.setItem("descripcion", servicio.descripcion);
                    localStorage.setItem("fecha_publicacion", servicio.fecha_publicacion);
                    localStorage.setItem("fecha_fin", servicio.fecha_fin);
                    localStorage.setItem("hora", horaservicio);
                    localStorage.setItem("pago", servicio.pago);
                    localStorage.setItem("titulo", servicio.titulo);
                    localStorage.setItem("ubicacion", servicio.ubicacion);
                    localStorage.setItem("idoficio",oficio)

                    window.location.href = '../html/actualizarser.html';

                });

                agregarCelda.append(ActualizarBoton);
                fila.append(idCelda, descripcionCelda, fechaInicioCelda, fechaFinCelda,celdahora, pagoCelda, tituloCelda, ubicacionCelda, agregarCelda);
                tablaCuerpo.append(fila)

            });
        }
    })

});



