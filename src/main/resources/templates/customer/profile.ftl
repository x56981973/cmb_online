<#include "include/header.ftl">

<div class="page-container">
<#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/customer/home">控制面板</a>
                    <i class="fa fa-angle-right"></i>
                    账号设置
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
                                <input type="text" class="form-control" id="username" readOnly="true" value="${customer.username}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label hor-form">名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="name" readOnly="true" value="${customer.name}">
                            </div>
                            <div class="col-sm-1">
                                <a href="#" class="help-block" id="edit_name">编辑</a>
                            </div>
                            <#--<div class="col-sm-1" hidden="hidden" id="reset_show">-->
                                <#--<a href="#" class="help-block" id="reset_name">重置</a>-->
                            <#--</div>-->
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label hor-form">手机</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="mobile" readOnly="true" value="${customer.mobile}">
                            </div>
                            <div class="col-sm-2">
                                <a href="#" class="help-block" id="edit_mobile">编辑</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label hor-form">城市</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="city" readOnly="true" value="${customer.city}">
                            </div>
                            <div class="col-sm-2">
                                <a href="#" class="help-block" id="edit_city">编辑</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label hor-form">地址</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="address" readOnly="true" value="${customer.address}">
                            </div>
                            <div class="col-sm-2">
                                <a href="#" class="help-block" id="edit_address">编辑</a>
                            </div>
                        </div>
                        <div class="panel-footer" id="form_footer" hidden="hidden">
                            <div class="row">
                                <div class="col-sm-8 col-sm-offset-2">
                                    <button type="submit" class="btn btn-primary" onclick="return updateInfo()">保存设置</button>
                                    <button type="reset" class="btn" id="cancel">取消</button>
                                </div>
                            </div>
                        </div>
                    </form>
                    <iframe style="display: none" id="rfFrame" name="rfFrame" src="about:blank"></iframe>
                </div>
            </div>

            <div class="grid-form">
                <div class="grid-form1">
                    <h3>修改密码</h3>
                    <form class="form-horizontal" id="updateUser" enctype="multipart/form-data" method="post" target="rfFrame">
                        <div class="form-group">
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
                                    <button type="submit" class="btn btn-primary" onclick="return updatePwd()">保存设置</button>
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
    function updatePwd()
    {
        //全部无修改
        if($('#password2').val() == "" && $('#password1').val() == ""){
            return false;
        }
        //两次密码不一致
        if($('#password2').val() != $('#password1').val()){
            toastr.error("两次密码不一致!");
            return false;
        } else {
            $.ajax({
                url: '${base}/customer/account/update/pwd',
                type: 'POST',
                data: $.param({
                    'username': "${customer.username}",
                    'name': "${customer.name}",
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

<script type="text/javascript">
    $('#edit_name').click(function(){
        $('#name').removeAttr("readonly");
        $('#form_footer').removeAttr("hidden");
    });
</script>

<#--<script type="text/javascript">-->
    <#--$('#reset_name').click(function(){-->
        <#--$('#name').val("${customer.name}");-->
        <#--$('#reset_show').removeAttr("hidden");-->
    <#--});-->
<#--</script>-->

<script type="text/javascript">
    $('#edit_mobile').click(function(){
        $('#mobile').removeAttr("readonly");
        $('#form_footer').removeAttr("hidden");
    });
</script>

<script type="text/javascript">
    $('#edit_city').click(function(){
        $('#city').removeAttr("readonly");
        $('#form_footer').removeAttr("hidden");
    });
</script>

<script type="text/javascript">
    $('#edit_address').click(function(){
        $('#address').removeAttr("readonly");
        $('#form_footer').removeAttr("hidden");
    });
</script>

<script type="text/javascript">
    $('#cancel').click(function(){
        $('#name').attr("readonly","true");
        $('#mobile').attr("readonly","true");
        $('#city').attr("readonly","true");
        $('#address').attr("readonly","true");
        $('#form_footer').attr("hidden","hidden");
    });
</script>

<script type="text/javascript">

function updateInfo()
{
    var name = $('#name').val();
    var username = $('#username').val();
    var mobile = $('#mobile').val();
    var city = $('#city').val();
    var address = $('#address').val();

    if(name == ''){
        swal("姓名不能为空","","error");
    } else if(username == ''){
        swal("用户名不能为空","","error");
    } else if(mobile == ''){
        swal("手机不能为空","","error");
    } else if(city == ''){
        swal("城市不能为空","","error");
    } else if(address == ''){
        swal("地址不能为空","","error");
    } else {
        $.ajax({
            url: '${base}/customer/account/update/info',
            type: 'POST',
            data: $.param({
                'username': username,
                'name': name,
                'mobile': mobile,
                'city': city,
                'address': address
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
                                <#--window.location.href = "${base}" + "/login";-->
                                location.reload();
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