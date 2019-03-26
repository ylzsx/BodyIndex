package cn.fhypayaso.bodyIndex.network;

import cn.fhypayaso.bodyIndex.business.login.modal.request.LoginRequestModal;
import cn.fhypayaso.bodyIndex.business.login.modal.response.LoginResponseModal;
import cn.fhypayaso.bodyIndex.network.response.ApiResponse;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author fhyPayaso
 * @since 2018/4/24 on 上午12:18
 * fhyPayaso@qq.com
 */
public interface ApiService {


    @POST("")
    Observable<ApiResponse<String>> login();

    @POST("login")
    Call<ApiResponse<LoginResponseModal>> login(@Body LoginRequestModal loginRequestModal);

}
