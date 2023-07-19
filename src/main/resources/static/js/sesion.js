$(document).ready(function() {
    $('#loginForm').submit(function(event) {
        event.preventDefault();

        var idUsuario = parseInt($('#idUsuario').val());
        var contraseña = $('#contraseña').val();


        $.ajax({
            type: 'POST',
            url: 'https://picserv.up.railway.app/login',
            data: { idUsuario: idUsuario, contraseña: contraseña },
            success: function(response) {
                localStorage.setItem('idUsuario', idUsuario);
                if (response === 'cliente') {
                    window.location.href = '../html/cliente.html';
                } else if (response === 'trabajador') {
                    window.location.href = '../html/trabajador.html';
                }
            },
            error: function() {
                alert('Inicio de sesión fallido');
            }
        });
    });
});