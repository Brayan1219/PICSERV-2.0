document.addEventListener("DOMContentLoaded", function() {
  
  let idUsuario = parseInt(localStorage.getItem("idUsuario"));

  
  document.getElementById("id_trabajador").value = idUsuario;
  let ListaOfi=document.querySelector('#select')
  ListaOfi.innerHTML= '' 
  $.ajax({
    url: "http://localhost:8080/ListarOficios",
    type: "GET",
    dataType: "json",
    success: function(respuesta) {
      Object.values(respuesta).forEach(Oficio=>{
        ListaOfi.innerHTML+='<option value="'+Oficio["id_Oficio"]+'">'+ Oficio["nombre"]+'</option>';
      })
    }
  });

  $('#formtraba').on('click', function() {
    let datos = {
      id_trabajador:parseInt(localStorage.getItem("idUsuario")),
      nombre: $('#nombre').val(),
      apellido: $('#apellido').val(),
      telefono: $('#telefono').val(),
      edad: parseInt($('#edad').val()),
      sexo: $('#sexo option:selected').text(),
      imagen:'../images/iconouser.png',
    };

    let oficio=parseInt($('#select').val())
    let cod=datos.id_trabajador;
    let datosEnvio = JSON.stringify(datos);
    console.log(datosEnvio);
    var url="http://localhost:8080/AgregarTrabajador/"+cod + "/" +oficio;
    $.ajax({
      url: url,
      type: "POST",
      data: datosEnvio,
      contentType: "application/json",
      dataType: "json",
      success: function(respuesta) {
        console.log(respuesta)
      }
    });
  });
});









