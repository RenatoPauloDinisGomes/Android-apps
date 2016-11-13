package com.gomes.renato.notify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Renato on 11/08/2016.
 */
public class ListAdapter extends BaseAdapter {
    private List<BodyPart> lista;
    private Context ctx;

    public ListAdapter(List<BodyPart> lista, Context ctx) {
        this.lista = lista;
        this.ctx = ctx;
    }

    public List<BodyPart> getLista() {
        return lista;
    }

    public void setLista(List<BodyPart> lista) {
        this.lista = lista;
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
        View v = View.inflate(ctx, R.layout.item_list_left, null);
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        img.setImageResource(lista.get(i).getImg());
        TextView tx = (TextView) v.findViewById(R.id.textView);
        tx.setText(lista.get(i).getPartName());
        return v;
    }
}
