<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<!-- 이렇게 써도 됨 -->
<%-- <% pageContext.forward(request.getParameter("forwardPage")); %> --%>
<!-- action 태그 -->
<jsp:forward page='<%=request.getParameter("forwardPage") %>'></jsp:forward>
