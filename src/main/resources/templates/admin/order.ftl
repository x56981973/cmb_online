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