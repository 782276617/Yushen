package com.yushen.util;



import java.io.IOException;

import org.json.JSONException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

/**
 * �������Ź�����
 * @author Administrator
 *
 */
public class SMSUtils {
	// ����Ӧ��SDK AppID
	private static int appid = 1400161504; // 1400��ͷ

	// ����Ӧ��SDK AppKey
	private static String appkey = "012dc75028056cdc143507a213484968";

	// ��Ҫ���Ͷ��ŵ��ֻ�����
	private static String[] phoneNumbers = {"17198644317"};

	// ����ģ��ID����Ҫ�ڶ���Ӧ��������
	private static int templateId = 7839; // NOTE: �����ģ��ID`7839`ֻ��һ��ʾ������ʵ��ģ��ID��Ҫ�ڶ��ſ���̨������

	// ǩ��
	private static String smsSign = "��Ѷ��"; // NOTE: �����ǩ��"��Ѷ��"ֻ��һ��ʾ������ʵ��ǩ����Ҫ�ڶ��ſ���̨�����룬����ǩ������ʹ�õ���`ǩ������`��������`ǩ��ID`

	
	/*
	  ��������
	 */
	public static SmsSingleSenderResult basicsSms(String phoneNumber){
		SmsSingleSenderResult result = null;
			try {
			    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
			    result = ssender.send(0, "86", phoneNumber,
			        "����Ѷ�ơ�������֤����: 5678", "", "");
			 
			} catch (HTTPException e) {
			    // HTTP��Ӧ�����
			    e.printStackTrace();
			} catch (JSONException e) {
			    // json��������
			    e.printStackTrace();
			} catch (IOException e) {
			    // ����IO����
			    e.printStackTrace();
			}
			  return result;
	}
	
	
/*	*//**
	 * ָ��ģ��ID��������
	 * @return
	 *//*
*/	public static SmsSingleSenderResult templateSms(){
		SmsSingleSenderResult result = null;
		try {
		    String[] params = {"5678"};
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		     result = ssender.sendWithParam("86", phoneNumbers[0],
		        templateId, params, smsSign, "", "");  // ǩ������δ�ṩ����Ϊ��ʱ����ʹ��Ĭ��ǩ�����Ͷ���
		} catch (HTTPException e) {
		    // HTTP��Ӧ�����
		    e.printStackTrace();
		} catch (JSONException e) {
		    // json��������
		    e.printStackTrace();
		} catch (IOException e) {
		    // ����IO����
		    e.printStackTrace();
		}
		  return result;
	}
}
