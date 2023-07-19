$(document).ready(function () {

    

    let cod = parseInt(localStorage.getItem("id_trabajador"));

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

            // Asignar los valores a los inputs
            $("#idTrabajadorInput").val(id_trabajador);
            $("#sexoInput").val(sexo);
            $("#edadInput").val(edad);
            $("#apellidoInput").val(apellido);
            $("#telefonoInput").val(telefono);
            $("#nombreInput").val(nombre);
            $("#imagenPerfil").attr("src", imagen);

        }
    });
});

function mostrar(){
    document.getElementById('calificar').style.display = 'block';
}