package com.wuchao.latte.Fragment.web.event;

import com.wuchao.latte.util.log.LatteLogger;

/**
 * @author: gary
 * @date: 2020/11/29 22:44
 * @desciption:
 */

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        LatteLogger.e("UndefineEvent", params);
        return null;
    }
}
