package zzr.com.bantang.activity.titleListContent;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

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
import zzr.com.bantang.R;
import zzr.com.bantang.Utils.JsonUtils;
import zzr.com.bantang.entity.TitleContentEntity;

public class TitleListContentActivity extends AppCompatActivity {
    private ArrayList<HashMap<String,String>> datas=new ArrayList<>();
    private HashMap<String,String> map;
    private TextView tv_title_content_name;
    private ImageView iv_title_content_userimg;
    private TextView tv_title_content_username;
    private TextView tv_title_content_views;
    private TextView tv_title_content_content;
    private XRecyclerView rv_listcontent;
    private HashMap<String,String> secDatas=new HashMap<>();
    private ListContentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_title_list_content);
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);

        }
        initView();
        initRecycler();
        tv_title_content_name.setText(secDatas.get("title"));
        tv_title_content_views.setText(secDatas.get("views"));
        Picasso.with(getBaseContext()).load(secDatas.get("avatar")).into(iv_title_content_userimg);
        tv_title_content_username.setText(secDatas.get("nickname"));
        System.out.println("2222   username"+tv_title_content_username.getText());
        rxRetrofitContent(secDatas.get("id"));
        adapter.notifyDataSetChanged();
    }

    private void initRecycler() {
        LinearLayoutManager manager=new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        rv_listcontent.setLayoutManager(manager);
        adapter=new ListContentAdapter();
        rv_listcontent.setAdapter(adapter);
    }

    private void initView() {
        View head=View.inflate(getBaseContext(),R.layout.title_content_head,null);

        tv_title_content_name= (TextView) head.findViewById(R.id.tv_title_content_name);
        iv_title_content_userimg= (ImageView) head.findViewById(R.id.iv_title_content_userimg);
        tv_title_content_username= (TextView) head.findViewById(R.id.tv_title_content_username);
        tv_title_content_views= (TextView) head.findViewById(R.id.tv_title_content_views);
        tv_title_content_content= (TextView) head.findViewById(R.id.tv_title_content_content);
        rv_listcontent= (XRecyclerView) this.findViewById(R.id.rv_title_content);
        rv_listcontent.addHeaderView(head);




    }


    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getDataFromRec(Message message){
        switch (message.what){
            case 7:
            secDatas= (HashMap<String, String>) message.obj;
                System.out.println("2222  secDatas"+secDatas.size());
                break;
        }




        }





    class ListContentAdapter extends RecyclerView.Adapter<ListContentAdapter.MyHolder>{
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View root=View.inflate(getBaseContext(),R.layout.shouye_list_content,null);
            MyHolder holder=new MyHolder(root);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.tv_goods_name.setText(datas.get(position).get("title"));
            holder.tv_goods_content.setText(datas.get(position).get("desc"));
            Picasso.with(getBaseContext()).load(datas.get(position).get("pic").toString()).into(holder.iv_goods_img);
            Picasso.with(getBaseContext()).load(datas.get(position).get("thumbnail_pic").toString()).into(holder.iv_goods_s_img);
            holder.tv_goods_name.setText(datas.get(position).get("title"));
            holder.tv_goods_price.setText(datas.get(position).get("price"));
            holder.tv_goods_like.setText(datas.get(position).get("likes"));

        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            TextView tv_goods_titile_name;
            TextView tv_goods_content;
            ImageView iv_goods_img;
            ImageView iv_goods_s_img;
            TextView tv_goods_name;
            TextView tv_goods_price;
            TextView tv_goods_like;
            public MyHolder(View itemView) {
                super(itemView);
                tv_goods_titile_name= (TextView) itemView.findViewById(R.id.tv_goods_titile_name);
                tv_goods_content= (TextView) itemView.findViewById(R.id.tv_goods_content);
                iv_goods_img= (ImageView) itemView.findViewById(R.id.iv_goods_img);
                iv_goods_s_img= (ImageView) itemView.findViewById(R.id.iv_goods_s_img);
                tv_goods_name= (TextView) itemView.findViewById(R.id.tv_goods_name);
                tv_goods_price= (TextView) itemView.findViewById(R.id.tv_goods_price);
                tv_goods_like= (TextView) itemView.findViewById(R.id.tv_goods_like);
            }
        }
    }




    /**
     * 内容
     */
    private void rxRetrofitContent(String id) {


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://open4.bantangapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonUtils.TitleContentApi restApi = retrofit.create(JsonUtils.TitleContentApi.class);
        Call<TitleContentEntity> call = restApi.TitleContent("com.jzyd.BanTang",
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
                id,
                "1",
                "0");

        call.enqueue(new Callback<TitleContentEntity>() {
            @Override
            public void onResponse(Call<TitleContentEntity> call, Response<TitleContentEntity> response) {
                TitleContentEntity body = response.body();
                tv_title_content_content.setText(body.getData().getDesc());
                System.out.println("2222   desc "+tv_title_content_content.getText());

                List<TitleContentEntity.DataBean.ProductListBean> product_list = body.getData().getProduct_list();
                System.out.println("2222   product_list"+product_list.size());

                for (TitleContentEntity.DataBean.ProductListBean temp : product_list) {
                    map=new HashMap<String, String>();
                    String title = temp.getTitle();
                    map.put("title",title);
                    String pic = temp.getPic();
                    map.put("pic",pic);
                    String desc = temp.getDesc();
                    map.put("desc",desc);
                    String price = temp.getPrice();
                    map.put("price",price);
                    String thumbnail_pic = temp.getThumbnail_pic();
                    map.put("thumbnail_pic",thumbnail_pic);
                    String likes = temp.getLikes();
                    map.put("likes",likes);
                    String url = temp.getUrl();
                    map.put("url",url);

                    System.out.println("2222  title"+title);

                    datas.add(map);

                }
                System.out.println("2222   data.size"+datas.size());
                adapter.notifyDataSetChanged();
                call.cancel();
            }


            @Override
            public void onFailure(Call<TitleContentEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
