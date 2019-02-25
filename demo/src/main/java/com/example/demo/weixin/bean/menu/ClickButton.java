package com.example.demo.weixin.bean.menu;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: click类型的按钮（有type、name和key3个属性）
 * @Parameters:
 * @Return:
 */

@Setter
@Getter
public class ClickButton extends Button{
    private String type;
    private String key;
}
