document.addEventListener("DOMContentLoaded", function() {
  
  let idUsuario = parseInt(localStorage.getItem("idUsuario"));

  
  document.getElementById("id_cliente").value = idUsuario;
});

$('#formclie').on('click', function() {
  let datos = {
    id_cliente: parseInt(localStorage.getItem("idUsuario")),
    nombre: $('#nombre').val(),
    apellido: $('#apellido').val(),
    telefono: $('#telefono').val(),
    edad: parseInt($('#edad').val()),
    sexo: $('#sexo option:selected').text(),
    imagen:'../images/foto.jpg',
  };

  let cod = datos.id_cliente;
  let datosEnvio = JSON.stringify(datos);

  $.ajax({
    url: "http://localhost:8080/AgregarCliente/" + cod,
    type: "POST",
    data: datosEnvio,
    contentType: "application/json",
    dataType: "json",
    success: function(respuesta) {
      console.log(respuesta);
    }
  });
});





  