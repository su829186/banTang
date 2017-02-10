package zzr.com.bantang.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zzr.com.bantang.Fragment.FindFragmentList.NewFindFragment;
import zzr.com.bantang.R;
import zzr.com.bantang.Utils.JsonUtils;
import zzr.com.bantang.Utils.PicassoImageLoader;
import zzr.com.bantang.entity.FindEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {
    private ArrayList<String> urlpath=new ArrayList<>();
    private HashMap<String,String> map;
    private ArrayList<HashMap<String,String>> datas=new ArrayList<>();
    private ArrayList<HashMap<String,String>> datas_activity=new ArrayList<>();
    private Banner banner;
    private RecyclerView listGroup;
    private  RecyclerView listActivity;
    private MyAdapter adapter;
    private Activity_Adapter activity_adapter;
    private View root;



    private ArrayList<Fragment> fs = new ArrayList<>();
    private ArrayList<String> ts = new ArrayList<>();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initData();
    }

    /**
     * 导航栏
     */
    private void initData() {
        fs.add(new NewFindFragment());
        fs.add(new NewFindFragment());
        fs.add(new NewFindFragment());


        ts.add("最新");
        ts.add("热门");
        ts.add("关注");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_find, null);
        rxRetrofit();
        banner= (Banner) root.findViewById(R.id.banner_find);


        initNavTop();



        listGroup= (RecyclerView) root.findViewById(R.id.rv_group);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        listGroup.setLayoutManager(manager);
        adapter=new MyAdapter();
        listGroup.setAdapter(adapter);


        listActivity= (RecyclerView) root.findViewById(R.id.rv_activity);
        GridLayoutManager manager1=new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false);

        listActivity.setLayoutManager(manager1);
        activity_adapter=new Activity_Adapter();
        listActivity.setAdapter(activity_adapter);



        return root;
    }

    private void initNavTop() {
        /**
         * 顶部导航栏
         */
        TabLayout tb= (TabLayout) root.findViewById(R.id.nav_find_top);
        //可滑动
        tb.setTabMode(TabLayout.MODE_FIXED);
        tb.setTabGravity(TabLayout.GRAVITY_FILL);
        ViewPager vp= (ViewPager) root.findViewById(R.id.vp_find);
        vp.setAdapter(new VpAdapter(getChildFragmentManager()));
        tb.setupWithViewPager(vp,true);
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
     * 创建小组RecyclerView适配器
     */
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

        //创建view结构
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View root = View.inflate(parent.getContext(), R.layout.group_layout, null);
            MyHolder holder=new MyHolder(root);
            return holder;
        }

        //给view结构填充数据
        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.tv_group.setText(datas.get(position).get("title").toString());
            Picasso.with(getContext()).load(datas.get(position).get("photo").toString()).resize(100,100).into(holder.iv_group);
            System.out.println("!!!Bind"+holder.tv_group.toString());
        }

        @Override
        public int getItemCount() {
            System.out.println("!!!  data.size:"+datas.size());
            return datas.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            TextView tv_group;
            ImageView iv_group;
            public MyHolder(View itemView) {
                super(itemView);
                tv_group= (TextView) itemView.findViewById(R.id.tv_group);
                iv_group= (ImageView) itemView.findViewById(R.id.iv_group);
            }
        }
    }



    /**
     * 创建活动RecyclerView适配器
     */
    class Activity_Adapter extends RecyclerView.Adapter<Activity_Adapter.Activity_Holder>{
        @Override
        public Activity_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View root = View.inflate(parent.getContext(), R.layout.find_activity_layout, null);
            Activity_Holder holder=new Activity_Holder(root);

            return holder;
        }

        @Override
        public void onBindViewHolder(Activity_Holder holder, int position) {
            holder.tv_activity_title.setText(datas_activity.get(position).get("title").toString());
            holder.tv_activity_user.setText(datas_activity.get(position).get("users").toString());
            Picasso.with(getContext()).load(datas_activity.get(position).get("icon").toString()).resize(70,70).into(holder.iv_activity_find);
        }

        @Override
        public int getItemCount() {
            return datas_activity.size();
        }

        class Activity_Holder extends RecyclerView.ViewHolder{
            ImageView iv_activity_find;
            TextView tv_activity_title;
            TextView tv_activity_user;
            public Activity_Holder(View itemView) {
                super(itemView);
                iv_activity_find= (ImageView) itemView.findViewById(R.id.iv_find_activity);
                tv_activity_title= (TextView) itemView.findViewById(R.id.tv_find_activity_title);
                tv_activity_user= (TextView) itemView.findViewById(R.id.tv_find_activity_user);
            }
        }
    }



    /**
     * 轮播图
     */
    private void init() {


        System.out.println("---init1");
        banner.setImages(urlpath)
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


        JsonUtils.FindApi restApi = retrofit.create(JsonUtils.FindApi.class);
        Call<FindEntity> call = restApi.FindList("com.jzyd.BanTang",
                "1486171582",
                "5.9.7",
                "ppzhushuo",
                "bt_app_android",
                "ffcda7a1c4ff338e05c42e7972ba7b8d",
                "4.4.2",
                "720",
                "OPPO A33m",
                "864394010601641",
                "25");

        call.enqueue(new Callback<FindEntity>() {
            @Override
            public void onResponse(Call<FindEntity> call, Response<FindEntity> response) {
                FindEntity body = response.body();
                List<FindEntity.DataBean.BannerBean> find = body.getData().getBanner();
                System.out.println("+++666");
                for (FindEntity.DataBean.BannerBean temp : find
                        ) {
                    map=new HashMap<String, String>();
                    String path = temp.getPhoto().toString();
                    urlpath.add(path);


                }


                List<FindEntity.DataBean.SubjectListBean> subject_list = body.getData().getSubject_list();
                for (FindEntity.DataBean.SubjectListBean obj:subject_list) {
                    map=new HashMap<String, String>();
                    String title = obj.getTitle();
                    map.put("title",title);
                    String photo = obj.getPhoto();
                    map.put("photo",photo);
                    System.out.println("!!!"+title+"  photo"+photo);
                    datas.add(map);

                }
                adapter.notifyDataSetChanged();

                List<FindEntity.DataBean.ActivityListBean> activity_list = body.getData().getActivity_list();
                for (FindEntity.DataBean.ActivityListBean obj:activity_list) {
                    map=new HashMap<String, String>();
                    String title = obj.getTitle();
                    map.put("title",title);
                    String icon = obj.getIcon();
                    map.put("icon",icon);
                    String users = obj.getUsers();
                    map.put("users",users);
                    System.out.println("!!!"+title+"  icon"+icon);
                    datas_activity.add(map);
                }
                activity_adapter.notifyDataSetChanged();

                init();



                call.cancel();
            }


            @Override
            public void onFailure(Call<FindEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });





    }

}
