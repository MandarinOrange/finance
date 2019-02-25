package com.example.demo.weixin.bean.message;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Video {
    //媒体文件ID
    private String MediaId;
    //视频消息缩略图的媒体ID
    private String ThumbMediaId;
}
