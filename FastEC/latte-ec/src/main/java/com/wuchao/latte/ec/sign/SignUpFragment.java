package com.wuchao.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.wuchao.ec.R;
import com.wuchao.ec.R2;
import com.wuchao.latte.Fragment.LatteFragment;
import com.wuchao.latte.app.Latte;
import com.wuchao.latte.net.rx.RxRestClient;
import com.wuchao.latte.util.log.LatteLogger;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: gary
 * @date: 2020/11/16 22:30
 * @desciption:
 */

public class SignUpFragment extends LatteFragment {

    @BindView(R2.id.edit_sign_up_username)
    TextInputEditText mUserName;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText mPassword;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone;
    @BindView(R2.id.edit_sign_up_question)
    TextInputEditText mQuestion;
    @BindView(R2.id.edit_sign_up_answer)
    TextInputEditText mAnswer;

    private ISignListener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }

    private boolean checkForm() {
        final String name = mUserName.getText().toString();
        final String question = mQuestion.getText().toString();
        final String answer = mAnswer.getText().toString();
        final String password = mPassword.getText().toString();
        final String phone = mPhone.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()) {
            mUserName.setError("请输入姓名");
            isPass = false;
        } else {
            mUserName.setError(null);
        }

//        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            mQuestion.setError("错误的邮箱格式");
//            isPass = false;
//        } else {
//            mQuestion.setError(null);
//        }

        if (phone.isEmpty()) {
            mAnswer.setError("手机号码错误");
            isPass = false;
        } else {
            mAnswer.setError(null);
        }

        if (password.isEmpty()) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

//        if (rePassword.isEmpty() || rePassword.length() < 6 || !(rePassword.equals(password))) {
//            mPhone.setError("密码验证错误");
//            isPass = false;
//        } else {
//            mPhone.setError(null);
//        }

        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @OnClick({R2.id.btn_sign_up})
    public void onClickSignUp() {
        //if (checkForm()) {
            RxRestClient.builder()
                    .url("user/regist")
//                    .params("username", mUserName.getText().toString())
//                    .params("password", mPassword.getText().toString())
//                    .params("answer", mQuestion.getText().toString())
//                    .params("question", mAnswer.getText().toString())
                    .build()
                    .post()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(String response) {
                            LatteLogger.json("USER_PROFILE", response);
                            SignHandler.onSignUp(response, mISignListener);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
            Toast.makeText(Latte.getApplicationContext(), "验证通过", Toast.LENGTH_LONG).show();
        //}
    }

    @OnClick({R2.id.tv_link_sign_in})
    public void onClickLink() {
        getSupportDelegate().start(new SignInFragment());
    }
}
