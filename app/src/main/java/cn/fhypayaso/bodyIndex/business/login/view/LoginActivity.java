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
import cn.fhypayaso.bodyIndex.business.login.modal.request.LoginRequestModal;
import cn.fhypayaso.bodyIndex.business.login.presenter.LoginPresenter;
import cn.fhypayaso.bodyIndex.business.main.view.MainActivity;
import cn.fhypayaso.bodyIndex.common.CacheKey;
import cn.fhypayaso.bodyIndex.utils.CacheUtil;
import cn.fhypayaso.bodyIndex.utils.ToastUtil;

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
    @BindView(R.id.tv_retrieve_password)
    TextView mTvRetrievePassword;

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        setImmersiveStatusBar(true);

        /**
         * 验证token是否为空，开启服务器取消注释
         */
        String token= CacheUtil.getSP().getString(CacheKey.TOKEN,"");
        if (!"".equals(token)){
            startActivity(MainActivity.class);
            finish();
        }
    }

    @OnClick({R.id.btn_login, R.id.tv_register,R.id.tv_retrieve_password})
    public void clickView(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String account = mEdtAccount.getText().toString();
                String passward = mEdtPassword.getText().toString();
                showProgressDialog();
                mPresenter.login(new LoginRequestModal(account,passward));
                break;
            case R.id.tv_register:
                startActivity(RegisterActivity.class);
                break;
            case R.id.tv_retrieve_password:
                startActivity(RetrievePasswordActivity.class);
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

    /**
     * 登录成功与失败回调
     * @param s
     */
    @Override
    public void loginSuccess(String s) {
        dismissProgressDialog();
        ToastUtil.showToast("登录成功");
        startActivity(MainActivity.class);
        finish();
    }

    @Override
    public void loginFailed() {
        dismissProgressDialog();
        ToastUtil.showToast("登录失败");
    }
}
