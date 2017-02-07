package zzr.com.bantang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import zzr.com.bantang.Fragment.FindFragment;
import zzr.com.bantang.Fragment.TitleFragment;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_send;
    private RadioButton rb_title;
    private RadioButton rb_find;
    private RadioButton rb_msg;
    private RadioButton rb_mine;
    private RadioGroup rg_bottom;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        tv= (TextView) this.findViewById(R.id.tv)   ;
        initRB();



        rg_bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_title:
                        transaction=manager.beginTransaction();
                        Fragment fragment=new TitleFragment();
                        transaction.replace(R.id.fl_content,fragment);
                        transaction.commit();
                        break;
                    case R.id.rb_find:
                        transaction=manager.beginTransaction();
                        Fragment findFragment=new FindFragment();
                        transaction.replace(R.id.fl_content,findFragment);
                        transaction.commit();
                        break;
                    case R.id.rb_msg:
                        transaction=manager.beginTransaction();
                        Fragment msgFragment=new FindFragment();
                        transaction.replace(R.id.fl_content,msgFragment);
                        transaction.commit();
                        break;
                    case R.id.rb_mine:
                        transaction=manager.beginTransaction();
                        Fragment mineFragment=new FindFragment();
                        transaction.replace(R.id.fl_content,mineFragment);
                        transaction.commit();
                        break;
                }
            }
        });
    }





    private void initRB() {
        iv_send= (ImageView) this.findViewById(R.id.iv_send);

        Picasso.with(this).load(R.drawable.ic_main_tab_publish_enter).resize(44,44).into(iv_send);
        rg_bottom= (RadioGroup) this.findViewById(R.id.rg_bottom);
        rb_title= (RadioButton) this.findViewById(R.id.rb_title);
        rb_find= (RadioButton) this.findViewById(R.id.rb_find);
        rb_msg= (RadioButton) this.findViewById(R.id.rb_msg);
        rb_mine= (RadioButton) this.findViewById(R.id.rb_mine);
        ((RadioButton)rg_bottom.findViewById(R.id.rb_title)).setChecked(true);

        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        Fragment fragment=new TitleFragment();
        transaction.replace(R.id.fl_content,fragment);

        transaction.commit();


    }
}
