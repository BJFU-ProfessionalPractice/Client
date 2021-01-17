package com.wuchao.latte.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * @author: gary
 * @date: 2020/12/17 15:16
 * @desciption:
 */
@AutoValue
public abstract class RgbValue {

    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbValue create(int red, int green, int blue) {
        return new AutoValue_RgbValue(red, green, blue);
    }
}
