package cn.fhypayaso.bodyIndex.business.login.view;

import android.os.Bundle;

import cn.fhypayaso.bodyIndex.R;
import cn.fhypayaso.bodyIndex.base.annotation.ContentView;
import cn.fhypayaso.bodyIndex.base.annotation.RegisterPresenter;
import cn.fhypayaso.bodyIndex.base.mvp.view.BasePresenterActivity;
import cn.fhypayaso.bodyIndex.business.login.contract.LoginContract;
import cn.fhypayaso.bodyIndex.business.login.presenter.LoginPresenter;

@ContentView(R.layout.activity_login)
@RegisterPresenter(LoginPresenter.class)
public class LoginActivity extends BasePresenterActivity<LoginContract.Presenter> implements LoginContract.View{

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        setImmersiveStatusBar(true);
        setLayoutNoLimits(true);
    }

}
