package zzr.com.bantang.Fragment.MsgFragmentList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import zzr.com.bantang.entity.MsgMoveEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoveFragment extends Fragment {
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
        root=inflater.inflate(R.layout.fragment_move,null);

        return inflater.inflate(R.layout.fragment_move, container, false);
    }


    /**
     * 通过post请求获取JSON中图片
     */
    private void rxRetrofit() {


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://open4.bantangapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonUtils.MsgMoveApi restApi = retrofit.create(JsonUtils.MsgMoveApi.class);
        Call<MsgMoveEntity> call = restApi.MsgMoveList("com.jzyd.BanTang",
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
                "1,2,3,4,5,6");

        call.enqueue(new Callback<MsgMoveEntity>() {
            @Override
            public void onResponse(Call<MsgMoveEntity> call, Response<MsgMoveEntity> response) {
                MsgMoveEntity body = response.body();
                List<MsgMoveEntity.DataBean.ListBean> list = body.getData().getList();
                for (MsgMoveEntity.DataBean.ListBean temp : list
                        ) {
                    map=new HashMap<String, String>();


                }
                adapter.notifyDataSetChanged();


                call.cancel();
            }


            @Override
            public void onFailure(Call<MsgMoveEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
