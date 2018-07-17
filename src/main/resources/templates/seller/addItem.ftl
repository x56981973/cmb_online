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
                    新增商品
                </li>

                <li style="float: right">
                    <a href="${base}/logout"><i class="fa fa-power-off"></i> 登出</a>
                </li>
            </ol>

            <div class="grid-form">
                <div class="grid-form1">
                    <h3>新增商品</h3>
                    <form class="form-horizontal" id="addItem" enctype="multipart/form-data" method="post" target="rfFrame">
                        <div class="form-group">
                            <label class="col-sm-2 control-label hor-form">所属商家</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="username" name="username" value="${username}" readonly="true">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>

                            <label class="col-sm-2 control-label hor-form">商品名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="description" name="description"">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>

                            <label class="col-sm-2 control-label hor-form">商品价格</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="price" name="price"">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>

                            <label class="col-sm-2 control-label hor-form">商品库存</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="stock" name="stock"">
                            </div>
                            <div class="clearfix" style="margin-bottom: 20px"> </div>

                            <label class="col-sm-2 control-label hor-form">商品类型</label>
                            <div class="col-sm-8">
                                <select id="class_id" name="class_id">
                                    <option value="-1""> 请选择 </option>
                                <#if (itemClass?size > 0)>
                                    <#list itemClass as i>
                                        <option value="${i.class_id}" id="${i.class_name}"> ${i.class_name} </option>
                                    </#list>
                                </#if>
                                </select>
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
                                    <button type="submit" class="btn btn-primary" id="postAdd">新增</button>
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
    $("#postAdd").click(function(){
        var description = $('#description').val();
        var username = $('#username').val();
        var price = $('#price').val();
        var stock = $('#stock').val();
        var class_id = $('#class_name option:selected').val();
        var pic = $('#pic').val();

        if(description == ''){
            swal("商品名不能为空","","error");
        } else if(username == ''){
            swal("商家不能为空","","error");
        } else if(price == ''){
            swal("价格不能为空","","error");
        } else if(stock == ''){
            swal("库存不能为空","","error");
        } else if(class_id == "-1"){
            swal("请选择商品类型","","error");
        } else if(pic == ""){
            swal("请上传图片","","error");
        } else {

            var form = new FormData(document.getElementById("addItem"));
            $.ajax({
                url: '${base}/seller/item/add',
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