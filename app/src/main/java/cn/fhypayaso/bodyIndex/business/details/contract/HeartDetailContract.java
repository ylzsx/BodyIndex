package cn.fhypayaso.bodyIndex.business.details.contract;

import java.util.List;

import cn.fhypayaso.bodyIndex.base.mvp.impl.IBaseContract;
import cn.fhypayaso.bodyIndex.business.details.model.response.HeartWarningResponseModel;

public interface HeartDetailContract {

    interface Presenter extends IBaseContract.IBasePresenter {
        void initHeartWarningList();
    }

    interface View extends IBaseContract.IBaseView {
        void initHeartWarningListSuccess(List<HeartWarningResponseModel> heartWarningList);
        void initHeartWarningListFailed();
    }
}
