package com.yushen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class MessageServlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // 设置响应内容类型
		 // 设置响应内容类型
         response.setContentType("text/json; charset=utf-8");
         PrintWriter out = response.getWriter();
         
         JSONObject jsonobj = new JSONObject(); 
			//SMSUtils.basicsSms("17198644317");
         jsonobj.put("status", 200);
         // 输出数据
          out = response.getWriter();
          out.println(jsonobj);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
