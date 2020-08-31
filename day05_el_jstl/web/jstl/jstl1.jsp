<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: SunHao
  Date: 2020/8/31
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    list.add("小鲁班");
    list.add("妲己");
    list.add("后羿");
    request.setAttribute("list", list);
//    for (String str:
//         list) {
//
//    }

%>

<c:forEach items="${list}" var="str" varStatus="s">
    ${s.index} ---- ${s.count} ${str}<br>
</c:forEach>





</body>
</html>
