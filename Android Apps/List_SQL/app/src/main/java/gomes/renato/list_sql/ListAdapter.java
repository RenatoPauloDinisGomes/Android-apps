package gomes.renato.list_sql;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Renato on 08/08/2016.
 */
public class ListAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;

    public ListAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.list_item_layout, null);
        TextView textView = (TextView) v.findViewById(R.id.tv_Nome);
        textView.setText(list.get(position));
        return v;
    }
}
