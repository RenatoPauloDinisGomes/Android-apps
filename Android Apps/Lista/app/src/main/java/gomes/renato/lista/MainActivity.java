package gomes.renato.lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] Nomes = {"Renato", "Ana", "João", "Maria", "Luís", "Isabel", "Paulo", "Mafalda", "Gomes", "Joana", "Renato", "Ana", "João", "Maria", "Luís", "Isabel", "Paulo", "Mafalda", "Gomes", "Joana"};
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.List);
      /*  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,Nomes);
       mListView.setAdapter(arrayAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,Nomes[position],Toast.LENGTH_SHORT).show();

            }
        });*/
        ListAdapter adapter = new ListAdapter();
        mListView.setAdapter(adapter);
    }


    public class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Nomes.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.list_item, parent, false);

            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            TextView textView = (TextView) view.findViewById(R.id.text);
            if (position % 2 != 0) {
                imageView.setImageResource(R.drawable.face_female);
            } else {
                imageView.setImageResource(R.drawable.face_men);
            }
            textView.setText(Nomes[position]);
            return view;
        }
    }


}
