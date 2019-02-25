package com.example.demo.weixin.bean.menu;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: view类型的按钮(有type、name、url三个属性)
 * @Parameters:
 * @Return:
*/

@Getter
@Setter
public class ViewButton extends Button {
    public String type;
    public String url;
}
