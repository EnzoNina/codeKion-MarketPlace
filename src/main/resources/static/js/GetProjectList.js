$(document).ready(function() {
    $('#proyectosTable').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/getProyectos",
            "type": "GET"
        },
        "columns": [
            { "data": "nombreProyecto" },
            { "data": "urlProyecto" },
            { "data": "descripcionProyecto" },
            { "data": "estadoProyecto" },
            {
                "data": null,
                "render": function (data, type, row) {
                    return '<a href="/perfilProyecto/' + row.id + '">Ver perfil del Proyecto</a>';
                }
            }
        ],
        "lengthMenu": [5, 10, 15]  // Define las opciones de longitud de la página
    });
});
