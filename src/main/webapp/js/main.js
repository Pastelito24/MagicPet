var user_id = new URL(location.href).searchParams.get("id");
var user;

$(document).ready(function () {
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
    
    getUsuario().then(function () {
    $("#mi-perfil-btn").attr("href","profile.html?id=" + user_id);
    });

    async function getUsuario() {
        await $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioPedir",
            data: {
                id: user_id
            },
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    user = parsedResult;
                } else {
                    console.log("Error recuperando los datos del usuario");
                }
            }
        });
    }
});