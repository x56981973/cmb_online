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
                            <th>商家</th>
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
                                    <a> 详情 </a> | <a> 编辑 </a> | <a> 删除 </a>
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
            "ordering": false
        });
    } );
</script>
<#include "include/footer.ftl">