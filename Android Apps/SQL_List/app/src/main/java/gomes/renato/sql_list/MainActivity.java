package gomes.renato.sql_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private String[] Nomes = {"Renato", "Ana", "João", "Maria", "Luís", "Isabel", "Paulo", "Mafalda", "Gomes", "Joana", "Renato", "Ana", "João", "Maria", "Luís", "Isabel", "Paulo", "Mafalda", "Gomes", "Joana"};

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.List);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, Nomes);
        lista.setAdapter(adapter);
    }
}
