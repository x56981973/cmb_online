<#include "include/header.ftl">

<div class="page-container">
<#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/admin/home">控制面板</a>
                    <i class="fa fa-angle-right"></i>
                    商家
                </li>

                <li style="float: right">
                    <a href="${base}/logout"><i class="fa fa-power-off"></i> 登出</a>
                </li>
            </ol>

            <div class="agile-grids">
                <div class="agile-tables">
                    <h2> 商家列表 </h2>
                    <h2> ---------------------------------------------------
                        <a style="float: right; color: black; font-size: 20px" data-toggle="modal" data-target="#addModal">
                            <i class="fa fa-plus"> 新增</i>
                        </a>
                    </h2>
                    <table id="table" class="display">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>用户名</th>
                            <th>名称</th>
                            <th>地址</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if (sellers?size > 0)>
                            <#list sellers as s>
                        <tr>
                            <td>${s.s_id}</td>
                            <td>${s.username}</td>
                            <td>${s.name}</td>
                            <td>${s.address}</td>
                            <td>
                                <#if s.status == "1">
                                    <i class="fa fa-check-circle" style="color: #32C867"></i>
                                <#else>
                                    <i class="fa fa-ban" style="color: #EB3E28"></i>
                                </#if>
                            </td>
                            <td>
                                <a  href="#" data-toggle="modal" data-target="#viewModal"
                                    data-name="${s.name}" data-username="${s.username}" data-password="${s.password}"
                                    data-address="${s.address}" data-status="${s.status}"> 详情 </a> |
                                <a  href="#" data-toggle="modal" data-target="#editModal"
                                    data-name="${s.name}" data-username="${s.username}" data-password="${s.password}"
                                    data-address="${s.address}" data-status="${s.status}"> 编辑 </a> |
                                <a  href="#" data-toggle="modal" data-target="#deleteModal"
                                    data-name="${s.name}" data-username="${s.username}"> 删除 </a>
                            </td>
                        </tr>
                            </#list>
                        </#if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="viewModal" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4>详情</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label hor-form">用户名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="view_username" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="view_name" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">密码</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="view_password" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">地址</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="view_address" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">状态</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="view_status" readOnly="true">
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary"">确认</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    $("#viewModal").on("show.bs.modal", function (event) {
        var button = $(event.relatedTarget);
        var username = button.data("username");
        var name = button.data("name");
        var password = button.data("password");
        var address = button.data("address");
        var status = button.data("status");

        var modal = $(this);
        modal.find('#view_username').val(username);
        modal.find('#view_name').val(name);
        modal.find('#view_password').val(password);
        modal.find('#view_address').val(address);
        if(status == "1"){
            modal.find('#view_status').val("启用");
        } else {
            modal.find('#view_status').val("禁用");
        }
    });

</script>


<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4>添加商家</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="vali-form">
                        <div class="col-md-12 form-group1">
                            <label class="control-label">用户名</label>
                            <input type="text" id="new_username" >
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <div class="col-md-12 form-group1">
                            <label class="control-label">名称</label>
                            <input type="text" id="new_name" >
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <div class="col-md-12 form-group1">
                            <label class="control-label">密码</label>
                            <input type="text" id="new_password" >
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a class="btn btn-primary" id="postAdd">确认</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $("#postAdd").click(function(){
        var new_username = $('#new_username').val();
        var new_name = $('#new_name').val();
        var new_password = $('#new_password').val();

        if(new_name == ''){
            swal("姓名不能为空","","error");
        } else if(new_username == ''){
            swal("用户名不能为空","","error");
        } else if(new_password == ''){
            swal("密码不能为空","","error");
        } else {
            $.ajax({
                url: '${base}/admin/seller/insert',
                type: 'POST',
                data: $.param({'username': new_username, 'name': new_name, 'password': new_password}),
                success: function (result) {
                    var data = eval("(" + result + ")");
                    console.log(data);
                    if (data.error == 0) {
                        swal({
                                    title: data.msg,
                                    text: "",
                                    type: "success",
                                    confirmButtonText: "确认"
                                },
                                function () {
                                    location.reload();
                                });
                    } else {
                        swal(data.msg, "", "error");
                    }
                }
            });
        }
    })
</script>


<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4>提示</h4>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a class="btn btn-primary" id="checkDelete">确认</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var username = "";

    $("#deleteModal").on("show.bs.modal", function (event) {
        var button = $(event.relatedTarget);
        var name = button.data("name");
        username = button.data("username");
        var modal = $(this);
        modal.find('.modal-body').text('确认删除 '+name+' 吗?');
    });

    $("#checkDelete").click(function(){
        $.ajax({
            url: '${base}/admin/seller/delete',
            type: 'POST',
            data: $.param({'username':username}),
            success: function (result) {
                var data = eval("(" + result + ")");
                console.log(data);
                if (data.error == 0) {
                    swal({
                                title: data.msg,
                                text: "",
                                type: "success",
                                confirmButtonText: "确认"
                            },
                            function(){
                                location.reload();
                            });
                } else {
                    swal(data.msg,"","error");
                }
            }
        });
        $('#deleteModal').modal('hide');
    })
</script>


<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4>编辑商家</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="vali-form" id="editForm">
                        <div class="col-md-12 form-group1">
                            <label class="control-label">用户名</label>
                            <input type="text" id="edit_username">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <div class="col-md-12 form-group1">
                            <label class="control-label">名称</label>
                            <input type="text" id="edit_name">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <div class="col-md-12 form-group1">
                            <label class="control-label">密码</label>
                            <input type="text" id="edit_password">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <div class="col-md-12 form-group1">
                            <label class="control-label">地址</label>
                            <input type="text" id="edit_address">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <div class="col-md-12 form-group2 group-mail">
                            <label class="control-label">状态</label>
                            <select id="selector">
                                <option value="1" id="normal" >启用</option>
                                <option value="2" id="banned" >禁用</option>
                            </select>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a class="btn btn-primary" id="postEdit">确认</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    $("#editModal").on("show.bs.modal", function (event) {
        var button = $(event.relatedTarget);
        var username = button.data("username");
        var name = button.data("name");
        var password = button.data("password");
        var address = button.data("address");
        var status = button.data("status");

        var modal = $(this);
        modal.find('#edit_username').val(username);
        modal.find('#edit_name').val(name);
        modal.find('#edit_password').val(password);
        modal.find('#edit_address').val(address);

        if(status == "1"){
            modal.find('#normal').attr("selected","selected");
        } else {
            modal.find('#banned').attr("selected","selected");
        }
    });

    $("#postEdit").click(function(){
        var username = $('#edit_username').val();
        var name = $('#edit_name').val();
        var password = $('#edit_password').val();
        var address = $('#edit_address').val();
        var status = $('#selector option:selected').val();

        $.ajax({
            url: '${base}/admin/seller/update',
            type: 'POST',
            data: $.param({'username':username,'name':name,'password':password,
                'address':address,'status':status}),
            success: function (result) {
                var data = eval("(" + result + ")");
                if (data.error == 0) {
                    swal({
                                title: data.msg,
                                text: "",
                                type: "success",
                                confirmButtonText: "确认"
                            },
                            function(){
                                location.reload();
                            });
                } else {
                    swal(data.msg,"","error");
                }
            }
        });
    })
</script>

<link rel="stylesheet" type="text/css" href="${base}/backend/DataTables/datatables.min.css"/>
<script type="text/javascript" src="${base}/backend/DataTables/datatables.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#table').DataTable({
            "ordering": false
        });
    } );
</script>
<#include "include/footer.ftl">