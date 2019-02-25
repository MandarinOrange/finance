package com.example.demo.weixin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WeixinCoreService {
    public abstract String weixinMessageHandelCoreService(HttpServletRequest request,HttpServletResponse response);
}
