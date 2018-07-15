<#include "include/header.ftl">

<div class="page-container">
<#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/admin/home">控制面板</a>
                    <i class="fa fa-angle-right"></i>
                    订单
                </li>

                <li style="float: right">
                    <a href="${base}/logout"><i class="fa fa-power-off"></i> 登出</a>
                </li>
            </ol>

            <div class="grid-form">
                <div class="grid-form1">
                    <h3>基本信息</h3>
                    <form class="form-horizontal" id="updateUser" enctype="multipart/form-data" method="post" target="rfFrame">
                        <div class="form-group">
                            <label class="col-sm-2 control-label hor-form">用户名</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="username" readOnly="true" value="${admin.username}">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>
                            <label class="col-sm-2 control-label hor-form">名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="name" value="${admin.name}">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>
                            <label class="col-sm-2 control-label hor-form">修改密码</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="password1">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>
                            <label class="col-sm-2 control-label hor-form">再次输入</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="password2">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>
                        </div>
                        <div class="panel-footer">
                            <div class="row">
                                <div class="col-sm-8 col-sm-offset-2">
                                    <button type="submit" class="btn btn-primary" onclick="return update()">保存设置</button>
                                    <button type="reset" class="btn">取消</button>
                                </div>
                            </div>
                        </div>
                    </form>
                    <iframe style="display: none" id="rfFrame" name="rfFrame" src="about:blank"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function update()
    {
        //全部无修改
        if($('#password2').val() == "" && $('#password1').val() == "" && $('#name').val() == "${admin.name}"){
            return false;
        }
        //两次密码不一致
        if($('#password2').val() != $('#password1').val()){
            toastr.error("两次密码不一致!");
            return false;
        }

        if($('#password2').val() == "" && $('#password1').val() == "" && $('#name').val() != "${admin.name}"){
            $.ajax({
                url: '${base}/admin/account/update/name',
                type: 'POST',
                data: $.param({
                    'username': "${admin.username}",
                    'name': $('#name').val()
                }),
                success: function (result) {
                    var data = eval("(" + result + ")");
                    if (data.error == 0) {
                        swal({
                                    title: data.msg,
                                    text: "",
                                    type: "success",
                                    confirmButtonText: "确认"
                                },
                                function () {
                                    window.location.href = "${base}" + "/login";
                                });
                    } else {
                        swal("更新失败!", "请稍后再试", "error");
                    }
                }
            });
        } else {
            $.ajax({
                url: '${base}/admin/account/update/pwd',
                type: 'POST',
                data: $.param({
                    'username': "${admin.username}",
                    'name': "${admin.name}",
                    'password': $('#password1').val()
                }),
                success: function (result) {
                    var data = eval("(" + result + ")");
                    if (data.error == 0) {
                        swal({
                                    title: data.msg,
                                    text: "",
                                    type: "success",
                                    confirmButtonText: "确认"
                                },
                                function () {
                                    window.location.href = "${base}" + "/login";
                                });
                    } else {
                        swal("更新失败!", "请稍后再试", "error");
                    }
                }
            });
        }
    }
</script>

<script src="//cdn.bootcss.com/toastr.js/2.1.2/toastr.min.js"></script>
<#include "include/footer.ftl">