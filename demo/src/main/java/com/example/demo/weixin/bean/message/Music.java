package com.example.demo.weixin.bean.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Music {
    private String Title;
    //音乐描述
    private String Description;
    //音乐链接
    private String MusicUrl;
    //高品质音乐链接，Wi-Fi环境优先使用该链接播放音乐
    private String HQMusicUrl;
    //缩略图的媒体ID，通过上传多媒体文件得到的ID
    private String ThumbMediaId;

}
