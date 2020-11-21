
<html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<head>
    <title>文件上传表单</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<h3>文件上传：</h3>
请选择需要上传的文件:<br/>
<form action="uploadservlet" method="post" enctype="multipart/form-data">
    <input type="file" name="file" size="50"/>
    <br/>
    <input type="submit" vlue="上传文件"/>
</form>
</body>
</html>
