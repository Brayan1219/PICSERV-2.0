document.addEventListener("DOMContentLoaded", function() {
    let id_servicio = parseInt(localStorage.getItem("id_servicio"));
    let descripcion = localStorage.getItem("descripcion");
    let fecha_publicacion = localStorage.getItem("fecha_publicacion");
    let fecha_fin = localStorage.getItem("fecha_fin");
    let pago = localStorage.getItem("pago");
    let titulo = localStorage.getItem("titulo");
    let ubicacion = localStorage.getItem("ubicacion");
    let id_cliente = parseInt(localStorage.getItem("idUsuario")); 
    let id_oficio = parseInt(localStorage.getItem("idoficio")); 
  
    document.getElementById("id_servicio").value = id_servicio;
    document.getElementById("descripcion").value = descripcion;
    document.getElementById("fecha_publicacion").value = fecha_publicacion;
    document.getElementById("fecha_fin").value = fecha_fin;
    document.getElementById("pago").value = pago;
    document.getElementById("titulo").value = titulo;
    document.getElementById("ubicacion").value = ubicacion;
    document.getElementById("id_cliente").value = id_cliente;
    document.getElementById("id_Oficio").value =id_oficio ;
  
    document.getElementById("actualizarservi").addEventListener("click", function() {
      let id_servicio = parseInt(localStorage.getItem("id_servicio"));
      let descripcion = document.getElementById("descripcion").value;
      let fecha_fin = document.getElementById("fecha_fin").value;
      let pago = document.getElementById("pago").value;
      let titulo = document.getElementById("titulo").value;
      let ubicacion = document.getElementById("ubicacion").value;
      let id_cliente=parseInt(document.getElementById("id_cliente").value);
      let id_oficio=parseInt(document.getElementById("id_Oficio").value );
  
      let servicio = {
        id_servicio: id_servicio,
        descripcion: descripcion,
        fecha_fin: fecha_fin,
        pago: pago,
        titulo: titulo,
        ubicacion: ubicacion,
        cliente: {
          id_cliente: id_cliente,  // Incluye el ID del cliente
        },
        oficio: {
          id_Oficio: id_oficio,  // Incluye el ID del oficio
        }
      };
  
      // Realiza la petición AJAX
      $.ajax({
        url: "https://picserv.up.railway.app/ActualizarServicio",
        type: "PUT",
        data: JSON.stringify(servicio),
        contentType: "application/json",
        dataType: "json",
        success: function(respuesta) {
          swal("¡Éxito!", "El servicio se actualizó exitosamente", "success");
        },
        error: function(xhr, status, error) {
          swal("¡Error!", "Error al actualizar el servicio: " + error, "error");
          console.error("Error al actualizar el servicio:", error);
        }
      });
    });
  });