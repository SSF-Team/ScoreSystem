<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>注册 - 学生管理系统</title>
<body>

<?php
 $usernamelogn=$_GET['username'];
 $password=$_GET['password'];
 if($usernamelogn == null || $password == null)
 {
    echo '拒绝访问！';
    header('Location: /reg');
    exit;
 }


// SQL Info
 $servername = "地址";
 $username = "账号";
 $password = "密码";
 $dbname = "数据库";
  
 // 创建连接
 $conn = mysqli_connect($servername, $username, $password, $dbname);
 // Check connection
 if (!$conn)
 {
     die("连接失败: " . mysqli_connect_error());
 }
  
 $sql = "SELECT uid,uname FROM User;";
 $result = mysqli_query($conn, $sql);
  
 if (mysqli_num_rows($result) > 0)
 {
     $uid = 0;
     $uhas = 0;
     while($row = mysqli_fetch_assoc($result)) {
         echo "id: " . $row["uid"]. " - Name: " . $row["uname"]. "<br>";
         if($row["uname"] == $_GET['username'])
         {
             echo ">> ";
             $uhas = 1;
         }
         $uid = $row["uid"]+1;
     }
     if($uhas == 1)
     {
        echo "<br>用户 ".$_GET['username']." 重复 - 当前ID数：".$uid;
        header('Location: /reg?back=same');
        exit;
     }
     else
     {
        echo "<br>用户 ".$_GET['username'].",当前ID数：".$uid;
        $back = mysqli_query($conn,"SET NAMES 'utf8'");
            if (!$back)
            {
                die("处理编码失败");
            }
        $sql = "INSERT INTO User(uid, uname, upassword) VALUES ({$uid}, '{$_GET['username']}', '{$_GET['password']}');";
        $result = mysqli_query($conn, $sql);
        if($result == 0)
        {
            echo '<br>操作失败！';
            mysqli_close($conn);
            exit;
        }
        else
        {
            echo '<br>写入 User 成功！';
            mysqli_close($conn);
            echo '<br>添加基础数据：'.$uid.$_GET['username'];
            $conna = mysqli_connect($servername, $username, $password, $dbname);
            // Check connection
            if (!$conna)
            {
                die("连接失败: " . mysqli_connect_error());
            }
            $backa = mysqli_query($conna,"SET NAMES 'utf8'");
            if (!$backa)
            {
                die("处理编码失败");
            }
            $sqla = "INSERT INTO Student(uid, 姓名, 学号, 年龄, 号码, 住址, 班主任) VALUES ({$uid}, '{$_GET['username']}', '', NULL, NULL, NULL, '');";
            $resulta = mysqli_query($conna, $sqla);
  
            if ($resulta)
            {
                echo '<br>写入 Student 成功！';
                mysqli_close($conna);
                header('Location: /reg?back=ok');
                exit;
            }
            else
            {
                echo '<br>操作失败！';
                mysqli_close($conna);
                exit;
            }
        }
     }
 }
 else
 {
     
 }
?>

</body>
</html>

