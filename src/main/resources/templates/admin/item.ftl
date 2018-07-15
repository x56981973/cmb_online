<#include "include/header.ftl">

<div class="page-container">
<#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/admin/home">控制面板</a>
                    <i class="fa fa-angle-right"></i>
                    商品
                </li>

                <li style="float: right">
                    <a href="${base}/logout"><i class="fa fa-power-off"></i> 登出</a>
                </li>
            </ol>

            <div class="agile-grids">
                <div class="agile-tables">
                    <h2> 商品列表 </h2>
                    <h2> ---------------------------------------------------
                        <a style="float: right; color: black; font-size: 20px"><i class="fa fa-plus"> 新增</i></a>
                    </h2>
                    <table id="table" class="display">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>商品名</th>
                            <th>图片地址</th>
                            <th>价格</th>
                            <th>库存</th>
                            <th>所属商家</th>
                            <th>商品类别</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if (items?size > 0)>
                            <#list items as i>
                            <tr>
                                <td>${i.i_id}</td>
                                <td>${i.description}</td>
                                <td>${i.detail}</td>
                                <td>${i.price}</td>
                                <td>${i.stock}</td>
                                <td>${i.s_name}</td>
                                <td>
                                    <#if i.class_name??>
                                        ${i.class_name}
                                    <#else>
                                        N/A
                                    </#if>
                                </td>
                                <td>
                                    <a  href="#" data-toggle="modal" data-target="#editModal" data-id="${i.i_id}"
                                        data-description="${i.description}" data-price="${i.price}" data-stock="${i.stock}"
                                        data-sid="${i.s_id}" data-classid="${i.class_id}" data-classname="${i.class_name}"> 编辑 </a> |
                                    <a  href="${base}/admin/item/edit/${i.i_id}" > 修改图片 </a> |
                                    <a  href="#" data-toggle="modal" data-target="#deleteModal"
                                        data-id="${i.i_id}" data-description="${i.description}"> 删除 </a>
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
        var description = button.data("description");
        var id = button.data("id");
        var modal = $(this);
        modal.find('.modal-body').text('确认删除 商品:'+ description + ', 编号:' + id + ' 吗?');
    });

    $("#checkDelete").click(function(){
        $.ajax({
            url: '${base}/admin/item/delete',
            type: 'POST',
            data: $.param({'i_id':id}),
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
                <h4>编辑商品</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="vali-form">
                        <div class="col-md-12 form-group1">
                            <label class="control-label">编号</label>
                            <input type="text" id="i_id" name="i_id" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 10px"> </div>
                        <div class="col-md-12 form-group1">
                            <label class="control-label">商品名</label>
                            <input type="text" id="description" name="description">
                        </div>
                        <div class="clearfix" style="margin-bottom: 10px"> </div>
                        <div class="col-md-12 form-group1">
                            <label class="control-label">价格</label>
                            <input type="text" id="price" name="price">
                        </div>
                        <div class="clearfix" style="margin-bottom: 10px"> </div>
                        <div class="col-md-12 form-group1">
                            <label class="control-label">库存</label>
                            <input type="text" id="stock" name="stock">
                        </div>
                        <div class="clearfix" style="margin-bottom: 10px"> </div>
                        <div class="col-md-12 form-group2 group-mail">
                            <label class="control-label">商品类别</label>
                            <select id="class_name" name="class_name">
                            <#if (itemClass?size > 0)>
                                <#list itemClass as i>
                                    <option value="${i.class_id}" id="${i.class_name}"> ${i.class_name} </option>
                                </#list>
                            </#if>
                            </select>
                        </div>
                        <#--<div class="col-md-12 form-group1">-->
                            <#--<label class="control-label">图片上传</label>-->
                            <#--<input type="file" id="pic" name="pic">-->
                        <#--</div>-->
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
        var i_id = button.data("id");
        var description = button.data("description");
        var price = button.data("price");
        var stock = button.data("stock");
        var class_name = button.data("classname");

        var modal = $(this);
        modal.find('#i_id').val(i_id);
        modal.find('#description').val(description);
        modal.find('#price').val(price);
        modal.find('#stock').val(stock);
        modal.find('#'+class_name).attr("selected","selected");
    });

    $("#postEdit").click(function(){
        var i_id = $('#i_id').val();
        var description = $('#description').val();
        var price = $('#price').val();
        var stock = $('#stock').val();
        var class_id = $('#class_name option:selected').val();

        $.ajax({
            url: '${base}/admin/item/update',
            type: 'POST',
            data: $.param({'i_id':i_id,'description':description,'price':price,
                'stock':stock,'class_id':class_id}),
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
    });
</script>

<#--<div class="modal fade" id="picModal" tabindex="-1" role="dialog" aria-labelledby="picModalLabel">-->
    <#--<div class="modal-dialog">-->
        <#--<div class="modal-content">-->
            <#--<div class="modal-header">-->
                <#--<button type="button" class="close" data-dismiss="modal">×</button>-->
                <#--<h4 id="title"></h4>-->
            <#--</div>-->
            <#--<div class="modal-body">-->
                <#--<div class="col-md-12 form-group1">-->
                    <#--<label class="control-label">原图片</label>-->
                    <#--<div>-->
                        <#--<img id="origin">-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="clearfix" style="margin-bottom: 20px"> </div>-->
                <#--<form class="form-horizontal" id="fileUpload" enctype="multipart/form-data" method="post">-->
                    <#--<div class="col-md-12 form-group1">-->
                        <#--<label class="control-label">图片上传</label>-->
                        <#--<input type="file" id="pic" name="pic">-->
                    <#--</div>-->
                    <#--<div class="form-actions">-->
                        <#--<button type="submit" class="btn btn-primary">上传</button>-->
                        <#--<button type="reset" id="reset" class="btn">取消</button>-->
                    <#--</div>-->
                <#--</form>-->
                <#--<div class="clearfix"> </div>-->
            <#--</div>-->
            <#--&lt;#&ndash;<div class="modal-footer">&ndash;&gt;-->
                <#--&lt;#&ndash;<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>&ndash;&gt;-->
                <#--&lt;#&ndash;<a class="btn btn-primary" id="postPic">确认</a>&ndash;&gt;-->
            <#--&lt;#&ndash;</div>&ndash;&gt;-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->

<#--<script type="text/javascript">-->

    <#--$("#picModal").on("show.bs.modal", function (event) {-->
        <#--var button = $(event.relatedTarget);-->
        <#--var i_id = button.data("id");-->
        <#--var description = button.data("description");-->
        <#--var detail = button.data("detail");-->

        <#--var modal = $(this);-->
        <#--modal.find('#title').val("修改商品: " + description);-->
        <#--modal.find('#description').val(description);-->
        <#--modal.find('#origin').attr('src','${base}/pic/'+detail);-->

    <#--});-->

    <#--$("#postPic").click(function(){-->
        <#--var i_id = $('#i_id').val();-->
        <#--var description = $('#description').val();-->
        <#--var price = $('#price').val();-->
        <#--var stock = $('#stock').val();-->
        <#--var class_id = $('#class_name option:selected').val();-->

        <#--$.ajax({-->
            <#--url: '${base}/admin/item/update',-->
            <#--type: 'POST',-->
            <#--data: $.param({'i_id':i_id,'description':description,'price':price,-->
                <#--'stock':stock,'class_id':class_id}),-->
            <#--success: function (result) {-->
                <#--var data = eval("(" + result + ")");-->
                <#--if (data.error == 0) {-->
                    <#--swal({-->
                                <#--title: data.msg,-->
                                <#--text: "",-->
                                <#--type: "success",-->
                                <#--confirmButtonText: "确认"-->
                            <#--},-->
                            <#--function(){-->
                                <#--location.reload();-->
                            <#--});-->
                <#--} else {-->
                    <#--swal(data.msg,"","error");-->
                <#--}-->
            <#--}-->
        <#--});-->
    <#--});-->
<#--</script>-->

<link rel="stylesheet" type="text/css" href="${base}/backend/DataTables/datatables.min.css"/>
<script type="text/javascript" src="${base}/backend/DataTables/datatables.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#table').DataTable({
//            "ordering": false
        });
    } );
</script>
<#include "include/footer.ftl">