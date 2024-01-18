//Usaremos Ajax para cargar los proyectos en el select
$.ajax({
    url: "/getProyectos",
    type: "GET",
    dataType: "json",
    success: function (data) {
        var TablaproyectosSelect = $("#tablaProyectos tbody");
        TablaproyectosSelect.empty();
        $.each(data, function (index, proyecto) {
            var fila = "<tr><td>" + proyecto.nombreProyecto + "</td><td>" + proyecto.urlProyecto + "</td><td>" + proyecto.descripcionProyecto + "</td><td>" + proyecto.estadoProyecto + "</td><td><a href='/perfilProyecto/" + proyecto.id + "'>Ver perfil</a></td></tr>";
            TablaproyectosSelect.append(fila);
        });
    },
    error: function (error) {
        console.error("Hubo un error al cargar los proyectos", error);
    }
});