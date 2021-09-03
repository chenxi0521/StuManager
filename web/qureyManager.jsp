
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>学生管理系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/stuPage.css" rel="stylesheet">
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/stuPage.js" type="text/javascript"></script>
    <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
    <style>
        #bigbox{
            margin: 0 auto;
            height: 800px;
            width: 1500px;
            text-align: center;
        }
        #top{
            height: 100px;
            position: relative;
        }
        .left{
            width: 250px;
            position: absolute;
            top:50px;
            left: 0;
        }
        .right{
            position: absolute;
            top:50px;
            right: 0;
        }
        .zhong{
            position: absolute;
            top:50px;
            left: 250px;
        }
        th,td{
            text-align: center;
            line-height: 55px;
        }

        .form-check-input{
            position: relative;
            top: 15px;
            left: 40px;
        }


        .bj{
            width: 150px;
        }

        img{
            width: 80px;
            height: 80px;
            border-radius:50%
        }

    </style>
    <script>
        $(function (){

            $("#all").click(function (){
                $("[name='che']").prop("checked",$("#all").prop("checked"));
            });

            $("#batchDel").click(function (){
                var str = "";
                $("input[name='che']").each(function (){
                   if ($(this).prop("checked")==true){
                      str += $(this).val()+",";

                   }
                });

                if (str.length>0){
                    str = str.substring(0,str.length-1)
                    window.location="stu?type=batchDel&sids="+str;
                }

            })


        });

    </script>


</head>
<body>


    <div id="bigbox">

        <div id="top">
            <div class="left">
                <form action="stu" method="get">
                    <input type="hidden" name="type" value="query">
                    <input type="text"  name="select" value="${sessionScope.select}">
                    <input type="submit" class="btn btn-outline-primary" value="搜索">
                </form>
            </div>
            <div class="zhong">
                <input type="button" class="btn btn-outline-primary" value="批量删除" id="batchDel">
            </div>
            <div class="right">
                <span id="user">${sessionScope.uname},欢迎你使用学生管理系统！</span>
                <a href="insert.jsp">新增</a>
                <a href="user?type=outlogin">退出系统</a>
            </div>
        </div>


        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="all" >
                            <label class="form-check-label">
                                编号
                            </label>
                        </div>
                    </th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>邮箱</th>
                    <th>照片</th>
                    <th class="bj">编辑</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="stu" items="${stuAll}">
                    <tr>
                        <td>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="che" value="${stu.sid}">
                                <label class="form-check-label" >
                                        ${stu.sid}
                                </label>
                            </div>
                        </td>
                        <td>${stu.sname}</td>
                        <td>${stu.sex}</td>
                        <td>${stu.age}</td>
                        <td>${stu.email}</td>
                        <td><img src="/stuphoto/${stu.photo}" class="img-circle img-responsive"></td>
                        <td id="bj">
                            <a class="btn btn-primary" href="stu?type=getStu&sid=${stu.sid}">修改</a>&nbsp;
                            <a class="btn btn-primary" href="stu?type=del&sid=${stu.sid}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
            <a href="stu?type=query&page=1&select=${sessionScope.select}">首页</a>
            <a href="stu?type=query&page=${requestScope.pu.prePage}&select=${sessionScope.select}">上一页</a>
            <label>${requestScope.pu.page}/${requestScope.pu.countPage}</label>
            <a href="stu?type=query&page=${requestScope.pu.nextPage}&select=${sessionScope.select}">下一页</a>
            <a href="stu?type=query&page=${requestScope.pu.countPage}&select=${sessionScope.select}">最后</a>
        </div>
    </div>

</body>
</html>
