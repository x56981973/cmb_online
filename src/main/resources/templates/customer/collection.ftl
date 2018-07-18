<#include "include/header.ftl">

<div class="page-container">
<#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/customer/home">首页</a>
                    <i class="fa fa-angle-right"></i>
                    <a href="${base}/customer/collection">收藏夹</a>
                    <i class="fa fa-angle-right"></i>
                    <#if flag??>
                        搜索
                    </#if>
                </li>

                <li style="float: right">
                    <a href="${base}/logout"><i class="fa fa-power-off"></i> 登出</a>
                </li>
            </ol>

            <div class="grid-form" style="margin: 0">
                <div class="grid-form1">
                    <form role="form" class="form-horizontal" style="margin: 0">
                        <div class="form-group" style="margin: 0">
                            <div class="col-md-12">
                                <div class="input-group" style="padding: 0">
                                    <input type="text" class="form-control1" id="search_text">
                                    <div class="input-group-addon">
                                        <a href="#" type="button" id="search_button" class="fa fa-search"></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="waterfall" id="waterfall-container">
            <#if (items?size > 0)>
                <#list items as i>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <a>
                                <img src="${base}/${i.detail}" >
                            </a>
                        </li>
                        <li class="list-group-item">
                            <button type="button" class="btn btn-default btn-xs" title="删除"
                                    data-toggle="modal" data-target="#deleteModal" data-id="${i.i_id}" data-description="${i.description}">
                                <span class="glyphicon glyphicon-trash"></span>
                            </button>
                            <button type="button" class="btn btn-default btn-xs pull-right" title="加入购物车"
                                    data-toggle="modal" data-target="#confirmModal" data-id="${i.i_id}" data-description="${i.description}">
                                <span class="glyphicon glyphicon-shopping-cart"></span>
                            </button>
                        </li>
                        <li class="list-group-item">
                            <div class="media">
                                <div class="media-body">
                                    <h4 class="media-heading">${i.description}
                                        &nbsp;&nbsp;| &nbsp;&nbsp;
                                        RMB: ${i.price} 元</h4>
                                ${i.s_name}
                                </div>
                            </div>
                        </li>
                    </ul>
                </#list>
            </#if>
            </div>
        </div>
    </div>
</div>

<script src="${base}/backend/js/bootstrap-waterfall.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#waterfall-container').waterfall();
    });
</script>

<script type="text/javascript">
    $('#search_button').click(function(){
        var keyword = $('#search_text').val();
        if(keyword != ""){
            window.location.href="${base}/customer/collection/search?keyword="+ keyword;
        } else {
            window.location.href="${base}/customer/collection";
        }
    });
</script>

<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel">
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
                <a class="btn btn-primary" id="checkConfirm">确认</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var id = "";

    $("#confirmModal").on("show.bs.modal", function (event) {
        var button = $(event.relatedTarget);
        var description = button.data("description");
        id = button.data("id");
        var modal = $(this);
        modal.find('.modal-body').text('确认将商品: '+ description + ' 加入购物车吗?');
    });

    $("#checkConfirm").click(function(){
        $.ajax({
            url: '${base}/customer/add_to_cart',
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
                    });
                } else {
                    swal(data.msg,"","error");
                }
            }
        });
        $('#confirmModal').modal('hide');
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
    var id = "";

    $("#deleteModal").on("show.bs.modal", function (event) {
        var button = $(event.relatedTarget);
        var description = button.data("description");
        id = button.data("id");
        var modal = $(this);
        modal.find('.modal-body').text('确认将商品: '+ description + ' 删除吗?');
    });

    $("#checkDelete").click(function(){
        $.ajax({
            url: '${base}/customer/collection/delete',
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

<#include "include/footer.ftl">