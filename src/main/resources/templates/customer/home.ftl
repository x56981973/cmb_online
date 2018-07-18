<#include "include/header.ftl">

<div class="page-container">
<#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/customer/home">首页</a>
                    <i class="fa fa-angle-right"></i>
                    <#if flag??>
                        <#if flag == "search">
                            搜索
                        <#else>
                            ${flag}
                        </#if>
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
                        <button type="button" class="btn btn-default btn-xs" title="收藏"
                                data-toggle="modal" data-target="#collectionModal" data-id="${i.i_id}" data-description="${i.description}">
                            <span class="glyphicon glyphicon-heart"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-xs pull-right" title="加入购物车"
                                data-toggle="modal" data-target="#cartModal" data-id="${i.i_id}" data-description="${i.description}">
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
            window.location.href="${base}/customer/search?keyword="+ keyword;
        } else {
            window.location.href="${base}/customer/home";
        }
    });
</script>

<div class="modal fade" id="cartModal" tabindex="-1" role="dialog" aria-labelledby="cartModalLabel">
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
                <a class="btn btn-primary" id="checkCart">确认</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var id = "";

    $("#cartModal").on("show.bs.modal", function (event) {
        var button = $(event.relatedTarget);
        var description = button.data("description");
        id = button.data("id");
        var modal = $(this);
        modal.find('.modal-body').text('确认将商品: '+ description + ' 加入购物车吗?');
    });

    $("#checkCart").click(function(){
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
                            },
                            function(){
                                window.location.href="${base}/customer/cart";
                            });
                } else {
                    swal(data.msg,"","error");
                }
            }
        });
        $('#cartModal').modal('hide');
    })
</script>

<div class="modal fade" id="collectionModal" tabindex="-1" role="dialog" aria-labelledby="collectionModalLabel">
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
                <a class="btn btn-primary" id="checkCollection">确认</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var id = "";

    $("#collectionModal").on("show.bs.modal", function (event) {
        var button = $(event.relatedTarget);
        var description = button.data("description");
        id = button.data("id");
        var modal = $(this);
        modal.find('.modal-body').text('确认将商品: '+ description + ' 添加到收藏夹吗?');
    });

    $("#checkCollection").click(function(){
        $.ajax({
            url: '${base}/customer/collection/add',
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
                                window.location.href="${base}/customer/collection";
                            });
                } else {
                    swal(data.msg,"","error");
                }
            }
        });
        $('#collectionModal').modal('hide');
    })
</script>

<#include "include/footer.ftl">