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

<s:if test="consumerList.size == 0">
    <h2>Покупателей нет</h2>
    <p>
    <form action="consumers/addForm">
        <input type="submit" value="Добавить нового"/>
    </form>
    </p>
</s:if>
<s:else>
    <h2>Покупатели</h2>

    <p>
    <form action="consumers/addForm">
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
                <td><a href="<s:url action="editForm">
                        <s:param name="idConsumer" value="idConsumer"/>
                    </s:url>">Изменить</a>
                </td>
                <td><a href="<s:url action="delete">
                        <s:param name="idConsumer" value="idConsumer"/>
                    </s:url>">Удалить</a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <s:actionerror/>

    <s:form action="getByName" method="get">
        <s:textfield name="consumerName" label="Поиск по имени"/>
        <s:submit value="Найти"/>
    </s:form>

</s:else>
</body>
</html>