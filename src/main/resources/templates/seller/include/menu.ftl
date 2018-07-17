<!--/sidebar-menu-->
<div class="sidebar-menu">
    <header class="logo1">
        <a class="sidebar-icon"> <span class="fa fa-bars"></span> </a>
    </header>

    <div class="menu">
        <ul id="menu" >
            <li>
                <a href="${base}/seller/home">
                    <i class="fa fa-tachometer"></i>
                    <span>控制面板</span>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li id="menu-academico" >
                <a href="${base}/seller/item">
                    <i class="fa fa-gift"></i>
                    <span>商品</span>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li id="menu-academico" >
                <a href="${base}/seller/order">
                    <i class="fa fa-file-text"></i>
                    <span>订单</span>
                    <span class="fa fa-angle-right" style="float: right"></span>
                    <div class="clearfix"></div>
                </a>
                <ul id="menu-academico-sub" >
                    <li id="menu-academico-avaliacoes" >
                        <a href="${base}/seller/order">
                            <i class="fa fa-files-o"></i> &nbsp;&nbsp;&nbsp;&nbsp;全部订单&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </li>
                    <li id="menu-academico-avaliacoes" >
                        <a href="${base}/seller/done_order">
                            <i class="fa fa-check-circle"></i> &nbsp;&nbsp;&nbsp;&nbsp;已发货订单&nbsp;&nbsp;&nbsp;&nbsp;
                        </a>
                    </li>
                    <li id="menu-academico-avaliacoes" >
                        <a href="${base}/seller/not_done_order">
                            <i class="fa fa-exclamation-circle"></i> &nbsp;&nbsp;&nbsp;&nbsp;待发货订单&nbsp;&nbsp;&nbsp;&nbsp;
                        </a>
                    </li>
                </ul>
            </li>
            <li id="menu-academico" >
                <a href="#">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <span>${name}</span>
                    <span class="fa fa-angle-right" style="float: right"></span>
                    <div class="clearfix"></div>
                </a>
                <ul id="menu-academico-sub" >
                    <li id="menu-academico-avaliacoes" >
                        <a href="${base}/seller/profile">
                            <i class="fa fa-gear"></i> &nbsp;&nbsp;&nbsp;&nbsp;账号设置&nbsp;&nbsp;&nbsp;&nbsp;
                        </a>
                    </li>
                    <li id="menu-academico-avaliacoes" >
                        <a href="${base}/logout">
                            <i class="fa fa-power-off"></i> &nbsp;&nbsp;&nbsp;&nbsp;登出&nbsp;&nbsp;&nbsp;&nbsp;
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<div class="clearfix"></div>

<script>
    var toggle = true;

    $(".sidebar-icon").click(function() {
        if (toggle)
        {
            $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
            $("#menu span").css({"position":"absolute"});
        }
        else
        {
            $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
            setTimeout(function() {
                $("#menu span").css({"position":"relative"});
            }, 400);
        }
        toggle = !toggle;
    });
</script>