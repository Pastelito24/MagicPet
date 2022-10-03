var user_id = new URL(location.href).searchParams.get("user_id");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        getAlquiladas(user.username);
    });

    $("#reservar-btn").attr("href", `home.html?username=${user_id}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            user_id: user_id,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-user_id").val(parsedResult.user_id);
                $("#input-user_password").val(parsedResult.user_password);
                $("#input-user_name").val(parsedResult.user_name);
                $("#input-last_name").val(parsedResult.last_name);
                $("#input-email").val(parsedResult.email);
                $("#input-location_user").val(parsedResult.location_user);


            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getAlquiladas(user_id) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletAlquilerListar",
        data: $.param({
            user_id: user_id,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult)

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}


function modificarUsuario() {

    let user_id = $("#input-user_id").val();
    let user_password = $("#input-user_password").val();
    let user_name = $("#input-user_name").val();
    let last_name = $("#input-last_name").val();
    let email = $("#input-email").val();
    let location_user = $("#input-location_user").val();
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            user_id: user_id,
            user_password: user_password,
            user_name: user_name,
            last_name: last_name,
            email: email,
            location_user: location_user,

        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            user_id: user_id
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}


