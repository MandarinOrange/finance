package com.example.demo.weixin.bean.response;

import com.example.demo.weixin.bean.message.Music;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicMessage extends BaseMessage {
    private Music music;
}
