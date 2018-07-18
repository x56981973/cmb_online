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
                    <h2> 购物车列表 </h2>
                    <table id="table" class="display">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>商品名</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>数量</th>
                            <th>所属商家</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if (items?size > 0)>
                            <#list items as i>
                            <tr>
                                <td>${i.i_id}</td>
                                <td>${i.description}</td>
                                <td>
                                    <img src="${base}/${i.detail}" height="180" width="180">
                                </td>
                                <td>${i.price}</td>
                                <td id="number">
                                    <#if i.stock == 0>
                                        暂无库存
                                    <#else>
                                        99
                                    </#if>
                                </td>
                                <td>${i.s_name}</td>
                                <td>
                                    <a  href="#" data-toggle="modal" data-target="#deleteModal"
                                        data-id="${i.i_id}" > 删除 </a>
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

<script>
    var num = $('#number').val();
    console.log(num);
</script>

<link rel="stylesheet" type="text/css" href="${base}/backend/DataTables/datatables.min.css"/>
<script type="text/javascript" src="${base}/backend/DataTables/datatables.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#table').DataTable({
//            "ordering": false,
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
            }
        });
    } );
</script>
<#include "include/footer.ftl">