package com.example.demo.weixin.util;

public class WechatConstants {
    public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public static String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    public static String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    public static String appid = "wx473235c6be5c945a";
    public static String appsecret = "69a0c7bcccf20833fd549ae9a530d299";
    public static String redirect_url = "http://loan.ngrok.xiaomiqiu.cn/wechat/auth";
    public static String ACCESS_TOKEN_URL_BY_CODE = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    public static String CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid
            +"&redirect_uri="+redirect_url+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";     //scope=snsapi_base获取用户openid
    public static String REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
    public static String SNSAPI_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    public static String IS_TOKEN_VAILD = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
}
