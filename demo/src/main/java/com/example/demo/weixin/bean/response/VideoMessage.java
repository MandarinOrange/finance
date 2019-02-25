package com.example.demo.weixin.bean.response;

import com.example.demo.weixin.bean.message.Video;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoMessage extends BaseMessage {
    private Video video;

}
