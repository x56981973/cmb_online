<#include "include/header.ftl">

<div class="page-container">
<#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/customer/home">首页</a>
                    <i class="fa fa-angle-right"></i>
                    购物车
                </li>

                <li style="float: right">
                    <a href="${base}/logout"><i class="fa fa-power-off"></i> 登出</a>
                </li>
            </ol>

            <div class="agile-grids">
                <div class="agile-tables">
                    <h3 style="margin-bottom: 30px"> 购物车列表 </h3>
                    <table id="table" class="display">
                        <thead>
                        <tr>
                            <th>所属商家</th>
                            <th>商品名</th>
                            <th>详情</th>
                            <th>单价</th>
                            <th>数量</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if cart.itemList??>
                        <#if (cart.itemList?size > 0)>
                            <#list cart.itemList as i>
                                <#if i.stock <= 0>
                                    <tr>
                                        <td style="color: #999">${i.s_name}</td>
                                        <td style="color: #999">${i.description}</td>
                                        <td>
                                            <img src="${base}/${i.detail}" height="180" width="180">
                                        </td>
                                        <td style="color: #999">RMB: ${i.price} 元</td>
                                        <td style="color: #999">暂无库存</td>
                                        <td>
                                            <a  href="#" data-toggle="modal" data-target="#deleteModal"
                                                data-id="${i.i_id}" data-description="${i.description}" > 删除 </a>
                                        </td>
                                    </tr>
                                <#else>
                                    <tr>
                                        <td>${i.s_name}</td>
                                        <td>${i.description}</td>
                                        <td>
                                            <img src="${base}/${i.detail}" height="180" width="180">
                                        </td>
                                        <td>RMB: ${i.price} 元</td>
                                        <td>
                                            <ul class="pagination">
                                                <li>
                                                    <a onclick="minus('${i.i_id}','${cart.numList[i_index]}')">
                                                        <span style="padding: 0">-</span>
                                                    </a>
                                                </li>
                                                <li><a >${cart.numList[i_index]}</a></li>
                                                <li>
                                                    <a onclick="plus('${i.i_id}','${cart.numList[i_index]}')">
                                                        <span style="padding: 0">+</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </td>
                                        <td>
                                            <a  href="#" data-toggle="modal" data-target="#deleteModal"
                                                data-id="${i.i_id}" data-description="${i.description}" > 删除 </a>
                                        </td>
                                    </tr>
                                </#if>
                            </#list>
                        </#if>
                        </#if>
                        </tbody>
                    </table>
                </div>
            </div>

            <ol class="breadcrumb bg-danger light">
                <li class="breadcrumb-item">
                    <h2 style="color: #FFFFFF; margin-top: 10px;"> &nbsp; 合 计 : </h2>
                </li>

                <li style="float: right">
                    <h2 style="color: #FFFFFF; margin-top: 10px;">
                        <strong style="font-size: large">RMB: &nbsp;</strong>
                        ${cart.total_price}
                        <strong style="font-size: large"> 元 &nbsp;</strong>
                        <button class="btn bg-alert dark text-white text-center" style="margin-bottom: 0"
                                data-toggle="modal" data-target="#confirmModal">
                                <strong style="font-size: large"> 结算</strong>
                        </button>
                    </h2>
                </li>
            </ol>
        </div>
    </div>
</div>

<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4>确认订单信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label hor-form">姓名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="edit_name" value="${customer.name}">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">城市</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="edit_city" value="${customer.city}">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">地址</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="edit_address" value="${customer.address}">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">手机</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="edit_mobile" value="${customer.mobile}">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">支付方式</label>
                        <div class="col-sm-9">
                            <select id="selector_payment">
                                <option value="alipay" id="alipay" >支付宝</option>
                                <option value="wechatpay" id="wechatpay" >微信</option>
                                <option value="unionpay" id="unionpay" >银联</option>
                            </select>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a class="btn btn-primary" id="postOrder">提交</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    $("#confirmModal").on("show.bs.modal", function (event) {
        var modal = $(this);
        var payment = "${customer.default_payment}";

        if(payment == "alipay"){
            modal.find('#alipay').attr("selected","selected");
        } else if(payment == "wechatpay"){
            modal.find('#wechatpay').attr("selected","selected");
        } else{
            modal.find('#unionpay').attr("selected","selected");
        }
    });

    $("#postOrder").click(function(){
        var name = $('#edit_name').val();
        var city = $('#edit_city').val();
        var address = $('#edit_address').val();
        var mobile = $('#edit_mobile').val();
        var payment = $('#selector_payment option:selected').val();

        if(name == ''){
            swal("姓名不能为空","","error");
        } else if(city == ''){
            swal("城市不能为空","","error");
        } else if(address == ''){
            swal("地址不能为空","","error");
        } else if(mobile == ''){
            swal("手机不能为空","","error");
        } else {
            $.ajax({
                url: '${base}/customer/post_order',
                type: 'POST',
                data: $.param({
                    'c_name': name, 'c_city': city, 'c_address': address,
                    'c_mobile': mobile, 'payment': payment
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
                                    window.location.href="${base}/customer/order";
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
    var id = "";

    $("#deleteModal").on("show.bs.modal", function (event) {
        var button = $(event.relatedTarget);
        var description = button.data("description");
        id = button.data("id");
        var modal = $(this);
        modal.find('.modal-body').text('确认将商品: '+ description + ' 移出购物车吗?');
    });

    $("#checkDelete").click(function(){
        $.ajax({
            url: '${base}/customer/cart/delete',
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

<script type="text/javascript">
    function minus(id, num){
        var new_num = parseInt(num) - 1;

        if (new_num != 0) {
            $.ajax({
                url: '${base}/customer/cart/update_num',
                type: 'POST',
                data: $.param({
                    'i_id': id,
                    'num': new_num
                }),
                success: function (result) {
                    var data = eval("(" + result + ")");
                    if (data.error == 0) {
                        location.reload();
                    } else {
                        swal(data.msg, "", "error");
                    }
                }
            });
        }
    }
</script>

<script type="text/javascript">
    function plus(id, num){
        var new_num = parseInt(num) + 1;

        $.ajax({
            url: '${base}/customer/cart/update_num',
            type: 'POST',
            data: $.param({
                'i_id': id,
                'num': new_num
            }),
            success: function (result) {
                var data = eval("(" + result + ")");
                if (data.error == 0) {
                    location.reload();
                } else {
                    swal(data.msg, "", "error");
                }
            }
        });
    }
</script>

<link rel="stylesheet" type="text/css" href="${base}/backend/DataTables/datatables.min.css"/>
<script type="text/javascript" src="${base}/backend/DataTables/datatables.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#table').DataTable({
            "ordering": false,
//            "paging": false,
            "language": {
                "lengthMenu": "每页显示 _MENU_ 条结果",
                "zeroRecords": "没有匹配结果",
                "info": "当前显示第  _PAGE_ 页  共 _PAGES_ 页",
                "infoEmpty": "没有匹配结果",
                "infoFiltered": "(由 _MAX_ 项结果过滤)",
                "search": "搜索:",
                "paginate": {
                    "previous": "上页",
                    "next": "下页"
                }
            },
            "columnDefs": [
                {
                    "targets": [0,1,2,3,4,5],
                    "className": 'dt-center'
                }
            ]
        });
    } );
</script>
<#include "include/footer.ftl">