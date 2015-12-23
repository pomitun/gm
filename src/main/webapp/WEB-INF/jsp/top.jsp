<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
  <title><spring:message code="title" /></title>
</head>
<body>
<p>${demo}</p>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
