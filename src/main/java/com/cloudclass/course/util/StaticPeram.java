package com.cloudclass.course.util;

/**
 * 手机验证码配置
 * @author ss
 * @date 2020-6-10
 */
public class StaticPeram {
    final static String defaultConnectTimeout  = "sun.net.client.defaultConnectTimeout";
    final static String defaultReadTimeout = "sun.net.client.defaultReadTimeout";
    final static String Timeout = "10000";
    // 初始化ascClient需要的几个参数
    final static String product = "Dysmsapi";// 短信API产品名称
    final static String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名
    // AK (产品密钥)
    final static String accessKeyId = "LTAI4GEp2WNXB8QmNEUj9EdH";// accessKeyId
    final static String accessKeySecret = "QhuENeeB9CjiWnapBwaiC9UMGFDtOL";// accessKeySecret
    // 必填:短信签名-可在短信控制台中找到
    final static String SignName = "云课集"; // 短信签名
    // 必填:短信模板-可在短信控制台中找到
    final static String TemplateCode = "SMS_192835183"; // 短信模板

}
