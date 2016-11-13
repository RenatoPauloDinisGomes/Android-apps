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
public class ListAdapterMenuPrincipal extends BaseAdapter {
    private List<Muscle> lista;
    private Context ctx;

    public ListAdapterMenuPrincipal(Context ctx, List<Muscle> lista) {
        this.lista = lista;
        this.ctx = ctx;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(ctx, R.layout.row_layout_menu_principal, null);
        TextView textView = (TextView) v.findViewById(R.id.tv_row_menu_principal);
        ImageView imageView = (ImageView) v.findViewById(R.id.iv_row_menu_principal);
        textView.setText(lista.get(i).getName());
        imageView.setImageResource(lista.get(i).getImg());
        return v;
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

}
