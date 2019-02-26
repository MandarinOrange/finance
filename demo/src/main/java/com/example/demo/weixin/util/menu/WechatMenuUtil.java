package com.example.demo.weixin.util.menu;

import com.example.demo.weixin.bean.menu.Menu;
import com.example.demo.weixin.util.WechatConstants;
import com.example.demo.weixin.util.https.HttpRequestUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @Description: 自定义菜单工具类，包括菜单的创建、查询、删除
 * @Parameters:
 * @Return:
 */

public class WechatMenuUtil {
    Logger logger = LoggerFactory.getLogger(WechatMenuUtil.class);
    //@Autowired
    private HttpRequestUtil httpRequestUtil = new HttpRequestUtil();

    /**
     * @Parameters: menu 菜单实例
     * 				accessToken 凭证
     * @Return: true false
     * @Return:
     */
    public boolean creatMenu(Menu menu, String accessToken){
        boolean result = false;
        String url = WechatConstants.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
        //将菜单对象转换成JSON字符串
        String jsonMenu = JSONObject.fromObject(menu).toString();
        //发起POST请求创建菜单
        JSONObject jsonObject = httpRequestUtil.httpsRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0== errorCode) {
                result = true;
            } else {
                result = false;
                logger.error("创建菜单失败 errcode：{} errmsg：{} ",errorCode,errorMsg);
            }
        }
        return result;
    }
    /**
     *
     * @Description: 查询菜单
     * @Parameters:
     * @Return:
     */
    public String getMenu(String accessToken){
        String result = null;
        String requestUrl = WechatConstants.MENU_GET_URL.replace("ACCESS_TOKEN", accessToken);
        //发起GET请求查询菜单
        JSONObject jsonObject = httpRequestUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            result = jsonObject.toString();
        }
        return result;
    }
    /**
     *
     * @Description: 删除菜单
     * @Parameters:
     * @Return:
     */
    public boolean deleteMenu(String accessToken){
        boolean result = false;
        String requestUrl = WechatConstants.MENU_DELETE_URL.replace("ACCESS_TOKEN", accessToken);
        //发起GET请求删除菜单
        JSONObject jsonObject = httpRequestUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0== errorCode) {
                result = true;
            } else {
                result = false;
                logger.error("创建菜单失败 errcode：{} errmsg：{} ",errorCode,errorMsg);
            }
        }
        return result;
    }
}
