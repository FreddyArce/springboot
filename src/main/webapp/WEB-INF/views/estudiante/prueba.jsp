<!DOCTYPE html>
<html>
    <head>
        <title>Prueba</title>
        <style type="text/css">
            body {
                /* rojo(2 digitos), verde(2 digitos), azul (2 digitos) */
                background-color: #cccccc;
                color: #000099;
                font-family: Arial;
                font-size: 14pt;
                font-weight: bold;
            }

            .banner {
                /*background-color: black;*/
                background: linear-gradient(45deg, blue, yellow, #000000);
                color: #ffffff;
                padding: 10px;
                border-radius: 10px;
                margin: 10px;
            }
        </style>
        <script type="text/javascript">
            var txtNombre, txtApellido;

            function mostrarMensaje() {
                var nombre = txtNombre.value;
                var apellido = txtApellido.value;

                alert(nombre + ' ' + apellido);
            }

            window.onload = function() {
                txtNombre = document.getElementById('txtNombre');
                txtApellido = document.getElementById('txtApellido');
            }
        </script>
    </head>
    <body>
        <div class="banner">
            <h1>Ejemplo de Javascript</h1>
        </div>
        <div>
            Nombre: <input id="txtNombre" />
            <br />
            Apellido: <input id="txtApellido" />
            <br />
            <button type="button" onclick="mostrarMensaje()">Agregar</button>
        </div>
    </body>
</html>