package com.wuchao.latte.ec.pay;

/**
 * @author: gary
 * @date: 2020/12/25 22:29
 * @desciption:
 */

public interface IAlPayResultListener {

    void onPaySuccess();

    void onPaying();

    void onPayingFail();

    void onPayingCancel();

    void onPayingConnectError();
}
