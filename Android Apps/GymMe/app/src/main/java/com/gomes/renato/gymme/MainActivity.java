package com.gomes.renato.gymme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //view
    private ListView ListLeft;
    //data helpers

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get views
        ListLeft = (ListView) findViewById(R.id.ListLeft);

    }
}
