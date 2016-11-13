package com.gomes.renato.notify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Renato on 12/08/2016.
 */
public class ListAdapterWorkoutsList extends BaseAdapter {
    private List<Workout> lista;
    private Context context;

    public ListAdapterWorkoutsList(List<Workout> lista, Context context) {
        this.lista = lista;
        this.context = context;
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
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.item_list_workouts, null);
        TextView textView = (TextView) v.findViewById(R.id.tv_workouts_item);
        String data = lista.get(i).getDay() + "/" + lista.get(i).getMonth() + "/" + lista.get(i).getYear();
        textView.setText(data);
        return v;
    }
}
