<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${ua=='pc'}">
	<%@include file="/pc/index.html"%>
</c:if>
<c:if test="${ua=='mobile'}">
	<%@include file="/home/index.html"%>
</c:if>