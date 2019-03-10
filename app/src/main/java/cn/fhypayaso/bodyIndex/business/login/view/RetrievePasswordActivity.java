package cn.fhypayaso.bodyIndex.business.login.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.fhypayaso.bodyIndex.R;
import cn.fhypayaso.bodyIndex.base.annotation.ContentView;
import cn.fhypayaso.bodyIndex.base.annotation.RegisterPresenter;
import cn.fhypayaso.bodyIndex.base.mvp.view.BasePresenterActivity;
import cn.fhypayaso.bodyIndex.business.login.contract.RetrievePasswordContract;
import cn.fhypayaso.bodyIndex.business.login.presenter.RetrievePasswordPresenter;

@ContentView(R.layout.activity_retrieve_password)
@RegisterPresenter(RetrievePasswordPresenter.class)
public class RetrievePasswordActivity extends BasePresenterActivity<RetrievePasswordContract.Presenter> implements RetrievePasswordContract.View {

    @BindView(R.id.tv_back)
    TextView mTvBack;
    @BindView(R.id.edt_phone)
    EditText mEdtPhone;
    @BindView(R.id.edt_new_psw)
    EditText mEdtNewPsw;
    @BindView(R.id.edt_confirm_psw)
    EditText mEdtConfirmPsw;
    @BindView(R.id.edt_verification_code)
    EditText mEdtVerificationCode;
    @BindView(R.id.btn_send_verification)
    Button mBtnSendVerification;
    @BindView(R.id.btn_retrieve_password)
    Button mBtnRetrievePassword;

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
