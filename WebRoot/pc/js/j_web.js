



/*====================================页面配置====================================*/



$(function(){



	var sWidth=document.documentElement.scrollWidth;



	var sHieght=document.documentElement.scrollHeight;



	var in_height=document.body.offsetHeight;



	$("#banner").width(sWidth) ;



	$("#banner").slide({titCell:".hd ul",mainCell:".bd ul",effect:"fold",autoPlay:true,delayTime:800,interTime:6000,mouseOverStop:false,autoPage: true,autoPage: '<li><a href="javascript:void(0)"> </a></li>'});



	 



	$("#nav").slide({titCell:".title",targetCell:".list",type:"menu",effect:"slideDown",delayTime:200,triggerTime:110,returnDefault:false,titOnClassName:"li_on"});



	



	$("#nav li:last-child .a").css("background-image","none");



	



	$("#s_partner").slide({mainCell:".bd .box",autoPlay:false,vis:5,autoPlay:true,effect:"leftMarquee",interTime:50,pnLoop:false,trigger:"click"});



	$(".s_main_box .f1 .hd li:first").addClass("first");



 	 

	$(".slide_p_show").slide({mainCell:".bd",effect:"leftLoop",autoPlay:false,delayTime:800});



	 //内页左侧推荐

	$("#left_news1 li").hover(function(){$("#left_news1 li").removeClass("on");$(this).addClass("on");},function(){}); 

	$("#left_news2 li").hover(function(){$("#left_news2 li").removeClass("on");$(this).addClass("on");},function(){}); 



	$("#s_news").slide({titCell:".hd a",mainCell:".bd", effect:"fold",titOnClassName:"li_on"});



	$("#gotop_box").click(function(){$("html,body").animate({scrollTop: 0}, 600);});



	

	$("#n_news .un_box li:odd").addClass("odd");

	$("#n_dsj dl:even").addClass("left_section");



	$("#n_dsj dl:odd").addClass("right_section");



	



	



	var dsj_li = $("#n_dsj dd ");



	$("#n_dsj dl .dd:odd").addClass("left_box");



	$("#n_dsj dd .dd:even").addClass("right_box");



	 



	



	$(".ar_article p img").parent("p").css("line-height","0");



	



	$("#dsj_li1,#dsj_li2").css("display","block");



	



	$("#bnt_dsj_more").click(function(){



		$("#n_dsj  dl").css("display","block");



		$("#bnt_dsj_more").text("已全部展示");



		}) ;



	



	//人力资源

	$("#n_hr").slide({mainCell:".bd",effect:"leftLoop",delayTime:800,interTime:6000});

	//弹窗

	 $(".bnt_close_ar").click(function(){



		$("#page_show_box .bg_box").fadeOut(0);



		 $("#page_show_box").fadeOut(300);



		});  



});







window.onscroll=function(){



 if($(window).scrollTop()>200){



	 



	 $("#j_sub_contact").slideDown();



	 }



	  else if($(window).scrollTop()<200){



	 $("#j_sub_contact").slideUp();



	 }



 };	 



 



 