package com.wuchao.latte.Fragment;

/**
 * @author: gary
 * @date: 2020/10/22 23:01
 * @desciption: 正式使用的
 */

public abstract class LatteFragment extends PermissionCheckerFragment {

    @SuppressWarnings("unchecked")
    public <T extends LatteFragment> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
