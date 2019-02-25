package com.example.demo.weixin.util.menu;

import com.example.demo.weixin.bean.menu.AccessToken;
import com.example.demo.weixin.service.https.HttpRequestUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 编写获取access_token的工具类
 */


@Component
public class WechatCommonUtil {
    Logger logger = LoggerFactory.getLogger(WechatCommonUtil.class);

    //获取access_token接口
    private static String token_url = WechatConstants.ACCESS_TOKEN_URL;
    //@Autowired
    HttpRequestUtil httpRequestUtil = new HttpRequestUtil();

    /**
     * @Description: 获取微信调用高级接口的凭证（access_token）
     * @Parameters:
     * @Return:
     */
    public AccessToken getAccessToken(String appid,String appsecret){
        //将公众号的appid和appsecret替换进url
        //String.replace()替换原字符串中的子串
        String url = token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        AccessToken accessToken = new AccessToken();
        //发起get请求获取凭证
        JSONObject jsonObject = httpRequestUtil.httpsRequest(url,"GET",null);
        logger.info("获取到的json格式的Token为:"+jsonObject);
        if (jsonObject!=null) {
            try {
                accessToken.setAccess_token(jsonObject.getString("access_token"));
                accessToken.setExpires_in(jsonObject.getInt("expires_in"));
            } catch (Exception e) {
                accessToken = null;
                //获取token失败
                logger.error("获取token失败 errcode:{} errmsg:{}",
                        jsonObject.getInt("errcode"),
                        jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }
}
