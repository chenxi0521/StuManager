
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>新增</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
    <style>

        #bigbox{
            width: 600px;
            margin:0 auto;
        }

        img{
            width: 80px;
            height: 80px;
            border-radius:50%
        }
    </style>

    <script type="text/javascript">
        $(function (){
            $("#exampleInputFile").mouseleave(function (){

                var imgurl = getObjectURL($("#exampleInputFile")[0].files[0]);
                $("img").prop("src",imgurl);
            });

        });

        function getObjectURL(file) {
            var url = null;
            if(window.createObjectURL != undefined) { // basic
                url = window.createObjectURL(file);
            } else if(window.URL != undefined) { // mozilla(firefox)
                url = window.URL.createObjectURL(file);
            } else if(window.webkitURL != undefined) { // webkit or chrome
                url = window.webkitURL.createObjectURL(file);
            }
            return url;
        }
    </script>
</head>
<body>

    <div id="bigbox">
        <form action="stu" method="post" enctype="multipart/form-data">
            <input type="hidden" name="type" value="insert">
            <div class="mb-3">
                <label  class="form-label">姓名:</label>
                <input type="text" class="form-control"  name="sname">
            </div>
            性别:
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio"  name="sex" value="男" checked>
                    <label class="form-check-label">男</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="sex" value="女">
                    <label class="form-check-label" >女</label>
                </div>
            <div class="mb-3">
                <label  class="form-label">年龄:</label>
                <input type="text" class="form-control"  name="age">
            </div>

            <div class="form-group">
                <label for="exampleInputFile">照片</label>
                <input type="file" id="exampleInputFile"  name="photo">
                <img src="" class="img-circle img-responsive">
            </div>

            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">邮箱:</label>
                <input type="email" class="form-control"  name="email"  id="exampleFormControlInput1" placeholder="name@example.com">
            </div>
            </table>
            <input type="submit" class="btn btn-outline-primary" value="提交">
        </form>

    </div>

</body>
</html>