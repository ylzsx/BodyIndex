package cn.fhypayaso.bodyIndex.business.details.presenter;

import java.util.ArrayList;
import java.util.List;

import cn.fhypayaso.bodyIndex.base.mvp.presenter.BasePresenter;
import cn.fhypayaso.bodyIndex.business.details.contract.HeartDetailContract;
import cn.fhypayaso.bodyIndex.business.details.model.response.HeartWarningResponseModel;

public class HeartDetailPresenter extends BasePresenter<HeartDetailContract.View> implements HeartDetailContract.Presenter {

    @Override
    public void initHeartWarningList() {
        List<HeartWarningResponseModel> heartWarningList = new ArrayList<>();
        HeartWarningResponseModel h = new HeartWarningResponseModel("心率过快","15分钟前");
        heartWarningList.add(h);
        mView.initHeartWarningListSuccess(heartWarningList);
    }
}
