package com.wuchao.fastec.example.generators;

import com.wuchao.latte.annotations.EntryGenerator;
import com.wuchao.latte.wechat.templates.WXEntryTemplate;

/**
 * @author: gary
 * @date: 2020/12/27 23:05
 * @desciption:
 */
@EntryGenerator(packageName = "com.wuchao.fastec.example",
        entryTemplate = WXEntryTemplate.class)
public interface WeChatEntry {
}
