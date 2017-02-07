package zzr.com.bantang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import zzr.com.bantang.MainActivity;
import zzr.com.bantang.R;

/**
 * 闪屏
 */
public class SplashActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private Button btn;
    private int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        init();
    }

    private void init() {
        btn = (Button) this.findViewById(R.id.btnOn);
        new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 4; i > 0; i--) {

                        Thread.sleep(1000);
                        temp=i;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btn.setText("跳转"+temp);
                            }
                        });

                    }
                    jump();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void jump() {

        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void btnOn(View view) {
        jump();
    }
}
