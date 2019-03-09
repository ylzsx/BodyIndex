package cn.fhypayaso.bodyIndex.business.main.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.fhypayaso.bodyIndex.R;
import cn.fhypayaso.bodyIndex.base.annotation.ContentView;
import cn.fhypayaso.bodyIndex.base.annotation.RegisterPresenter;
import cn.fhypayaso.bodyIndex.base.mvp.view.BasePresenterActivity;
import cn.fhypayaso.bodyIndex.business.details.view.activity.HeartDetailActivity;
import cn.fhypayaso.bodyIndex.business.login.view.LoginActivity;
import cn.fhypayaso.bodyIndex.business.main.contract.MainContract;
import cn.fhypayaso.bodyIndex.business.main.presenter.MainPresenter;

@ContentView(R.layout.activity_main)
@RegisterPresenter(MainPresenter.class)
public class MainActivity extends BasePresenterActivity<MainContract.Presenter> implements MainContract.View {

    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_modify_password)
    TextView mTvModifyPassword;
    @BindView(R.id.tv_logout)
    TextView mTvLogout;
    @BindView(R.id.tv_heart_rate)
    TextView mTvHeartRate;
    @BindView(R.id.img_heart_detail)
    ImageView mImgHeartDetail;
    @BindView(R.id.tv_temperature)
    TextView mTvTemperature;
    @BindView(R.id.img_temperature_detail)
    ImageView mImgTemperatureDetail;

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.tv_logout,R.id.img_heart_detail})
    public void clickView(View view) {
        switch (view.getId()) {
            case R.id.tv_logout:
                startActivity(LoginActivity.class);
                finish();
                break;
            case R.id.img_heart_detail:
                startActivity(HeartDetailActivity.class);
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
