$(document).ready(function() {
    $('#agregartra').on('click', function() {
      let datos = {
        idUsuario: parseInt($('#idUsuario').val()),
        nombre_usuario: $('#nombre_usuario').val(),
        correo_electronico: $('#correo_electronico').val(),
        contraseña: $('#contraseña').val(),

      };

      localStorage.setItem("idUsuario", datos.idUsuario);

      let datosEnvio = JSON.stringify(datos);
      $.ajax({
        url: "http://localhost:8080/AgregarUsuario",
        type: "POST",
        data: datosEnvio,
        contentType: "application/json",
        dataType: "json",
        success: function(respuesta) {
          
        }
      });
    });

    $('#agregarcli').on('click', function() {
      let datos = {
        idUsuario: parseInt($('#idUsuario').val()),
        nombre_usuario: $('#nombre_usuario').val(),
        correo_electronico: $('#correo_electronico').val(),
        contraseña: $('#contraseña').val(),
      };

      localStorage.setItem("idUsuario", datos.idUsuario);
    
      let datosEnvio = JSON.stringify(datos);
    
      $.ajax({
        url: "http://localhost:8080/AgregarUsuario",
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
  