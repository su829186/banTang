package zzr.com.bantang.Fragment;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.rollviewpager.RollPagerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zzr.com.bantang.R;
import zzr.com.bantang.Utils.JsonUtils;
import zzr.com.bantang.Utils.PicassoImageLoader;
import zzr.com.bantang.entity.RollViewPagerObj;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment {
    private RollPagerView mRollViewPager;
    private View root;
   // private TestNormalAdapter adapter = new TestNormalAdapter();
    public ArrayList<Bitmap> imgs = new ArrayList<>();
    private ArrayList<String> imgPath = new ArrayList<>();
    private Banner banner;

    private ArrayList<Fragment> fs = new ArrayList<>();
    private ArrayList<String> ts = new ArrayList<>();


    public TitleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initData();
    }

    private void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_title, null);
        banner= (Banner) root.findViewById(R.id.vg_banner);
        //initViewPager();
        rxRetrofit();




        return root;
    }

    /**
     * 轮播图
     */
    private void init() {


        System.out.println("---init1");
        banner.setImages(imgPath)
                .setImageLoader(new PicassoImageLoader())
                .start();
        System.out.println("---init2");

    }




    /**
     * 通过post请求获取JSON中图片
     */
    private void rxRetrofit() {


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://open4.bantangapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonUtils.RestApi restApi = retrofit.create(JsonUtils.RestApi.class);
        Call<RollViewPagerObj> call = restApi.login("com.jzyd.BanTang",
                "bt_app_android",
                "ffcda7a1c4ff338e05c42e7972ba7b8d",
                "864394010601641",
                "ppzhushuo",
                "1486171582",
                "5.9.7",
                "4.4.2",
                "720",
                "25",
                "OPPO A33m",
                "16158",
                "0",
                "0");

        call.enqueue(new Callback<RollViewPagerObj>() {
            @Override
            public void onResponse(Call<RollViewPagerObj> call, Response<RollViewPagerObj> response) {
                RollViewPagerObj body = response.body();
                List<RollViewPagerObj.DataBeanX.BannerBean> banner = body.getData().getBanner();
                        for (RollViewPagerObj.DataBeanX.BannerBean temp : banner
                                ) {
                            String path = temp.getPhoto().toString();
                            path=path.substring(0,67);
                            System.out.println("---"+path);
                            imgPath.add(path);
                            System.out.println("---imagepath");
                        }
                System.out.println("---"+imgPath.size());
                  init();



                call.cancel();
            }


            @Override
            public void onFailure(Call<RollViewPagerObj> call, Throwable t) {
                t.printStackTrace();
            }
        });





    }


}
