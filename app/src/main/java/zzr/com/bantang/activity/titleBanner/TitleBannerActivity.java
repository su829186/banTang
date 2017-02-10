package zzr.com.bantang.activity.titleBanner;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zzr.com.bantang.Adapter.BannerContentAdapter;
import zzr.com.bantang.R;
import zzr.com.bantang.Utils.JsonUtils;
import zzr.com.bantang.entity.TitleBannerEntity;

public class TitleBannerActivity extends AppCompatActivity {
    private ArrayList<HashMap<String,String>> datas=new ArrayList<>();
    private RecyclerView listGroup;
    private ListView lv_group;
    private BannerContentAdapter adapter;
    private Toolbar toolbar;
    private TextView tv_banner_title;

    private ArrayList<HashMap<String,String>> listBanner=new ArrayList<>();
    private HashMap<String,String> mapBanner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_title_banner);
        toolbar= (Toolbar) this.findViewById(R.id.banner_toolbar);
        ImageView iv_toolbar= (ImageView) this.findViewById(R.id.iv_toolbar);
        tv_banner_title= (TextView) this.findViewById(R.id.tv_banner_title);
        iv_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

        lv_group= (ListView) this.findViewById(R.id.lv_banner_content);
        adapter=new BannerContentAdapter(this,listBanner);
        lv_group.setAdapter(adapter);






    }



    @Subscribe(threadMode= ThreadMode.MAIN,sticky = true)
    public void getDataFromActivity(Message message){
        System.out.println("***eventBus");
        switch (message.what){
            case 1:
                datas= (ArrayList<HashMap<String, String>>) message.obj;
                tv_banner_title.setText(datas.get(1).get("title"));
                rxRetrofitBanner(datas.get(1).get("ids"));
                System.out.println("111111"+datas.size());
                break;
            case 2:
                datas= (ArrayList<HashMap<String, String>>) message.obj;
                tv_banner_title.setText(datas.get(2).get("title"));
                rxRetrofitBanner(datas.get(2).get("ids"));
                System.out.println("111111"+datas.size());
                break;
            case 3:
                datas= (ArrayList<HashMap<String, String>>) message.obj;
                tv_banner_title.setText(datas.get(3).get("title"));
                rxRetrofitBanner(datas.get(3).get("ids"));
                System.out.println("111111"+datas.size());
                break;
            case 4:
                datas= (ArrayList<HashMap<String, String>>) message.obj;
                tv_banner_title.setText(datas.get(4).get("title"));
                rxRetrofitBanner(datas.get(4).get("ids"));
                System.out.println("111111"+datas.size());
                break;

        }

    }


    /**
     * 轮播图内容
     */
    private void rxRetrofitBanner(String ids) {


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://open4.bantangapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonUtils.BannerList restApi = retrofit.create(JsonUtils.BannerList.class);
        Call<TitleBannerEntity> call = restApi.BannerContent("com.jzyd.BanTang",
                "bt_app_android",
                "ffcda7a1c4ff338e05c42e7972ba7b8d",
                "133524383248522",
                "ppzhushuo",
                "1486120408",
                "5.9.7",
                "4.4.2",
                "720",
                "25",
                "GT-P5210",
                ids);

        call.enqueue(new Callback<TitleBannerEntity>() {
            @Override
            public void onResponse(Call<TitleBannerEntity> call, Response<TitleBannerEntity> response) {
                TitleBannerEntity body = response.body();
                List<TitleBannerEntity.DataBean.TopicBean> topic = body.getData().getTopic();

                for (TitleBannerEntity.DataBean.TopicBean temp : topic
                        ) {
                    mapBanner = new HashMap<String, String>();
                    String path = temp.getPic().toString();
                    mapBanner.put("path", path);
                    String title = temp.getTitle();
                    mapBanner.put("title", title);
                    String praises = temp.getPraises();
                    mapBanner.put("praises", praises);
                    String views = temp.getViews();
                    mapBanner.put("views", views);
                    String time = temp.getCreate_time_str();
                    mapBanner.put("time", time);

                    String avatar = temp.getUser().getAvatar();
                    mapBanner.put("avatar", avatar);
                    String nickname = temp.getUser().getNickname();
                    mapBanner.put("nickname", nickname);
                    System.out.println("111111 title:" + title);
                    listBanner.add(mapBanner);

                    System.out.println("111111 listBannerSize:" + listBanner.size());

                }
                System.out.println("111111   size" + listBanner.size());
                adapter.notifyDataSetChanged();

                call.cancel();
            }


            @Override
            public void onFailure(Call<TitleBannerEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }


}
