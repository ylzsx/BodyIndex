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
import cn.fhypayaso.bodyIndex.business.login.contract.LoginContract;
import cn.fhypayaso.bodyIndex.business.login.presenter.LoginPresenter;
import cn.fhypayaso.bodyIndex.business.main.view.MainActivity;

@ContentView(R.layout.activity_login)
@RegisterPresenter(LoginPresenter.class)
public class LoginActivity extends BasePresenterActivity<LoginContract.Presenter> implements LoginContract.View {

    @BindView(R.id.edt_account)
    EditText mEdtAccount;
    @BindView(R.id.edt_password)
    EditText mEdtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_register)
    TextView mTvRegister;

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        setImmersiveStatusBar(true);
    }

    @OnClick({R.id.btn_login,R.id.tv_register})
    public void clickView(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(MainActivity.class);
                finish();
                break;
            case R.id.tv_register:
                startActivity(RegisterActivity.class);
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
