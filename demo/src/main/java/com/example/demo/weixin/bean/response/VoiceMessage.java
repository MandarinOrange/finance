package com.example.demo.weixin.bean.response;

import com.example.demo.weixin.bean.message.Voice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoiceMessage extends  BaseMessage{
    private Voice voice;
}
