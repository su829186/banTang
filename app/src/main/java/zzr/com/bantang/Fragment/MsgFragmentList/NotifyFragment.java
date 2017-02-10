package zzr.com.bantang.Fragment.MsgFragmentList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zzr.com.bantang.Adapter.MsgNotifyListAdapter;
import zzr.com.bantang.R;
import zzr.com.bantang.Utils.JsonUtils;
import zzr.com.bantang.entity.MsgNotifyEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotifyFragment extends Fragment {
    private View root;
    private HashMap<String,String> map;
    private ArrayList<HashMap<String,String>> datas=new ArrayList<>();
    private FragmentManager manager;
    private PullToRefreshListView refreshListView;
    private MsgNotifyListAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_notify, null);
        rxRetrofit();

        refreshListView= (PullToRefreshListView) root.findViewById(R.id.pullto_msg_notify);
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

        adapter=new MsgNotifyListAdapter(getContext(),datas);
        refreshListView.setAdapter(adapter);
        return root;
    }


    /**
     * 通过post请求获取JSON中图片
     */
    private void rxRetrofit() {


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://open4.bantangapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonUtils.MsgNotifyApi restApi = retrofit.create(JsonUtils.MsgNotifyApi.class);
        Call<MsgNotifyEntity> call = restApi.MsgNotifyList("com.jzyd.BanTang",
                "bt_app_android",
                "ffcda7a1c4ff338e05c42e7972ba7b8d",
                "2810387",
                "f296b995c5fddb9a37c68f5b44ff1428",
                "133524383248522",
                "ppzhushuo",
                "1486120408",
                "5.9.7",
                "4.2.2",
                "720",
                "25",
                "GT-P5210",
                "0",
                "20",
                "1,2,13,12,16,15,18,17,6,19,8,5",
                "1",
                "1");

        call.enqueue(new Callback<MsgNotifyEntity>() {
            @Override
            public void onResponse(Call<MsgNotifyEntity> call, Response<MsgNotifyEntity> response) {
                MsgNotifyEntity body = response.body();
                List<MsgNotifyEntity.DataBean.MessageBean> message = body.getData().getMessage();
                for (MsgNotifyEntity.DataBean.MessageBean temp : message
                        ) {
                    map=new HashMap<String, String>();
                    MsgNotifyEntity.DataBean.MessageBean.MessageContentBean message_content = temp.getMessage_content();
                    String content = message_content.getContent();
                    map.put("content",content);
                    MsgNotifyEntity.DataBean.MessageBean.MessageContentBean.UserBean user = message_content.getUser();
                    String nickname = user.getNickname();
                    map.put("nickname",nickname);
                    String avatar = user.getAvatar();
                    map.put("avatar",avatar);
                    datas.add(map);
                    System.out.println("~~~"+content);

                }
                adapter.notifyDataSetChanged();


                call.cancel();
            }


            @Override
            public void onFailure(Call<MsgNotifyEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
