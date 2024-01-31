// Realiza la llamada AJAX para obtener las notificaciones
$.ajax({
    url: "/getNumeroNotificaciones",
    type: "GET",
    dataType: "json",
    success: function (data) {
        // Actualiza el contenido del select con los proyectos
        var notificaciones = $("#nSolicitudes");
        console.log(data);
        notificaciones.text(data);
    },
    error: function (error) {
        console.error("Error al obtener proyectos:", error);
    }
});