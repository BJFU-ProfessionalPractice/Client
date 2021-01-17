package com.wuchao.latte.ec.sign;

/**
 * @author: gary
 * @date: 2020/11/27 19:04
 * @desciption:
 */

public interface ISignListener {
    //登录成功
    void onSignInSuccess();

    //注册成功
    void onSignUpSuccess();
}
