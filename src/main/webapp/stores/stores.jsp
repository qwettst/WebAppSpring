<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../resources/css/style.css" rel="stylesheet" type="text/css">
    <title>Список магазинов</title>
</head>
<body>

<s:if test="storeList.size == 0">
    <h2>Магазинов нет</h2>
    <form action="stores/addForm">
        <input type="submit" value="Добавить новый"/>
    </form>
</s:if>
<s:else>
    <h2>Магазины</h2>
    <p>
    <form action="stores/addForm">
        <input type="submit" value="Добавить новый"/>
    </form>
    </p>
    <table border="1">
        <thead>
        <tr>
            <th>Id</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="storeList">
            <tr>
                <td><s:property value="idStore"/></td>
                <td><s:property value="address"/></td>
                <td><a href="<s:url action="edit-%{idStore}" />">Изменить</a></td>
                <td><a href="<s:url action="delete-%{idStore}" />">Удалить</a></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <s:form action="getByAddress" method="get">
        <s:textfield name="storeAddress" label="Поиск по имени"/>
        <s:submit value="Найти"/>
    </s:form>
</s:else>
</body>
</html>