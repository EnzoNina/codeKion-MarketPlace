var notificationSocket = new SockJS('/ws');
var stompClient = Stomp.over(notificationSocket);

stompClient.connect({}, function (frame) {
    console.log('Connected to notifications: ' + frame);

    stompClient.subscribe('/topic/notificaciones', function (notificacion) {
        // Maneja la notificación recibida en el cliente
        alert("Nueva notificación: " + notificacion.body);
        console.log(notificacion.body);
    });
}, errorCallback);

function errorCallback(error) {
    console.error('Error durante la suscripción: ' + error);
}


