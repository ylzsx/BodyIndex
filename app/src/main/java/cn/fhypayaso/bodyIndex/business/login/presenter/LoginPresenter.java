package cn.fhypayaso.bodyIndex.business.login.presenter;

import cn.fhypayaso.bodyIndex.base.mvp.presenter.BasePresenter;
import cn.fhypayaso.bodyIndex.business.login.contract.LoginContract;
import cn.fhypayaso.bodyIndex.business.login.modal.request.LoginRequestModal;
import cn.fhypayaso.bodyIndex.business.login.modal.response.LoginResponseModal;
import cn.fhypayaso.bodyIndex.network.NetworkFactory;
import cn.fhypayaso.bodyIndex.network.response.ApiResponse;
import cn.fhypayaso.bodyIndex.network.response.ResponseCallBack;
import retrofit2.Call;
import retrofit2.Response;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter{

    @Override
    public void login(LoginRequestModal loginRequestModal) {
        NetworkFactory.getService().login(loginRequestModal)
                .enqueue(new ResponseCallBack<ApiResponse<LoginResponseModal>>() {
                    @Override
                    public void onDataResponse(Call<ApiResponse<LoginResponseModal>> call, Response<ApiResponse<LoginResponseModal>> response) {
                        if (mView != null) {
                            mView.loginSuccess(response.body().getData().getToken());
                        }
                    }

                    @Override
                    public void onDataFailure(Call<ApiResponse<LoginResponseModal>> call, Throwable t) {

                    }
                });
    }
}
