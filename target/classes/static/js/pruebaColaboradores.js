$(document).ready(function () {
    $('#colaboradoresTable').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/BuscarcolaboradoresPageAjax",
            "type": "GET",
            "data": function (params) {
                var start = params.start || 0;
                var length = params.length || 5;
                var searchValue = params.search.value || '';
                return {
                    "start": start,
                    "length": length,
                    "search[value]": searchValue
                };
            },
            "dataSrc": function (json) {
                console.log(json.content)
                json.page = json.pageable ? json.pageable.pageNumber + 1 : 1;
                json.recordsTotal = json.totalElements;
                json.recordsFiltered = json.totalElements;
                return json.content;
            }
        },
        "columns": [
            {
                "data": function (row) {
                    return row.usuario.nombre + ' ' + row.usuario.apellido;
                }
            },
            {
                "data": function (row) {
                    var habilidades = row.habilidades.map(function (habilidad) {
                        return habilidad.nombreHabilidad;
                    });
                    return habilidades.join(', '); // Concatena todas las habilidades con coma
                }
            },
            {
                "data": function (row) {
                    var subcategorias = row.subCategorias.map(function (subCategoria) {
                        return subCategoria.nombreSubCategoria;
                    });
                    return subcategorias.join(', '); // Concatena todas las subcategorías con coma
                }
            },
            {
                "data": null,
                "render": function (data, type, row) {
                    return '<button class="abrirModalBtn" data-toggle="modal" data-target="#myModal" data-user="' + row.usuario.id + '">Enviar Solicitud</button>';
                }
            }
        ],
        "lengthMenu": [5, 10, 15]
    });
});