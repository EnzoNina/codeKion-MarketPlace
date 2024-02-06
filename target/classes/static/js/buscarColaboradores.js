// Espera a que el documento esté completamente cargado
document.addEventListener("DOMContentLoaded", function () {
    $('#myModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var user = button.data('user');
        $('#userInput').val(user);
    });
});

//Cargamos los proyectos con Ajax
$.ajax({
    url: "/getProyectosPorUsuario",
    type: "GET",
    dataType: "json",
    success: function (data) {
        // Actualiza el contenido del select con los proyectos
        var proyectosSelect = $("#proyecto");
        proyectosSelect.empty();

        if (data.length === 0) {
            proyectosSelect.after("<p>No hay proyectos disponibles</p>")
        } else {
            $.each(data, function (index, proyecto) {
                proyectosSelect.append("<option value='" + proyecto.id + "'>" + proyecto.nombreProyecto + "</option>");
            });
            //Convertimos la tabla a DataTableJS
            new DataTable('#colaboradoresTable', {
                "lengthMenu": [5, 10, 15]
            });
        }
    },
    error: function (error) {
        console.error("Error al obtener proyectos:", error);
    }
});