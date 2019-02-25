/**
 * 微信消息处理，将关注回复消息等写成方法
 */

package com.example.demo.weixin.util.message;

import com.example.demo.loginService.API.impl.UserService;
import com.example.demo.weixin.bean.WeixinMessageInfo;
import com.example.demo.weixin.bean.response.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WeixinMessageModelUtil {
    /**
     * @Description: 封装微信回复消息，各种回复消息对应不同的方法
     */
    @Autowired
    private WeixinMessageUtil weixinMessageUtil;
//    @Autowired
//    private WebConfigBean webConfigBean;
    @Autowired
    private UserService userService;
//    @Autowired
//    private EncodeUTF8 encodeUT8;

    /**
     * @Description: 当系统出错时，默认回复的文本消息
     * @Parameters: WeixinMessageModelUtil
     * @Return: 系统出错回复的消息
     */
    public String systemErrorResponseMessageModel(WeixinMessageInfo weixinMessageInfo ){

        // 回复文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(weixinMessageInfo.getFromUserName());
        textMessage.setFromUserName(weixinMessageInfo.getToUserName());
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(weixinMessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setFuncFlag(0);
        textMessage.setContent("系统出错啦，请稍后再试");
        return weixinMessageUtil.textMessageToXml(textMessage);
    }

//    /**
//     * @Description: 用户关注时发送的图文消息
//     * @Parameters: WeixinMessageModelUtil
//     * @Return: 用户关注后发送的提示绑定用户的图文消息
//     */
//    public String followResponseMessageModel(WeixinMessageInfo weixinMessageInfo){
//
//        // 关注时发送图文消息
//        NewsMessage newsMessage = new NewsMessage();
//        newsMessage.setToUserName(weixinMessageInfo.getFromUserName());
//        newsMessage.setFromUserName(weixinMessageInfo.getToUserName());
//        newsMessage.setCreateTime(new Date().getTime());
//        newsMessage.setMsgType(weixinMessageUtil.RESP_MESSAGE_TYPE_NEWS);
//        newsMessage.setFuncFlag(0);
//
//        // 图文消息
//        List<Article> articleList=new ArrayList<Article>();
//        Article article = new Article();
//        // 设置图文消息的标题
//        String string = "欢迎关注借贷平台";
//        article.setTitle(string);
//        article.setPicUrl(webConfigBean.getWeixinPicture()+"meetingLogo2.png");
//        article.setUrl(webConfigBean.getDoMainNameurl()+"/WeixinParticipantFouce");
//        articleList.add(article);
//        newsMessage.setArticleCount(articleList.size());
//        newsMessage.setArticles(articleList);
//        return weixinMessageUtil.newsMessageToXml(newsMessage);
//    }


    /**
     * @Description: 用户关注时发送的文本消息
     * @Parameters: WeixinMessageModelUtil
     * @Return: 用户关注后发送的提示绑定用户的文本消息
     */
    public String followResponseMessageModel(WeixinMessageInfo weixinMessageInfo){

        // 关注时发送文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(weixinMessageInfo.getToUserName());
        textMessage.setToUserName(weixinMessageInfo.getFromUserName());
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(weixinMessageUtil.REQ_MESSAGE_TYPE_TEXT);
        textMessage.setFuncFlag(0);

        // 设置文本内容
        String string = "欢迎关注借贷平台";
        textMessage.setContent(string);
        return weixinMessageUtil.textMessageToXml(textMessage);
    }


//    /**
//     * @Description: 用户取消关注，先判断用户是否绑定，如果已经绑定则解除绑定
//     * @Parameters: WeixinMessageModelUtil
//     * @Return: void
//     */
//    public void cancelAttention(String fromUserName){
//
//        if (userService.isAlreadyBinding(fromUserName)) {
//            userService.userUnbinding(fromUserName);
//        }else {
//            System.out.println("取消关注用户{}"+fromUserName+"还未绑定");
//        }
//    }
}

