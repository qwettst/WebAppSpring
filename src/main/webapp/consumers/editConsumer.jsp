<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Изменить покупателя</title>
</head>
<body>
<s:form action="edit" method="post">
    <s:hidden name="idConsumer" value="%{idConsumer}"/>
    <s:textfield name="consumer.firstName" label="Фамилия"/>
    <s:textfield name="consumer.lastName" label="Имя"/>
    <s:textfield name="consumer.phone" label="Телефон"/>
    <s:submit value="Изменить"/>
</s:form>
</body>
</html>