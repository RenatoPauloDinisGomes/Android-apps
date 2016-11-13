package gomes.renato.list_sql;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * Created by User on 06/08/2016.
 */
public class DialogAdd extends DialogFragment {

    private LayoutInflater inflater;
    private View v;
    private SQLHandler BaseDadosHandler;
    private List<String> list;

    public DialogAdd(SQLHandler baseDadosHandler, List<String> list) {
        this.BaseDadosHandler = baseDadosHandler;
        this.list = list;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.dialog_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText et = (EditText) v.findViewById(R.id.et_user);
                String Nome = et.getText().toString();
                if(!Nome.isEmpty())
                {
                    list.add(Nome);
                    BaseDadosHandler.insert(Nome);
                }else{
                    Toast.makeText(getActivity(),"Insert some text",Toast.LENGTH_SHORT).show();
                }

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
