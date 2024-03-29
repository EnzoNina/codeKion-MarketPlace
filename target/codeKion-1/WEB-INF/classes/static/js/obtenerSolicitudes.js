// Realiza la llamada AJAX para obtener las solicitudes
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
            notificaciones.after("<p>No hay solicitudes para unirse a proyectos</p>")
        } else {
            $.each(data, function (index, notificacion) {
                var fila = "<tr><td>" + notificacion.idProyecto.id + "</td><td>" + notificacion.idProyecto.nombreProyecto + "</td><td>" + notificacion.idProyecto.urlProyecto + "</td><td>" + notificacion.idProyecto.descripcionProyecto + "</td><td>" + notificacion.idProyecto.estadoProyecto + "</td><td><a href='/notificaciones/aceptarSolicitud/" + notificacion.id + "'>Aceptar solicitud</a></td></tr>";
                notificaciones.append(fila);
            });
        }
    },
    error: function (error) {
        console.error("Error al obtener proyectos:", error);
    }
});