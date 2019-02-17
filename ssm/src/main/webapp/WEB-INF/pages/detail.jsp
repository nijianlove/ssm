<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }

        #pic img{width:370px;height:200px}
    </style>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">个人信息</h3>
    <form>
        <div class="form-group">
            <input type="hidden" class="form-control" id="id" name="id" value="${user.id}"/>
        </div>

        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" readonly="readonly" value="${user.name}"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="text" class="form-control" id="gender" readonly="readonly" name="gender" value="${user.gender}"/>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" readonly="readonly" name="age" value="${user.age}"/>
        </div>

        <div class="form-group">
            <label>籍贯：</label>
            <input type="text" class="form-control" id="address" readonly="readonly" name="address"
                   value="${user.address}"/>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" value="${user.qq}" readonly="readonly"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" value="${user.email}" readonly="readonly"/>
        </div>

        <div class="form-group">
            <label>头像</label>
            <div id="pic">
                <img src="${pageContext.request.contextPath}${user.pic}" alt="头像未上传" >
            </div>
        </div>

        <%--<div class="form-group">
          <label for="email">Email：</label>
          <input type="text" class="form-control" id="email" name="email" value="${user.email}"/>
        </div>--%>
    </form>
</div>
</body>
</html>