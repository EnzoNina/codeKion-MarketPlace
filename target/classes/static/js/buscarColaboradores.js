// Espera a que el documento esté completamente cargado
document.addEventListener("DOMContentLoaded", function () {
    $('#myModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var user = button.data('user');
        $('#userInput').val(user);
    });
});

// Realiza la llamada AJAX para obtener proyectos
$.ajax({
    url: "/getProyectos",
    type: "GET",
    dataType: "json",
    success: function (data) {
        // Verifica los datos recibidos en la consola
        console.log("Proyectos recibidos:", data);
        // Actualiza el contenido del select con los proyectos
        var proyectosSelect = $("#proyecto");
        proyectosSelect.empty();
        $.each(data, function (index, proyecto) {
            proyectosSelect.append("<option value='" + proyecto.id + "'>" + proyecto.nombreProyecto + "</option>");
        });
    },
    error: function (error) {
        console.error("Error al obtener proyectos:", error);
    }
});

// Cuando se haga clic en el botón "Enviar Solicitud", realiza la acción deseada
document.getElementById("enviarSolicitudBtn").addEventListener("click", function () {
    // Obtiene el valor seleccionado en el select de proyectos
    var proyectoSeleccionado = document.getElementById("proyectos").value;

    // Realiza la acción deseada, por ejemplo, enviar la solicitud al proyecto seleccionado
    alert("Se envió la solicitud al proyecto con ID: " + proyectoSeleccionado);

    // Cierra el modal después de realizar la acción
    $("#myModal").modal("hide");
});