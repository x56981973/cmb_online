<#include "include/header.ftl">

<div class="page-container">
    <#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/seller/home">控制面板</a>
                    <i class="fa fa-angle-right"></i>

                </li>

                <li style="float: right">
                    <a href="${base}/logout"><i class="fa fa-power-off"></i> 登出</a>
                </li>
            </ol>

            <div class="four-grids">
                <div class="col-md-3 four-grid">
                    <a href="${base}/seller/order">
                        <div class="four-agileinfo">
                            <div class="icon">
                                <i class="glyphicon glyphicon-gift" aria-hidden="true"></i>
                            </div>
                            <div class="four-text">
                                <h3>订单总数</h3>
                                <h4> ${order_num}  </h4>

                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-3 four-grid">
                    <a href="${base}/seller/not_done_order">
                        <div class="four-agileits">
                            <div class="icon">
                                <i class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></i>
                            </div>
                            <div class="four-text">
                                <h3>未发货订单</h3>
                                <h4> ${not_done_order_num} </h4>

                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-3 four-grid">
                    <a href="${base}/seller/item">
                        <div class="four-w3ls">
                            <div class="icon">
                                <i class="glyphicon glyphicon-gift" aria-hidden="true"></i>
                            </div>
                            <div class="four-text">
                                <h3>商品总数</h3>
                                <h4> ${item_num} </h4>

                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-3 four-grid">
                    <a href="#">
                        <div class="four-wthree">
                            <div class="icon">
                                <i class="glyphicon glyphicon-user" aria-hidden="true"></i>
                            </div>
                            <div class="four-text">
                                <h3>平均流量</h3>
                                <h4> 10000 </h4>

                            </div>
                        </div>
                    </a>
                </div>
                <div class="clearfix"></div>
            </div>

            <!--agileinfo-grap-->
            <div class="agileinfo-grap">
                <div class="agileits-box">
                    <header class="agileits-box-header clearfix">
                        <h3>订单统计</h3>
                        <div class="toolbar">
                            <div class="pull-left">
                                <div class="btn-group">
                                    <a href="#" class="btn btn-default btn-xs active">Daily</a>
                                    <a href="#" class="btn btn-default btn-xs">Monthly</a>
                                    <a href="#" class="btn btn-default btn-xs">Yearly</a>
                                </div>
                            </div>
                            <div class="pull-right">
                                <div class="btn-group">
                                    <a aria-expanded="false" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                        导出 <i class="fa fa-angle-down"></i>
                                    </a>
                                    <ul class="dropdown-menu pull-right" role="menu">
                                        <li><a href="#">导出为 PDF</a></li>
                                        <li><a href="#">导出为 CSV</a></li>
                                        <li><a href="#">导出为 PNG</a></li>
                                    </ul>
                                </div>
                                <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-cog"></i></a>
                            </div>
                        </div>
                    </header>
                    <div class="agileits-box-body clearfix">
                        <div id="hero-area"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {

        //CHARTS
        //    function gd(year, day, month) {
        // 	return new Date(year, month - 1, day).getTime();
        // }

        graphArea2 = Morris.Area({
            element: 'hero-area',
            padding: 10,
            behaveLikeLine: true,
            gridEnabled: false,
            gridLineColor: '#dddddd',
            axes: true,
            resize: true,
            smooth:true,
            pointSize: 0,
            lineWidth: 0,
            fillOpacity:0.85,
            data: [
                {period: '2018-07-10', 订单: 2668},
                {period: '2018-07-11', 订单: 15780},
                {period: '2018-07-12', 订单: 12920},
                {period: '2018-07-13', 订单: 8770},
                {period: '2018-07-14', 订单: 10820},
                {period: '2018-07-15', 订单: 9680},
                {period: '2018-07-16', 订单: 4830},
                {period: '2018-07-17', 订单: 15083},
                {period: '2018-07-18', 订单: 10697},
                {period: '2018-07-19', 订单: 8442}
            ],
            lineColors:['#ff4a43'],
            xkey: 'period',
            redraw: true,
            ykeys: ['订单'],
            labels: ['每日订单'],
            pointSize: 2,
            hideHover: 'auto',
            resize: true
        });


    });
</script>
<#include "include/footer.ftl">