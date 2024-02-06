//Usaremos Ajax para cargar los proyectos en el select
$.ajax({
    url: "/getProyectos",
    type: "GET",
    dataType: "json",
    success: function (data) {
        var TablaproyectosSelect = $("#proyectosTable tbody");
        TablaproyectosSelect.empty();

        if (data.length === 0) {
            TablaproyectosSelect.after("<p>No hay proyectos disponibles</p>");
        } else {
            $.each(data, function (index, proyecto) {
                var fila = "<tr><td>" + proyecto.nombreProyecto + "</td><td>" + proyecto.urlProyecto + "</td><td>" + proyecto.descripcionProyecto + "</td><td>" + proyecto.estadoProyecto + "</td><td><a href='/perfilProyecto/" + proyecto.id + "'>Ver perfil del Proyecto</a></td></tr>";
                TablaproyectosSelect.append(fila);
            });

            // Inicializar DataTableJS después de cargar los datos
            new DataTable('#proyectosTable', {
                "lengthMenu": [5, 10, 15]
            });
        }
    },
    error: function (error) {
        console.error("Hubo un error al cargar los proyectos", error);
    }
});
