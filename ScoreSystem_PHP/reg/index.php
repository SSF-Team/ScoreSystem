<?php
echo '
<!---------------------------------------------------->
<!--    ███████╗████████╗ █████╗ ██████╗ ██╗  ██╗   -->
<!--    ██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚██╗██╔╝   -->
<!--    ███████╗   ██║   ███████║██████╔╝ ╚███╔╝    -->
<!--    ╚════██║   ██║   ██╔══██║██╔═══╝  ██╔██╗    -->
<!--    ███████║   ██║   ██║  ██║██║     ██╔╝ ██╗   -->
<!--    ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝     ╚═╝  ╚═╝   -->                                 
<!---------------------------------------------------->
'
?>

<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>注册 - 学生管理系统</title>

    <!-- 响应式触发 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- 样式表 -->
    <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
    <!-- 引入JS -->
    <script src="https://use.fontawesome.com/60da9132fd.js"></script>

</head>
<style>
    body
    {
        background: #F8F9FA;
    }
    .topmask
    {
        z-index:1;
        background-color:#00000066;
        width:100%;
        height:100%;
        position:absolute;
        left:0px;
        top:0px;
    }
</style>
<body onload="onload();">

<script>
    function onload() {
        if (screen.width < screen.height) {      //移动设备

        }
    }
</script>
<!-- 窗口分辨率判断，区分桌面/移动设备 -->

<?php
if($_GET["back"] == "ok")
{
    echo '
    <div id="topmask" class="topmask">
    <div style="width:30%;margin: 0 auto;margin-top:15%;;min-width:400px;">
        <div class="shadow-sm p-3 mb-5 bg-white rounded" style="padding-left: 0px!important;padding-right: 0px!important;padding-top: 0px!important;">
            <div class="card-body" style="padding-left: 0px;padding-right: 0px;padding: 20px;">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="15%" style="vertical-align:middle;padding-right:10px;">
                        <div align="right">
                            <i class="fa fa-2x fa-exclamation-circle" aria-hidden="true"></i>
                        </div>
                    </td>
                    <td style="vertical-align:middle;">
                        <a style="font-size:18px">注册成功！</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div align="center" style="margin-top:-20px;">
                            <br>
                            <a id="poptip" align="left">感谢注册</a>
                            <br>
                            <button type="button" class="btn btn-primary" style="width:40%;margin-top:20px;" onclick="closepop();">好的</button>
                        </div>
                    </td>
                </tr>
            </table>
            </div>
        </div>
    </div>
</div>
    ';
}
?>

<div id="topmain" style="margin: 8%"></div>
<div id="main" style="width:25%;margin: 0 auto;min-width:320px;">
<div class="shadow-sm p-3 mb-5 bg-white rounded" style="padding-left: 0px!important;padding-right: 0px!important;padding-top: 0px!important;">
    <div class="card-body" style="padding-left: 0px;padding-right: 0px;padding-top: 0px;">
        <h5 class="card-title">
        <img src="bar.png" style="width:100%;height:100px"/>
        <div align="center" style="margin-top: -35px;">
            <a style="color:#FFF;">注册</a>
        </div>
        </h5>
        <div id="tip" class="alert alert-warning alert-dismissible fade show" role="alert" style="height:40px;padding-top:6px;padding-botton:6px;display:none;margin-bottom: -10px;">
            <a style="font-size:15px;"><strong>提醒：</strong></a>
            <a id='tiptext' style="font-size:15px;">这是个提醒</a>
        </div>

        <?php
            if($_GET["back"] == "same")
            {
                echo '
                <div class="alert alert-warning alert-dismissible fade show" role="alert" style="margin-botton:-20px;height:40px;padding-top:6px;padding-botton:6px;margin-bottom: -10px;">
                    <a style="font-size:15px;"><strong>提醒：</strong></a>
                    <a style="font-size:15px;">此用户已注册。</a>
                </div>
                ';
            }
        ?>
        
        <br>
        <div align="center">
            <font style="font-size:15px;">注册您的账户</font>
            <br>
            <input id="name" type="text" placeholder="  用户名" aria-label="用户名" style="width:75%;height:35px;font-size:13px;;margin-top:20px;">
            <input id="pass" type="password" placeholder="  密码" aria-label="密码" style="width:75%;height:35px;font-size:13px;margin-top:10px;"><br>
            <button type="button" onclick="reg();" class="btn btn-light" style="width:50px;height:50px;margin-top:30px;border:2px solid #B6B6B4;"><i class="fa fa-angle-right fa-2x" aria-hidden="true" style="color:#B6B6B4;"></i></button>
        </div>
        <script>
        function reg()
        {
            var name = document.getElementById('name').value;
            var pass = document.getElementById('pass').value;
            if(typeof name == "undefined" || name == null || name == "" || typeof pass == "undefined" || pass == null || pass == "")
            {
                var tipbar = document.getElementById('tip');
                tipbar.style.display = "flex";
                var text = document.getElementById('tiptext');
                text.innerText = "请填写完整内容。";
            }
            else
            {
                window.location.href="/reg/reg.php?username=" + name + "&password=" + pass;
            }
        }
        function closepop()
        {
            var pop = document.getElementById('topmask');
            pop.style.display = "none";
        }
        </script>
        <div style="clear:both;">
        </div>
    </div>
</div>
<div align="center" style="margin-top: -30px;">
    <font style="font-size: 10px;">Copyright © 懒得取名 Studio 2020</font>
    </div>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="bootstrap.min.js"></script>

</body>
</html>