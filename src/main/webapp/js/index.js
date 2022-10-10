var delUsuario = new URL(location.href).searchParams.get("del-usuario");

$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });
    
    if(delUsuario){
        alert("Estimado usuario: La eliminación de su cuenta fue un éxito.")
        window.location = window.location.href.split("?")[0]
    }

});

function autenticarUsuario() {

    let user_id = $("#usuario").val();
    let user_password = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            user_id: user_id,
            user_password: user_password
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let user_id = parsedResult['user_id'];
                document.location.href = "home.html?id=" + user_id;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
function registrarUsuario() {

    let user_id = $("#input-user_id").val();
    let user_password = $("#input-user_password").val();
    let user_passwordConfirmacion = $("#input-user_password-repeat").val();
    let user_name = $("#input-user_name").val();
    let last_name = $("#input-last_name").val();
    let email = $("#input-email").val();
    let location_user = $("#input-location_user").val();
    
    
    
    if (user_password == user_passwordConfirmacion) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                user_id: user_id,
                user_password: user_password,
                user_name: user_name,
                last_name: last_name,
                email: email,
                location_user: location_user
                
                              
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let user_id = parsedResult['user_id'];
                    document.location.href = "home.html?id=" + user_id;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}