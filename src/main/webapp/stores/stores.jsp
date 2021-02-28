<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<s:url value="/resources/style.css"/> " rel="stylesheet" type="text/css">
    <title>Список магазинов</title>
</head>
<body>

<s:if test="storeList.size == 0">
    <h2>Магазинов нет</h2>
    <sec:authorize access="hasRole('ADMIN')">
        <form action="<s:url namespace="/stores" action="addForm"/>">
            <input type="submit" value="Добавить новый"/>
        </form>
    </sec:authorize>
</s:if>
<s:else>
    <h2>Магазины</h2>
    <p>
    <sec:authorize access="hasRole('ADMIN')">
        <form action="<s:url namespace="/stores" action="addForm"/>">
            <input type="submit" value="Добавить новый"/>
        </form>
    </sec:authorize>
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
                <td><a href="<s:url namespace="/stores" action="editForm">
                        <s:param name="idStore" value="idStore"/>
                    </s:url>">Изменить</a>
                </td>
                <td><a href="<s:url namespace="/stores" action="delete">
                        <s:param name="idStore" value="idStore"/>
                    </s:url>">Удалить</a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <s:actionerror/>

    <s:form namespace="/stores" action="getByAddress" method="get">
        <s:textfield name="storeAddress" label="Поиск по имени"/>
        <s:submit value="Найти"/>
    </s:form>
</s:else>
<p><a href="<s:url namespace="/" action="index"/>">Main page</a></p>
</body>
</html>