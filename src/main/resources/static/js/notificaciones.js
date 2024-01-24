var notificationSocket = new SockJS('/ws');
var stompClient = Stomp.over(notificationSocket);

stompClient.connect({}, function (frame) {
    console.log('Connected to notifications: ' + frame);

    stompClient.subscribe('/topic/notificaciones', function (notificacion) {
        // Maneja la notificación recibida en el cliente
        alert("Nueva notificación: " + notificacion.body);
        console.log(notificacion.body);
    });
},errorCallback);
function errorCallback(error) {
    console.error('Error durante la suscripción: ' + error);
}


// Realiza la llamada AJAX para obtener las notificaciones
$.ajax({
    url: "/notificaciones/getNotificaciones",
    type: "GET",
    dataType: "json",
    success: function (data) {
        // Actualiza el contenido del select con los proyectos
        var notificaciones = $("#tablaNotificaciones tbody");
        notificaciones.empty();
        console.log(data);

        if (data.length === 0) {
            notificaciones.after("<p>No hay proyectos disponibles</p>")
        } else {
            $.each(data, function (index, notificacion) {
                var fila = "";
                notificaciones.append(fila);
            });
        }
    },
    error: function (error) {
        console.error("Error al obtener proyectos:", error);
    }
});