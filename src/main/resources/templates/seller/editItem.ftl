<#include "include/header.ftl">

<div class="page-container">
<#include "include/menu.ftl">

    <div class="left-content">
        <div class="mother-grid-inner">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="${base}/seller/home">控制面板</a>
                    <i class="fa fa-angle-right"></i>
                    <a href="${base}/seller/item">商品</a>
                    <i class="fa fa-angle-right"></i>
                    编辑商品
                </li>

                <li style="float: right">
                    <a href="${base}/logout"><i class="fa fa-power-off"></i> 登出</a>
                </li>
            </ol>

            <div class="grid-form">
                <div class="grid-form1">
                    <h3>编辑商品</h3>
                    <form class="form-horizontal" id="updateItem" enctype="multipart/form-data" method="post" target="rfFrame">
                        <div class="form-group">
                            <label class="col-sm-2 control-label hor-form">商品编号</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="i_id" name="i_id" readOnly="true" value="${i.i_id}">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>

                            <label class="col-sm-2 control-label hor-form">商品名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="description" name="description" readOnly="true" value="${i.description}">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>

                            <label class="col-sm-2 control-label hor-form">所属商家</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="username" name="username" readOnly="true" value="${i.s_username}">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>

                            <label class="col-sm-2 control-label hor-form">原图片</label>
                            <div class="col-sm-8">
                                <img src="${base}/${i.detail}" height="180" width="180">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>

                            <label class="col-sm-2 control-label hor-form">图片上传</label>
                            <div class="col-sm-8">
                                <input type="file" id="pic" name="pic">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>

                        </div>
                        <div class="panel-footer">
                            <div class="row">
                                <div class="col-sm-8 col-sm-offset-2">
                                    <button type="submit" class="btn btn-primary" id="postPic">保存设置</button>
                                    <button type="reset" class="btn" id="cancel">取消</button>
                                </div>
                            </div>
                        </div>
                    </form>
                    <iframe style="display: none" id="rfFrame" name="rfFrame" src="about:blank"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $("#postPic").click(function(){
        var pic = $('#pic').val();
        if(pic == ""){
            swal("请上传图片","","error");
        } else {

            var form = new FormData(document.getElementById("updateItem"));
            $.ajax({
                url: '${base}/seller/item/update_pic',
                type: 'POST',
                data: form,
                cache: false,
                processData: false,
                contentType: false,
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
                                    window.location.href = "${base}" + "/seller/item"
                                });
                    } else {
                        swal(data.msg, "", "error");
                    }
                }
            });

        }
    });
</script>

<script type="text/javascript">
    $("#cancel").click(function(){
        window.location.href = "${base}" + "/seller/item"
    });
</script>


<#include "include/footer.ftl">