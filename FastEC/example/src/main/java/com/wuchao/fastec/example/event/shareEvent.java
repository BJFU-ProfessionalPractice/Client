package com.wuchao.fastec.example.event;

import com.blankj.utilcode.util.ToastUtils;
import com.wuchao.latte.Fragment.web.event.Event;

/**
 * @author: gary
 * @date: 1/1 16:48
 * @desciption:
 */

public class shareEvent extends Event {
    @Override
    public String execute(String params) {
        ToastUtils.showLong("分享");
        return null;
    }
}
