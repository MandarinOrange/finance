package com.example.demo.weixin.bean.response;

import com.example.demo.weixin.bean.message.Article;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewsMessage extends BaseMessage {
    //图文消息个数,限制为10条以内
    private int ArticleCount;
    //多条图文消息信息，默认第一个item为大图
    private List<Article> Articles;
}
