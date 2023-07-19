$(document).ready(function () {

    $('#imagenPerfilContainer').on('mouseover', function () {
        $('#agregarImagenText').show();
    });

    // Cuando el cursor sale de la imagen preterminada
    $('#imagenPerfilContainer').on('mouseout', function () {
        $('#agregarImagenText').hide();
    });

    // Cuando se hace clic en "Agregar imagen"
    $('#agregarImagenText').on('click', function () {
        $('#inputImagen').click();
    });

    // Cuando se selecciona una imagen
    $('#inputImagen').on('change', function () {
        var input = this;
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#imagenPerfil').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    });

    let cod = parseInt(localStorage.getItem("idUsuario"));

    $.ajax({
        url: "https://picserv.up.railway.app/BuscarTrabajador/" + cod,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            var id_trabajador = respuesta.id_trabajador;
            var sexo = respuesta.sexo;
            var edad = respuesta.edad;
            var apellido = respuesta.apellido;
            var telefono = respuesta.telefono;
            var nombre = respuesta.nombre;
            var imagen = respuesta.imagen;
            var idUsuario = respuesta.usuario.idUsuario;
            var idOficio = respuesta.oficio.id_Oficio;

            // Asignar los valores a los inputs
            $("#idTrabajadorInput").val(id_trabajador);
            $("#sexoInput").val(sexo);
            $("#edadInput").val(edad);
            $("#apellidoInput").val(apellido);
            $("#telefonoInput").val(telefono);
            $("#nombreInput").val(nombre);
            $("#oficioInput").val(idOficio);
            $("#imagenPerfil").attr("src", imagen);

            $("#actualizar").click(function () {
                var id_trabajador = $("#idTrabajadorInput").val();
                var sexo = $("#sexoInput").val();
                var edad = $("#edadInput").val();
                var apellido = $("#apellidoInput").val();
                var telefono = $("#telefonoInput").val();
                var nombre = $("#nombreInput").val();
                var imagenPerfil = $('#imagenPerfil').attr('src');

                var datosActualizados = {
                    id_trabajador: id_trabajador,
                    sexo: sexo,
                    imagen: imagenPerfil,
                    apellido: apellido,
                    nombre: nombre,
                    telefono: telefono,
                    edad: edad,
                    usuario: {
                        idUsuario: idUsuario,
                    },
                    oficio:{
                        id_Oficio:idOficio
                    }

                };

                // Actualizar los datos del cliente
                $.ajax({
                    url: "https://picserv.up.railway.app/ActualizarTrabajador",
                    type: "PUT",
                    dataType: "json",
                    data: JSON.stringify(datosActualizados),
                    contentType: "application/json",
                    success: function (respuesta) {
                        
                    },
                    error: function (xhr, status, error) {
                        swal("Super!", "Datos Actualizados.", "success");
                    }
                });
            });
        }
    });
});