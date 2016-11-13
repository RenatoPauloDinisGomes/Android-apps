package com.gomes.renato.notify;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements com.gomes.renato.notify.StartFragment.OnFragmentInteractionListener, FragmentBodyPartInfo.OnFragmentInteractionListener, FragmentAddWorkout.OnFragmentInteractionListener {
    private BottomBar bottomBar;

    private boolean aux = false;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private List<BodyPart> bodyParts;
    private SQLHandler BaseDadosHandle;
    private List<Workout> ListaWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Calendar startDate = Calendar.getInstance();
       int day = startDate.get(Calendar.DAY_OF_MONTH);
        int month = startDate.get(Calendar.MONTH);
        int year = startDate.get(Calendar.YEAR);
        Toast.makeText(getApplicationContext(),day + " " + month+" "+year, Toast.LENGTH_LONG).show();
        bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItems(R.menu.bottom_bar);
        bottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (aux == true) {
                    if (menuItemId == R.id.btnplus) {
                        /*Intent intent = new Intent(getApplicationContext(), add_workout_activity.class);
                        startActivity(intent);*/
                        BaseDadosHandle.insert(new Workout(new BodyPart("Chest", R.drawable.chest1, "LowerChest"), 20, 200, "Was a ok Wourkout"));
                        getSupportFragmentManager().beginTransaction().replace(R.id.ContentFrameLayout, new FragmentAddWorkout()).commit();
                    }
                } else if (menuItemId == R.id.btnSettings) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.ContentFrameLayout, new FragmentBodyPartInfo()).commit();
                } else {
                    aux = true;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.btnplus) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.ContentFrameLayout, new FragmentAddWorkout()).commit();
                } else if (menuItemId == R.id.btnSettings) {

                }
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.ContentFrameLayout, new StartFragment()).commit();
        ListaWorkouts = new ArrayList<>();
        BaseDadosHandle = new SQLHandler(this);

        ListaWorkouts = BaseDadosHandle.getList();
        Toast.makeText(MainActivity.this, "WORKOUTS : " + ListaWorkouts.size(), Toast.LENGTH_SHORT).show();
        bodyParts = criarLista();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.MainActivityLayout);
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerList = (ListView) findViewById(R.id.ListLeft);
        final ListAdapter adapter = new ListAdapter(bodyParts, MainActivity.this);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentBodyPartInfo fragment = new FragmentBodyPartInfo();
                List<Workout> listaTreinos = new ArrayList<Workout>();
                switch (i) {
                    case 0:
                        listaTreinos = getListTreinos("Chest");
                        break;
                    case 1:
                        listaTreinos = getListTreinos("Legs");
                        break;
                    case 2:
                        listaTreinos = getListTreinos("Biceps");
                        break;
                    case 3:
                        listaTreinos = getListTreinos("Back");
                        break;
                    case 4:
                        listaTreinos = getListTreinos("Shoulders");
                        break;
                    case 5:
                        listaTreinos = getListTreinos("Triceps");
                        break;
                    case 6:
                        listaTreinos = getListTreinos("Abs");
                        break;
                    case 7:
                        listaTreinos = getListTreinos("Cardio");
                        break;
                    default:
                        break;
                }

                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("WORKOUTS", (ArrayList<Workout>) listaTreinos);
                Toast.makeText(getApplicationContext(), "Size listWourkouts before trasaction " + listaTreinos.size(), Toast.LENGTH_SHORT).show();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.ContentFrameLayout, fragment).commit();


                /*
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {

                   ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
                    TextView textView = (TextView) view.findViewById(R.id.textView);
                    Pair<View, String> p1 = Pair.create((View) imageView, "imageNota");
                    Pair<View, String> p2 = Pair.create((View) textView, "textoNota");
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, p1, p2);
                    Intent intent = new Intent(getApplicationContext(), Nota_viewer_activity.class);
                    intent.putExtra("TEXTO", adapter.getLista().get(i).getPartName());
                    intent.putExtra("IMG", adapter.getLista().get(i).getImg());
                    startActivity(intent, optionsCompat.toBundle());
                }
            */
            }
        });

    }

    private List<Workout> getListTreinos(String bodypart) {
        List<Workout> listaTreinos = new ArrayList<Workout>();
        for (int j = 0; j < ListaWorkouts.size(); j++) {
            if (ListaWorkouts.get(j).getPart().getPartName().equals(bodypart)) {
                listaTreinos.add(ListaWorkouts.get(j));
            }
        }
        return listaTreinos;
    }

    private List<BodyPart> criarLista() {
        int i = 0;
        List<BodyPart> lista = new ArrayList<>();
        lista.add(new BodyPart("Chest", R.drawable.chest1, ""));
        lista.add(new BodyPart("Legs", R.drawable.legs1, ""));
        lista.add(new BodyPart("Biceps", R.drawable.bicep2, ""));
        lista.add(new BodyPart("Back", R.drawable.back1, ""));
        lista.add(new BodyPart("Shoulders", R.drawable.shoulderpress, ""));
        lista.add(new BodyPart("Triceps", R.drawable.triceps1, ""));
        lista.add(new BodyPart("Abs", R.drawable.abs1, ""));
        lista.add(new BodyPart("Cardio", R.drawable.cardio1, ""));
        return lista;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        bottomBar.onSaveInstanceState(outState);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
