package cn.fhypayaso.bodyIndex.business.login.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.fhypayaso.bodyIndex.R;
import cn.fhypayaso.bodyIndex.base.annotation.ContentView;
import cn.fhypayaso.bodyIndex.base.annotation.RegisterPresenter;
import cn.fhypayaso.bodyIndex.base.mvp.view.BasePresenterActivity;
import cn.fhypayaso.bodyIndex.business.login.contract.RegisterContract;

@ContentView(R.layout.activity_register)
@RegisterPresenter(cn.fhypayaso.bodyIndex.business.login.presenter.RegisterPresenter.class)
public class RegisterActivity extends BasePresenterActivity<RegisterContract.Presenter> implements RegisterContract.View {

    @BindView(R.id.tv_back)
    TextView mTvBack;
    @BindView(R.id.edt_phone)
    EditText mEdtPhone;
    @BindView(R.id.edt_register_psw)
    EditText mEdtRegisterPsw;
    @BindView(R.id.edt_verification_code)
    EditText mEdtVerificationCode;

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        setImmersiveStatusBar(true);
    }

    @OnClick({R.id.tv_back})
    public void clickView(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
