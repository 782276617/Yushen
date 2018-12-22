<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${ua=='pc'}">
	<%@include file="/pc/contact.html"%>
</c:if>
<c:if test="${ua=='mobile'}">
	<%@include file="/home/contact.html"%>
</c:if>
<script type="text/javascript">

	$("#sub").click(function(){
var name = $(".contact-form input[name='name']").val();
var tel = $(".contact-form input[name='tel']").val();
var txt = $(".contact-form #txt").val();
	if(name==""||name.length<=0){
		alert("请输入您的姓名");
		return;
	}
	if(tel==""||tel.length<=0){
		alert("请输入您的联系号码");
		return;
	}else {
	   var reg = /^1[34578]\d{9}$/;     
	     var r = tel.match(reg);   
	     if(r==null){    
	          alert("手机号码格式错误，请重填");
	          return;
	     }
	}
	
	if(txt==""||txt.length<=0){
		alert("请输入您的留言信息");
		return;
	  
	}
	
	
		$.ajax({
			type:"post",
			url:"sub/message",
			data:"",
			success:function(result){
				if(result.status==200){
					alert("谢谢您的留言！");
					location.reload();
				}
			}
		});
		
	});
	
</script>

