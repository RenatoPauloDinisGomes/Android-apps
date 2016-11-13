package gomes.renato.list_sql;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] Nomes = {"Renato", "Ana", "João", "Maria", "Luís", "Isabel", "Paulo", "Mafalda", "Gomes", "Joana", "Renato", "Ana", "João", "Maria", "Luís", "Isabel", "Paulo", "Mafalda", "Gomes", "Joana"};
    private ListAdapter adapter;
    private Button btnAdd;
    private Button btnRemove;
    private ListView list;
    private SQLHandler BaseDadosHandler;
    private List<String> Lista_Nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.List);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        Lista_Nomes = new ArrayList<String>();

        BaseDadosHandler = new SQLHandler(this);

        Lista_Nomes = BaseDadosHandler.getList();
        adapter = new ListAdapter(Lista_Nomes, MainActivity.this);
        // final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_selectable_list_item, Lista_Nomes);
        list.setAdapter(adapter);

        final List<String> finalList = Lista_Nomes;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAdd dialog = new DialogAdd(BaseDadosHandler, finalList);
                dialog.show(MainActivity.this.getFragmentManager(), "my_dialog_add");
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDelete dialog = new DialogDelete(BaseDadosHandler, finalList);
                dialog.show(MainActivity.this.getFragmentManager(), "my_dialog_delete");
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, long id) {


                final String nome = Lista_Nomes.get(position).toString().trim();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Lista_Nomes.remove(nome);
                        BaseDadosHandler.delete(nome);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {
                        final Dialog dialogEdit = new Dialog(MainActivity.this);
                        dialogEdit.setTitle("Enter new user name");
                        dialogEdit.setContentView(R.layout.edit_name_layout);
                        dialogEdit.show();
                        final EditText etNewName = (EditText) dialogEdit.findViewById(R.id.et_newName);
                        Button btnOk = (Button) dialogEdit.findViewById(R.id.btnOk);
                        Button btnCancel = (Button) dialogEdit.findViewById(R.id.btnCancel);
                        btnOk.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String newName = etNewName.getText().toString();
                                if (!newName.isEmpty()) {
                                    BaseDadosHandler.delete(nome);
                                    BaseDadosHandler.insert(newName);
                                    Lista_Nomes.remove(nome);
                                    Lista_Nomes.add(newName);
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(MainActivity.this, nome + " was changed to " + newName, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "Nome invalido", Toast.LENGTH_SHORT).show();
                                }
                                dialogEdit.cancel();

                            }
                        });

                        btnCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogEdit.cancel();
                            }
                        });
                    }
                });
                dialog.setTitle("Are you sure you what to delete?");
                dialog.setMessage(nome + " will be deleted");
                dialog.show();

            }
        });
    }
}
