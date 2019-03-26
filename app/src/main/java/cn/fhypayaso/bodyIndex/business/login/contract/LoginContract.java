package cn.fhypayaso.bodyIndex.business.login.contract;

import cn.fhypayaso.bodyIndex.base.mvp.impl.IBaseContract;
import cn.fhypayaso.bodyIndex.business.login.modal.request.LoginRequestModal;

public interface LoginContract {

    interface Presenter extends IBaseContract.IBasePresenter {
        void login(LoginRequestModal loginRequestModal);
    }

    interface View extends IBaseContract.IBaseView {
        void loginSuccess(String s);
        void loginFailed();
    }
}
