package cn.fhypayaso.bodyIndex.business.details.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.fhypayaso.bodyIndex.R;
import cn.fhypayaso.bodyIndex.base.annotation.ContentView;
import cn.fhypayaso.bodyIndex.base.annotation.RegisterPresenter;
import cn.fhypayaso.bodyIndex.base.mvp.view.BasePresenterActivity;
import cn.fhypayaso.bodyIndex.business.details.contract.HeartDetailContract;
import cn.fhypayaso.bodyIndex.business.details.model.response.HeartWarningResponseModel;
import cn.fhypayaso.bodyIndex.business.details.presenter.HeartDetailPresenter;
import cn.fhypayaso.bodyIndex.business.details.view.adapter.HeartWarningAdapter;

@ContentView(R.layout.activity_heart_detail)
@RegisterPresenter(HeartDetailPresenter.class)
public class HeartDetailActivity extends BasePresenterActivity<HeartDetailContract.Presenter> implements HeartDetailContract.View {

    @BindView(R.id.img_back)
    ImageView mImgBack;
    @BindView(R.id.img_left)
    ImageView mImgLeft;
    @BindView(R.id.img_right)
    ImageView mImgRight;
    @BindView(R.id.linechart)
    LineChart mLinechart;
    @BindView(R.id.rcView_heart)
    RecyclerView mRcViewHeart;

    private List<HeartWarningResponseModel> mHeartWarningList = new ArrayList<>();
    private HeartWarningAdapter adapter;

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {

        // 初始化RecyclerView
        mPresenter.initHeartWarningList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRcViewHeart.setLayoutManager(linearLayoutManager);

        adapter = new HeartWarningAdapter(mHeartWarningList);
        mRcViewHeart.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 初始化心率警告列表成功与失败回调
     */
    @Override
    public void initHeartWarningListSuccess(List<HeartWarningResponseModel> heartWarningList) {
        mHeartWarningList = heartWarningList;
    }

    @Override
    public void initHeartWarningListFailed() {

    }
}
