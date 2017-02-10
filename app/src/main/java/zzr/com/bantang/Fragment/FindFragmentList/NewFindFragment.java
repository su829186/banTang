package zzr.com.bantang.Fragment.FindFragmentList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zzr.com.bantang.R;
import zzr.com.bantang.Utils.JsonUtils;
import zzr.com.bantang.entity.FindNewEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFindFragment extends Fragment {
    private ArrayList<HashMap<String,String>> datas=new ArrayList<>();
    private HashMap<String,String> map;
    private View root;
    private RecyclerView NewGroup;
    private MyAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.fragment_new_find,null);
        System.out.println("~~~init");
        rxRetrofit();
        NewGroup= (RecyclerView) root.findViewById(R.id.rv_find);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        NewGroup.setLayoutManager(manager);
        adapter=new MyAdapter();
        NewGroup.setAdapter(adapter);




        return root;
    }


    /**
     * 最新页面适配器
     */
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View root=View.inflate(getContext(),R.layout.find_new_layout,null);
            MyHolder holder=new MyHolder(root);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            Picasso.with(getContext()).load(datas.get(position).get("avatar").toString()).into(holder.iv_find_user_img);
            holder.tv_find_user.setText(datas.get(position).get("nickname").toString());
            holder.tv_find_time.setText(datas.get(position).get("datestr").toString());
            Picasso.with(getContext()).load(datas.get(position).get("url").toString()).into(holder.iv_find_img);
            holder.tv_find_content.setText(datas.get(position).get("comments").toString());
            holder.tv_find_views.setText(datas.get(position).get("views").toString());
            System.out.println("~~~"+datas.get(position).get("url").toString());
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            ImageView iv_find_user_img;
            TextView tv_find_user;
            TextView tv_find_time;
            ImageView iv_find_img;
            TextView tv_find_content;
            TextView tv_find_views;

            public MyHolder(View itemView) {
                super(itemView);
                iv_find_user_img= (ImageView) itemView.findViewById(R.id.iv_find_user_img);
                tv_find_user= (TextView) itemView.findViewById(R.id.tv_find_user);
                tv_find_time= (TextView) itemView.findViewById(R.id.tv_find_time);
                iv_find_img= (ImageView) itemView.findViewById(R.id.iv_find_img);
                tv_find_content= (TextView) itemView.findViewById(R.id.tv_find_content);
                tv_find_views= (TextView) itemView.findViewById(R.id.tv_find_views);
            }
        }
    }



    /**
     * 通过POST请求获取数据
     */
    private void rxRetrofit() {

        System.out.println("~~~rxRe");
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://open4.bantangapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        System.out.println("~~~retrofit");


        JsonUtils.FindNewApi restApi = retrofit.create(JsonUtils.FindNewApi.class);
        System.out.println("~~~Api");
        Call<FindNewEntity> call = restApi.FindNewList("com.jzyd.BanTang",
                "bt_app_android",
                "ffcda7a1c4ff338e05c42e7972ba7b8d",
                "133524383248522",
                "ppzhushuo",
                "1486120408",
                "5.9.7",
                "4.2.2",
                "720",
                "25",
                "GT-P5210",
                "0",
                "20");
        System.out.println("~~~call");
        call.enqueue(new Callback<FindNewEntity>() {

            @Override
            public void onResponse(Call<FindNewEntity> call, Response<FindNewEntity> response) {
                System.out.println("~~~onResponse");
                FindNewEntity body = response.body();
                List<FindNewEntity.DataBean.ListBean> list = body.getData().getList();
                for (FindNewEntity.DataBean.ListBean temp : list
                        ) {
                    map = new HashMap<String, String>();
                    System.out.println("~~~map");
                    String content = temp.getPost().getContent();
                    map.put("content",content);
                    String url = temp.getPost().getMiddle_pic_url();
                    map.put("url",url);
                    String nickname = temp.getPost().getUser().getNickname();
                    map.put("nickname",nickname);
                    String avatar = temp.getPost().getUser().getAvatar();
                    map.put("avatar",avatar);
                    String datestr = temp.getPost().getDatestr();
                    map.put("datestr",datestr);
                    String praises = temp.getPost().getDynamic().getPraises();
                    map.put("praises",praises);
                    String comments = temp.getPost().getDynamic().getComments();
                    map.put("comments",comments);
                    String views = temp.getPost().getDynamic().getViews();
                    map.put("views",views);
                    System.out.println("~~~  "+url);

                    datas.add(map);


                }

                adapter.notifyDataSetChanged();
                call.cancel();
            }


            @Override
            public void onFailure(Call<FindNewEntity> call, Throwable t) {
                t.printStackTrace();
                System.out.println("~~~failuer");
            }
        });
    }

}
