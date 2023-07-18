$(document).ready(function () {

    let cod = parseInt(localStorage.getItem("idUsuario"));

    $.ajax({
        url: "http://localhost:8080/BucarServicio/" + cod,
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            var tablaCuerpo = $("#tablaServicio");

            respuesta.forEach(function (servicio) {
                var fila = $("<tr></tr>");

                var idCelda = $("<th class='table-success' scope='row'></th>").text(servicio.id_servicio);
                var descripcionCelda = $("<td></td>").text(servicio.descripcion);
                var fechaInicioCelda = $("<td></td>").text(servicio.fecha_publicacion);
                var fechaFinCelda = $("<td></td>").text(servicio.fecha_fin);
                var pagoCelda = $("<td></td>").text(servicio.pago);
                var tituloCelda = $("<td></td>").text(servicio.titulo);
                var ubicacionCelda = $("<td></td>").text(servicio.ubicacion);
                var agregarCelda = $("<td></td>");
                var agregarBoton = $("<button class='btn btn-danger btn-sm'></button>").text("Eliminar");

                agregarBoton.data("id_servicio", servicio.id_servicio);

                agregarCelda.append(agregarBoton);
                fila.append(idCelda, descripcionCelda, fechaInicioCelda, fechaFinCelda, pagoCelda, tituloCelda, ubicacionCelda, agregarCelda);
                tablaCuerpo.append(fila);
            });
        }
    });

    $(document).on("click", ".btn-danger", function () {
        var id_servicio = $(this).data("id_servicio");

        swal({
            title: "¿Estás seguro?",
            text: "Esta acción no se puede deshacer",
            icon: "warning",
            buttons: ["Cancelar", "Eliminar"],
            dangerMode: true,
        })
            .then((willDelete) => {
                if (willDelete) {
                    $.ajax({
                        url: "http://localhost:8080/EliminarServicio/" + id_servicio,
                        type: "DELETE",
                        success: function (response) {
                            swal("¡Servicio eliminado!", "El servicio ha sido eliminado correctamente.", "success")
                                .then(() => {
                                    location.reload(); // Recargar la página
                                });
                        },
                        error: function (error) {
                            swal("Error", "Servicio en uso.", "error");
                        }
                    });
                } else {
                    swal("Cancelado", "El servicio no ha sido eliminado.", "info");
                }
            });
    });




});