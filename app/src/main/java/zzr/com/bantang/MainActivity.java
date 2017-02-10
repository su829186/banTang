package zzr.com.bantang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

import zzr.com.bantang.Fragment.FindFragment;
import zzr.com.bantang.Fragment.MineFragment;
import zzr.com.bantang.Fragment.MsgFragment;
import zzr.com.bantang.Fragment.TitleFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{


    private TextView tv;
    private BottomNavigationBar main_bar;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        main_bar = (BottomNavigationBar) this.findViewById(R.id.bn_main_bar);
        initBar();
    }





    private void initBar() {
        main_bar.setMode(BottomNavigationBar.MODE_FIXED);
        main_bar.setActiveColor("#FD6363");
        main_bar.setInActiveColor("#cccccc");
        main_bar.addItem(new BottomNavigationItem(R.drawable.home_checked,"首页").setInactiveIcon(this.getResources().getDrawable(R.drawable.home)))
                .addItem(new BottomNavigationItem(R.drawable.community_checked,"发现").setInactiveIcon(this.getResources().getDrawable(R.drawable.community)))
                //.addItem(new BottomNavigationItem(R.drawable.enter,"").setInactiveIcon(this.getResources().getDrawable(R.drawable.enter)))
                .addItem(new BottomNavigationItem(R.drawable.msg_checked,"消息").setInactiveIcon(this.getResources().getDrawable(R.drawable.msg)))
                .addItem(new BottomNavigationItem(R.drawable.personal_checked,"我的").setInactiveIcon(this.getResources().getDrawable(R.drawable.personal)))
                .initialise();

        initFragment();



    }

    private void initFragment() {
        fragments=getFragments();

        FragmentManager manager=getSupportFragmentManager();

        FragmentTransaction transaction=manager.beginTransaction();

        transaction.add(R.id.fl_content,fragments.get(0));

        transaction.commit();

        main_bar.setTabSelectedListener(this);







    }

    private ArrayList<Fragment> getFragments(){
        ArrayList<Fragment> fragments=new ArrayList<>();

        fragments.add(new TitleFragment());
        fragments.add(new FindFragment());
        fragments.add(new MsgFragment());
        fragments.add(new MineFragment());

        return fragments;
    }


    @Override
    public void onTabSelected(int position) {
        if(fragments!=null){
            if(position<fragments.size()){
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                Fragment fragment=fragments.get(position);

                if(fragment.isAdded()){
                    transaction.show(fragment);
                }else {
                    transaction.add(R.id.fl_content,fragment);
                }
                transaction.commitAllowingStateLoss();

            }

        }
    }

    @Override
    public void onTabUnselected(int position) {
        if(fragments!=null){
            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            Fragment fragment=fragments.get(position);

            transaction.hide(fragment);
            transaction.commitAllowingStateLoss();
        }
    }

    @Override
    public void onTabReselected(int position) {

    }
}
