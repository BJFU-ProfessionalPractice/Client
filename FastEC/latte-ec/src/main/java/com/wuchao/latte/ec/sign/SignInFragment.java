package com.wuchao.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.wuchao.ec.R;
import com.wuchao.ec.R2;
import com.wuchao.latte.Fragment.LatteFragment;
import com.wuchao.latte.net.rx.RxRestClient;
import com.wuchao.latte.util.log.LatteLogger;
import com.wuchao.latte.wechat.LatteWeChat;
import com.wuchao.latte.wechat.callbacks.IWeChatSignInCallback;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: gary
 * @date: 2020/11/20 22:30
 * @desciption:
 */

public class SignInFragment extends LatteFragment {

    @BindView(R2.id.edit_sign_in_username)
    TextInputEditText mUsername;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @OnClick({R2.id.btn_sign_in})
    public void onClickSignIn() {
//        SignHandler.onSignIn("", mISignListener);
//        /*if (checkForm()) {
            RxRestClient.builder()
                    .url("/user/login")
                    .params("username", mUsername.getText().toString())
                    .params("password", mPassword.getText().toString())
                    .build()
                    .post()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Logger.d("test");
                        }

                        @Override
                        public void onNext(String response) {
                            LatteLogger.json("USER_PROFILE", response);
                            SignHandler.onSignIn(response, mISignListener);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Logger.d("test");
                        }

                        @Override
                        public void onComplete() {
                            Logger.d("test");
                        }
                    });
//        }*/
    }

    @OnClick({R2.id.tv_link_sign_up})
    public void onClickLink() {
        start(new SignUpFragment());
    }

    @OnClick({R2.id.icon_sign_in_wechat})
    public void onClickWeiChat() {
        LatteWeChat.getInstance().onSignSuccess(new IWeChatSignInCallback() {
            @Override
            public void onSignInSuccess(String userInfo) {

            }
        }).signIn();
    }

    private boolean checkForm() {
        final String email = mUsername.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;
//        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            mUsername.setError("错误的邮箱格式");
//            isPass = false;
//        } else {
//            mUsername.setError(null);
//        }

        if (password.isEmpty()) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        return isPass;
    }

}
