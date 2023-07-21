$(document).ready(function () {
  let ListaOfi = document.querySelector('#select');
  ListaOfi.innerHTML = '';


  const preciosOficios = {
    1: 70000,
    2: 120000,
  };

  // Función para cargar los oficios en el select
  function cargarOficios() {
    $.ajax({
      url: "https://picserv.up.railway.app/ListarOficios",
      type: "GET",
      dataType: "json",
      success: function (respuesta) {
        Object.values(respuesta).forEach(Oficio => {
          ListaOfi.innerHTML += '<option value="' + Oficio["id_Oficio"] + '">' + Oficio["nombre"] + '</option>';
        });
      }
    });
  }

  cargarOficios(); // Cargar los oficios al iniciar la página

  // Función para mostrar el precio cuando se seleccione un oficio
  function mostrarPrecio() {
    let selectedOficio = parseInt($('#select').val());
    let precioOficio = preciosOficios[selectedOficio];

    if (!isNaN(precioOficio)) {
      $('#pago').val(precioOficio); // Mostrar el precio en el campo de precio
    } else {
      $('#pago').val(''); // Si el oficio no tiene precio, limpiar el campo de precio
    }
  }

  $('#select').on('change', mostrarPrecio); // Mostrar el precio al cambiar el select

  $('#agregarser').on('click', function () {
    let datos = {
      descripcion: $('#descripcion').val(),
      fecha_fin: $('#fecha_fin').val(),
      hora: $('#tiempo').val(),
      pago: parseFloat($('#pago').val()),
      titulo: $('#titulo').val(),
      ubicacion: $('#ubicacion').val(),
    };

    let oficio = parseInt($('#select').val())
    let cod = parseInt(localStorage.getItem("idUsuario"));
    let datosEnvio = JSON.stringify(datos);
    var url = "https://picserv.up.railway.app/AgregarServicio/" + cod + "/" + oficio;
    $.ajax({
      url: url,
      type: "POST",
      data: datosEnvio,
      contentType: "application/json",
      dataType: "json",
      success: function (respuesta) {
        // Aquí puedes realizar alguna acción después de que se agregue el servicio
      }
    });
  });
});
