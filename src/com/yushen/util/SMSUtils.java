package com.yushen.util;



import java.io.IOException;

import org.json.JSONException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

/**
 * 单发短信工具类
 * @author Administrator
 *
 */
public class SMSUtils {
	// 短信应用SDK AppID
	private static int appid = 1400161504; // 1400开头

	// 短信应用SDK AppKey
	private static String appkey = "012dc75028056cdc143507a213484968";

	// 需要发送短信的手机号码
	private static String[] phoneNumbers = {"17198644317"};

	// 短信模板ID，需要在短信应用中申请
	private static int templateId = 7839; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请

	// 签名
	private static String smsSign = "腾讯云"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

	
	/*
	  单发短信
	 */
	public static SmsSingleSenderResult basicsSms(String phoneNumber){
		SmsSingleSenderResult result = null;
			try {
			    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
			    result = ssender.send(0, "86", phoneNumber,
			        "【腾讯云】您的验证码是: 5678", "", "");
			 
			} catch (HTTPException e) {
			    // HTTP响应码错误
			    e.printStackTrace();
			} catch (JSONException e) {
			    // json解析错误
			    e.printStackTrace();
			} catch (IOException e) {
			    // 网络IO错误
			    e.printStackTrace();
			}
			  return result;
	}
	
	
/*	*//**
	 * 指定模板ID单发短信
	 * @return
	 *//*
*/	public static SmsSingleSenderResult templateSms(){
		SmsSingleSenderResult result = null;
		try {
		    String[] params = {"5678"};
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		     result = ssender.sendWithParam("86", phoneNumbers[0],
		        templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
		} catch (HTTPException e) {
		    // HTTP响应码错误
		    e.printStackTrace();
		} catch (JSONException e) {
		    // json解析错误
		    e.printStackTrace();
		} catch (IOException e) {
		    // 网络IO错误
		    e.printStackTrace();
		}
		  return result;
	}
}
