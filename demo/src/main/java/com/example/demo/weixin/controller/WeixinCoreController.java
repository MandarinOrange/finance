package com.example.demo.weixin.controller;

import com.example.demo.weixin.bean.UserInfo;
import com.example.demo.weixin.bean.authorize.CodeToken;
import com.example.demo.weixin.service.DataProcess;
import com.example.demo.weixin.service.WeixinCoreService;
import com.example.demo.weixin.util.connection.WechatCommonUtil;
import com.example.demo.weixin.util.connection.WeixinSignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.demo.weixin.util.WechatConstants.appid;
import static com.example.demo.weixin.util.WechatConstants.appsecret;

@RestController
@RequestMapping(value = "/wechat")
public class WeixinCoreController {

    //控制台输出日志信息所在的类
    private static Logger logger = LoggerFactory.getLogger(WeixinCoreController.class);

    @Autowired
    private WeixinSignUtil weixinSignUtil;
    @Autowired
    private WechatCommonUtil wechatCommonUtil;
    @Autowired
    private DataProcess dataProcess;
    @Autowired
    private WeixinCoreService weixinCoreService;

    @RequestMapping(value = "/access",method = RequestMethod.GET)
    public String WeChatInterface(HttpServletRequest request)/*throws Exception*/{
        System.out.println("-----验证微信服务号开始-----");
        //微信加密签名
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");

        logger.info("signature is :"+signature+"    timestamp is :"+timestamp+"     nonce is :"+nonce);
        if(weixinSignUtil.checkSignature(signature,timestamp,nonce)){
            System.out.println("------验证微信服务号结束-------");
            return echostr;
        }else{

            //此处可以实现其他逻辑
            logger.warn("不是微信服务器的请求，小心！！");
            return null;
        }
    }


    @RequestMapping(value="/access", method=RequestMethod.POST)
    public String getWeiXinMessage(HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("----------------开始处理微信发过来的消息------------------");
        // 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        request.setCharacterEncoding("UTF-8");
        // 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        response.setCharacterEncoding("UTF-8");
        String respXml = weixinCoreService.weixinMessageHandelCoreService(request, response);
        if (dataProcess.dataIsNull(respXml)){
            logger.error("-------------处理微信消息失败-----------------------");
            return null;
        }else {
            logger.info("----------返回微信消息处理结果-----------------------:"+respXml);
            return respXml;
        }
    }

    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    public UserInfo auth(HttpServletRequest request,HttpServletResponse response)throws Exception{
        logger.info("--------进入auth的方法--------");

        String code = request.getParameter("code");
        logger.info("code={}",code);

        CodeToken codeToken = wechatCommonUtil.getCodeToken(appid,appsecret,code);
        UserInfo userInfo = new UserInfo();
        if(codeToken!=null){
            try{
                String openid = codeToken.getOpenid();
                String refresh_token = codeToken.getRefresh_token();
                String access_token = codeToken.getAccess_token();
                //判断access_token是否过期
                if(!wechatCommonUtil.isTokenValid(access_token,appid)){
                    wechatCommonUtil.refreshToken(appid,refresh_token);
                }
                logger.info("开始获取用户信息");
                userInfo = wechatCommonUtil.getUserInfo(access_token,openid);
            }catch (Exception e){
                userInfo = null;
            }
        }else{
            logger.info("用户授权失败");
        }
        return userInfo;
    }

}
