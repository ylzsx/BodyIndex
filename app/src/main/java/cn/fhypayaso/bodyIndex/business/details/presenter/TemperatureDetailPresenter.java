package cn.fhypayaso.bodyIndex.business.details.presenter;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

import cn.fhypayaso.bodyIndex.base.mvp.presenter.BasePresenter;
import cn.fhypayaso.bodyIndex.business.details.contract.TemperatureDetailContarct;
import cn.fhypayaso.bodyIndex.business.details.model.response.WarningResponseModel;

public class TemperatureDetailPresenter extends BasePresenter<TemperatureDetailContarct.View> implements TemperatureDetailContarct.Presenter {

    @Override
    public void initTemperatureWarningList() {
        List<WarningResponseModel> temperatureWarningList = new ArrayList<>();
        WarningResponseModel h = new WarningResponseModel("体温过高","15分钟前");
        temperatureWarningList.add(h);
        mView.initTemperatureWarningListSuccess(temperatureWarningList);
    }

    @Override
    public void initChartData() {
        final List<Entry> values = new ArrayList<>();
        values.add(new Entry(0, 36.5f,"一小时前"));
        values.add(new Entry(1, 36.9f,""));
        values.add(new Entry(2, 36.8f,""));
        values.add(new Entry(3, 37.1f,""));
        values.add(new Entry(4, 37,"半个小时前"));
        values.add(new Entry(5, 37.5f,""));
        values.add(new Entry(6, 37.9f,""));
        values.add(new Entry(7, 37.4f,""));
        values.add(new Entry(8, 37.9f,"刚刚"));
        mView.initChartDataSuccess(values);
    }
}
