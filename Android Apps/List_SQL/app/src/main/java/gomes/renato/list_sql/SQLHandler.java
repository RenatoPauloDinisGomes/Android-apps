package gomes.renato.list_sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06/08/2016.
 */
public class SQLHandler {
    private SQLiteDatabase BaseDados;

    public SQLHandler(Context ctx) {

        SQLBuilder auxdb = new SQLBuilder(ctx);
        BaseDados = auxdb.getWritableDatabase();
    }

    public void insert(String Nome) {

        ContentValues valores = new ContentValues();
        valores.put("nome", Nome);
        BaseDados.insert("user", null, valores);
    }

    public void update(String Nome,String NewName) {

        ContentValues valores = new ContentValues();
        valores.put("nome", Nome);
        BaseDados.update("user", valores, "nome = ?", new String[]{Nome});
    }

    public List<String> getList() {

        List<String> list = new ArrayList<String>();
        String[] colunas = new String[]{"_id", "nome"};
        Cursor cursor = BaseDados.query("user", colunas, null, null, null, null, "nome ASC");
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public void delete(String Nome) {
        BaseDados.delete("user", "nome = ?", new String[]{Nome});
    }
}
