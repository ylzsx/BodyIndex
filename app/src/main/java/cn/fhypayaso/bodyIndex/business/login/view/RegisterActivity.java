package cn.fhypayaso.bodyIndex.business.login.view;

import android.os.Bundle;

import cn.fhypayaso.bodyIndex.R;
import cn.fhypayaso.bodyIndex.base.annotation.ContentView;
import cn.fhypayaso.bodyIndex.base.annotation.RegisterPresenter;
import cn.fhypayaso.bodyIndex.base.mvp.view.BasePresenterActivity;
import cn.fhypayaso.bodyIndex.business.login.contract.RegisterContract;

@ContentView(R.layout.activity_register)
@RegisterPresenter(cn.fhypayaso.bodyIndex.business.login.presenter.RegisterPresenter.class)
public class RegisterActivity extends BasePresenterActivity<RegisterContract.Presenter> implements RegisterContract.View {

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        setImmersiveStatusBar(true);
    }
}
