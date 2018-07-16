<#include "include/header.ftl">

<div class="page-container">
<#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/seller/home">控制面板</a>
                    <i class="fa fa-angle-right"></i>
                    订单
                </li>

                <li style="float: right">
                    <a href="${base}/logout"><i class="fa fa-power-off"></i> 登出</a>
                </li>
            </ol>

            <div class="agile-grids">
                <div class="agile-tables">
                    <h2> 订单列表 </h2>
                    <h2> --------------------------------------------------- </h2>
                    <table id="table" class="display">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>订单日期</th>
                            <th>顾客</th>
                            <th>商家</th>
                            <th>商品数量</th>
                            <th>订单总额</th>
                            <th>订单状态</th>
                            <th>订单详情</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if (orders?size > 0)>
                            <#list orders as o>
                            <tr>
                                <td>${o.o_id}</td>
                                <td>${o.date}</td>
                                <td>${o.c_name}</td>
                                <td>${o.s_name}</td>
                                <td>${o.itemList?size}</td>
                                <td>${o.total_price}</td>
                                <td>
                                    <#if o.status == "1">
                                        已成交
                                    <#elseif o.status == "2">
                                        待发货
                                    <#else>
                                        待收货
                                    </#if>
                                </td>
                                <td>
                                    <a  href="#" data-toggle="modal" data-target="#detailModal"
                                        data-brief="${o.brief}" data-id="${o.o_id}" data-date="${o.date}" data-payment="${o.payment}"
                                        data-cname="${o.c_name}" data-price="${o.total_price}" data-city="${o.c_city}"
                                        data-address="${o.c_address}" data-mobile="${o.c_mobile}"> 详情 </a>
                                    <#if o.status == "2">
                                        | <a  href="#" data-toggle="modal" data-target="#detailModal"
                                            data-id="${o.o_id}"> 确认发货 </a>
                                    </#if>
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

<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4>详情</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label hor-form">订单编号</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="o_id" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">订单日期</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="date" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">订单总额</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="total_price" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">支付方式</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="payment" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">顾客姓名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="c_name" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">城市</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="city" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">地址</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="address" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">手机</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobile" readOnly="true">
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">商品列表</label>
                        <div class="col-sm-9" id="item_list">
                            <#--<input type="text" class="form-control" id="payment" readOnly="true">-->
                        </div>
                        <div class="clearfix" style="margin-bottom: 20px"> </div>
                        <label class="col-sm-2 control-label hor-form">状态</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="status" readOnly="true">
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary" data-dismiss="modal">确认</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    $("#detailModal").on("show.bs.modal", function (event) {
        var button = $(event.relatedTarget);
        var brief = button.data("brief");
        var o_id = button.data("id");
        var date = button.data("date");
        var c_name = button.data("cname");
        var s_name = button.data("sname");
        var total_price = button.data("price");
        var city = button.data("city");
        var address = button.data("address");
        var mobile = button.data("mobile");
        var payment = button.data("payment");

        var modal = $(this);
        modal.find('#o_id').val(o_id);
        modal.find('#date').val(date);
        modal.find('#total_price').val(total_price);
        modal.find('#c_name').val(c_name);
        modal.find('#city').val(city);
        modal.find('#address').val(address);
        modal.find('#mobile').val(mobile);
        if(status == "1"){
            modal.find('#status').val("已成交");
        } else if(status == "2"){
            modal.find('#status').val("待发货");
        } else {
            modal.find('#status').val("待收货");
        }

        if(payment == "alipay"){
            modal.find('#payment').val("支付宝");
        } else if(payment == "wechatpay"){
            modal.find('#payment').val("微信");
        } else{
            modal.find('#payment').val("银联");
        }

        var data = eval("(" + brief + ")");
        $.each(data, function(index,item){
            console.log(item.i_id);
            console.log(item.description);
            console.log(item.price);
            console.log(item.num);
        });

    });

</script>

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