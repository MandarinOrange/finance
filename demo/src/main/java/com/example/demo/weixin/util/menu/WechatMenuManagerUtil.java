package com.example.demo.weixin.util.menu;

import com.example.demo.weixin.bean.menu.*;

import static com.example.demo.weixin.util.WechatConstants.CODE_URL;


/**
 * @Description: 菜单管理器类
 * @Parameters:
 * @Return:
 */
public class WechatMenuManagerUtil {
    /**
     * @Description: 定义菜单结构
     * @Parameters:
     * @Return:
     */
    public Menu getMenu(){
//        ClickButton firstClickButton = new ClickButton();
//        firstClickButton.setName("功能图文");
//        firstClickButton.setKey("function");
//        firstClickButton.setType("click");

        ViewButton firstViewButton = new ViewButton();
        firstViewButton.setName("业务介绍");
        firstViewButton.setType("view");
        firstViewButton.setUrl(CODE_URL);

        ViewButton secondViewButton = new ViewButton();
        secondViewButton.setName("我要贷款");
        secondViewButton.setType("view");
        secondViewButton.setUrl("http://loan.ngrok.xiaomiqiu.cn/personalCenter.html");

        ComplexButton complexButton = new ComplexButton();

        ViewButton viewButton1 = new ViewButton();
        viewButton1.setType("view");
        viewButton1.setName("中心");
        viewButton1.setUrl("http://loan.ngrok.xiaomiqiu.cn/personalCenter.html");

        ViewButton viewButton2 = new ViewButton();
        viewButton2.setType("view");
        viewButton2.setName("网页授权");
        viewButton2.setUrl("http://loan.ngrok.xiaomiqiu.cn/personalCenter.html");         //http://loan.ngrok.xiaomiqiu.cn/WeChat/login.php
        ViewButton[] viewButton = {viewButton1,viewButton2};
        complexButton.setSub_button(viewButton);
        complexButton.setName("我的服务");

        Menu menu = new Menu();
        Button[] boButtons = {firstViewButton,secondViewButton,complexButton};
        menu.setButton(boButtons);

        return menu;
    }
}

