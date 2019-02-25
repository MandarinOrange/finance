package com.example.demo.weixin.bean.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TextMessage extends BaseMessage  {
    //回复的消息内容
    private String Content;
}
