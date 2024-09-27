<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.entity.UserBean" %>
<link href="header.css" rel="stylesheet /">
<div class="header-container">
	<% if(session.getAttribute("userBean") != null){ %>
		<table>
			<tr>
				<td>ユーザーID:</td>
				<td><%= ((UserBean)session.getAttribute("userBean")).getUserId() %></td>
			</tr>
			<tr>
				<td>氏名:</td>
				<td><%= ((UserBean)session.getAttribute("userBean")).getUserName() %></td>
			</tr>
		</table>
	<% } %>
</div>