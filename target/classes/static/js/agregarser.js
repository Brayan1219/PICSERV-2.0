$(document).ready(function () {

  let ListaOfi = document.querySelector('#select');
  ListaOfi.innerHTML = '';

  $.ajax({
    url: "http://localhost:8080/ListarOficios",
    type: "GET",
    dataType: "json",
    success: function (respuesta) {
      Object.values(respuesta).forEach(Oficio=>{
        ListaOfi.innerHTML+='<option value="'+Oficio["id_Oficio"]+'">'+ Oficio["nombre"]+'</option>';
      })

    }
  });


  $('#agregarser').on('click', function () {
    let datos = {
      descripcion: $('#descripcion').val(),
      fecha_fin: $('#fecha_fin').val(),
      pago: parseFloat($('#pago').val()),
      titulo: $('#titulo').val(),
      ubicacion: $('#ubicacion').val(),
    };

    let oficio = parseInt($('#select').val())
    let cod = parseInt(localStorage.getItem("idUsuario"));
    let datosEnvio = JSON.stringify(datos);
    var url = "http://localhost:8080/AgregarServicio/" + cod + "/" + oficio;
    $.ajax({
      url: url,
      type: "POST",
      data: datosEnvio,
      contentType: "application/json",
      dataType: "json",
      success: function (respuesta) {
        
      }
    });
  });
});


function agregarServicio() {
  // Obtener los valores de los campos
  var descripcion = document.getElementById('descripcion').value;
  var fechaFin = document.getElementById('fecha_fin').value;
  var pago = document.getElementById('pago').value;
  var titulo = document.getElementById('titulo').value;
  var ubicacion = document.getElementById('ubicacion').value;

  // Verificar si los campos están vacíos
  if (
    descripcion === '' ||
    fechaFin === '' ||
    pago === '' ||
    titulo === '' ||
    ubicacion === ''
  ) {
    alert('Por favor, complete todos los campos.');
  } else {
    // Enviar el formulario o realizar alguna acción adicional
    // Aquí puedes agregar tu lógica para enviar los datos a través de AJAX o realizar cualquier otra acción necesaria
    // Por ejemplo, podrías enviar los datos a un servidor utilizando fetch() o XMLHttpRequest
    // Luego redirigir a otra página
    location.href = '../html/servicio.html';
  }
}



