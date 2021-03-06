package cn.fhypayaso.bodyIndex.business.details.contract;

import com.github.mikephil.charting.data.Entry;

import java.util.List;

import cn.fhypayaso.bodyIndex.base.mvp.impl.IBaseContract;
import cn.fhypayaso.bodyIndex.business.details.model.response.WarningResponseModel;

public interface HeartDetailContract {

    interface Presenter extends IBaseContract.IBasePresenter {
        void initHeartWarningList();
        void initChartData();
    }

    interface View extends IBaseContract.IBaseView {
        void initHeartWarningListSuccess(List<WarningResponseModel> heartWarningList);
        void initHeartWarningListFailed();
        void initChartDataSuccess(List<Entry> values);
        void initChartDataFailed();
    }
}
