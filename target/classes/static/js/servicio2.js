$(document).ready(function () {
    let cod = parseInt(localStorage.getItem("idUsuario"));

    $.ajax({
        url: "https://picserv.up.railway.app/BuscarTrabajador/" + cod,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            var idOficio = respuesta.oficio.id_Oficio;
            let ofi = idOficio;

            $.ajax({
                url: "https://picserv.up.railway.app/BucarServicioOficio/" + ofi,
                type: "GET",
                dataType: "json",
                success: function(respuesta) {
                  var tablaCuerpo = $("#tablaServicio");
              
                  respuesta.forEach(function(servicio) {
                    var fila = $("<tr></tr>");
              
                    var idCelda = $("<th class='table-success' scope='row'></th>").text(servicio.id_servicio);
                    var descripcionCelda = $("<td></td>").text(servicio.descripcion);
                    var fechaInicioCelda = $("<td></td>").text(servicio.fecha_publicacion);
                    var fechaFinCelda = $("<td></td>").text(servicio.fecha_fin);
                    var pagoCelda = $("<td></td>").text(servicio.pago);
                    var tituloCelda = $("<td></td>").text(servicio.titulo);
                    var ubicacionCelda = $("<td></td>").text(servicio.ubicacion);
                    var agregarCelda = $("<td></td>");
                    var actualizarBoton = $("<button class='btn btn-primary btn-sm'></button>").text("POSTULARSE");
              
                    var agregarotro = $("<td></td>");
                    var VerBoton = $("<button class='btn btn-primary btn-sm' id='ver'></button>").text("VER");
              
                    actualizarBoton.data("id_servicio", servicio.id_servicio);
                    VerBoton.data("id_servicio", parseInt(servicio.id_servicio)); // Convert to integer
              
                    VerBoton.on("click", function() {
                      var idservicio = $(this).data("id_servicio");
                      localStorage.setItem("id_servicio", idservicio);
                      window.location.href = "../html/info_servicio.html";
                    });
              
                    agregarCelda.append(actualizarBoton);
                    agregarotro.append(VerBoton);
                    fila.append(
                      idCelda,
                      descripcionCelda,
                      fechaInicioCelda,
                      fechaFinCelda,
                      pagoCelda,
                      tituloCelda,
                      ubicacionCelda,
                      agregarCelda,
                      agregarotro
                    );
                    tablaCuerpo.append(fila);
                  });
                }
              });
              
        }
    });

    $(document).on("click", ".btn-primary", function () {
        var button = $(this);
        var id_servicio = button.data("id_servicio");
        let cod = parseInt(localStorage.getItem("idUsuario"));
        var url = "https://picserv.up.railway.app/AgregarPostulados/" + cod + "/" + id_servicio;

        $.ajax({
            url: url,
            type: "POST",
            contentType: "application/json",
            dataType: "JSON",
            success: function (respuesta) {

            },
            error: function (xhr, status, error) {
                // Manejar la respuesta del servidor si es necesario
                // Reemplazar el botón por el texto "Postulado"
                button.parent().html("Postulado");
            }
        });
    });
});
