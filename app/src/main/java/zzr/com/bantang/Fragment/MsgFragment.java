package zzr.com.bantang.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import zzr.com.bantang.Fragment.MsgFragmentList.MoveFragment;
import zzr.com.bantang.Fragment.MsgFragmentList.NotifyFragment;
import zzr.com.bantang.Fragment.MsgFragmentList.TalkFragment;
import zzr.com.bantang.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MsgFragment extends Fragment {
    private View root;
    private ArrayList<Fragment> fs = new ArrayList<>();
    private ArrayList<String> ts = new ArrayList<>();





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_msg, null);
        initData();


        /**
         * 顶部导航栏
         */
        TabLayout tb= (TabLayout) root.findViewById(R.id.nav_msg_top);
        //可滑动
        tb.setTabMode(TabLayout.MODE_FIXED);
        tb.setTabGravity(TabLayout.GRAVITY_FILL);
        ViewPager vp= (ViewPager) root.findViewById(R.id.vp_msg);
        vp.setAdapter(new VpAdapter(getChildFragmentManager()));
        tb.setupWithViewPager(vp,true);

        return root;
    }

    private void initData() {
        fs.add(new NotifyFragment());
        fs.add(new TalkFragment());
        fs.add(new MoveFragment());

        ts.add("通知");
        ts.add("评论");
        ts.add("推送");
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

}
