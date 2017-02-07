package zzr.com.bantang.Fragment;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zzr.com.bantang.R;
import zzr.com.bantang.Utils.JsonUtils;
import zzr.com.bantang.entity.RollViewPagerObj;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment {
    private RollPagerView mRollViewPager;
    private View root;
    public ArrayList<Bitmap> imgs=new ArrayList<>();
    private ArrayList<String> imgPath=new ArrayList<>();


    public TitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.fragment_title,null);
        rxRetrofit();
        initViewPager();
        init();



        return inflater.inflate(R.layout.fragment_title, container, false);
    }

    private void init() {

    }

    /**
     * 轮播图
     */
    private void initViewPager() {
        for (String str:imgPath) {
            final String str1=str;
            new Thread(){
                @Override
                public void run() {

                    try {
                        Bitmap bitmap = Picasso.with(getActivity()).load(str1).get();
                        System.out.println("---bitmap");
                        imgs.add(bitmap);
                        System.out.println("---imgs");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        mRollViewPager= (RollPagerView) root.findViewById(R.id.roll_view_pager);

        //设置播放时间间隔
        mRollViewPager.setPlayDelay(1000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW,Color.WHITE));
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
                    String path=temp.getPhoto().toString();
                    imgPath.add(path);

                    System.out.println("---path");



                    System.out.println("---" + temp.getPhoto().toString());

                }
                call.cancel();
            }

            @Override
            public void onFailure(Call<RollViewPagerObj> call, Throwable t) {
                t.printStackTrace();
            }
        });









    }

    /**
     * 轮播图适配器
     */
    class TestNormalAdapter extends StaticPagerAdapter {


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageBitmap(imgs.get(position));
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            return view;
        }

        @Override
        public int getCount() {
            return imgs.size();
        }

    }



}
