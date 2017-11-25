/**
 * Created by dllo on 17/11/18.
 */
$(document).ready(function () {
    var aN = 0;
    var aC = 0;
    var aLN = 0;
    var aLP = 0;
    var aLP2 = 0;
    var aP = 0;
    $("#accName").blur(function () {
        var accName = this.value;
        $.ajax({
            url:"/valAcc/accName",
            type:"get",
            async: false,
            data:{accName : accName},
            dataType: "json",
            success:function (result) {
                if (result.errorCode == 0){
                    $("#validate_accName").html(result.message);
                    aN = 0;
                }else {
                    $("#validate_accName").html("");
                    aN = 1;
                }
            }
        })
    });
    $("#idCard").blur(function () {
        var idCard = this.value;
        $.ajax({
            url:"/valAcc/idCard",
            type:"get",
            async: false,
            data:{idCard : idCard},
            dataType: "json",
            success:function (result) {
                if (result.errorCode == 0){
                    $("#validate_idCard").html(result.message);
                    aC = 0;
                }else {
                    $("#validate_idCard").html("");
                    aC = 1;
                }
            }
        })
    });
    $("#accLoginName").blur(function () {
        var accLoginName = this.value;
        $.ajax({
            url:"/valAcc/accLoginName",
            type:"get",
            async: false,
            data:{accLoginName : accLoginName},
            dataType: "json",
            success:function (result) {
                if (result.errorCode == 0){
                    $("#validate_accLoginName").html(result.message);
                    aLN = 0;
                }else {
                    $("#validate_accLoginName").html("");
                    aLN = 1;
                }
            }
        })
    });
    $("#accLoginPwd").blur(function () {
        var accLoginPwd = this.value;
        $.ajax({
            url:"/valAcc/accLoginPwd",
            type:"get",
            async: false,
            data:{accLoginPwd : accLoginPwd},
            dataType: "json",
            success:function (result) {
                if (result.errorCode == 0){
                    $("#validate_accLoginPwd").html(result.message);
                    aLP = 0;
                }else {
                    $("#validate_accLoginPwd").html("");
                    aLP = 1;
                }
            }
        })
    });
    $("#accLoginPwd2").blur(function () {
        var accLoginPwd2 = this.value;
        var accLoginPwd = $("#accLoginPwd").val();
        if (accLoginPwd != accLoginPwd2){
            $("#validate_accLoginPwd2").html("两次输入的密码不一致!");
            aLP2 = 0;
        }else {
            aLP2 = 1;
            $("#validate_accLoginPwd2").html("");
        }

    });
    $("#accPhone").blur(function () {
        var accPhone = this.value;
        $.ajax({
            url:"/valAcc/accPhone",
            type:"get",
            async: false,
            data:{accPhone : accPhone},
            dataType: "json",
            success:function (result) {
                if (result.errorCode == 0){
                    $("#validate_accPhone").html(result.message);
                    aP = 0;
                }else {
                    $("#validate_accPhone").html("");
                    aP = 1;
                }
            }
        })
    });

    //保存成功的提示信息
    $("#sub").click(function () {
        if (aN && aC && aP && aLN && aLP && aLP2){
            $("#save_result_info").attr("class","save_success");
            $("#save_result_info").html("添加成功!");
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 2000);
            $("#addForm").submit();
            return;
        }
        $("#save_result_info").attr("class","save_fail");
        $("#save_result_info").html("界面信息有误请检查,*号为必填项");
        showResultDiv(true);
        window.setTimeout("showResultDiv(false);", 2000);
    });
});