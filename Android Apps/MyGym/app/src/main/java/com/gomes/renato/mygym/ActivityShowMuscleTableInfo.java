package com.gomes.renato.mygym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ActivityShowMuscleTableInfo extends AppCompatActivity {
private ImageView Iv_top_left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_show_muscle_table_info);
        Bundle bundle = getIntent().getExtras();
        int img = bundle.getInt("IMG");
        Iv_top_left = (ImageView) findViewById(R.id.iv_top_icon_menu_info);
        Iv_top_left.setImageResource(img);

    }
}
