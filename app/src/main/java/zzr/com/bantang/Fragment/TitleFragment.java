package zzr.com.bantang.Fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.rollviewpager.RollPagerView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zzr.com.bantang.Fragment.TitleFragmentList.RecFragment;
import zzr.com.bantang.R;
import zzr.com.bantang.Utils.JsonUtils;
import zzr.com.bantang.Utils.PicassoImageLoader;
import zzr.com.bantang.activity.titleBanner.TitleBannerActivity;
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

    private ArrayList<HashMap<String, String>> listBanner = new ArrayList<>();
    private HashMap<String, String> mapBanner;

    private ArrayList<Fragment> fs = new ArrayList<>();
    private ArrayList<String> ts = new ArrayList<>();

    private ArrayList<HashMap<String, String>> datas_bannerContent = new ArrayList<>();
    private HashMap<String, String> map;



    public TitleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initData();
    }

    private void initData() {
        fs.add(new RecFragment());
        fs.add(new RecFragment());
        fs.add(new RecFragment());
        fs.add(new RecFragment());
        fs.add(new RecFragment());
        fs.add(new RecFragment());
        fs.add(new RecFragment());
        fs.add(new RecFragment());
        fs.add(new RecFragment());
        fs.add(new RecFragment());

        ts.add("推荐");
        ts.add("最新");
        ts.add("热门");
        ts.add("礼物");
        ts.add("美食");
        ts.add("生活");
        ts.add("设计感");
        ts.add("家居");
        ts.add("数码");
        ts.add("阅读");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_title, null);
        banner = (Banner) root.findViewById(R.id.vg_banner);


        /**
         * 顶部导航栏
         */
        TabLayout tb = (TabLayout) root.findViewById(R.id.nav_second_top);
        //可滑动
        tb.setTabMode(TabLayout.MODE_SCROLLABLE);
        /*TabLayout.Tab tab1 = tb.newTab().setText("推荐");
        tb.addTab(tab1);
        TabLayout.Tab tab2 = tb.newTab().setText("最新");
        tb.addTab(tab2);*/
        ViewPager vp = (ViewPager) root.findViewById(R.id.vp_title);
        vp.setAdapter(new VpAdapter(getChildFragmentManager()));
        tb.setupWithViewPager(vp, true);


        //initViewPager();
        rxRetrofit();


        initContent();


        return root;
    }

    private void initContent() {

    }


    /**
     * 顶部导航栏适配器
     */
    class VpAdapter extends FragmentPagerAdapter {

        public VpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return ts.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return fs.get(position);
        }

        @Override
        public int getCount() {
            return fs.size();
        }
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
        final Intent intent = new Intent(getActivity(), TitleBannerActivity.class);
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                final Message message = new Message();
                switch (position) {
                    case 2:
                        message.what = 1;
                        break;
                    case 3:
                        message.what = 2;
                        break;
                    case 4:
                        message.what = 3;
                        break;
                    case 5:
                        message.what = 4;
                        break;
                }
                message.obj = datas_bannerContent;
                System.out.println("111111 message"+message.obj);
                EventBus.getDefault().postSticky(message);
                getActivity().startActivity(intent);



            }
        });

    }


    /**
     * 通过post请求获取轮播图JSON中图片
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
                    map = new HashMap<String, String>();
                    String path = temp.getPhoto().toString();
                    imgPath.add(path);
                    System.out.println("ttt  pathsize"+imgPath.size());
                    System.out.println("ttt  path:  "+imgPath);
                    String ids = temp.getExtend();
                    map.put("ids", ids);
                    String title = temp.getTitle();
                    map.put("title", title);
                    datas_bannerContent.add(map);
                }
                System.out.println("---" + imgPath.size());

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
