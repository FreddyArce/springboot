<!DOCTYPE html>
<html>
    <head>
        <title>
            Listado de estudiantes
        </title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" href="/resources/css/style.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.3.5/axios.min.js" integrity="sha512-nnNHpffPSgINrsR8ZAIgFUIMexORL5tPwsfktOTxVYSv+AUAILuFYWES8IHl+hhIhpFGlKvWFiz9ZEusrPcSBQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script type="text/javascript" src="/resources/js/estudiante.js"></script>
    </head>
    <body>
        <div class="container text-white">
            <div class="banner p-3">
                <img src="/resources/images/emi5.png" width="100px" />
                <h1>Sistema academico</h1>
            </div>
        </div>
        <div class="container">
            <h2>Listado de estudiantes</h2>
            <a href="/estudiantes/new" class="btn btn-primary">Nuevo</a>
            <div>
                <table class="table table-primary">
                    <thead>
                        <tr>
                            <th>
                                Nombre
                            </th>
                            <th>
                                Apellido
                            </th>
                            <th>
                                Fecha de nacimiento
                            </th>
                            <th>
                                Ciudad
                            </th>
                            <th>
                                Semestre
                            </th>
                        </tr>
                    </thead>
                    <tbody id="tbEstudiantes">
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>