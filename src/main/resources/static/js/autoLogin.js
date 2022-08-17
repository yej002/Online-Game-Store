$(function () {
    $("#loginBtn").click(function () {
        if (!$("#auto").prop("checked")) {
            $.cookie("isAutoLogin", "false", {
                expire: -1
            });
            $.cookie("username", "", {
                expires: -1
            });
            $.cookie("password", "", {
                expires: -1
            });
        } else {
            var vusername = $("#username").val();
            var vpassword = $("#password").val();
            $.cookie("isAutoLogin", "true", {
                expires: 7
            });
            $.cookie("username", vusername, {
                expires: 7
            });
            $.cookie("password", vpassword, {
                expires: 7
            });
        }
    })

    if ($.cookie("isAutoLogin") == "true") {
        $("#auto").prop("checked", true);
        $("#username").val($.cookie("username"));
        $("#password").val($.cookie("password"));
    }
});