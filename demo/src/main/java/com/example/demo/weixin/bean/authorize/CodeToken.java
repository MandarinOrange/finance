package com.example.demo.weixin.bean.authorize;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CodeToken {
    private String openid;
    private String Access_token;
    private int Expires_in;
    private String refresh_token;
    private String scope;
}
