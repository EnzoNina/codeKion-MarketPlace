//var socket = new SockJS('/ws');
//var stompClient = Stomp.over(socket);

//stompClient.connect({}, function (frame) {
//    console.log('Connected: ' + frame);
    // Suscribe al usuario al canal de notificaciones
//  stompClient.subscribe('/user/chat/notificaciones', function (notification) {
        // Muestra la notificación en la interfaz del usuario
  //      console.log(notification.body);
    //    alert("Nueva notificación: " + notification.body);
    //});
//});

var globalNotificationSocket = new SockJS('/ws');
var globalNotificationStompClient = Stomp.over(globalNotificationSocket);

globalNotificationStompClient.connect({}, function (frame) {
    console.log('Connected to global notification: ' + frame);

    globalNotificationStompClient.subscribe('/topic/notificacion-global', function (notification) {
        // Maneja la notificación global recibida en el cliente
        alert("Nueva notificación global: " + notification.body);
    });
});