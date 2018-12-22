package com.yushen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yushen.util.CheckMobile;

public class PageFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		check(request,response);
		String page = request.getServletPath();
		int i = page.indexOf(".html");
		if(i>0){
			page = page.replace(".html", "");
			request.getRequestDispatcher(page+".jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	/**
	  * 检查访问方式是否为移动端
	  * @Title: check
	  * @param request
	  * @throws IOException 
	  */
	 public boolean check(HttpServletRequest request,HttpServletResponse response) throws IOException{
			boolean isFromMobile=false;
			
			HttpSession session= request.getSession();
	    //检查是否已经记录访问方式（移动端或pc端）
			//if(null==session.getAttribute("ua")){
				try{
					//获取ua，用来判断是否为移动端访问
					String userAgent = request.getHeader( "USER-AGENT" ).toLowerCase();  
					if(null == userAgent){  
					    userAgent = "";  
					}
					isFromMobile=CheckMobile.check(userAgent);
					//判断是否为移动端访问
					if(isFromMobile){
						session.setAttribute("ua","mobile");
					} else {
						session.setAttribute("ua","pc");
					}
				}catch(Exception e){}
			//}else{
				//isFromMobile=session.getAttribute("ua").equals("mobile");
			//}
			return isFromMobile;
	}
}
