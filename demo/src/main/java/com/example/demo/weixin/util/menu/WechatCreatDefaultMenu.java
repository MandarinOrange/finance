package com.example.demo.weixin.util.menu;


import com.example.demo.weixin.bean.menu.Menu;

/**
 * @Description: 创建自定义菜单主方法
 * @Parameters:
 * @Return:
 */
public class WechatCreatDefaultMenu {
    public static void main(String[] args){
        WechatCommonUtil wechatCommonUtil = new WechatCommonUtil();
        WechatMenuUtil wechatMenuUtil = new WechatMenuUtil();
        WechatMenuManagerUtil wechatMenuManagerUtil = new WechatMenuManagerUtil();
        String appid = "wx473235c6be5c945a";
        String appsecret = "69a0c7bcccf20833fd549ae9a530d299";

        //获取access_token
        String accessToken = wechatCommonUtil.getAccessToken(appid, appsecret).getAccess_token();
        //获取菜单结构
        Menu menu = wechatMenuManagerUtil.getMenu();
        if (accessToken!=null) {
            //生成菜单
            boolean result = wechatMenuUtil.creatMenu(menu, accessToken);
            if (result) {
                System.out.println("菜单创建成功");
            }else {
                System.out.println("菜单创建失败");
            }
        }else {
            System.out.println("token为空");
        }
    }
}
