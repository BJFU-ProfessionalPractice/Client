package com.wuchao.fastec.example.generators;

import com.wuchao.latte.annotations.AppRegisterGenerator;
import com.wuchao.latte.wechat.templates.AppRegisterTemplate;

/**
 * @author: gary
 * @date: 2020/12/27 23:05
 * @desciption:
 */
@AppRegisterGenerator(packageName = "com.wuchao.fastec.example",
        registerTemplate = AppRegisterTemplate.class)
public interface AppRegister {
}
