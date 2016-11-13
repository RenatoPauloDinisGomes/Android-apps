package com.gomes.renato.mygym;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Renato on 13/08/2016.
 */
public class ListAdapterMenuShowMuscleInfo extends BaseAdapter {
    private List<Workout> lista;
    private Context ctx;

    public ListAdapterMenuShowMuscleInfo(List<Workout> lista, Context ctx) {
        this.lista = lista;
        this.ctx = ctx;
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
        View v = View.inflate(ctx, R.layout.row_layout_wourkouts_info_menu, null);
        //get views da row
        ImageView imgTypeWorkout = (ImageView) v.findViewById(R.id.iv_typeWorkout_row_menu_workout_info);
        TextView textView = (TextView) v.findViewById(R.id.tv_row_menu_workout_info);

        return v;
    }
}
