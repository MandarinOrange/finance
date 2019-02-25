package com.example.demo.weixin.bean.response;


import com.example.demo.weixin.bean.message.Image;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageMessage extends BaseMessage {
    private Image image;
}
