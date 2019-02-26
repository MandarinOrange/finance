package com.example.demo.weixin.util.connection;

import com.example.demo.weixin.bean.UserInfo;
import com.example.demo.weixin.bean.authorize.CodeToken;
import com.example.demo.weixin.bean.menu.AccessToken;
import com.example.demo.weixin.util.WechatConstants;
import com.example.demo.weixin.util.https.HttpRequestUtil;
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


    /**
     * @Description: 用户同意授权，用code得到授权access_token
     * @Parameters:
     * @Return:
     */
    public CodeToken getCodeToken(String appid,String secret,String code){
        token_url = WechatConstants.ACCESS_TOKEN_URL_BY_CODE;
        //将appid，secret,code替换进url
        String url = token_url.replace("APPID",appid).replace("SECRET",secret).replace("CODE",code);
        CodeToken codeToken = new CodeToken();

        //发起get请求获取凭证
        JSONObject jsonObject = httpRequestUtil.httpsRequest(url,"GET",null);
        logger.info("获取到的json格式的Token为:"+jsonObject);
        if(jsonObject!=null){
            try{
                codeToken.setAccess_token(jsonObject.getString("access_token"));
                codeToken.setExpires_in(jsonObject.getInt("expires_in"));
                codeToken.setOpenid(jsonObject.getString("openid"));
                codeToken.setRefresh_token(jsonObject.getString("refresh_token"));
                codeToken.setScope(jsonObject.getString("scope"));
            }catch(Exception e){
                codeToken = null;
                //获取token失败
                logger.error("获取token失败 errcode:{} errmsg:{}",
                        jsonObject.getInt("errcode"),
                        jsonObject.getString("errmsg"));
            }
        }
        return codeToken;
    }

    /**
     * 刷新access_token
     */
    public CodeToken refreshToken(String appid,String refresh_token){
        token_url = WechatConstants.REFRESH_TOKEN;
        String url = token_url.replace("APPID",appid).replace("refresh_token",refresh_token);
        CodeToken codeToken = new CodeToken();

        JSONObject jsonObject = httpRequestUtil.httpsRequest(url,"GET",null);
        if(jsonObject!=null){
            try{
                codeToken.setScope(jsonObject.getString("scope"));
                codeToken.setRefresh_token(jsonObject.getString("refresh_token"));
                codeToken.setAccess_token(jsonObject.getString("access_token"));
                codeToken.setExpires_in(jsonObject.getInt("expires_in"));
                codeToken.setOpenid(jsonObject.getString("openid"));
            }catch (Exception e){
                codeToken = null;
                //获取token失败
                logger.error("获取token失败 errcode:{} errmsg:{}",
                        jsonObject.getInt("errcode"),
                        jsonObject.getString("errmsg"));
            }

        }
        return codeToken;

    }

    /**
     * 获取用户信息
     */
    public UserInfo getUserInfo(String access_token,String openid){
        token_url = WechatConstants.SNSAPI_USERINFO_URL;
        String url = token_url.replace("ACCESS_TOKEN",access_token).replace("OPENID",openid);
        UserInfo userInfo = new UserInfo();

        JSONObject jsonObject = httpRequestUtil.httpsRequest(url,"GET",null);
        if(jsonObject!=null){
            try{
                userInfo.setCity(jsonObject.getString("city"));
                userInfo.setCountry(jsonObject.getString("country"));
                userInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
                userInfo.setNickname(jsonObject.getString("nickname"));
                userInfo.setOpenid(jsonObject.getString("openid"));
                userInfo.setPrivilege(jsonObject.getString("privilege"));
                userInfo.setProvince(jsonObject.getString("province"));
                userInfo.setSex(jsonObject.getString("sex"));
                userInfo.setUnionid(jsonObject.getString("unionid"));
            }catch (Exception e){
                userInfo = null;
                //获取信息失败
                logger.info("获取信息失败：errcode：{}  errmsg:{}",
                        jsonObject.getInt("errcode"),
                        jsonObject.getString("errmsg"));
            }
        }
        return userInfo;

    }

    /**
     * 验证access_token是否有效
     */
    public boolean isTokenValid(String access_token,String openid)throws Exception{
        token_url = WechatConstants.IS_TOKEN_VAILD;
        String url = token_url.replace("ACCESS_TOKEN",access_token).replace("OPENID",openid);

        JSONObject jsonObject = httpRequestUtil.httpsRequest(url,"GET",null);
        boolean flag = false;
        if(jsonObject!=null){
            if(jsonObject.getInt("errcode")==0)flag=true;
        }
        logger.info("errcode:{}   errmsg:{}",
                jsonObject.getInt("errcode"),
                jsonObject.getString("errmsg"));
        return flag;
    }
}
