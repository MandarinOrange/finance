package com.example.demo.weixin.bean.menu;


import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 复合类型的按钮（也就是含有子菜单的一级菜单）
 * @Parameters:
 * @Return:
 */

@Getter
@Setter
public class ComplexButton extends Button {
    private Button[] sub_button;
}
