package com.panghaha.it.bootmbuttondemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout Lj_but,OA_but;
    private TextView Lj_text,OA_text;
    private ImageView Lj_icon,OA_icon;

    private int isOA=1;
    private LinearLayout addrenwu_bt;//悬浮新增按钮

    private CenterFragment centerfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lj_but = (LinearLayout) findViewById(R.id.lingjian_but);
        OA_but = (LinearLayout) findViewById(R.id.oa_but);
        Lj_icon = (ImageView) findViewById(R.id.Lj_icon);
        OA_icon = (ImageView) findViewById(R.id.oa_icon);
        Lj_text = (TextView) findViewById(R.id.Lj_text);
        OA_text = (TextView) findViewById(R.id.oa_text);


        addrenwu_bt = (LinearLayout) findViewById(R.id.add_renwu);

        addrenwu_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"天王盖地虎,我发一米五（陈一发）",Toast.LENGTH_SHORT).show();
            }
        });

        FragmentManager fr = getSupportFragmentManager();
        FragmentTransaction ft = fr.beginTransaction();
        centerfragment = new CenterFragment();
        ft.add(R.id.oa_fragment,centerfragment).hide(centerfragment).commit();

        Lj_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOA = 1;
                addrenwu_bt.setClickable(true);
                FragmentManager fr = getSupportFragmentManager();
                FragmentTransaction ft = fr.beginTransaction();
                ft.hide(centerfragment).commit();

                Lj_text.setTextColor(getResources().getColor(R.color.white));
                Lj_icon.setImageResource(R.drawable.tab_renwuguanli_pre);
//                Lj_but.setBackgroundResource(R.color.tab1);

//                OA_but.setBackgroundResource(R.color.tab2);
                OA_icon.setImageResource(R.drawable.tab_oaofficework_nor);
                OA_text.setTextColor(getResources().getColor(R.color.tab1));
            }
        });

        OA_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOA = 2;
                addrenwu_bt.setClickable(false);
                FragmentManager fr2 = getSupportFragmentManager();
                FragmentTransaction ft2 = fr2.beginTransaction();
                ft2.show(centerfragment).commit();


//                OA_but.setBackgroundResource(R.color.tab1);
                OA_icon.setImageResource(R.drawable.tab_oaofficework_pre);
                OA_text.setTextColor(getResources().getColor(R.color.white));

                Lj_text.setTextColor(getResources().getColor(R.color.tab1));
                Lj_icon.setImageResource(R.drawable.tab_renwuguanli_nor);
//                Lj_but.setBackgroundResource(R.color.tab2);
            }
        });
    }
}
