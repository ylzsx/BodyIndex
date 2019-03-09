package cn.fhypayaso.bodyIndex.business.details.presenter;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

import cn.fhypayaso.bodyIndex.base.mvp.presenter.BasePresenter;
import cn.fhypayaso.bodyIndex.business.details.contract.HeartDetailContract;
import cn.fhypayaso.bodyIndex.business.details.model.response.WarningResponseModel;

public class HeartDetailPresenter extends BasePresenter<HeartDetailContract.View> implements HeartDetailContract.Presenter {

    @Override
    public void initHeartWarningList() {
        List<WarningResponseModel> heartWarningList = new ArrayList<>();
        WarningResponseModel h = new WarningResponseModel("心率过快","15分钟前");
        heartWarningList.add(h);
        mView.initHeartWarningListSuccess(heartWarningList);
    }

    @Override
    public void initChartData() {
        final List<Entry> values = new ArrayList<>();
        values.add(new Entry(0, 65,"一小时前"));
        values.add(new Entry(1, 75,""));
        values.add(new Entry(2, 74,""));
        values.add(new Entry(3, 70,""));
        values.add(new Entry(4, 65,"半个小时前"));
        values.add(new Entry(5, 70,""));
        values.add(new Entry(6, 96,""));
        values.add(new Entry(7, 89,""));
        values.add(new Entry(8, 88,"刚刚"));
        mView.initChartDataSuccess(values);
    }
}
