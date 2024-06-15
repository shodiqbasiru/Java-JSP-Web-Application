$(document).ready(function () {
    $("#loginForm").validate({
        errorClass: "error",
        rules: {
            userId: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            userId: {
                required: "Please enter your User ID"
            },
            password: {
                required: "Please enter your password"
            }
        }
    });
});