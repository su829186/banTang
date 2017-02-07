package zzr.com.bantang.Utils;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import zzr.com.bantang.entity.RollViewPagerObj;

/**
 * Created by Administrator on 2017/2/6.
 */

public class JsonUtils {
    public interface RestApi{
        @FormUrlEncoded
        @POST("recommend/operationElement")
        Call<RollViewPagerObj> login(@Field("app_id") String app_id,
                                     @Field("client_id") String client_id,
                                     @Field("client_secret") String client_secret,
                                     @Field("track_deviceid") String track_deviceid,
                                     @Field("channel_name") String channel_name,
                                     @Field("app_installtime") String app_installtime,
                                     @Field("app_versions") String app_versions,
                                     @Field("os_versions") String os_versions,
                                     @Field("screensize") String screensize,
                                     @Field("v") String v,
                                     @Field("track_device_info") String track_device_info,
                                     @Field("id") String id,
                                     @Field("statistics_uv") String statistics_uv,
                                     @Field("is_night") String is_night);
    }
}
