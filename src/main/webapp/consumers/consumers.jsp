<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../resources/css/style.css" rel="stylesheet" type="text/css">
    <title>Список покупателей</title>
</head>
<body>

<s:if test="storeList.size == 0">
    <h2>Покупателей нет</h2>
</s:if>
<s:else>
    <h2>Покупатели</h2>
    <p>
    <form action="addConsumerForm">
        <input type="submit" value="Добавить нового"/>
    </form>
    </p>
    <table border="1">
        <thead>
        <tr>
            <th>Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Phone</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="consumerList">
            <tr>
                <td><s:property value="idConsumer"/></td>
                <td><s:property value="firstName"/></td>
                <td><s:property value="lastName"/></td>
                <td><s:property value="phone"/></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:else>
</body>
</html>