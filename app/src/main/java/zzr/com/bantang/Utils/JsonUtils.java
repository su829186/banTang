package zzr.com.bantang.Utils;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import zzr.com.bantang.entity.FindEntity;
import zzr.com.bantang.entity.FindNewEntity;
import zzr.com.bantang.entity.MsgMoveEntity;
import zzr.com.bantang.entity.MsgNotifyEntity;
import zzr.com.bantang.entity.RollViewPagerObj;
import zzr.com.bantang.entity.TitleBannerEntity;
import zzr.com.bantang.entity.TitleContentEntity;
import zzr.com.bantang.entity.TitleEntity;

/**
 * Created by Administrator on 2017/2/6.
 */

public class JsonUtils {
    /**
     * 轮播图
     */
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


    /**'
     * 轮播图内容
     */
    public interface BannerList{
        @FormUrlEncoded
        @POST("topics/topic/listByIds")
        Call<TitleBannerEntity> BannerContent(@Field("app_id") String app_id,
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
                                              @Field("ids") String ids);
    }

    /**
     * 首页文章
     */
    public interface RecApi{
        @FormUrlEncoded
        @POST("recommend/index")
        Call<TitleEntity> RecList(@Field("app_id") String app_id,
                                  @Field("app_installtime") String app_installtime,
                                  @Field("app_open_count") String app_open_count,
                                  @Field("app_versions") String app_versions,
                                  @Field("channel_name") String channel_name,
                                  @Field("client_id") String client_id,
                                  @Field("client_secret") String client_secret,
                                  @Field("last_get_time") String last_get_time,
                                  @Field("os_versions") String os_versions,
                                  @Field("page") String page,
                                  @Field("pagesize") String pagesize,
                                  @Field("screensize") String screensize,
                                  @Field("track_device_info") String track_device_info,
                                  @Field("track_deviceid") String track_deviceid,
                                  @Field("update_time") String update_time,
                                  @Field("v") String v);
    }

    /**
     * 发现栏内容
     */
    public interface FindApi {
        @FormUrlEncoded
        @POST("post/index/index")
        Call<FindEntity> FindList(@Field("app_id") String app_id,
                                  @Field("app_installtime") String app_installtime,
                                  @Field("app_versions") String app_versions,
                                  @Field("channel_name") String channel_name,
                                  @Field("client_id") String client_id,
                                  @Field("client_secret") String client_secret,
                                  @Field("os_versions") String os_versions,
                                  @Field("screensize") String screensize,
                                  @Field("track_device_info") String track_device_info,
                                  @Field("track_deviceid") String track_deviceid,
                                  @Field("v") String v);
    }

    /**
     * 发现栏最新页面内容
     */
    public interface FindNewApi {
        @FormUrlEncoded
        @POST("post/index/listByNew")
        Call<FindNewEntity> FindNewList(@Field("app_id") String app_id,
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
                                        @Field("page") String page,
                                        @Field("pagesize") String pagesize);



    }

    /**
     * 消息栏通知
     */
    public interface MsgNotifyApi {
        @FormUrlEncoded
        @POST("users/notice/list")
        Call<MsgNotifyEntity> MsgNotifyList(@Field("app_id") String app_id,
                                            @Field("client_id") String client_id,
                                            @Field("client_secret") String client_secret,
                                            @Field("track_user_id") String track_user_id,
                                            @Field("oauth_token") String oauth_token,
                                            @Field("track_deviceid") String track_deviceid,
                                            @Field("channel_name") String channel_name,
                                            @Field("app_installtime") String app_installtime,
                                            @Field("app_versions") String app_versions,
                                            @Field("os_versions") String os_versions,
                                            @Field("screensize") String screensize,
                                            @Field("v") String v,
                                            @Field("track_device_info") String track_device_info,
                                            @Field("page") String page,
                                            @Field("pagesize") String pagesize,
                                            @Field("type_id") String type_id,
                                            @Field("is_merge") String is_merge,
                                            @Field("is_message") String is_message);

    }

    /**
     * 消息栏推送
     */
    public interface MsgMoveApi {
        @FormUrlEncoded
        @POST("users/push/list")
        Call<MsgMoveEntity> MsgMoveList(@Field("app_id") String app_id,
                                        @Field("client_id") String client_id,
                                        @Field("client_secret") String client_secret,
                                        @Field("track_user_id") String track_user_id,
                                        @Field("oauth_token") String oauth_token,
                                        @Field("track_deviceid") String track_deviceid,
                                        @Field("channel_name") String channel_name,
                                        @Field("app_installtime") String app_installtime,
                                        @Field("app_versions") String app_versions,
                                        @Field("os_versions") String os_versions,
                                        @Field("screensize") String screensize,
                                        @Field("v") String v,
                                        @Field("track_device_info") String track_device_info,
                                        @Field("page") String page,
                                        @Field("pagesize") String pagesize,
                                        @Field("type_id") String type_id);

    }

    /**
     * 首页文章内容
     */
    public interface TitleContentApi {
        @FormUrlEncoded
        @POST("topic/newInfo")
        Call<TitleContentEntity> TitleContent(@Field("app_id") String app_id,
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
