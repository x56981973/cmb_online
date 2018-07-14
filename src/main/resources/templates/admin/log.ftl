<#include "include/header.ftl">

<div class="page-container">
<#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/admin/home">控制面板</a>
                    <i class="fa fa-angle-right"></i>
                    系统日志
                </li>

                <li style="float: right">
                    <a href="${base}/logout"><i class="fa fa-power-off"></i> 登出</a>
                </li>
            </ol>

            <div class="agile-grids">
                <div class="agile-tables">
                    <h2> 登陆历史 </h2>
                    <h2> --------------------------------------------------- </h2>
                    <table id="table1" class="display">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>用户名</th>
                            <th>登录时间</th>
                            <th>IP地址</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if (loginRecords?size > 0)>
                            <#list loginRecords as lr>
                            <tr>
                                <td>${lr.id}</td>
                                <td>${lr.username}</td>
                                <td>${lr.date}</td>
                                <td>${lr.ip_address}</td>
                            </tr>
                            </#list>
                        </#if>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="agile-grids">
                <div class="agile-tables">
                    <h2> 操作历史 </h2>
                    <h2> --------------------------------------------------- </h2>
                    <table id="table2" class="display">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>用户名</th>
                            <th>操作时间</th>
                            <th>操作类型</th>
                            <th>操作内容</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if (optionRecords?size > 0)>
                            <#list optionRecords as or>
                            <tr>
                                <td>${or.id}</td>
                                <td>${or.username}</td>
                                <td>${or.date}</td>
                                <td>${or.option_class}</td>
                                <td>${or.option_detail}</td>
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
    $(document).ready(function(){
        $('#table1').DataTable({
            "ordering": false
        });
    });
    $(document).ready(function(){
        $('#table2').DataTable({
            "ordering": false
        });
    });
</script>
<#include "include/footer.ftl">