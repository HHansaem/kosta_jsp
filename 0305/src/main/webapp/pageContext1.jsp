<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- pageContext2.jsp 에 응답 대신하라고 위임 -->
<!-- url은 그대로 (pageContext1.jsp) -->
<% pageContext.forward("pageContext2.jsp"); %>