package com.gomes.renato.mygym;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Menu principal
    private ListView listView_menu_principal;
    //tudo
    private MyGym MyGymApp;
    //Listas
    private List<Muscle> listaMuscles;
    //data storage helper
    PrefClass prefClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //create preff class
        prefClass = new PrefClass(MainActivity.this);

            MyGymApp = getData();
      if(MyGymApp == null)
      {
          MyGymApp = new MyGym("Renato gomes");
          //listas
          MyGymApp.setListaMuscles(getListaMuscles());

      }


        Toast.makeText(getApplicationContext(), MyGymApp.getListaMuscles().size() + " inicial", Toast.LENGTH_SHORT).show();
        //get Views from layouts
        listView_menu_principal = (ListView) findViewById(R.id.lv_menu_principal);



        //criate adapter to listview
        ListAdapterMenuPrincipal adapterMenuPrincipal = new ListAdapterMenuPrincipal(getApplicationContext(), MyGymApp.getListaMuscles());
        listView_menu_principal.setAdapter(adapterMenuPrincipal);

        //add listeners para os clicks na listaview do menu principal
        listView_menu_principal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //criar intent para a class
                Intent intent = new Intent(getApplicationContext(), ActivityShowMuscleTableInfo.class);
                //get vimageview para criar o par
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_row_menu_principal);
                Pair<View, String> p1 = Pair.create((View) imageView, "iv_transition");
                //colocar o img no bundle para na actividade a mudar receber
                intent.putExtra("IMG", MyGymApp.getListaMuscles().get(i).getImg());

                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, p1);
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                }
                startActivity(intent, optionsCompat.toBundle());
            }
        });

    }

    private List<Muscle> getListaMuscles() {
        List<Muscle> lista = new ArrayList<>();
        lista.add(new Muscle("Chest", R.drawable.chest));
        lista.add(new Muscle("Legs", R.drawable.legs));
        lista.add(new Muscle("Biceps", R.drawable.biceps));
        lista.add(new Muscle("Back", R.drawable.back));
        lista.add(new Muscle("Shoulders", R.drawable.shoulders));
        lista.add(new Muscle("Triceps", R.drawable.chest));
        lista.add(new Muscle("Abs", R.drawable.abs));
        lista.add(new Muscle("Cardio", R.drawable.cardio));
        return lista;
    }

    private void saveData() {
        //converter para json
        Gson gson = new Gson();
        String data_json = gson.toJson(MyGymApp);
        //guardar nas sharedpreferences
        prefClass.getEditor().putString("Data", data_json);
        prefClass.getEditor().commit();
    }


    private MyGym getData() {
        Gson gson = new Gson();
        MyGym temp;
        String data = prefClass.getSettings().getString("Data", "");
        temp = gson.fromJson(data, MyGym.class);
        return temp;
    }

}
