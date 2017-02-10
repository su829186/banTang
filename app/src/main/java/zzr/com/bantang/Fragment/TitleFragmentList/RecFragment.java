package zzr.com.bantang.Fragment.TitleFragmentList;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zzr.com.bantang.Adapter.TitleListAdapter;
import zzr.com.bantang.R;
import zzr.com.bantang.Utils.JsonUtils;
import zzr.com.bantang.activity.titleListContent.TitleListContentActivity;
import zzr.com.bantang.entity.TitleEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecFragment extends Fragment {
    private View root;
    private ArrayList<HashMap<String,String>> datas=new ArrayList<>();
    private HashMap<String,String> map;
    private TitleListAdapter adapter;
    private FragmentManager manager;
    private PullToRefreshListView refreshListView;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    private void initData() {
        rxRetrofit();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.fragment_rec2,null);
        initData();
        refreshListView= (PullToRefreshListView) root.findViewById(R.id.pullto_rec);
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        manager=getActivity().getSupportFragmentManager();

        refreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshListView.onRefreshComplete();
                    }
                },1000);

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshListView.onRefreshComplete();
                    }
                },1000);
            }
        });

        refreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), TitleListContentActivity.class);
                if(datas.get(position).get("type").isEmpty()){
                    Message message=new Message();
                    message.what=7;
                    message.obj=datas.get(position);
                    System.out.println("2222   message"+message.obj);
                    EventBus.getDefault().postSticky(message);
                    startActivity(intent);
                }

            }
        });

        adapter=new TitleListAdapter(getContext(),datas);
        refreshListView.setAdapter(adapter);
        return root;
    }


    /**
     * 通过POST请求获取数据
     */
    private void rxRetrofit() {


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://open4.bantangapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonUtils.RecApi restApi = retrofit.create(JsonUtils.RecApi.class);
        Call<TitleEntity> call = restApi.RecList("com.jzyd.BanTang",
                "1486171582",
                "18",
                "5.9.7",
                "ppzhushuo",
                "bt_app_android",
                "ffcda7a1c4ff338e05c42e7972ba7b8d",
                "1486433923",
                "4.4.2",
                "0",
                "20",
                "720",
                "OPPO A33m",
                "864394010601641",
                "0",
                "25");

        call.enqueue(new Callback<TitleEntity>() {
            @Override
            public void onResponse(Call<TitleEntity> call, Response<TitleEntity> response) {
                TitleEntity body = response.body();
                List<TitleEntity.DataBean.TopicBean> topic = body.getData().getTopic();
                for (TitleEntity.DataBean.TopicBean temp : topic
                        ) {
                    map=new HashMap<String, String>();
                    String urlpath=temp.getPic().toString();
                    map.put("urlpath",urlpath);
                    String author=temp.getUser().getNickname().toString();
                    map.put("author",author);
                    String title = temp.getTitle().toString();
                    map.put("title",title);
                    String views=temp.getViews().toString();
                    map.put("views",views);
                    String like=temp.getLikes().toString();
                    map.put("like",like);
                    String nickname = temp.getUser().getNickname();
                    map.put("nickname",nickname);
                    String avatar = temp.getUser().getAvatar();
                    map.put("avatar",avatar);
                    String id = temp.getId();
                    map.put("id",id);
                    String type = temp.getType();
                    map.put("type",type);

                    System.out.println("---urlpath:"+urlpath+"   title:"+title);

                    datas.add(map);
                    adapter.notifyDataSetChanged();
                }




                call.cancel();
            }


            @Override
            public void onFailure(Call<TitleEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });





    }

}
