<!--/sidebar-menu-->
<div class="sidebar-menu">
    <header class="logo1">
        <a class="sidebar-icon"> <span class="fa fa-bars"></span> </a>
    </header>

    <div class="menu">
        <ul id="menu" >
            <li>
                <a href="${base}/customer/home">
                    <i class="fa fa-gift"></i>
                    <span>首页</span>
                    <span class="fa fa-angle-right" style="float: right"></span>
                    <div class="clearfix"></div>
                </a>
                <ul id="menu-academico-sub" >
                    <li id="menu-academico-avaliacoes" >
                        <a href="${base}/customer/class?class_name=服饰">
                            <i class="fa fa-th-large"></i> &nbsp;&nbsp;&nbsp;&nbsp;服饰&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </li>
                    <li id="menu-academico-avaliacoes" >
                        <a href="${base}/customer/class?class_name=食品"">
                            <i class="fa fa-th-large"></i> &nbsp;&nbsp;&nbsp;&nbsp;食品&nbsp;&nbsp;&nbsp;&nbsp;
                        </a>
                    </li>
                    <li id="menu-academico-avaliacoes" >
                        <a href="${base}/customer/class?class_name=电子"">
                            <i class="fa fa-th-large"></i> &nbsp;&nbsp;&nbsp;&nbsp;电子&nbsp;&nbsp;&nbsp;&nbsp;
                        </a>
                    </li>
                </ul>
            </li>
            <li id="menu-academico" >
                <a href="${base}/customer/cart">
                    <i class="fa fa-shopping-cart"></i>
                    <span>购物车</span>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li id="menu-academico" >
                <a href="${base}/customer/collection">
                    <i class="fa fa-heart"></i>
                    <span>收藏夹</span>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li id="menu-academico" >
                <a href="${base}/customer/order">
                    <i class="fa fa-file-text"></i>
                    <span>我的订单</span>
                    <span class="fa fa-angle-right" style="float: right"></span>
                    <div class="clearfix"></div>
                </a>
                <ul id="menu-academico-sub" >
                    <li id="menu-academico-avaliacoes" >
                        <a href="${base}/customer/order">
                            <i class="fa fa-files-o"></i> &nbsp;&nbsp;&nbsp;&nbsp;全部订单&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </li>
                    <li id="menu-academico-avaliacoes" >
                        <a href="${base}/customer/not_done_order">
                            <i class="fa fa-check-circle"></i> &nbsp;&nbsp;&nbsp;&nbsp;未完成订单&nbsp;&nbsp;&nbsp;&nbsp;
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
                        <a href="${base}/customer/profile">
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