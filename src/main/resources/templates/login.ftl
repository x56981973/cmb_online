<!DOCTYPE html>
<html>
    <head>
        <#include "common.ftl">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>网上商城</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="login/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="login/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="login/css/form-elements.css">
        <link rel="stylesheet" href="login/css/style.css">

        <!-- formvalidation CSS-->
        <link href="login/formvalidation/formValidation.min.css" rel="stylesheet">
        <#--<link rel="shortcut icon" href="${base}/favicon.ico">-->
    </head>

    <body>
        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>简 易 电 子 商 务 系 统 </strong> </h1>
                            <div class="description">
                            	<p>
                                    <a href="#"><strong> 夏之阳: x56981973@sjtu.edu.cn</strong></a>
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>登陆</h3>
                            		<p>请输入用户名和密码</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="${base}/loginCheck" method="post" class="login-form" id="loginForm">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="username">Username</label>
			                        	<input type="text" name="username" placeholder="Username..." class="form-username form-control" id="username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="password">Password</label>
			                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="password">
			                        </div>
                                    <div id="loginMsg" class="col-lg-12" style="padding: 6px;display: none;"></div>
			                        <button type="submit" class="btn" >提交</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="login/js/jquery-1.11.1.min.js"></script>
        <script src="login/bootstrap/js/bootstrap.min.js"></script>
        <script src="login/js/jquery.backstretch.min.js"></script>
        <script src="login/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="login/js/placeholder.js"></script>
        <![endif]-->

        <script src="login/formvalidation/formValidation.min.js"></script>
        <script src="login/formvalidation/bootstrap.min.js"></script>

        <script type="text/javascript">
        $(function () {
            $('#loginForm')
                .formValidation({
                    framework: 'bootstrap',
                    icon: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        username: {
                            validators: {
                                notEmpty: {
                                    message: '用户名不能为空'
                                }
                            }
                        },
                        password: {
                            validators: {
                                notEmpty: {
                                    message: '密码不能为空'
                                }
                            }
                        }
                    }
                })
                .on('success.form.fv',function(e) {
                    e.preventDefault();

                    var patt = new RegExp('^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$');
                    var username = $('#username').val();
                    var password = $('#password').val();
                    var u_test = patt.test(username);
                    var p_test = patt.test(password);
                    if(u_test != true ){
                        $('#loginMsg').addClass('alert alert-danger').css('display','block').text("登录名格式错误");
                    } else if(p_test != true){
                        $('#loginMsg').addClass('alert alert-danger').css('display','block').text("密码格式错误");
                    } else {
                        var $form = $(e.target),
                                fv = $form.data('formValidation');
                        // Use Ajax to submit form data
                        $.ajax({
                            url: $form.attr('action'),
                            type: 'POST',
                            data: $form.serialize(),
                            success: function (result) {
                                var data = eval("(" + result + ")");
                                if (data.error != 0) {
                                    $('#loginMsg').addClass('alert alert-danger').css('display', 'block').text(data.msg);
                                } else {
                                    $('#loginMsg').removeClass('alert-danger').addClass('alert-success').css('display', 'block').text(data.msg);
                                    window.location.href = "${base}" + data.to;
                                }
                            }
                        });
                        fv.disableSubmitButtons(false);
                    }
                });
        });
        </script>

    </body>
</html>