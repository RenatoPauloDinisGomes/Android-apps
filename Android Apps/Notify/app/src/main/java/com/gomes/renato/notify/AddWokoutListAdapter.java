package com.gomes.renato.notify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Renato on 12/08/2016.
 */
public class AddWokoutListAdapter extends BaseAdapter {
    private List<String> lista;
    private Context ctx;

    public AddWokoutListAdapter(List<String> lista, Context context) {
        this.lista = lista;
        this.ctx = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i - 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(ctx, R.layout.add_workout_row1, null);
        TextView t=(TextView) v.findViewById(R.id.textView2);
        t.setText(lista.get(i));
        return v;
    }
}
