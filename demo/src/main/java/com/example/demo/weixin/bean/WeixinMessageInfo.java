package com.example.demo.weixin.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter
public class WeixinMessageInfo implements Serializable {

    //序列化版本号
    //默认会根据对象结构自动生成。
    //如果对象结构发生变化，序列号就会变化，导致不能正常调用。
    //这样直接声明出来，就是一个定值了，即使构造方法发生了变化，仍然可以调用，只不过发生改动的属性会变成null
    private static final long serialVersionUID = 1L;

    private String fromUserName;            //发送方微信账号
    private String toUserName;              //接收方微信账号
    private String weixinUserName;          //微信用户名
    private String messageType;             //消息类型

    @Override
    public String toString(){
        return "WeixinMessageInfo [fromUserName=" + fromUserName
                + ", toUserName=" + toUserName +", weixinUserName="
                + weixinUserName + ", messageType=" + messageType + "]";

    }
}
