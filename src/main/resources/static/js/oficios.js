$(document).ready(function () {

    $.ajax({
        url: "https://picserv.up.railway.app/ListarOficios",
        type: "GET",
        datatype: "json",
        success: function (respuesta) {
            var tablaCuerpo = $("#tablaoficio");

            respuesta.forEach(function (oficio) {
                var fila = $("<tr></tr>");
                var idCelda = $("<th class='table-success' scope='row'></th>").text(oficio.id_Oficio);
                var nombreCelda = $("<td></td>").text(oficio.nombre);
                var descripcionCelda = $("<td></td>").text(oficio.descripcion);
                

                fila.append(idCelda,descripcionCelda,nombreCelda);
                tablaCuerpo.append(fila)
            });
        }
    })

    $('#agregar').on('click', function() {
        let datos = {
          id_Oficio: parseInt($('#id_oficio').val()),
          nombre: $('#nombre').val(),
          descripcion: $('#descripcion').val(),
        }
      
        let datosEnvio = JSON.stringify(datos);
      
        $.ajax({
          url: "https://picserv.up.railway.app/AgregarOficio",
          type: "POST",
          data: datosEnvio,
          contentType: "application/json",
          dataType: "json",
          success: function(respuesta) {
          },
          error: function() {
            console.log("Error al realizar la solicitud");
          }
        });
      });

});