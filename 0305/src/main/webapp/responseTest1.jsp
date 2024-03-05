<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- sendRedirect : "responseTest2.jsp" 이 페이지로 응답을 보내주고 해당 페이지를 다시 요청 -->
<!-- 즉, url에 responseTest1.jsp라고 쳐도 responseTest2.jsp 페이지를 요청하기 때문에 responseTest2.jsp 페이지가 띄워짐 -->
<% response.sendRedirect("responseTest2.jsp"); %>
